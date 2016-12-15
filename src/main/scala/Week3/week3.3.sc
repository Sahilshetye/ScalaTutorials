/// Binary tree Tree with adding the
//Used for persistent datastructure
object excercise {
  val t1 = new NonEmpty(8, Empty,  Empty)
  val t2 =  t1 incl 10
  val t3= new NonEmpty(10, Empty,  Empty) union (t1 incl 4)


  abstract class Intset {
    def incl(x: Int): Intset

    def contains(x: Int): Boolean

    def union(other:Intset):Intset
  }

  object Empty extends Intset {
    override  def contains(x: Int): Boolean = false

   override def incl(x: Int): Intset = new NonEmpty(x, Empty, Empty)

   override def toString: String = "."

    override def union(other: Intset): Intset = other
  }

  class NonEmpty(elem: Int, left: Intset, right: Intset) extends Intset {
      override def contains(x: Int): Boolean =
      if (x < elem) left contains x
      else if (x > elem) right contains x
      else true

    override def incl(x: Int): Intset =
      if (x < elem) new NonEmpty(x, left incl x, right)
      else if (x > elem) new NonEmpty(x, left, right incl x)
      else this

    def union(other: Intset): Intset =
      ((left union right)union other) incl elem

    override def toString: String = "{" + left + elem + right + "}"
  }

}