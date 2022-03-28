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
    public Vector getSpeed() {
        return (Vector) obj.getProperty("Speed");
    }

    @Override
    public void setPosition(Vector position) {
        obj.setProperty("Position", position);
    }

    @Override
    public void setSpeed(Vector speed) {
        obj.setProperty("Speed", speed);
    }

}
