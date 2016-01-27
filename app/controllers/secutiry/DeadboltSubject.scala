package controllers.security


import play.libs.Scala
import be.objectify.deadbolt.core.models.Subject
import slick.driver.PostgresDriver.api._
import play.api.Play.current

import be.objectify.deadbolt.scala.DeadboltExecutionContextProvider
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.Await

class DeadboltSubject(val userId: Int) extends Subject
{
  def getRoles: java.util.List[SecurityRole] = {
    Scala.asJava(List(new SecurityRole("myRole")))
    /*DB.withSession { implicit session =>
      val roles = for {
        userRole <- UserRoles if userRole.userId === userId
        role <- Roles if role.id === userRole.roleId
      } yield role.name
      Scala.asJava(roles.list.map(name => new SecurityRole(name)))
    }
    Await.result(RoleDao.queryNamesById(userId).map{ roles =>
      Scala.asJava(roles.map(name => new SecurityRole(name)))},
      10.second)*/
  }

  def getPermissions: java.util.List[UserPermission] = {
    Scala.asJava(Nil)
  }

  def getIdentifier: String = userId.toString
}