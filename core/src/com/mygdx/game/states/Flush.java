package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.IState;
import com.mygdx.game.animations.IAnimation;

public class Flush implements IState {
    IAnimation flushAnimation;

    public Flush(IAnimation activityAnimation)
    {
        this.flushAnimation = activityAnimation;
    }

    @Override
    public TextureRegion getCurrentFrame() {
        return this.flushAnimation.getCurrentKeyFrame(Gdx.graphics.getDeltaTime());
    }
}
