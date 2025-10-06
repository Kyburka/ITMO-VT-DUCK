cd ~/lab0/
echo "4.1:"
wc -c doduo5 >> doduo5 2> ~/tmp/error
echo "4.2:"
ls -larRt | grep -E '^[-d].* b[^/]*$' | sort -k6M -k7n -k8
echo "\n 4.3:"
[ ! -z "$(ls -1 -dp **/*r | grep -v '/$')" ] && cat $(ls -1 -dp **/*r | grep -v '/$') | sort | nl
echo "4.4:"
ls 2>/dev/null -Rtu | grep '^s' | tail -n 2
echo "4.5:" 
wc -l braviary5/vibrava braviary5/stunky braviary5/herdier | sort -n
echo "4.6:"
ls -R | sort | grep -v -e ':$' -e "^$"
