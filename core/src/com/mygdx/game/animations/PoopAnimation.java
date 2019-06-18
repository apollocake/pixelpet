package com.mygdx.game.animations;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.ICustomObserver;

import java.util.ArrayList;

public class PoopAnimation implements IAnimation {
    Animation<TextureRegion> poopAnimation;
    float stateTime;
    ArrayList<ICustomObserver> customObservers;


    public PoopAnimation(Animation<TextureRegion> animation)
    {
        this.poopAnimation = animation;
        this.Initialize();
        this.customObservers = new ArrayList<ICustomObserver>();
    }

    @Override
    public TextureRegion getCurrentKeyFrame(float deltaTime) {
        this.stateTime += deltaTime;
        return this.poopAnimation.getKeyFrame(stateTime);
    }

    @Override
    public void Initialize() {
        this.stateTime = 0;
    }
}
