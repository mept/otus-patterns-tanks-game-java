public class RotateCommand implements Command {
    IRotatable r;

    public RotateCommand(IRotatable r) {
        this.r = r;
    }

    @Override
    public void execute() {
        r.setDirection((r.getDirection() + r.getAngularSpeed()) % r.getMaxDirections());
    }
}
