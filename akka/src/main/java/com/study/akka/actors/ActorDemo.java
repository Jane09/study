package com.study.akka.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tb
 * @date 2018/12/12 16:35
 */
public class ActorDemo {

    public static void main(String[] args) {

        ActorSystem system = ActorSystem.create("actors");
        Props props1 = Props.create(MyActor.class);
        ActorRef ref = system.actorOf(props1);
        for(int i=1;i<=1000;i++){
            ref.tell("hello_"+i,ActorRef.noSender());
        }


//        Props props2 = Props.create(ActorWithArgs.class,"arg");
//        ActorRef ref2 = system.actorOf(props2);
//        ref2.tell("world",ActorRef.noSender());

        //careful,not recommended
//        Props props3 = Props.create(ActorWithArgs.class, () -> new ActorWithArgs("arg"));

//        system.stop(ref);
    }

    @AllArgsConstructor
    @Getter
    static class ActorWithArgs extends AbstractActor {
        private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
        private String arg;

        @Override
        public void preStart() throws Exception {
            ActorRef ref = getContext().getSystem().actorOf(MyActor.props());
            ref.tell("I'm fine",ActorRef.noSender());
        }

        @Override
        public Receive createReceive() {
            return receiveBuilder().match(String.class, s -> {
                log.info("Received String message: {} {}", s,arg);
            })
                    .matchAny(o -> log.info("received unknown message"))
                    .build();
        }
    }

    static class MyActor extends AbstractActor {
        private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

        public static Props props() {
            return Props.create(MyActor.class);
        }

        @Override
        public Receive createReceive() {
            return receiveBuilder().match(String.class, s -> {
                log.info("Received String message: {}", s);
//                int i=0;
//                while (i<100000) {
//                    i++;
//                }
            })
                    .matchAny(o -> log.info("received unknown message"))
                    .build();
        }
    }
}
