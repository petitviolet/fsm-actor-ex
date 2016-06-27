package net.petitviolet.fsm_actor_ex.fsm

sealed trait SignalData

object SignalData {
  sealed case class SignalColor(value: String) extends SignalData
  val RedData = SignalColor("red")
  val YellowData = SignalColor("yellow")
  val GreenData = SignalColor("green")
}

