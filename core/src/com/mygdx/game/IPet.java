package com.mygdx.game;

public interface IPet extends ICustomObserver {
    void SetState(Activity activity);
    void SetMoveDirection(Direction left);
    void MoveLeftRandom();
    void MoveRightRandom();
    void MoveLeft();
    void MoveRight();

}
