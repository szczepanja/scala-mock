import java.io.File

object CreateMock extends MockTrait {

  def getEnv: String = sys.env("PATH")

  def findFile(file: String): Seq[String] = {

    def isExists(dir: String) = {
      new File(dir + File.separatorChar + file).exists()
    }

    getEnv.split(File.pathSeparatorChar).filter(isExists)
  }

  def printPath(file: String, mock: MockTrait): Unit = {
    println(mock.findFile(file))
  }

}

trait MockTrait {
  def findFile(s: String): Seq[String]
}