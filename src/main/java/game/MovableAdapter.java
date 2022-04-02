package game;

import game.interfaces.IMovable;
import game.interfaces.UObject;

public class MovableAdapter implements IMovable {
    UObject obj;

    public MovableAdapter(UObject obj) {
        this.obj = obj;
    }

    @Override
    public Vector getPosition() {
        return (Vector) obj.getProperty("Position");
    }

    @Override
    public Vector getVectorSpeed() {
        return (Vector) obj.getProperty("VectorSpeed");
    }

    @Override
    public Integer getSpeed() {
        return (Integer) obj.getProperty("Speed");
    }

    @Override
    public Direction getDirection() {
        return (Direction) obj.getProperty("game.Direction");
    }

    @Override
    public void setPosition(Vector position) {
        obj.setProperty("Position", position);
    }

    @Override
    public void setSpeed(int speed) {
        obj.setProperty("Speed", speed);
    }

    @Override
    public void setVectorSpeed(Vector vectorSpeed) {
        obj.setProperty("VectorSpeed", vectorSpeed);
    }

    @Override
    public void setDirection(Direction direction) {
        obj.setProperty("game.Direction", direction);
    }
}
