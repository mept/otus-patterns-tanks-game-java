import java.util.Objects;

public class Vector {
    int x, y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Vector plus(Vector v1, Vector v2) {
        return new Vector(v1.x + v2.x, v1.y + v2.y);
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
