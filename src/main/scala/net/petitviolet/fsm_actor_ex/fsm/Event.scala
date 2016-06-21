package net.petitviolet.fsm_actor_ex.fsm

sealed trait Event
case object Change extends Event
case object Retain extends Event
