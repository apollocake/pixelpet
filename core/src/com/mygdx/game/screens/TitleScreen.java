package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.StageFactory;
import com.mygdx.game.IDrawable;
import com.mygdx.game.IPet;
import com.mygdx.game.DrawablesFactory;

public class TitleScreen implements Screen {


    IPet testPet;
    SpriteBatch spriteBatch = new SpriteBatch();
    Label health;

    public TitleScreen(final Game aGame) {
        testPet = DrawablesFactory.GetBaby();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(StageFactory.GetStage(this.spriteBatch));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        for(IDrawable d : DrawablesFactory.GetDrawables())
        {
            spriteBatch.draw(
                    d.getCurrentFrame(),
                    d.getLocation().x,
                    d.getLocation().y,
                    d.getDisplayWidth() / 2, 0,
                    d.getDisplayWidth(),
                    d.getDisplayHeight(),
                    (d.isXflipped() ? -1 : 1),
                    1,
                    0);
        }
        spriteBatch.end();

        StageFactory.GetStage(this.spriteBatch).act();
        StageFactory.GetStage(this.spriteBatch).draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        StageFactory.GetStage(this.spriteBatch).dispose();
    }
}