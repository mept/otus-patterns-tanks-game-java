package game.commands;

import game.Vector;
import game.exceptions.MoveException;
import game.interfaces.Command;
import game.interfaces.IMovable;

public class MoveCommand implements Command {
    IMovable m;

    public MoveCommand(IMovable m) {
        this.m = m;
    }

    @Override
    public void execute() throws MoveException {
        if (m.getPosition() == null) throw new MoveException("Не указана начальная позиция");
        if (m.getVectorSpeed() == null) throw new MoveException("Не указана векторная скорость");

        m.setPosition(Vector.vectorMove(m.getPosition(), m.getVectorSpeed()));
    }
}
