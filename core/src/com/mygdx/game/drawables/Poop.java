package com.mygdx.game.drawables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.IDrawable;
import com.mygdx.game.Map;
import com.mygdx.game.animations.IAnimation;

import java.util.Observable;
import java.util.Observer;

public class Poop implements IDrawable {

    IAnimation poopAnimation;
    Vector2 location;
    final float DISPLAY_WIDTH = 200;
    final float DISPLAY_HEIGHT = 400;

    public Poop(IAnimation animation, Vector2 location)
    {
        this.poopAnimation = animation;
        this.location = location;

        //dummy location:
        Map.MoveToRandomLocation(this, this.getCurrentFrame());
    }

    @Override
    public TextureRegion getCurrentFrame() {
        return this.poopAnimation.getCurrentKeyFrame(Gdx.graphics.getDeltaTime());
    }

    @Override
    public Vector2 getLocation() {
        return this.location;
    }

    @Override
    public void SetLocation(float x, float y) {
        this.location.x = x;
        this.location.y = y;
    }

    @Override
    public float getDisplayWidth() {
        return this.DISPLAY_WIDTH;
    }

    @Override
    public float getDisplayHeight() {
        return this.DISPLAY_HEIGHT;
    }

    @Override
    public boolean isXflipped() {
        return false;
    }
}
