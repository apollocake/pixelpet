package com.mygdx.game.Events;

import com.mygdx.game.ICustomObserver;

public class Registration {
    private final ICustomObserver subscriber;
    private final Event subscribedEvent;

    public Registration(ICustomObserver subscriber, Event subscribedEvent) {
        this.subscriber = subscriber;
        this.subscribedEvent = subscribedEvent;
    }

    public void notify(Object sender, Event incomingEvent)
    {
        if(incomingEvent.equals(this.subscribedEvent))
        {
            this.subscriber.update(sender, this.subscribedEvent);
        }
    }

}
