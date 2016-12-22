


object mergesort{
import math.Ordering
// writing implicit in ordering  will enable the compiler to compile and implicitly decide the type
  def msort[T](xs:List[T] )(implicit ord:Ordering[T]):List[T]={
    // def msort[T](xs:List[T] )(lt:(T,T)=>Boolean):List[T]={
    val n= xs.length/2
    if(n == 0) xs
    else{
     def merge(xs: List[T],ys:List[T]):List[T]= (xs,ys) match
       {
       case (Nil,ys)=> ys
         case(xs,Nil)=> xs
         case(x::xs1,y::ys1)=>
           if(ord.lt(x,y)) x :: merge(xs1,ys)
           else y :: merge(xs,ys1)
     }


       val(fst,scnd)=xs splitAt n
      //merge(msort(fst)(ord),msort(scnd)(ord)) partially  pararmterized
      merge(msort(fst),msort(scnd)) // fully paramterized
    }

  }
  val nums= List(-4,2,6,1,-8)
 // msort(nums)(Ordering.Int) // parametrized with  Ordering
  // msort(nums)((x:Int , y:Int) => x<y) // non parameterized
msort(nums)  // full paramterized
  val l= List("apple","pineapple","orange","banana")
 // msort(l)((x:String,y:String)=>x.compareTo(y)<0) // non - pararmterized version
 // msort(l)(Ordering.String)   //partially parameterized
  msort(l) // fully paramterized

}