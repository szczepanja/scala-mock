import org.scalamock.scalatest.MockFactory
import org.scalatest.funsuite.AnyFunSuite

class MockSpec extends AnyFunSuite with MockFactory {

  test("???") {
    val mockFormatter = mock[MockTrait]
    val file = "kubectl"

    (mockFormatter.findFile _).expects(file).returning(Seq("usr/local/bin")).once()

    CreateMock.printPath(file, mockFormatter)

  }

}
