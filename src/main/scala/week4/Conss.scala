package week4

import java.util.NoSuchElementException

/**
  * Created by sahil.shetye on 12/16/2016.
  * Not Scalable  hence scaled to a generalised parameter  T (Like in  JAVA ) and implemented the same is implementedin the  Trait INTSET which is basically a interface.
  */
//class Cons(val head:Int, val tail:Intlist) extends Intlist {
//
//}
//
//class Nil extends Intlist{
//
//}
trait List[T] {
  def isEmpty:Boolean
  def head:T
  def tail:List[T]
}

class Cons[T](val head:T, val tail:List[T]) extends List[T] {
  def isEmpty: Boolean= false


}

class Nil[T] extends List[T]{
  def isEmpty:Boolean= true
  // Error are always Nothing type and are passed as nothing in the p
  def head:Nothing = throw  new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")

}


