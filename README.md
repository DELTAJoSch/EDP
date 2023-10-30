# EDP
ExceptionDrivenPolymorphism
This very serious new Library brings polymorphism to Java.

## Idea
Since Java doesn't support polymorphism, how about we just add it in after the fact?
Using EDP, this can be done easily (at least as long as you don't value your Code making sense :) )
In EDP, every return Value is an exception. Instead of using return statements for results, throw statements throw ResultExceptions.
These Exceptions contain the return value and therefore support Polymorphism, as arbitrarily many different exception types can be thrown.

## But what about Exceptions?
A good question! Instead of throwing exceptions, we use return statements to signal a failure!

See an example in the example folder.
