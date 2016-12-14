
//Rational number with simplified
val x= new Rational(1,3)
x.numer
x.deno
val y= new Rational(5,7)
val z= new Rational(3,2)
x.add(y).mul(z)
x.sub(y).sub(z)
x.less(y)
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

 def less(that:Rational)=numer*that.deno < that.numer* deno

 def max(that:Rational)= if(this.less(that)) that else this

  def add(that:Rational)=
    new Rational(numer*that.deno+that.numer* deno, deno*that.deno)

  def mul(that:Rational)=
    new Rational(that.numer*numer,that.deno*deno)

  def neg=
    new Rational(-numer,deno)

  def sub(that:Rational)= add(that.neg)


  override def toString= {
    val g=gcd(x,y)
    numer/g+"/"+deno/g
  }
}