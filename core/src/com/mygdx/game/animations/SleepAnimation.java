package com.mygdx.game.animations;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.ICustomObserver;

import java.util.ArrayList;

public class SleepAnimation implements IAnimation {
    Animation<TextureRegion> sleepAnimation;
    float stateTime;
    ArrayList<ICustomObserver> customObservers;

    public SleepAnimation(Animation<TextureRegion> animation)
    {
        this.sleepAnimation = animation;
        this.Initialize();
        this.customObservers = new ArrayList<ICustomObserver>();
    }

    @Override
    public TextureRegion getCurrentKeyFrame(float deltaTime) {
        this.stateTime += deltaTime;
        return this.sleepAnimation.getKeyFrame(stateTime);
    }

    @Override
    public void Initialize() {
        this.stateTime = 0;
    }
}
