from re import *
reg = r"id=\"([^\"]+)\""
s = input()
match = findall(reg, s)
for a in match:
    print(a)