package net.petitviolet.fsm_actor_ex.fsm

import akka.actor.{ FSM, Actor }
import net.petitviolet.fsm_actor_ex.fsm.SignalData._

class SignalChangeFSMActor extends Actor with FSM[SignalState, SignalData] {
  startWith(Red, RedData)

  private def stayWithLogging = {
    println(s"retain: $stateData")
    stay
  }

  private def gotoWithLogging(d: Any)(s: SignalState) = {
    println(s"current => $stateData, d => $d")
    goto(s)
  }

  when(Green) {
    case Event(ChangeSignal, _) => goto(Yellow) using YellowData
    case Event(RetainSignal, _) => stay
  }

  when(Yellow) {
    case Event(ChangeSignal, _) => goto(Red) using RedData
    case Event(RetainSignal, _) => stay
  }

  when(Red) {
    case Event(ChangeSignal, _) => goto(Green) using GreenData
    case Event(RetainSignal, _) => stay
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
