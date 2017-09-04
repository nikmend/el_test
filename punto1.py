import math
import cmath
import sympy


def f(x,a,b,c):
    return a*x**2 + b*x + c
def df(x,a,b,c,N):
    from sympy import Symbol
    from scipy.misc import derivative
    return derivative(f,x,n=N,dx=1e-6, args=(a,b,c))

def errorf(act,ant):
     return ((abs(act-ant))/act)

def raiz(x,a,b,c, error,ciclos): # x ininical,  error permitido, numero de ciclos maximo
    k = 0
    xant = 1
    err = 0
    while( f(x,a,b,c) > error and k < ciclos):
        k = k + 1
        
        if(df(x,a,b,c,1) != 0):
            up=f(xant,a,b,c)*df(xant,a,b,c,1)
            down=(df(xant,a,b,c,1)**2)-(f(xant,a,b,c)*df(xant,a,b,c,2))
            x = xant -(up/down)
            err = errorf(x,xant)
            print (k, '\t', x, '\t', err, ' | ',f(x,a,b,c))
            xant = x
  
        else:
            xant = x
            x += error
    
    if (k == ciclos):
        print("No converge")
        return False
    else:
        return x
        


def comprobacion2(x,a,b,c):
  if(abs(x*(a*x+b)+c)<0.0001):
    print(x,"es de grado 2")
    return True
def comprobacionIM(x,a,b,c):
  disc=(b*b)-(4*a*c)
  if(disc<0):
    print("raices complejas")
    disc=cmath.sqrt(disc)
    ip=(-b+disc)/(2*a)
    iN=(-b-disc)/(2*a)
    print(ip)
    print(iN)
  return True

def main():
#0.09 x^2 - 21.12 x + 1239.04
    x = 1
    print ("ingrese a b c")
    a=float(input())
    b=float(input())
    c=float(input())
    error = 0.0001
    ciclos = 50
    """
    print (a,b,c)
    print(f(x,a,b,c))
    print(df(x,a,b,c,1))
    print(df(x,a,b,c,2))
    """
    resultado=raiz(x,a,b,c,error,ciclos)
    imag=comprobacionIM(x,a,b,c)
    if(resultado):
      if(comprobacion2(resultado,a,b,c)):
        print ("la raiz de multiplicidad 2 es: ", resultado)
    elif(not imag):
      print("ni  raices de multiplicidad dos ni complejas conjugadas")
    
  

main()
