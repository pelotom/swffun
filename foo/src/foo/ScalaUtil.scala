package foo

import com.amazonaws.services.simpleworkflow.flow.core.{Promise, Functor}
import com.amazonaws.services.simpleworkflow.flow.core.Promise._
import com.amazonaws.services.simpleworkflow.flow.core.Settable
import scalaz.Monad
import scalaz.Each

object ScalaUtil {
  implicit def promiseMonad:Monad[Promise] = new Monad[Promise] {
    override def point[A](a: => A): Promise[A] = asPromise(a)
    override def bind[A, B](p: Promise[A])(f: A => Promise[B]): Promise[B] = new Functor[B](p) {
      override def doExecute() = f(p.get())
    }
  }
  
  implicit def promiseEach = new Each[Promise] {
    override def each[A](p:Promise[A])(f: A => Unit) { promiseMonad.map(p)(f) }
  }
}
