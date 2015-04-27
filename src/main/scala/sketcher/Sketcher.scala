package sketcher

import org.scalajs.dom
import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport
import js.Dynamic.{global => g}
import paperjs._
import Basic._,Paths._,Items._,Styling._,Tools._,Projects._

@JSExport
object Sketcher {
  @JSExport
  def main(): Unit = {

    val circle = Shape.Circle(center = Point(200,200), radius = 50)

    circle.fillColor = Color("red")
    circle.strokeWidth = 3

    circle.onMouseEnter = (item: Item, e: dom.MouseEvent) => {
      item.strokeColor = Color("green")
    }

    val newColor = Color("black")

    g.paper.tool.onMouseMove = (e: ToolEvent) => {
      val path = Path.Circle(e.point, radius = 15)
      path.fillColor = newColor
      path.removeOnMove()
    }
    g.paper.view.asInstanceOf[View].update()
  }
}
