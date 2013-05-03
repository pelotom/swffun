package foo

import ScalaUtil._
import scalaz._
import Scalaz._
import scalaz.Monad._
import std.indexedSeq._
import com.amazonaws.services.simpleworkflow.flow.core.Promise
import effectful._
import language.postfixOps

class FooWorkflowImpl extends FooWorkflow {
  
  val activities = new FooActivitiesClientImpl();
  import activities._

  override def startFoo() = effectfully {
    val everybody = for (i <- 1 to 20; if i % 2 == 0) yield {
      val name = getName(i).!
      if (name == "World #2") {
        printGreeting(s"There you are #2!").!
      } else {
        printGreeting("Hello someone else!").!
      }
      name
    }
    println("finished saying hi to $everybody")
  }
}
