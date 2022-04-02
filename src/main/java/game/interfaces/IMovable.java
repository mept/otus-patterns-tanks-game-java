package game.interfaces;

import game.Direction;
import game.Vector;

public interface IMovable {
    Vector getPosition();
    Vector getVectorSpeed();
    Integer getSpeed();
    Direction getDirection();
    void setPosition(Vector position);
    void setSpeed(int speed);
    void setVectorSpeed(Vector vectorSpeed);
    void setDirection(Direction direction);
}
