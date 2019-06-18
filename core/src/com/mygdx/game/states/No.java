package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.IState;
import com.mygdx.game.animations.IAnimation;

public class No implements IState {
    IAnimation noAnimation;

    public No(IAnimation activityAnimation)
    {
        this.noAnimation = activityAnimation;
    }

    @Override
    public TextureRegion getCurrentFrame() {
        return this.noAnimation.getCurrentKeyFrame(Gdx.graphics.getDeltaTime());
    }
}
