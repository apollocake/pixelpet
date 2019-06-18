package com.mygdx.game.animations;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Events.Event;
import com.mygdx.game.Events.EventHub;
import com.mygdx.game.ICustomObserver;

import java.util.ArrayList;

public class MoveAnimation implements IAnimation {
    Animation<TextureRegion> moveAnimation;
    float stateTime;
    ArrayList<ICustomObserver> customObservers;
    boolean flippedKeyFrame;

    public MoveAnimation(Animation<TextureRegion> animation)
    {
        this.moveAnimation = animation;
        this.flippedKeyFrame = false;
        this.Initialize();
        this.customObservers = new ArrayList<ICustomObserver>();
    }

    @Override
    public TextureRegion getCurrentKeyFrame(float deltaTime) {
        this.stateTime += deltaTime;

        if(this.moveAnimation.isAnimationFinished(stateTime)) {
            this.Initialize();
            EventHub.PublishEvent(this, Event.FINISHED_MOVE);
        }

        return this.moveAnimation.getKeyFrame(stateTime);
    }

    @Override
    public void Initialize() {
        this.stateTime = 0;
    }
}
