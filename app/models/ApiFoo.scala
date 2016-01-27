package models

import play.api.libs.functional.syntax._
import play.api.libs.json.{Writes, JsPath, Reads, Json}

case class ApiFoo(Id: Long, Name: String) {
  def toJson(): String = Json.stringify(Json.toJson(this))
}

object ApiFoo {
  def fromJson(json: String): ApiFoo = Json.parse(json).as[ApiFoo]
  implicit val apiFooReads: Reads[ApiFoo] =(
      (JsPath \ "Id").read[Long] and (JsPath \ "Name").read[String]
    )(ApiFoo.apply _)

  implicit val apiFooWrites: Writes[ApiFoo] = (
    (JsPath \ "Id").write[Long] and
      (JsPath \ "Name").write[String]
    )(unlift(ApiFoo.unapply))
}
