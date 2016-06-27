package net.petitviolet.fsm_actor_ex.fsm

sealed trait SignalState
case object Red extends SignalState
case object Green extends SignalState
case object Yellow extends SignalState
