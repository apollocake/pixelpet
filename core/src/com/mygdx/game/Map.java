package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Map {
    public static boolean RequestMoveLocation(float x, float y, TextureRegion textureRegion, IDrawable drawable)
    {
        if(
                TopValid(y, drawable.getDisplayHeight()) &&
                BottomValid(y) &&
                LeftValid(x) &&
                RightValid(x, drawable.getDisplayWidth()))
        {
            moveLocation(x, y, drawable);
            return  true;
        }
        return false;
    }

    public static void MoveToRandomLocation(IDrawable drawable, TextureRegion textureRegion)
    {
        float x = (float) (Math.random() * (Gdx.graphics.getWidth() - drawable.getDisplayWidth()));
        float y = (float) (Math.random() * (Gdx.graphics.getHeight() - drawable.getDisplayHeight()));
        drawable.SetLocation(x, y);
    }

    private static boolean RightValid(float x, float regionWidth) {
        if(x > (Gdx.graphics.getWidth() - regionWidth))
        {
            return false;
        }
        return true;
    }

    private static boolean LeftValid(float x) {
        if(x < 0)
        {
            return false;
        }
        return true;
    }

    private static boolean BottomValid(float y) {
        if(y < 0)
        {
            return false;
        }
        return true;
    }

    private static boolean TopValid(float y, float regionHeight) {
        if(y > (Gdx.graphics.getHeight() - regionHeight))
        {
            return false;
        }
        return true;
    }

    private static void moveLocation(float x, float y, IDrawable drawable)
    {
        drawable.SetLocation(x, y);
    }

}
