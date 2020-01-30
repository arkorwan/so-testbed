package io.github.arkorwan.testbed

import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar

import scala.reflect.ClassTag

object SO59949979 {
  class A {
    def foo(x: String): String = "A_" + x
  }

  class B {
    def foo(x: String): String = "B_" + x
  }
}

class SO59949979 extends AnyFunSuite with MockitoSugar {

  import SO59949979._

  def adapt[F, T <: AnyRef : ClassTag](impl: F): T = {

    mock[T](new Answer[Any]() {
      override def answer(inv: InvocationOnMock): Any =
        impl.getClass
          .getDeclaredMethod(inv.getMethod.getName, inv.getMethod.getParameterTypes:_*)
          .invoke(impl, inv.getArguments:_*)
    })
  }

  test("reflective mock"){
    println(adapt[B, A](new B()).foo("foo"))
  }

}
