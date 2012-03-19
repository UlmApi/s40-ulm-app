#!/bin/python
# script for parsing post boxes from  OpenStreetMap-XML-files 
#
# usage: 
#   (1) curl "http://open.mapquestapi.com/xapi/api/0.6/node%5Bamenity=post_box%5D%5Bbbox=9.8396,48.3129,10.1407,48.4846%5D" > postboxes.xml
#   (2) cat postboxes.xml | python parse-osm.py
#   (3) node insert-into-couchdb.js

import os
import sys
import libxml2


# xml has to be provided via stdin
rss = sys.stdin.readlines()
rss = ''.join(rss)

# parse input
doc = libxml2.parseDoc(rss);
ctxt = doc.xpathNewContext()

print("[")
iterator = 0

items = ctxt.xpathEval("//tag[@v='post_box']/..")
if len(items) > 0:
    for i in items:    
		lat = i.xpathEval("./@lat")[0].content;
		lon = i.xpathEval("./@lon")[0].content;
		
		json = "{ \"lat\": " + lat + ", "
		
		# output the rest too
		rest = i.xpathEval("./*");
		if len(rest) > 0:
			for ps in rest:
				key = ps.xpathEval("./@k")[0].content
				value = ps.xpathEval("./@v")[0].content
				
				json = json + " \"" + key + "\" : \"" + value + "\", "
				
		json = json + " \"lon\": " + lon + " }" 
		if iterator > 0: print(", ")
		print(json)
		iterator = iterator + 1
        

print("]")