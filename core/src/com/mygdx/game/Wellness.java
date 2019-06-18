package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class Wellness implements IWellness{
    private Label label;
    private int healthCount;

    public Wellness(Label healthLabel) {
        this.label = healthLabel;
        this.healthCount = 0;
    }

    @Override
    public int GetHealth()
    {
        return  this.healthCount;
    }

    @Override
    public void SetHealth(int healthCount)
    {
        this.healthCount = healthCount;
        this.label.setText("Health:" + this.healthCount);
    }
}
