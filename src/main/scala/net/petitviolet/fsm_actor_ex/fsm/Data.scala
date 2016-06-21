package net.petitviolet.fsm_actor_ex.fsm

sealed trait Data
case class SignalColor(value: String) extends Data
