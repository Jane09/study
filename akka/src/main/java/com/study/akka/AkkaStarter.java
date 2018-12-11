package com.study.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.actor.Props;

/**
 * @author tb
 * @date 2018/12/11 16:46
 */
public class AkkaStarter {

    public static void main(String[] args) {
        String name = "akka";
        ActorSystem system = ActorSystem.create(name);
        ActorRef ref = system.actorOf(Props.create(MessageProducer.class,"producer"));
        Inbox inbox = Inbox.create(system);

        ref.tell(new Message("hello"), ActorRef.noSender());

    }
}
