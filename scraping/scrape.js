/* scrape aaalll the data */ 
var urls = require('./urls.js');

var request = require('request'); 
var fs = require('fs');
var crypto = require('crypto');

var facility = 'restaurant';
var days = ['mo', 'di', 'mi', 'do', 'fr', 'sa', 'so']

var globalArray = []


/* get the list of all the entries */
var dummyCntList = fs.readFileSync('./Restaurants.html', 'utf8');
var parseList = function(body) {
	var allHrefs = body.match(urls.regex);
	allHrefs.splice(0,1);

	/* duplikate eliminieren */
	var vorkommen = 0;
	for(var i in allHrefs) {
		for(var n in allHrefs) {
			if (allHrefs[i] === allHrefs[n]) vorkommen++;
		}
		if (vorkommen > 1) allHrefs.splice(i,1);
		vorkommen = 0;
	}

	//console.log('starting to scrape ' + allHrefs.length + ' entries');
	//getDetailsFromFile(allHrefs[0]);
	for (var i in allHrefs) getDetailsFromFile(allHrefs[i]);
	//for (var i in allHrefs) getDetails(allHrefs[i]);
	//console.log(allHrefs);
}



/* process for getting the details for each entry in the list */
//var dummyCntDetails = fs.readFileSync('./Zunfthaus.html', 'utf8');
var getDetails = function(url) {
	request.get(url, function (error, response, body) {
		if (!error && response.statusCode == 200) {
			/* save to local file */
			var fname = crypto.createHash('md5').update(url).digest('hex') + '.html';
			fs.writeFile('./' + facility + '/' + fname, body, 'utf8');
			
			parseDetails(fname, body);
		}
	});
}

var getDetailsFromFile = function(url) {
	var fname = crypto
		.createHash('md5')
		.update(url)
		.digest('hex') + '.html';
	var body = fs.readFileSync('./' + facility + '/' + fname, 'utf8');
	parseDetails(fname, body);
}

