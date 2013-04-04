package foo

import MonadicPromise._

class FooWorkflowImpl extends FooWorkflow {
  val activities = new FooActivitiesClientImpl();

  override def startFoo() = for {
    name 	<- activities.getName
    _ 		<- activities.printGreeting(s"Hello $name!")
  } yield ()
}
