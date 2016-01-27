package controllers

import play.api._
import play.api.libs.json.JsError
import play.api.mvc._
import database._
import models._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class Application extends Controller {

  def add = Action.async(parse.json) { request =>
    request.body.validate[ApiFoo].fold(
      errors => {
        Future {
          BadRequest(JsError.toJson(errors))
        }
      },
      foo => {
        Foos.add(new Foo(0, foo.Name)).map(i => Ok(i.toString))
      }
    )
  }
}
