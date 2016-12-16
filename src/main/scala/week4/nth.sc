
import week4._

object test {

  def nth[T](n: Int, xs: List[T]): T =
    if (xs.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) xs.head
    else nth(n - 1, xs.tail)

  def list: List[Int] = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, new Nil[Int])))

  System.out.print("Hello");

  nth(1, list)

}