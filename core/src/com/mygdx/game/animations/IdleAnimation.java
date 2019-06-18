package com.mygdx.game.animations;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Events.Event;
import com.mygdx.game.Events.EventHub;
import com.mygdx.game.ICustomObserver;

import java.util.ArrayList;

public class IdleAnimation implements IAnimation {
    Animation<TextureRegion> idleAnimation;
    float stateTime;
    ArrayList<ICustomObserver> customObservers;

    public IdleAnimation(Animation<TextureRegion> animation)
    {
        this.idleAnimation = animation;
        this.Initialize();
        this.customObservers = new ArrayList<ICustomObserver>();
    }

    @Override
    public TextureRegion getCurrentKeyFrame(float deltaTime) {
        if(this.idleAnimation.isAnimationFinished(stateTime)) {
            this.Initialize();
            EventHub.PublishEvent(this, Event.FINISHED_IDLE);
        }

        stateTime += deltaTime;

        return this.idleAnimation.getKeyFrame(stateTime);
    }

    @Override
    public void Initialize() {
        this.stateTime = 0;
    }
}
