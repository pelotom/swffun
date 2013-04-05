package foo

class FooActivitiesImpl extends FooActivities {
  override def getName(count:Int) = s"World #$count"
  override def printGreeting(greeting:String) = println(greeting)
}