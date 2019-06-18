package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public interface IDrawable {
    TextureRegion getCurrentFrame();
    Vector2 getLocation();
    void SetLocation(float x, float y);
    float getDisplayWidth();
    float getDisplayHeight();
    boolean isXflipped();
}
