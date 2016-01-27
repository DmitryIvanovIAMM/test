
import database._
import models.ApiFoo
import org.junit.runner._
import org.scalatest.{OptionValues, Matchers, SequentialNestedSuiteExecution, WordSpec}
import org.scalatestplus.play.OneAppPerSuite
import org.specs2.runner._
import play.api.http.MimeTypes
import play.api.test.Helpers._
import play.api.test._

import scala.concurrent.ExecutionContext.Implicits.global

@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends WordSpec
  with OneAppPerSuite
  with SequentialNestedSuiteExecution
  with Matchers
  with OptionValues {

  val jsonHeaders = FakeHeaders(Seq((CONTENT_TYPE, MimeTypes.JSON)))
  val conf = Map(
    "slick.dbs.default.driver" -> "slick.driver.H2Driver$",
    "slick.dbs.default.db.driver" -> "org.h2.Driver",
    "slick.dbs.default.db.url" -> "jdbc:h2:mem:test;MODE=PostgreSQL;DATABASE_TO_UPPER=FALSE"
  )

  def fakeApp: FakeApplication = new FakeApplication(additionalConfiguration = conf)

  "Application" should {

    "Add foo" in new WithApplication(fakeApp){
      Foos.add(new Foo(0, "TEST")).map(r => r should equal(OK))
    }

    "add new foo via api" in new WithApplication(fakeApp){
      val f = new ApiFoo(0, "test")
      val add = route(FakeRequest(POST, "/async-add", jsonHeaders, f.toJson())).get
      status(add) should equal(OK)
    }
  }
}
