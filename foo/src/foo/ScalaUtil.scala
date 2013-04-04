package foo

import com.amazonaws.services.simpleworkflow.flow.core.{Promise, Functor}

object ScalaUtil {
	implicit def monadicPromise[A]: Promise[A]=>MonadicPromise[A] = MonadicPromise(_)
	
	case class MonadicPromise[A](p:Promise[A]) {
	  def flatMap[B](f:A=>Promise[B]):Promise[B] = new Functor[B](p) {
	    def doExecute() = f(p.get())
	  }
	  def map[B](f:A=>B):Promise[B] = flatMap((a:A) => Promise.asPromise(f(a)))
	  def foreach(f:A=>Unit) = map(f)
	}
}