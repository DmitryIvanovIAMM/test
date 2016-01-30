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
    "slick.dbs.default.db.acquireIncrement" -> "10"
  )

  implicit lazy val fakeApp: FakeApplication = new FakeApplication(additionalConfiguration = conf)
  protected lazy val dbConfig = DatabaseConfigProvider.get[JdbcProfile](FakeApplication())

  override def beforeAll() = {
    //dbConfig.db.run


    Play.start(fakeApp)
    recreateDbSchema(fakeApp)
    //Evolutions.applyEvolutions(databaseApi.database("default"))
  }

  private def recreateDbSchema(app: Application) = {
    //val dbConfig = DatabaseConfigProvider.get[JdbcProfile](app)
    import dbConfig.driver.api._

    val recreateSchema: DBIO[Unit] = DBIO.seq(
      sqlu"drop schema public cascade",
      sqlu"create schema public"
    )
    Await.ready(dbConfig.db.run(recreateSchema), 5.second)
  }

  override def afterAll() = {
    //Evolutions.cleanupEvolutions(databaseApi.database("default"))
    //dbConfig.db.shutdown
    Play.stop(fakeApp)
  }*/

  /*lazy val app: FakeApplication = FakeApplication(
      additionalConfiguration = Map("ehcacheplugin" -> "disabled")
    )
  Play.start(app)*/

  /*lazy val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  //import driver.api._


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
    "slick.dbs.default.db.acquireIncrement" -> "10",
    "domain" -> "http://localhost:9000",
    "play.application.loader" -> "modules.CustomApplicationLoader"
  )
  lazy val fakeApp: FakeApplication = new FakeApplication(additionalConfiguration = conf)
  Play.start(fakeApp)*/

  "Second Specification" should {

    "respond to login 1" in {
      val wellcome = route(FakeRequest(GET, "/")).get
      status(wellcome) should equal(OK)
    }

  }

}
