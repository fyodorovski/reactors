package io.reactors
package services






/** Contains I/O-related services.
 */
class Io(val system: ReactorSystem) extends Protocol.Service {
  val defaultCharset = Charset.defaultCharset.name

  def shutdown() {}
}
