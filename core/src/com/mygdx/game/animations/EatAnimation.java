package com.mygdx.game.animations;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Events.Event;
import com.mygdx.game.Events.EventHub;
import com.mygdx.game.ICustomObserver;

public class EatAnimation implements IAnimation {

    Animation<TextureRegion> eatAnimation;
    float stateTime;
    ArrayList<ICustomObserver> customObservers;

    public EatAnimation(Animation<TextureRegion> animation)
    {
        this.eatAnimation = animation;
        this.Initialize();
        this.customObservers = new ArrayList<ICustomObserver>();
    }

    @Override
    public TextureRegion getCurrentKeyFrame(float deltaTime) {
        this.stateTime += deltaTime;
        if(this.eatAnimation.isAnimationFinished(stateTime)) {
            this.Initialize();
            EventHub.PublishEvent(this, Event.FINISHED_EAT);
            return this.eatAnimation.getKeyFrames()[this.eatAnimation.getKeyFrames().length -1];
        }

        return this.eatAnimation.getKeyFrame(stateTime);
    }

    @Override
    public void Initialize() {
        this.stateTime = 0;
    }
}
