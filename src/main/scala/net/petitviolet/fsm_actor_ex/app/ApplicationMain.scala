package net.petitviolet.fsm_actor_ex.app

import akka.actor.{ Props, ActorSystem }
import net.petitviolet.fsm_actor_ex.fsm.{ Retain, Change }
import net.petitviolet.fsm_actor_ex.fsm.SignalChangeFSMActor
import net.petitviolet.fsm_actor_ex.ping.PingActor

object ApplicationMain extends App {
  val system = ActorSystem("MyActorSystem")
  val signalActor = system.actorOf(Props[SignalChangeFSMActor], "fsm-signal")
  signalActor ! Change
  signalActor ! Change
  signalActor ! Retain
  signalActor ! Change
  signalActor ! Change
  signalActor ! Retain
  signalActor ! Change
  signalActor ! Change
  signalActor ! Retain
  signalActor ! Change
  signalActor ! Change
  signalActor ! Retain
  signalActor ! Change
  signalActor ! Change
  //  val pingActor = system.actorOf(PingActor.props, "pingActor")
  //  pingActor ! PingActor.Initialize
  // This example app will ping pong 3 times and thereafter terminate the ActorSystem - 
  // see counter logic in PingActor
  Thread.sleep(3000)
  system.terminate()
  //  system.awaitTermination()
}