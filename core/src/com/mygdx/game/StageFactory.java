package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class StageFactory {


    private static Label wellnessLabel;
    private static Group debugButtonGroup = new Group();
    private static boolean toggleDebug = false;
    private static Stage stage;
    private static TextButton eatCandyButton;
    private static TextButton eatMeatButton;
    private static TextButton sickButton;
    private static TextButton poopButton;
    private static TextButton sleepButton;
    private static TextButton noButton;
    private static TextButton leftButton;
    private static TextButton rightButton;
    private static TextButton upButton;
    private static TextButton downButton;
    private static TextButton debugEnableButton;
    private  static BitmapFont pixelFont = new BitmapFont(Gdx.files.internal("pixel.fnt"), Gdx.files.internal("pixel.png"), false); // font size 24 pixels

    private static LabelStyle labelStyle;
    private static final int debugButtonDefaultWidth = Gdx.graphics.getWidth() / 2;
    private static final int debugButtonDefaultHeight = Gdx.graphics.getWidth() / 6;

    public static Label GetWellnessLabel()
    {
        if(wellnessLabel == null)
        {
            labelStyle = new Label.LabelStyle(pixelFont, Color.DARK_GRAY);
            wellnessLabel = new Label("Health:", labelStyle);
            wellnessLabel.setColor(Color.WHITE);
            wellnessLabel.setFontScale(1, 1);
            wellnessLabel.setHeight(100);
            wellnessLabel.setWidth(500);
            wellnessLabel.setPosition(Gdx.graphics.getWidth() - 500, Gdx.graphics.getHeight() - 100);
        }
        return wellnessLabel;
    }

    public static Stage GetStage(SpriteBatch spriteBatch)
    {
        if(stage == null)
        {

            // camera setup
            stage = new Stage(new ScreenViewport(), spriteBatch);

            //set up fonts and styles
            int fontScale = 2;
            TextButton.TextButtonStyle pixelTextButtonStyle = new TextButton.TextButtonStyle();
            pixelTextButtonStyle.font = pixelFont;
            pixelTextButtonStyle.fontColor = Color.DARK_GRAY;
            pixelTextButtonStyle.downFontColor = new Color(0xaa0000ff);
            TextureRegion ehhh = new TextureRegion(new Texture(Gdx.files.internal("background.png")));
            TextureRegion buttonBackground = ehhh;
            pixelTextButtonStyle.up = new TextureRegionDrawable(buttonBackground);
            pixelTextButtonStyle.down = new TextureRegionDrawable(buttonBackground);


            // GUI HUD


            //button setup
            debugEnableButton = new TextButton("D", pixelTextButtonStyle);
            debugEnableButton.setColor(Color.WHITE);
            debugEnableButton.getLabel().setFontScale(1, 1);
            debugEnableButton.setWidth(100);
            debugEnableButton.setHeight(100);
            debugEnableButton.setPosition(20,Gdx.graphics.getHeight() - 120);
            debugEnableButton.addListener(new InputListener(){
                @Override
                public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//                aGame.setScreen(new OptionScreen(aGame));
                    toggleDebug = !toggleDebug;
                    debugButtonGroup.setVisible(toggleDebug);
                }
                @Override
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }
            });

            eatCandyButton = new TextButton("CANDY", pixelTextButtonStyle);
            eatCandyButton.setColor(Color.WHITE);
            eatCandyButton.getLabel().setFontScale(fontScale, fontScale);
            eatCandyButton.setWidth(debugButtonDefaultWidth);
            eatCandyButton.setHeight(debugButtonDefaultHeight);
            eatCandyButton.setPosition(0,0);
            eatCandyButton.addListener(new InputListener(){
                @Override
                public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    DrawablesFactory.GetBaby().SetState(Activity.EAT_CANDY);
                }
                @Override
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }
            });

            //button setup
            noButton = new TextButton("No", pixelTextButtonStyle);
            noButton.getLabel().setFontScale(fontScale, fontScale);
            noButton.setWidth(debugButtonDefaultWidth);
            noButton.setHeight(debugButtonDefaultHeight);
            noButton.setPosition(debugButtonDefaultWidth,0);
            noButton.addListener(new InputListener(){
                @Override
                public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    DrawablesFactory.GetBaby().SetState(Activity.NO);
                }
                @Override
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }
            });

            poopButton = new TextButton("Poop", pixelTextButtonStyle);
            poopButton.getLabel().setFontScale(fontScale, fontScale);
            poopButton.setHeight(debugButtonDefaultHeight);
            poopButton.setWidth(debugButtonDefaultWidth);
            poopButton.setPosition(0, debugButtonDefaultHeight);
            poopButton.addListener(new InputListener(){
                @Override
                public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    DrawablesFactory.CreatePoop();
                    if(DrawablesFactory.GetPoopCount() == 5)
                    {
                        DrawablesFactory.GetBaby().SetState(Activity.SICK);
                    }
                    if(DrawablesFactory.GetPoopCount() == 6)
                    {
                        DrawablesFactory.GetBaby().SetState(Activity.DEAD);
                    }
                }
                @Override
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }
            });

            leftButton = new TextButton("Left", pixelTextButtonStyle);
            leftButton.getLabel().setFontScale(fontScale, fontScale);
            leftButton.setHeight(debugButtonDefaultHeight);
            leftButton.setWidth(debugButtonDefaultWidth);
            leftButton.setPosition(0, 2*debugButtonDefaultHeight);
            leftButton.addListener(new InputListener(){
                @Override
                public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    DrawablesFactory.GetBaby().MoveLeftRandom();
                }
                @Override
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }
            });

            sleepButton = new TextButton("Sleep", pixelTextButtonStyle);
            sleepButton.getLabel().setFontScale(fontScale, fontScale);
            sleepButton.setHeight(debugButtonDefaultHeight);
            sleepButton.setWidth(debugButtonDefaultWidth);
            sleepButton.setPosition(debugButtonDefaultWidth,debugButtonDefaultHeight);
            sleepButton.addListener(new InputListener(){
                @Override
                public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    DrawablesFactory.GetBaby().SetMoveDirection(Direction.LEFT);
                    DrawablesFactory.GetBaby().SetState(Activity.SLEEP);
                }
                @Override
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }
            });

            rightButton = new TextButton("RIGHT", pixelTextButtonStyle);
            rightButton.getLabel().setFontScale(fontScale, fontScale);
            rightButton.setHeight(debugButtonDefaultHeight);
            rightButton.setWidth(debugButtonDefaultWidth);
            rightButton.setPosition(debugButtonDefaultWidth,2*debugButtonDefaultHeight);
            rightButton.addListener(new InputListener(){
                @Override
                public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    DrawablesFactory.GetBaby().MoveRightRandom();
                }
                @Override
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }
            });

            upButton = new TextButton("UP", pixelTextButtonStyle);
            upButton.getLabel().setFontScale(fontScale, fontScale);
            upButton.setHeight(debugButtonDefaultHeight);
            upButton.setWidth(debugButtonDefaultWidth);
            upButton.setPosition(0,3*debugButtonDefaultHeight);
            upButton.addListener(new InputListener(){
                @Override
                public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    Map.RequestMoveLocation(
                            DrawablesFactory.GetBaby().getLocation().x,
                            DrawablesFactory.GetBaby().getLocation().y + 20.0f, DrawablesFactory.GetBaby().getCurrentFrame(),
                            DrawablesFactory.GetBaby());
                }
                @Override
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }
            });

            eatMeatButton = new TextButton("MEAT", pixelTextButtonStyle);
            eatMeatButton.getLabel().setFontScale(fontScale, fontScale);
            eatMeatButton.setHeight(debugButtonDefaultHeight);
            eatMeatButton.setWidth(debugButtonDefaultWidth);
            eatMeatButton.setPosition(0,4*debugButtonDefaultHeight);
            eatMeatButton.addListener(new InputListener(){
                @Override
                public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    DrawablesFactory.GetBaby().SetState(Activity.EAT_MEAT);
                }
                @Override
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }
            });

            sickButton = new TextButton("SICK", pixelTextButtonStyle);
            sickButton.getLabel().setFontScale(fontScale, fontScale);
            sickButton.setHeight(debugButtonDefaultHeight);
            sickButton.setWidth(debugButtonDefaultWidth);
            sickButton.setPosition(debugButtonDefaultWidth, 4*debugButtonDefaultHeight);
            sickButton.addListener(new InputListener(){
                @Override
                public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    DrawablesFactory.GetBaby().SetState(Activity.SICK);
                }
                @Override
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }
            });

            downButton = new TextButton("DOWN", pixelTextButtonStyle);
            downButton.getLabel().setFontScale(fontScale, fontScale);
            downButton.setHeight(debugButtonDefaultHeight);
            downButton.setWidth(debugButtonDefaultWidth);
            downButton.setPosition(debugButtonDefaultWidth,3*debugButtonDefaultHeight);
            downButton.addListener(new InputListener(){
                @Override
                public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    Map.RequestMoveLocation(
                            DrawablesFactory.GetBaby().getLocation().x,
                            DrawablesFactory.GetBaby().getLocation().y - 20.0f, DrawablesFactory.GetBaby().getCurrentFrame(),
                            DrawablesFactory.GetBaby());
                }
                @Override
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }
            });

            //setup button group
            debugButtonGroup.setOrigin(debugButtonDefaultWidth / 2, debugButtonDefaultHeight / 2);
            debugButtonGroup.setPosition(0, 0);
            debugButtonGroup.addActor(sickButton);
            debugButtonGroup.addActor(eatCandyButton);
            debugButtonGroup.addActor(eatMeatButton);
            debugButtonGroup.addActor(poopButton);
            debugButtonGroup.addActor(sleepButton);
            debugButtonGroup.addActor(noButton);
            debugButtonGroup.addActor(leftButton);
            debugButtonGroup.addActor(rightButton);
            debugButtonGroup.addActor(upButton);
            debugButtonGroup.addActor(downButton);
            debugButtonGroup.setVisible(toggleDebug);

            //stage ordering
            stage.addActor(debugButtonGroup);
            stage.addActor(debugEnableButton);
            stage.addActor(GetWellnessLabel());
            stage.setDebugAll(true);
        }
        return stage;
    }
}
