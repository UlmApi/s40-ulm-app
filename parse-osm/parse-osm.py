#!/bin/python
# script for parsing post boxes from  OpenStreetMap-XML-files 
# usage? see execute-task-chain.sh

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