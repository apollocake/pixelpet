package com.mygdx.game.animations;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Events.Event;
import com.mygdx.game.Events.EventHub;
import com.mygdx.game.ICustomObserver;

import java.util.ArrayList;

public class NoAnimation implements IAnimation {
    Animation<TextureRegion> noAnimation;
    float stateTime;
    int shakeHeadCount;
    ArrayList<ICustomObserver> customObservers;

    public NoAnimation(Animation<TextureRegion> animation)
    {
        this.noAnimation = animation;
        this.Initialize();
        this.customObservers = new ArrayList<ICustomObserver>();
    }

    @Override
    public TextureRegion getCurrentKeyFrame(float deltaTime) {
        this.stateTime += deltaTime;
        if(this.noAnimation.isAnimationFinished(stateTime)) {
            this.stateTime = 0;
            shakeHeadCount++;
            if(shakeHeadCount == 3)
            {
                shakeHeadCount = 0;
                EventHub.PublishEvent(this, Event.FINISHED_NO);
                return this.noAnimation.getKeyFrames()[this.noAnimation.getKeyFrames().length -1];
            }
        }

        return this.noAnimation.getKeyFrame(stateTime);
    }

    @Override
    public void Initialize() {
        this.stateTime = 0;
        this.shakeHeadCount = 0;
    }
}
