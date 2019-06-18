package com.mygdx.game.drawables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Activity;
import com.mygdx.game.Direction;
import com.mygdx.game.Events.Event;
import com.mygdx.game.ICustomObserver;
import com.mygdx.game.IDrawable;
import com.mygdx.game.IPet;
import com.mygdx.game.IState;
import com.mygdx.game.IWellness;
import com.mygdx.game.Map;
import com.mygdx.game.DrawablesFactory;

import java.util.ArrayList;
import java.util.HashMap;

public class Baby implements IPet, ICustomObserver, IDrawable {

    IState currentState;
    HashMap<Activity, IState> statesHashMap;
    ArrayList<ICustomObserver> customObservers;
    Direction direction;
    IWellness wellness;

    Vector2 location;
    final float DISPLAY_WIDTH = 300;
    final float DISPLAY_HEIGHT = 600;

    public Baby(
            IState eatMeatState,
            IState eatCandyState,
            IState idleState,
            IState sickState,
            IState deadState,
            IState sleepState,
            IState noState,
            IState moveState,
            Vector2 location,
            IWellness wellness)
    {
        this.wellness = wellness;
        this.customObservers = new ArrayList<ICustomObserver>();
        this.statesHashMap = new HashMap<Activity, IState>();
        this.statesHashMap.put(Activity.EAT_MEAT, eatMeatState);
        this.statesHashMap.put(Activity.EAT_CANDY, eatCandyState);
        this.statesHashMap.put(Activity.IDLE, idleState);
        this.statesHashMap.put(Activity.SICK, sickState);
        this.statesHashMap.put(Activity.DEAD, deadState);
        this.statesHashMap.put(Activity.SLEEP, sleepState);
        this.statesHashMap.put(Activity.NO, noState);
        this.statesHashMap.put(Activity.MOVE, moveState);
        this.statesHashMap.put(Activity.IDLE, idleState);
        this.currentState = this.statesHashMap.get(Activity.IDLE);
        this.location = location;

        //dummy location:
        this.location.x = Gdx.graphics.getWidth()/2-this.getCurrentFrame().getRegionWidth();
        this.location.y = Gdx.graphics.getHeight()/2-this.getCurrentFrame().getRegionHeight()/2;
    }

    @Override
    public void SetState(Activity activity) {
        DrawablesFactory.ResetAnimations();
        this.currentState = this.statesHashMap.get(activity);
    }

    @Override
    public void SetMoveDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public TextureRegion getCurrentFrame() {
        return currentState.getCurrentFrame();
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
        return direction == Direction.RIGHT ? true : false;
    }

    @Override
    public void update(Object sender, Event o) {
        if(o.equals(Event.FINISHED_NO))
        {
            this.SetState(Activity.IDLE);
        }
        if(o.equals(Event.FINISHED_EAT))
        {
            this.SetState(Activity.IDLE);
            this.wellness.SetHealth(this.wellness.GetHealth() + 1);
        }
        if(o.equals(Event.FINISHED_IDLE))
        {
            if(Math.random() > 0.5)
            {
                this.MoveLeftRandom();
            }
            else
            {
                this.MoveRightRandom();
            }
        }
        if(o.equals(Event.FINISHED_MOVE))
        {
            this.SetState(Activity.IDLE);
        }
    }

    @Override
    public void MoveLeftRandom()
    {
        boolean movementAllowed = Map.RequestMoveLocation(
                DrawablesFactory.GetBaby().location.x - 30.0f,
                DrawablesFactory.GetBaby().location.y + (((float) Math.random() * 2 - 1) * 30.0f), DrawablesFactory.GetBaby().getCurrentFrame(),
                DrawablesFactory.GetBaby());
        if(movementAllowed)
        {
            this.SetMoveDirection(Direction.LEFT);
            this.SetState(Activity.MOVE);
        }
    }

    @Override
    public void MoveRightRandom()
    {
        boolean movementAllowed = Map.RequestMoveLocation(
                DrawablesFactory.GetBaby().location.x + 30.0f,
                DrawablesFactory.GetBaby().location.y + (((float) Math.random() * 2 - 1) * 30.0f), DrawablesFactory.GetBaby().getCurrentFrame(),
                DrawablesFactory.GetBaby());
        if(movementAllowed)
        {
            this.SetMoveDirection(Direction.RIGHT);
            this.SetState(Activity.MOVE);
        }
    }

    @Override
    public void MoveLeft()
    {
        boolean movementAllowed = Map.RequestMoveLocation(
                DrawablesFactory.GetBaby().location.x - 30.0f,
                DrawablesFactory.GetBaby().location.y, DrawablesFactory.GetBaby().getCurrentFrame(),
                DrawablesFactory.GetBaby());
        if(movementAllowed)
        {
            this.SetMoveDirection(Direction.LEFT);
            this.SetState(Activity.MOVE);
        }
    }

    @Override
    public void MoveRight()
    {
        boolean movementAllowed = Map.RequestMoveLocation(
                DrawablesFactory.GetBaby().location.x + 30.0f,
                DrawablesFactory.GetBaby().location.y, DrawablesFactory.GetBaby().getCurrentFrame(),
                DrawablesFactory.GetBaby());
        if(movementAllowed)
        {
            this.SetMoveDirection(Direction.RIGHT);
            this.SetState(Activity.MOVE);
        }
    }
}
