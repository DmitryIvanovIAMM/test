package controllers

//import fixture.PlaySpec
import fixture.PlaySpec
import org.scalatest.Matchers
import org.scalatestplus.play.{OneAppPerSuite}
import play.api.{ Play}
import play.api.db.evolutions.Evolutions
import play.api.db.slick.DatabaseConfigProvider
import play.api.test.{FakeApplication, FakeRequest}
import play.api.test.Helpers._
import slick.driver
import slick.driver.JdbcProfile
import scala.concurrent.Await
import scala.language.implicitConversions
import scala.concurrent.duration._

class SecondSpec extends PlaySpec {

  "Second Specification" should {

    "respond to login 1" in {
      val wellcome = route(FakeRequest(GET, "/")).get
      status(wellcome) should equal(OK)
    }

  }

}
