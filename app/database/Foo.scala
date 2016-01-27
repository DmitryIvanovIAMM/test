package database

import play.api.Play
import play.api.db.slick.DatabaseConfigProvider
import scala.concurrent.Future
import slick.driver.JdbcProfile
import slick.driver.PostgresDriver.api._
import scala.concurrent.ExecutionContext.Implicits.global

case class Foo(Id: Long, Name: String)

class FooTableDef(tag: Tag) extends Table[Foo](tag, "Foo") {
  def Id = column[Long]("Id", O.PrimaryKey, O.AutoInc)
  def Name = column[String]("Name")

  override def * = (Id, Name) <>(Foo.tupled, Foo.unapply)
  def nameIndex = index("Name_IDX", Name, unique = true)
}

object Foos {
  val foos = TableQuery[FooTableDef]
  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  def add(foo: Foo): Future[Int] = dbConfig.db.run(foos += foo)
}
