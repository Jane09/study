package com.study.akka;

import akka.actor.ActorSystem;

/**
 * @author tb
 * @date 2018/12/11 16:46
 */
public class AkkaStarter {

    public static void main(String[] args) {
        String name = "akka";
        ActorSystem system = ActorSystem.create(name);

    }
}
