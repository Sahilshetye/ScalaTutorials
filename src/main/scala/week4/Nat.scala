package week4

import java.util.NoSuchElementException

/**
  * Created by sahil.shetye on 12/16/2016.
  * IMPORTANT CONCEPT
  * PEANO NUMBERS
  */
abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat= new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat
{
  def isZero: Boolean= true
  def predecessor: Nat= throw new Error("0.predecessor")
  def + (that:Nat):Nat =  that
  def - (that:Nat):Nat =  if (that.isZero) this else throw new Error("Negative No")

}

class Succ(n:Nat) extends Nat{
  def isZero: Boolean=  false
  def predecessor: Nat = n
  def + (that:Nat):Nat = new Succ(n + that)
  def - (that:Nat):Nat = if(that.isZero) this else n- that.predecessor

}