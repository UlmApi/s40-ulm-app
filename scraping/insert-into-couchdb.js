/* simple script for inserting into couchdb */
var request = require('request');
var fs = require('fs');
var crypto = require('crypto');
var credentials = require('./credentials.js');

var json = fs.readFileSync('./restaurants_with_geo.json', 'utf8');
//var json = fs.readFileSync('./restaurants_test.json', 'utf8');
var json = JSON.parse(json);


function insert(entry) {
	request(
	  { method: 'PUT'
	  , uri:  'http://daten.ulmapi.de/oeffnungszeiten/' + entry._id
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
	    } else {
	      console.log('error: '+ response.statusCode)
	      console.log(body)
	    }
	  }
	)	
}


for (var i in json) {
	var entry = json[i];
	insert(entry);
}
