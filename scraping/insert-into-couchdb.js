/* simple script for inserting into couchdb */
var request = require('request');
var fs = require('fs');
var crypto = require('crypto');
var credentials = require('./credentials.js');

var json = fs.readFileSync('./clubs_with_geo.json', 'utf8');
//var json = fs.readFileSync('./restaurants_with_geo.json', 'utf8');
//var json = fs.readFileSync('./cafes_with_geo.json', 'utf8');
//var json = fs.readFileSync('./bars_with_geo.json', 'utf8');
//var json = fs.readFileSync('./restaurants_test.json', 'utf8');
var json = JSON.parse(json);


function insert(entry, url, versuch) {
	request(
	  { method: 'PUT'
	  , uri:  url
	  ,headers: 	{'Authorization': 'Basic ' + credentials.auth}
	  , multipart: 
	    [ { 'content-type': 'application/json'
	      ,  body: JSON.stringify(entry)
	      }
	    ] 
	  }
	, function (error, response, body) {
	    if(response.statusCode == 201){
	      console.log('inserted ' + entry._id)
	    } else if(response.statusCode == 409){
	      /* das gleiche nochmal mit _rev */ 
	      console.log('error: '+ response.statusCode)
	      console.log(body)
		    console.log('trying again with _rev');
		var url_ = 'http://daten.ulmapi.de/oeffnungszeiten/' + entry._id;
		request.get(url_, function (err, response, body) {
			var json = JSON.parse(body);
			var _url = url_ + '?rev=' + json._rev;
			entry._rev = json._rev;
		    console.log('trying again with new uri: ' + _url);
			insert(entry, _url, 2);
		});
	    } else {
	      console.log('error: '+ response.statusCode)
	      console.log(body)
	    }
	  }
	)	
}
/*
	var entry = json[0];
	console.log(entry);
	//insert(entry);
insert(entry, 'http://daten.ulmapi.de/oeffnungszeiten/' + entry._id);
*/

for (var i in json) {
	var entry = json[i];
	//console.log(entry);
	//insert(entry);
	insert(entry, 'http://daten.ulmapi.de/oeffnungszeiten/' + entry._id);
}
