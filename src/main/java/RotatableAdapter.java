public class RotatableAdapter implements IRotatable {
    UObject obj;

    public enum Directions {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }

    public RotatableAdapter(UObject obj) {
        this.obj = obj;
    }

    @Override
    public int getDirection() {
        return (int) obj.getProperty("Direction");
    }

    @Override
    public void setDirection(int direction) {
        obj.setProperty("Direction", direction);
    }

    /**
     * Угловая скорость - угол поворота за единицу времени
     */
    @Override
    public int getAngularSpeed() {
        return (int) obj.getProperty("AngularSpeed");
    }

    @Override
    public void setAngularSpeed(int angularSpeed) {
        obj.setProperty("AngularSpeed", angularSpeed);
    }

    @Override
    public int getMaxDirections() {
        return Directions.values().length;
    }
}
