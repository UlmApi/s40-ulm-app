#!/bin/sh
#file="bars.json"
#file2="bars_with_geo.json"

#file="restaurants.json"
#file2="restaurants_with_geo.json"

#file="cafes.json"
#file2="cafes_with_geo.json"

file="clubs.json"
file2="clubs_with_geo.json"

echo "[" > $file
node scrape.js >> $file
# delete last 2 lines
sed '$d' < $file > tmp ; mv tmp $file
sed '$d' < $file > tmp ; mv tmp $file
echo "]" >> $file

node geocoding.js >> $file2

node insert-into-couchdb.js

