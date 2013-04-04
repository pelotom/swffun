package foo

import com.amazonaws.services.simpleworkflow.flow.core.{Promise, Functor}
import com.amazonaws.services.simpleworkflow.flow.core.Promise._
import com.amazonaws.services.simpleworkflow.flow.core.Settable

class MonadicPromise[A](p: Promise[A]) {
  import MonadicPromise._
  
  def flatMap[B](f: A => Promise[B]): Promise[B] = new Functor[B](p) {
    override def doExecute() = f(p.get())
  }
  def map[B](f: A => B): Promise[B] = flatMap((a: A) => wrap(f(a)))
  def foreach(f: A => Unit) = map(f)
//  def filter(f: A => Boolean): Promise[A] = flatMap((a: A) => if (f(a)) wrap(a) else empty())
}

object MonadicPromise {
  def wrap[A](a: A): Promise[A] = asPromise(a)
  def empty[A](): Promise[A] = new Settable()

  implicit def monadicPromise[A]: Promise[A] => MonadicPromise[A] = new MonadicPromise(_)
}
