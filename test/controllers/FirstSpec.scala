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
//import slick.dbio.DBIO
import slick.driver
import slick.driver.JdbcProfile
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.language.implicitConversions
//import slick.dbio.DBIO

class FirstSpec extends PlaySpec {

  /*protected lazy val dbConfig = DatabaseConfigProvider.get[JdbcProfile](FakeApplication())
  val conf = Map(
    "slick.dbs.default.driver" -> "slick.driver.H2Driver$",
    "slick.dbs.default.db.driver" -> "org.h2.Driver",
    "slick.dbs.default.db.url" -> "jdbc:h2:mem:education-link;MODE=PostgreSQL;DB_CLOSE_ON_EXIT=FALSE",
    "slick.dbs.default.db.user" -> "sa",
    "slick.dbs.default.db.password" -> "",
    "slick.dbs.default.db.logStatements" -> "true",
    "slick.dbs.default.db.connectionTimeout" -> "30000",
    "slick.dbs.default.db.maxConnectionsPerPartition" -> "100",
    "slick.dbs.default.db.minConnectionsPerPartition" -> "10",
    "slick.dbs.default.db.acquireIncrement" -> "10"
  )

  implicit lazy val fakeApp: FakeApplication = new FakeApplication(additionalConfiguration = conf)

  override def beforeAll() = {


    Play.start(fakeApp)
    //Evolutions.applyEvolutions(databaseApi.database("default"))
  }

  override def afterAll() = {
    //Evolutions.cleanupEvolutions(databaseApi.database("default"))
    //dbConfig.db.shutdown
    //dbConfig.db.close()
    //Play.application.
    //Play.stop(fakeApp)

    //recreateDbSchema(fakeApp)


  }*/



  import scala.concurrent.ExecutionContext.global

  // Override app if you need a FakeApplication with other than
  // default parameters.
  /*lazy val app: FakeApplication = FakeApplication(
    additionalConfiguration = Map("ehcacheplugin" -> "disabled")
  )
  Play.start(app)*/


  //lazy val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  //import driver.api._


  /*val conf = Map(
    "slick.dbs.default.driver" -> "slick.driver.H2Driver$",
    "slick.dbs.default.db.driver" -> "org.h2.Driver",
    "slick.dbs.default.db.url" -> "jdbc:h2:mem:education-link;MODE=PostgreSQL;DB_CLOSE_ON_EXIT=FALSE",
    "slick.dbs.default.db.user" -> "sa",
    "slick.dbs.default.db.password" -> "",
    "slick.dbs.default.db.logStatements" -> "true",
    "slick.dbs.default.db.connectionTimeout" -> "30000",
    "slick.dbs.default.db.maxConnectionsPerPartition" -> "100",
    "slick.dbs.default.db.minConnectionsPerPartition" -> "10",
    "slick.dbs.default.db.acquireIncrement" -> "10",
    "domain" -> "http://localhost:9000",
    "play.application.loader" -> "modules.CustomApplicationLoader"
  )
  lazy val fakeApp: FakeApplication = new FakeApplication(additionalConfiguration = conf)
  Play.start(fakeApp)*/

  "First Specification" should {

    "respond to login 1" in {
      val wellcome = route(FakeRequest(GET, "/")).get
      status(wellcome) should equal(OK)
    }

  }

}
