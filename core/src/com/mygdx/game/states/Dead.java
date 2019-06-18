package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.IState;
import com.mygdx.game.animations.IAnimation;

public class Dead implements IState {
    IAnimation eatAnimation;

    public Dead(IAnimation activityAnimation)
    {
        this.eatAnimation = activityAnimation;
    }

    @Override
    public TextureRegion getCurrentFrame() {
        return this.eatAnimation.getCurrentKeyFrame(Gdx.graphics.getDeltaTime());
    }
}
