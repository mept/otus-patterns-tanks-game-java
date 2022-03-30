public interface IMovable {
    Vector getPosition();
    Vector getVectorSpeed();
    int getSpeed();
    Direction getDirection();
    void setPosition(Vector position);
    void setSpeed(int speed);
    void setVectorSpeed(Vector vectorSpeed);
    void setDirection(Direction direction);
}
