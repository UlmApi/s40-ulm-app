/* 
 * simple script for inserting our json with postboxes into couchdb 
 * usage? see execute-task-chain.sh
 */
var request = require('request');
var fs = require('fs');
var crypto = require('crypto');
var credentials = require('./credentials.js');

var json = fs.readFileSync('./postboxes.json', 'utf8');
var json = JSON.parse(json);


function insert(entry) {
	request(
	  { method: 'PUT'
	  , uri:  'http://daten.ulmapi.de/postkaesten/' + entry.id
	,headers: 	{'Authorization': 'Basic ' + credentials.auth}
	  , multipart: 
	    [ { 'content-type': 'application/json'
	      ,  body: JSON.stringify(entry)
	      }
	    ] 
	  }
	, function (error, response, body) {
	    if(response.statusCode == 201){
	      console.log('inserted ' + entry.id)
	    } else {
	      console.log('error: '+ response.statusCode)
	      console.log(body)
	    }
	  }
	)	
}


for (var i in json) {
	var entry = json[i];
	entry.id = ("" + entry.lat).replace('.','') + ("" + entry.lon).replace('.','');
	entry.id = crypto.createHash('md5').update(entry.id);
	entry.id = entry.id.digest('hex')
	insert(entry);
}