public class MoveCommand implements Command {
    IMovable m;

    public MoveCommand(IMovable m) {
        this.m = m;
    }

    @Override
    public void execute() {
        m.setPosition(Vector.vectorMove(m.getPosition(), m.getVectorSpeed()));
    }
}
