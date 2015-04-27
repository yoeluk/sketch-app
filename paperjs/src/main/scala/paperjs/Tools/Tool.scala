package paperjs
package Tools

import scala.scalajs.js

/**
 * Created by yoelusa on 27/04/15.
 */

trait Tool extends EventHandling[Tool] {
  var minDistance: Double = js.native
  var maxDistance: Double = js.native
  var fixedDistance: Double = js.native
  var onMouseDown: js.Function1[ToolEvent, Unit] = js.native
  var onMouseUp: js.Function1[ToolEvent, Unit] = js.native
  var onMouseMove: js.Function1[ToolEvent, Unit] = js.native
  var onMouseDrag: js.Function1[ToolEvent, Unit] = js.native
  var onKeyDown: js.Function1[ToolEvent, Unit] = js.native
  var onKeyUp: js.Function1[ToolEvent, Unit] = js.native
  def activate(): Unit = js.native
  def remove(): Unit = js.native
}
