package controllers

import fixture.PlaySpec
import play.api.test.FakeRequest
import play.api.test.Helpers._
import scala.language.implicitConversions

class SecondSpec extends PlaySpec {

  "Second Specification" should {

    "respond to login 1" in {
      val wellcome = route(FakeRequest(GET, "/")).get
      status(wellcome) should equal(OK)
    }

  }

}
