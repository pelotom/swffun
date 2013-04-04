package foo

class FooActivitiesImpl extends FooActivities {
  override def getName = "World"
  override def printGreeting(greeting:String) = println(greeting)
}