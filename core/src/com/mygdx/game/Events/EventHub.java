package com.mygdx.game.Events;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.Events.Registration;
import com.mygdx.game.ICustomObserver;

import java.util.ArrayList;

public class EventHub
{
    private static ArrayList<Registration> customObservers = new ArrayList<Registration>();

    public static void SubscribeToEvent(ICustomObserver observer, Event event) {
        try
        {
            customObservers.add(new Registration(observer, event));
        }
        catch (Exception e)
        {
            Gdx.app.debug("EventHub" , "Error subscribing to event " + event);
        }
    }

    public static void PublishEvent(Object sender, Event event) {
        Gdx.app.debug("EventHub","Event triggered: " + event);
        for (Registration o : customObservers) {
            o.notify(sender, event);
        }
    }



}
