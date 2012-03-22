var fs = require('fs');
var geocoder = require('geocoder');

//var json = fs.readFileSync('./bars.json', 'utf8');
//var json = fs.readFileSync('./cafes.json', 'utf8');
var json = fs.readFileSync('./clubs.json', 'utf8');
//var json = fs.readFileSync('./restaurants.json', 'utf8');
var json = JSON.parse(json);

var finishes = 0;

var checkGeo = function(u, address_) {
	address_ = JSON.stringify(address_);
	address = JSON.parse(address_);
	//var address = json[u].address;
	address = address.street + ', ' + address.plz;
	//console.log(address + ", " + u);
	
	var localU = 1*u;

	geocoder.geocode(address, function ( err, data ) {
		if (data.results.length > 0) {
			var geo = data.results[0].geometry.location;
			//console.log(JSON.stringify(geo));
			json[localU].location = { "type": "Point", "coordinates": [geo.lng, geo.lat] };
			//console.log("address: " + address + ", " + u + ", " + geo.lng);
			//console.log('ok!' + JSON.stringify(json[u].location));
		}
		finishes++;
		check_if_finished();
	});
}


for (var i in json) {
	var address = json[i].address;
	var new_address = {};

	for (var n in address) {
		if (address[n].match(/Telefon/)) {
			new_address.tel = address[n].replace('Telefon: ', '');
			address.splice(n,1);
		}
	}
	for (var n in address) {
		if (address[n].match(/http:\/\//)) {
			new_address.web = address[n];
			address.splice(n,1);
		}
	}
	for (var n in address) {
		if (address[n].match(/^\d*\s/)) {
			new_address.plz = address[n];
			address.splice(n,1);
		}
	}
	/* one left.. */
	new_address.street = address[0];

	json[i].address = new_address;
	/*
	console.log(new_address);
	console.log(address);
	console.log("");
	*/
}


for (var i in json) {
	//if (json[i]._id == "54f0cb3e48362728aecb17513f6057a8") 
		checkGeo(i, json[i].address);
}


function check_if_finished() {
	
	if (json.length === finishes)
		console.log(JSON.stringify(json));
}
