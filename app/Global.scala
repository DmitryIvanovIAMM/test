import data.TestDataLoader
import play.api._
import util.Logging

object Global extends GlobalSettings with Logging {
  override def onStart(app: Application): Unit = {
    super.onStart(app)
    val tdl = new TestDataLoader()
    app.mode match {
      case Mode.Dev =>
        info("Loading Test Data in Dev Mode")
        tdl.insertTestData()
      case Mode.Test =>
        info("Loading Test Data in Test Mode")
        tdl.insertTestData()
      case Mode.Prod =>
        info("Not doing anything as it's PROD")
    }
  }
}
