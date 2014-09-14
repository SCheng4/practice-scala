# Thoughts on Scala
_Take about 20 minutes to collect and write about your initial impressions of Scala. Some possible topics include:_

## What's easy to do in Scala? What's not?

It is easy to implement something recursivley. It is also easy to iterate through a list or apply a function to a list via case matching and high order functions. It is not easy to tranverse the list backwards because higher order functions don't work there. Looping and other imperative structures are unnatural and theremore more difficult to do in Scala.

## What is/are your favorite language design choice(s) that the designers of Scala made? Why?

We liked the match/case pattern matching because it is a more powerful switch case that is also more streamlined. We like the class constructs, as we are familiar with object oriented programming paradigm and it helps the code be more correct at compile time. 

The designers probably inclued support for the object oreinted paradigm to make Scala more powerful and also a hybrid language. This makes Scala cool! 

## What is/are your least favorite language design choice(s)? Why? And why do you think the designers made that / those choice(s)?

We struggled with the terse syntax and the lack of documentation for beginners. The syntax is much more symbolic (and less word based) than most langauges we have learned. A lot of what we found in online searching and in the book was not geared toward beginners; there were not examples of how to use the various constructs. 

One example of weird syntax is uninutive rules for when to use brackets and parentheses. When using map for tuples you have to specific the anonymous function inside a case whereas you don't need to for a mpa. 

The designers probably made the choice for symbolic syntax for readability because it is probably much easier to read for experienced developers. It is a much cleaner and succint way of expressing algorithms. 

## What Scala features would you like to learn more about?

We would like to learn more about how to use /when to use the Option data structure. We also want to learn about Companion objects. We also had some trouble with the higher order functions and how to use them (e.g. foreach, map, reduce, filter, fold, etc). 