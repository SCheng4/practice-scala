package org.scalalabs.basic.lab03
import sys._
/**
 * This exercise introduces you to pattern matching in combination with recursion.
 *
 * Recursion is a key concept for the functional style programming.
 * In the exercises below you learn how to apply recursion in combination with Scala's pattern matching facilities.
 *
 * For this exercise exclusively use pattern matching constructs in order to make the corresponding unittest work.
 *
 * Reference material to solve these exercises can be found here:
 * Pattern matching in general: http://programming-scala.labs.oreilly.com/ch03.html#PatternMatching
 * Pattern matching and recursion: http://programming-scala.labs.oreilly.com/ch08.html#Recursion
 */

//Modified by Sisi Cheng & Jean Sung
object RecursionPatternMatchingExercise {

  /**
   * ***********************************************************************
   * Recursive algorithms with pattern matching
   * For expected solution see unittest @RecursionPatternMatchingExerciseTest
   * ***********************************************************************
   */
  /**
   * Create a method that checks that each subsequent value is greater than
   * the previous one.
   * E.g.:
   * checkValuesIncrease(Seq(1,2,3)) == true
   * checkValuesIncrease(Seq(1,2,2)) == false
   */
  def checkValuesIncrease(seq: Seq[Int]): Boolean = {
    seq match {
      case Nil => true
      case (f::Nil) => true

      // recursively cutting head off list to check 
      case (f::s::r) => if (s > f) checkValuesIncrease(s::r) else false
    }
  }
  
  /**
   * Group Consecutive values
   * List(1,1,2,3,1,1) -> List(1,1), List(2), List(3), List(1,1)
   */
  def groupConsecutive[T](in: List[T]): List[List[T]] = {
    in match {
      case Nil => Nil
      case (f::r) => 
        val result = groupConsecutive(in.tail)
        //if the result already has a list with current value, prepend it to the list
        if (!result.isEmpty && (result.head contains(in.head))) (in.head :: result.head) :: result.tail
        // else, create a new list for the value, and prepend it to the list
        else List(in.head) :: result
    }
  }

  /**
   * Group Equal values
   * List(1,1,2,3,1,1) -> List(1,1,1,1), List(2), List(3)
   */
  def groupEquals[T](in: List[T]): List[List[T]] = {
    in match {
      case Nil => Nil
      case (f::r) => 
        val result = groupEquals(r)
        // flatten the overall list, check to see if there is a list that contains the current
        // if yes, prepend it to the mini list
        if (result.flatten contains f) result.map(ele=> if (ele contains f) f::ele else ele)
        // else create a new list for that element, concat with result 
        else List.concat(result, List(List(f))) 
    }
    

  }

  /**
   * Compress values
   * List(1,1,2,3,1,1) -> List(1,2,3)
   */
  def compress[T](in: List[T]): List[T] = {
    in match {
      case Nil => Nil
      case (f::r) => 
        val result = compress(r)
        //drop front element if already in list
        if (result contains f) result else  f:: result
          
    }
  }
  
  /**
   * Define the amount of all equal members
   * List(1,1,2,3,1,1) -> List((4,1),(1,2),(1,3))
   */
  def amountEqualMembers[T](in: List[T]): List[(Int, T)] = {
    
    // used a helper method so that we could reverse the list (cannot traverse the list backwards) 
	def amountEqualMembersInnerRecusive [T](in: List[T]): List[(Int, T)] = { 
			in match {
				case Nil => Nil
				case (f::r) => 
				  val result =  amountEqualMembersInnerRecusive(r)
				  // if there was already a mini list with our  element, ++ for counter in 1st element of tuple
				  if (result.map({case (a, b) => b}) contains f) result.map({case(a, b)=> if (b == f) (a+1, b) else (a, b)})
				  // else make a new embedded list for element, concat with results
				  else List.concat(result,List((1, f)))}
		  }
	amountEqualMembersInnerRecusive(in.reverse)
  }
  
  /**
   * Zip multiple lists
   * List(List(1,2,3), List('A, 'B, 'C), List('a, 'b, 'c)) -> List(List(1, 'A, 'a), List(2, 'B, 'b), List(3, 'C, 'c))
   */
  def zipMultiple(in: List[List[_]]): List[List[_]] = {
    in match {
      case Nil => List()
      case f::Nil => f.map(ele => List(ele))
      case f::r => {
        val result = zipMultiple(r)
        // zip does 2 lists, mapping will zip all of the rest of the lists
        (f.zip(result)).map({case (ele, list) => ele::list})
      }
    }
  }

  /**
   * Zip multiple lists with different sizes
   * List(List(1), List('A, 'B, 'C), List('a, 'b)) -> List(List(1, 'A, 'a))
   */
  def zipMultipleWithDifferentSize(in: List[List[_]]): List[List[_]] = {
    
     // previous alg works here too! 
    // map has good default behavior (for empty cases)
        in match {
      case Nil => List()
      case f::Nil => f.map(ele => List(ele))
      case f::r => {
        val result = zipMultiple(r)
        (f.zip(result)).map({case (ele, list) => ele::list})
      }
    }
  }

}
