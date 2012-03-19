#!/bin/sh

# get an xml with all postboxes within our "ulm"-bounding box
curl "http://open.mapquestapi.com/xapi/api/0.6/node%5Bamenity=post_box%5D%5Bbbox=9.8396,48.3129,10.1407,48.4846%5D" > postboxes.xml

# use the python script to transform the *.xml into *.json
cat postboxes.xml | python parse-osm.py > postboxes.json

# use node.js to import the *.json into our couchdb
node insert-into-couchdb.js "postboxes.json"
