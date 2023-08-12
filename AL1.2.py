def Triangle(a,b,c):
    if a+b<=c or a+c<=b or b+c<=a:
        print("NOT A TRIANGLE")
    elif a==b==c:
        print("Equilateral Triangle")
    elif a==b or b==c or a==c:
        print("Isosceles Triangle")
    elif a*a + b*b == c*c or a*a + c*c ==b*b or b*b + c*c == a*a:
        print('Right Triangle')
    else:
        print('Scalene Triangle')       

def main():
    a=int(input('Enter first side '))

    b=int(input('Enter second side' ))
    
    c=int(input('Enter third side' ))
    Triangle(a,b,c)
if __name__ =='__main__':
    main()    
