package net.petitviolet.fsm_actor_ex.fsm

sealed trait State
case object Red extends State
case object Green extends State
case object Yellow extends State
