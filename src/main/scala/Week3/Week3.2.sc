
//Rational number with simplified
val x= new Rational(1,3)
x.numer
x.deno
val y= new Rational(5,7)
val z= new Rational(3,2)
x + y * z
x-y - z
x < y
y.max(z)

class Rational(x:Int,y:Int)
{

  def this(x:Int)=this(x,1)

 // require is used for checking preconfigure
require(y!=0,"Denominator must be non zero")
//Private function used so that client cannot see the implementation
  // gcd  helps us to simplify the problem and can be only accessed from inside the class
  private def gcd(a:Int,b:Int):Int =if(b==0)a else gcd(b,a%b)
  // gcd is computed as soon as the function is called

// second option is by using  calling gcd  in def numer=x/gcd(x,y) if numerand deno are not called often or make numer and deno val if they are called often
  def  numer= x
  def deno= y

 def <(that:Rational)=numer*that.deno < that.numer* deno

 def max(that:Rational)= if(this < that ) that else this

  def +(that:Rational)=
    new Rational(numer*that.deno+that.numer* deno, deno*that.deno)

  def *(that:Rational)=
    new Rational(that.numer*numer,that.deno*deno)

  def unary_- :Rational =
    new Rational(-numer,deno)

  def -(that:Rational)= this + -that


  override def toString= {
    val g=gcd(x,y)
    numer/g+"/"+deno/g
  }
}