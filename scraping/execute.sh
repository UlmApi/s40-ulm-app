#!/bin/sh

echo "[" > restaurants.json
node scrape.js >> restaurants.json
# delete last 2 lines
sed '$d' < restaurants.json > tmp ; mv tmp restaurants.json
sed '$d' < restaurants.json > tmp ; mv tmp restaurants.json
echo "]" >> restaurants.json

node geocoding.js > restaurants_with_geo.json
node insert-into-couchdb.js

