package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.IState;
import com.mygdx.game.animations.IAnimation;

public class Idle implements IState {
    IAnimation idleAnimation;

    public Idle(IAnimation activityAnimation)
    {
        this.idleAnimation = activityAnimation;
    }

    @Override
    public TextureRegion getCurrentFrame() {
        return this.idleAnimation.getCurrentKeyFrame(Gdx.graphics.getDeltaTime());
    }
}