var parseDetails = function(fname, body) {
	body = decodeEntities(body);

	/* get name */
	pos_start = body.match('itemprop="v:itemreviewed">');
	var name = body.substring(pos_start.index + 26);
	pos_end = name.match('</span>');
	name = name.substring(0, pos_end.index);
	//console.log(name + '!!');

	/* start with body */
	pos_start = body.match('id="main"');
	pos_end = body.match('id="leftSide"');
	body = body.substring(pos_start.index, pos_end.index);


	/* matching auf alle uhrzeiten */
	pos_start = body.match("ffnungszeiten:</strong>");
	var oeffnungszeiten = body.substring(pos_start.index, body.length);
	pos_end = oeffnungszeiten.search("</table>");
	oeffnungszeiten = oeffnungszeiten.substring(0, pos_end);
	oeffnungszeiten = oeffnungszeiten.split('<tr>');
	oeffnungszeiten.splice(0,1);

	for (var i in oeffnungszeiten) {
		oeffnungszeiten[i] = oeffnungszeiten[i].replace(/^(<td)[\s\w\d=:;\-"]*>/gi, '');
		oeffnungszeiten[i] = oeffnungszeiten[i].replace(/(<\/td><\/tr>)\s*$/gi, '');
		oeffnungszeiten[i] = oeffnungszeiten[i].replace(/^\w*:(<\/td><td>)/gi, '');

		//console.log(oeffnungszeiten[i]);
		oeffnungszeiten[i] = oeffnungszeiten[i].split(/(<br\s*\/>\s*)/gi);
		oeffnungszeiten[i].splice(1,1);
		for (var n in oeffnungszeiten[i]) {
			oeffnungszeiten[i][n] = oeffnungszeiten[i][n].replace(/(:|Uhr|\s)/gi, '');
			oeffnungszeiten[i][n] = oeffnungszeiten[i][n].split(/\s*\-\s*/gi);
				for (var j in oeffnungszeiten[i][n]) {
					oeffnungszeiten[i][n][j] = parseInt(oeffnungszeiten[i][n][j]);
				}
		}
	}

	var opentimes = {};
	for (var i in oeffnungszeiten) {
		opentimes[days[i]] = oeffnungszeiten[i];
	}

	//console.log(oeffnungszeiten);

	//return;
	/*

	uhrzeiten = body.match(/(<td>)\d+:\d+\s(Uhr)\s-\s\d+:\d+\s(Uhr<\/td>)/gi);
	for (var i in uhrzeiten) uhrzeiten[i] = uhrzeiten[i].replace(/<(\/)*td>/gi, '');
	var saubere_uhrzeiten = {};
	for (var i in uhrzeiten) {
		var this_uhrzeit = new Array(
			uhrzeiten[i].match(/^\d+:\d+/g)[0],
			uhrzeiten[i].match(/-\s\d+:\d+/g)[0].replace(/-\s/, '')
	       	);

		saubere_uhrzeiten[days[i]] = new Array(this_uhrzeit);
	}
	*/

	/* matching auf die adresse */
	pos_start = body.match(/(margin-bottom:0px;">\s*<p style="margin-bottom:0px;">)/);
	var address = body.substring(pos_start.index);
	address = address.replace(/(margin-bottom:0px;">\s*<p style="margin-bottom:0px;">)/, '');
	pos_end = address.match(/\s(<\/p><\/div>)/);
	address = address.substring(0, pos_end.index);

	address = address.replace(/\s+/gi, ' ');
	address = address.trim();
	address = address.split(/\s*<br \/>\s*/);

	
	for (var i in address) {
		if (address[i].match(/(href=)/)) {
			address[i] = address[i].replace("</a>", '');
			pos_start = address[i].match('">');
			address[i] = address[i].substring(pos_start.index + 2);
		}
		if (address[i].trim().length === 0) address.splice(i,1);
	}
	//console.log(address);


	/* matching auf die besonderheiten */
	pos_start = body.match(/(<strong>Besonderheiten:<\/strong>)/);
	var details = body.substring(pos_start.index);
	pos_end = details.match(/(<\/table>)/);
	details = details.substr(0, pos_end.index);

	/* alles bis zum ersten <tr> rausloesche */
	pos_start = details.match(/<tr>/);
	details = details.substr(pos_start.index + 4); /* +4 to eliminate the first <tr> */
	details = details.split(/<tr>/);

	for (var i in details) {
		details[i] = details[i].replace('<td valign="top">', '');
		details[i] = details[i].replace(/&nbsp;/gi, ' ');
		details[i] = details[i].trim();
		details[i] = details[i].split(/(<\/td><td>)/);
		details[i].splice(1,1);
		
		empty = true;
		for (var a in details[i]) {
			details[i][a] = details[i][a].replace(/\s+/gi, ' ');
			details[i][a] = details[i][a].replace(/(<\/td><\/tr>)/gi, '');
			details[i][a] = details[i][a].trim();

			if (details[i][a].length > 0) empty = false;
		}
	}
	// console.log(details);

	var detail = {
		  'type' : 'oeffnungszeit'
		, 'name' : name
		, '_id' : fname.replace('.html','')
		, 'facility' : facility
		, 'address' : address
		, 'details' : details
		, 'open' : opentimes
	}


	fs.writeFile('./' + facility + '_json/' + fname, JSON.stringify(detail), 'utf8');
	console.log(JSON.stringify(detail) + '\n,\n');
	//console.log(JSON.stringify(detail));
}




var decodeEntities = function(text) {
	text = text.replace(/(&Auml;)/g, 'Ä');
	text = text.replace(/(&Ouml;)/g, 'Ö');
	text = text.replace(/(&Uuml;)/g, 'Ü');
	text = text.replace(/(&auml;)/g, 'ä');
	text = text.replace(/(&ouml;)/g, 'ö');
	text = text.replace(/(&uuml;)/g, 'ü');
	text = text.replace(/(&szlig;)/g, 'ß');

	return text;
}

//(dummyCntDetails);

parseList(dummyCntList);
