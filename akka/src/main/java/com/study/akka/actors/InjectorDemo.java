package com.study.akka.actors;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import lombok.RequiredArgsConstructor;

/**
 * @author tb
 * @date 2018/12/12 16:56
 */
public class InjectorDemo {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("injector");
        ActorRef ref = system.actorOf(Props.create(DependencyInjector.class,"applicationContext","TheActor"),"TheActor");
        ref.tell("hello",ActorRef.noSender());
    }

    @RequiredArgsConstructor
    class DependencyInjector implements IndirectActorProducer {

        final Object applicationContext;
        final String beanName;

        @Override
        public Actor produce() {
            return new TheActor((String)applicationContext);
        }

        @Override
        public Class<? extends Actor> actorClass() {
            return TheActor.class;
        }
    }

    @RequiredArgsConstructor
    class TheActor extends AbstractActor {
        private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
        final String applicationContext;

        @Override
        public Receive createReceive() {
            return receiveBuilder().match(String.class, s -> {
                log.info("Received String message: {} {}", s);
            })
                    .matchAny(o -> log.info("received unknown message"))
                    .build();
        }
    }
}
