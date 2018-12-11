package com.study.akka;

import akka.actor.UntypedAbstractActor;

/**
 * @author tb
 * @date 2018/12/11 16:51
 */
public class ScheduleConsumer  extends UntypedAbstractActor {

    @Override
    public void onReceive(Object message) throws Throwable {
        if(message instanceof Message) {
            System.out.println(((Message)message).getContent());
        }
    }
}
