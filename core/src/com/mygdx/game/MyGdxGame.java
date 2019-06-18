package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.screens.TitleScreen;

public class MyGdxGame extends Game {

	static public Skin gameSkin;

	@Override
	public void create() {
		gameSkin = new Skin(Gdx.files.internal("uiskin.json"));
		this.setScreen(new TitleScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}
