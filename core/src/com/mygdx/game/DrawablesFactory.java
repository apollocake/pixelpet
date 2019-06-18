package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Events.Event;
import com.mygdx.game.Events.EventHub;
import com.mygdx.game.animations.DeadAnimation;
import com.mygdx.game.animations.EatAnimation;
import com.mygdx.game.animations.IAnimation;
import com.mygdx.game.animations.IdleAnimation;
import com.mygdx.game.animations.MoveAnimation;
import com.mygdx.game.animations.NoAnimation;
import com.mygdx.game.animations.PoopAnimation;
import com.mygdx.game.animations.SickAnimation;
import com.mygdx.game.animations.SleepAnimation;
import com.mygdx.game.drawables.Baby;
import com.mygdx.game.states.Dead;
import com.mygdx.game.states.Eat;
import com.mygdx.game.states.Idle;
import com.mygdx.game.states.Move;
import com.mygdx.game.states.No;
import com.mygdx.game.drawables.Poop;
import com.mygdx.game.states.Sick;
import com.mygdx.game.states.Sleep;

import java.util.ArrayList;
import java.util.List;

public class DrawablesFactory {

    private static EatAnimation eatMeatAnimation;
    private static SickAnimation sickAnimation;
    private static EatAnimation eatCandyAnimation;
    private static IdleAnimation idleStateAnimation;
    private static DeadAnimation deadStateAnimation;
    private static SleepAnimation sleepStateAnimation;
    private static NoAnimation noStateAnimation;
    private static MoveAnimation moveStateAnimation;

    private static Baby baby;
    private static ArrayList<Poop> poopList = new ArrayList<Poop>();
    private static List<IDrawable> drawableList = new ArrayList<IDrawable>();

    public static Baby GetBaby()
    {
        if(baby == null)
        {
            TextureAtlas babyAtlas = new TextureAtlas(Gdx.files.internal("baby.atlas"));
            eatMeatAnimation = new EatAnimation(new Animation<TextureRegion>(1.0f, babyAtlas.findRegions("baby_eat_meat"), Animation.PlayMode.NORMAL));
            sickAnimation = new SickAnimation(new Animation<TextureRegion>(0.5f, babyAtlas.findRegions("baby_sick"), Animation.PlayMode.LOOP));
            eatCandyAnimation = new EatAnimation(new Animation<TextureRegion>(1.0f, babyAtlas.findRegions("baby_eat_candy"), Animation.PlayMode.NORMAL));
            idleStateAnimation = new IdleAnimation(new Animation<TextureRegion>(0.5f, babyAtlas.findRegions("baby_idle"), Animation.PlayMode.NORMAL));
            deadStateAnimation = new DeadAnimation(new Animation<TextureRegion>(0.5f, babyAtlas.findRegions("baby_dead"), Animation.PlayMode.LOOP_PINGPONG));
            sleepStateAnimation = new SleepAnimation(new Animation<TextureRegion>(0.5f, babyAtlas.findRegions("baby_sleep"), Animation.PlayMode.LOOP));
            noStateAnimation = new NoAnimation(new Animation<TextureRegion>(0.5f, babyAtlas.findRegions("baby_no"), Animation.PlayMode.LOOP));
            moveStateAnimation = new MoveAnimation(new Animation<TextureRegion>(0.1f, babyAtlas.findRegions("baby_move"), Animation.PlayMode.LOOP));
            IState sickState = new Sick(sickAnimation);
            IState eatMeatState = new Eat(eatMeatAnimation);
            IState eatCandyState = new Eat(eatCandyAnimation);
            IState idleState = new Idle(idleStateAnimation);
            IState deadState = new Dead(deadStateAnimation);
            IState sleepState = new Sleep(sleepStateAnimation);
            IState moveState = new Move(moveStateAnimation);
            IState noState = new No(noStateAnimation);
            IWellness wellness = new Wellness(StageFactory.GetWellnessLabel());
            baby = new Baby(
                    eatMeatState,
                    eatCandyState,
                    idleState,
                    sickState,
                    deadState,
                    sleepState,
                    noState,
                    moveState,
                    new Vector2(),
                    wellness);
            EventHub.SubscribeToEvent(baby, Event.FINISHED_EAT);
            EventHub.SubscribeToEvent(baby, Event.FINISHED_NO);
            EventHub.SubscribeToEvent(baby, Event.FINISHED_IDLE);
            EventHub.SubscribeToEvent(baby, Event.FINISHED_MOVE);
            drawableList.add(baby);
        }
        return baby;
    }

    public static Poop CreatePoop()
    {

        TextureAtlas poopAtlas = new TextureAtlas(Gdx.files.internal("poop.atlas"));
        IAnimation poopAnimation = new PoopAnimation(new Animation<TextureRegion>(0.5f, poopAtlas.findRegions("poop"), Animation.PlayMode.LOOP));
        Poop poop = new Poop(poopAnimation, new Vector2());
        poopList.add(poop);
        drawableList.add(0, poop);
        return poop;
    }

    public static void ResetAnimations()
    {
        eatMeatAnimation.Initialize();
        sickAnimation.Initialize();
        eatCandyAnimation.Initialize();
        idleStateAnimation.Initialize();
        deadStateAnimation.Initialize();
        sleepStateAnimation.Initialize();
        noStateAnimation.Initialize();
        moveStateAnimation.Initialize();
    }

    public static int GetPoopCount()
    {
        return poopList.size();
    }
    public static List<IDrawable> GetDrawables() { return drawableList;}
}
