package io.reactors
package debugger



import org.json4s._



trait WebApi {
  /** Either the full state or the sequence of updates since the specified timestamp.
   *
   *  @param suid   unique identifier of the session
   *  @param ts     timestamp of the last update
   *  @return       the the state change since the last update
   */
  def state(suid: String, ts: Long): JValue

  /** Gets an existing, or starts a new REPL.
   *
   *  Returns an existing REPL only if the request specifies the UID of the current
   *  session, and the REPL with the specified UID exists, and the requested type
   *  matches the type of the existing REPL. Otherwise, starts a new REPL.
   *
   *  @param suid     unique identifier of the session
   *  @param repluid  unique identifier of the REPL in this session
   *  @param tpe      type of the requested REPL
   *  @return         the (actual) session UID, and REPL UID
   */
  def replGet(suid: String, repluid: Long, tpe: String): JValue

  /** Evaluates a command in the REPL.
   *
   *  @param suid     session UID
   *  @param repluid  REPL UID
   *  @param command  string with the contents of the command to execute
   *  @return         the status and the output of the command
   */
  def replEval(suid: String, repluid: Long, cmd: String): JValue
}