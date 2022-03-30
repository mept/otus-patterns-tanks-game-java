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
    public int getSpeed() {
        return (int) obj.getProperty("Speed");
    }

    @Override
    public Direction getDirection() {
        return (Direction) obj.getProperty("Direction");
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
        obj.setProperty("Direction", direction);
    }
}
