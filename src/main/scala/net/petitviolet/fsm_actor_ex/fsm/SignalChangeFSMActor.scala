package net.petitviolet.fsm_actor_ex.fsm

import akka.actor.{ FSM, Actor }

class SignalChangeFSMActor extends Actor with FSM[State, SignalColor] {
  startWith(Red, SignalColor("init"))

  when(Green) {
    case Event(Change, _) => goto(Yellow) using SignalColor("green -> yello")
    case Event(Retain, _) => stay using SignalColor("retain green")
  }

  when(Yellow) {
    case Event(Change, _) => goto(Red) using SignalColor("yellow -> red")
    case Event(Retain, _) => stay using SignalColor("retain yellow")
  }

  when(Red) {
    case Event(Change, _) => goto(Green) using SignalColor("red -> green")
    case Event(Retain, _) => stay using SignalColor("retain red")
  }

  onTransition {
    case Green -> Yellow =>
      println(s"WARN! green -> yellow: $stateData")
    case Yellow -> Red =>
      println(s"CAUTION! yellow -> red: $stateData")
    case Red -> Green =>
      println(s"OK! red -> green: $stateData")
  }

  onTermination {
    case StopEvent(_, _, _) =>
      println("Shutting down FSM...")
  }

  initialize()
}
