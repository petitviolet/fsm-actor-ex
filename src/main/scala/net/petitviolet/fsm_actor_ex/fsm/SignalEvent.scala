package net.petitviolet.fsm_actor_ex.fsm

sealed trait SignalEvent
case object ChangeSignal extends SignalEvent
case object RetainSignal extends SignalEvent
