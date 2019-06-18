package com.mygdx.game.animations;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SickAnimation implements IAnimation {
    Animation<TextureRegion> deadAnimation;
    float stateTime;

    public SickAnimation(Animation<TextureRegion> animation)
    {
        this.Initialize();
        this.deadAnimation = animation;
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
