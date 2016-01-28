package controllers

import fixture.PlaySpec
import play.api.test.FakeRequest
import play.api.test.Helpers._
import scala.language.implicitConversions

class FirstSpec extends PlaySpec {

  "First Specification" should {

    "respond to login 1" in {
      val wellcome = route(FakeRequest(GET, "/")).get
      status(wellcome) should equal(OK)
    }

  }

}
