package com.mygdx.game.animations;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.ICustomObserver;

import java.util.ArrayList;

public class DeadAnimation implements IAnimation {
    Animation<TextureRegion> deadAnimation;
    float stateTime;
    ArrayList<ICustomObserver> customObservers;

    public DeadAnimation(Animation<TextureRegion> animation)
    {
        this.deadAnimation = animation;
        this.Initialize();
        this.customObservers = new ArrayList<ICustomObserver>();
    }

    @Override
    public TextureRegion getCurrentKeyFrame(float deltaTime) {
        this.stateTime += deltaTime;

        return this.deadAnimation.getKeyFrame(stateTime);
    }

    @Override
    public void Initialize() {
        this.stateTime = 0;
    }
}
