public class MoveForwardCommand implements Command {
    IMovable m;

    public MoveForwardCommand(IMovable m) {
        this.m = m;
    }

    @Override
    public void execute() {
        m.setPosition(Vector.simpleMove(m.getPosition(), m.getSpeed(), m.getDirection()));
    }
}
