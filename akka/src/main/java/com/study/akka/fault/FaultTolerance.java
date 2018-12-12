package com.study.akka.fault;

import akka.actor.AbstractActor;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.japi.pf.DeciderBuilder;

import java.time.Duration;

/**
 *
 * 容错
 * @author tb
 * @date 2018/12/12 17:22
 */
public class FaultTolerance {

    public static void main(String[] args) {

    }


    static class Supervisor extends AbstractActor {

        private static SupervisorStrategy strategy =
                new OneForOneStrategy(10, Duration.ofMinutes(1),
                        DeciderBuilder
                                .match(ArithmeticException.class, e -> SupervisorStrategy.resume())
                                .match(NullPointerException.class, e -> SupervisorStrategy.restart())
                                .match(IllegalArgumentException.class, e -> SupervisorStrategy.stop())
                                .matchAny(o -> SupervisorStrategy.escalate())
                                .build());

        @Override
        public SupervisorStrategy supervisorStrategy() {
            return strategy;
        }

        @Override
        public Receive createReceive() {
            return receiveBuilder()
                    .match(Props.class, props -> {
                        getSender().tell(getContext().actorOf(props), getSelf());
                    })
                    .build();
        }
    }
}
