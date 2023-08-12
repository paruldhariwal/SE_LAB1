def isPrime(n):
    count=0
    for i in range(1,n+1):
        if n%i==0:
            count=count+1
    if count==2:
        return True
    return False    

def PrimeFactors(n):
    Prime_Factors=[]
    for i in range(2,n+1):
        if n%i==0 and isPrime(i):
            Prime_Factors.append(i)
    return(Prime_Factors)        

def main():
    n=int(input('Enter a number:'))    
    p=PrimeFactors(n)
    print("Prime factors=",p)       

if __name__ == '__main__':
    main()    
