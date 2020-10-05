# Online Python compiler (interpreter) to run Python online.
# Write Python 3 code in this online editor and 
tests = int(input())
print(type(tests))
for test in range(tests) : 
    length = int(input())
    s = input()
    for each in range(length-1):
        print(s[each])
        print(s[each+1])
        s[each]=chr(ord(s[each])+ord(s[each+1]))
        s[each+1]=chr(ord(s[each])-ord(s[each+1]))
        s[each]=chr(ord(s[each])-ord(s[each+1]))
        print(s[each])
        print(s[each+1])
