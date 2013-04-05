package foo

import ScalaUtil._
import scalaz._
import Scalaz._
import scalaz.Monad._
import std.indexedSeq._

class FooWorkflowImpl extends FooWorkflow {
  val activities = new FooActivitiesClientImpl();

  override def startFoo() = for (i <- 1 to 20) {
    for {
      name 	<- activities.getName(i)
      _		<- activities.printGreeting(s"Hello $name!")
    }()
  }
}
