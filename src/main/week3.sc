

  val x= new Rational(1,3)
  x.numer
  x.deno
  val y= new Rational(5,7)
  val z= new Rational(3,2)
  x.add(y).mul(z)
  x.sub(y).sub(z)

class Rational(x:Int,y:Int)
{
  def  numer= x
  def deno= y

  def add(that:Rational)=
    new Rational(numer*that.deno+that.numer* deno, deno*that.deno)

  def mul(that:Rational)=
    new Rational(that.numer*numer,that.deno*deno)

  def neg=
    new Rational(-numer,deno)

  def sub(that:Rational)= add(that.neg)


  override def toString: String = numer+"/"+deno
}