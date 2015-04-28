package sketcher

import org.scalajs.dom.html
import scala.scalajs.js.annotation.JSExport
import paperjs._
import Basic._,Paths._,Items._,Styling._,Tools._

@JSExport
object Sketcher {
  @JSExport
  def main(canvas: html.Canvas): Unit = {

    Paper.setup(canvas)
    val tool = Tool()

    val newColor = Color("black")

    tool.onMouseMove = (e: ToolEvent) => {
      val path = Path.Circle(e.point, radius = 15)
      path.fillColor = newColor
      path.removeOnMove()
    }

    val circle = Shape.Circle(Point(200,200), radius = 50)

    circle.fillColor = Color("red")
    circle.strokeWidth = 3

    circle.onMouseEnter = (item: Item, e: ToolEvent) =>
      item.strokeColor = Color("green")

    Paper.view.update()
  }
}
