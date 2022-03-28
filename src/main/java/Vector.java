import java.util.Objects;

public class Vector {
    int x, y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Vector vectorMove(Vector v1, Vector v2) {
        return new Vector(v1.x + v2.x, v1.y + v2.y);
    }

    public static Vector simpleMove(Vector position, int speed, Direction direction) {
        return switch (direction) {
            case UP -> new Vector(position.x, position.y + speed);
            case RIGHT -> new Vector(position.x + speed, position.y);
            case DOWN -> new Vector(position.x + speed, position.y - speed);
            case LEFT -> new Vector(position.x - speed, position.y);
        };
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector vector = (Vector) obj;
        return vector.x == x && vector.y == y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
