package com.mygdx.game.animations;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Observer;

public interface IAnimation {
    TextureRegion getCurrentKeyFrame(float deltaTime);
    void Initialize();
}
