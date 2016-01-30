package controllers

import controllers.security.{MyDeadboltHandler}
import dao.AddressDao
import models._
import play.api.Play
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfig}
import play.api.mvc._
import slick.driver.JdbcProfile
import scala.concurrent.ExecutionContext.Implicits.global

object Application extends Controller
  with HasDatabaseConfig[JdbcProfile]
  with AddressDatabaseModule {

  protected val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)
  import driver.api._

  def index = Action.async { implicit request =>
    AddressDao().queryById(1).map {
      address =>
        Ok(views.html.index(address, new MyDeadboltHandler))
    }
  }

}
