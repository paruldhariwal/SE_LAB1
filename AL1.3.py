def NextDate(a,b,c):
    if b==2:
        if (a==28 and c%4==0):
            a+=1
        elif (a==28 and c%4!=0):
            a=1
            b+=1
        else:
            a=a+1
    elif b in (4,6,9,11):
            
        if a==30:           
            a=1
            b+=1
        else:
            a+=1    
    elif b in (1,3,5,7,8,10):
        if a==31:
            a=1
            b=b+1
        else:
            a=a+1   
    else:
        if a==31:
            a=1
            b=1
            c=c+1
        else:
            a+=1
    return(a,b,c)        
def main():
    a=int(input('Enter Day:'))
    b=int(input('Enter Month:'))
    c=int(input("Enter Year:"))
    print("Present Date:",a,'/',b,'/',c)
    a,b,c=NextDate(a,b,c)
    print("NEXT DATE:",a,'/',b,'/',c)
if __name__ =="__main__" :
    main()   

            
               
        
            
