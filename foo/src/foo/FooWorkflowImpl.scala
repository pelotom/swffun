package foo

import ScalaUtil._
import scalaz._
import Scalaz._
import scalaz.Monad._
import std.indexedSeq._
import com.amazonaws.services.simpleworkflow.flow.core.Promise

class FooWorkflowImpl extends FooWorkflow {
  
  val activities = new FooActivitiesClientImpl();

  override def startFoo() {
    for {
      names <- 1 to 20 traverse greet
    } yield println(s"All done: ${names.length} greetings delivered")
  }
  
  def greet(i:Int): Promise[String] = for {
    name 	<- activities getName i
    _ 		<- activities printGreeting s"Hello $name!"
  } yield name
}
