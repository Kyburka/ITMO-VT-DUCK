from re import *
def sorting_words(word):
    return (len(word), word)
reg = r"[А-ЯЁа-яё]+"
s = input()
s=s.lower()
print(s)
glas='аеёиоуыэюя'
match = findall(reg, s)
res=[]
for a in match:
    uniq = set()
    for b in a:
        if b in glas:
            uniq.add(b)
    if len(uniq)==1:
        res.append(a)
res.sort(key=sorting_words)
for a in res:
    print(a)
    
