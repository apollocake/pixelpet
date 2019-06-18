package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.IState;
import com.mygdx.game.animations.IAnimation;

public class Move implements IState {
    IAnimation moveAnimation;

    public Move(IAnimation activityAnimation)
    {
        this.moveAnimation = activityAnimation;
    }

    @Override
    public TextureRegion getCurrentFrame() {
        return this.moveAnimation.getCurrentKeyFrame(Gdx.graphics.getDeltaTime());
    }
}
