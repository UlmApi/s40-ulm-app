#!/bin/sh

file="bars.json"
file2="bars_with_geo.json"

echo "[" > $file
node scrape.js >> $file
# delete last 2 lines
sed '$d' < $file > tmp ; mv tmp $file
sed '$d' < $file > tmp ; mv tmp $file
echo "]" >> $file

echo "[" > $file2
node geocoding.js >> $file2
# delete last 2 lines
sed '$d' < $file2 > tmp ; mv tmp $file2
sed '$d' < $file2 > tmp ; mv tmp $file2
echo "]" >> $file2

#node insert-into-couchdb.js

