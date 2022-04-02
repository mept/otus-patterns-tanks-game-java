package game.commands;

import game.Vector;
import game.exceptions.MoveForwardException;
import game.interfaces.Command;
import game.interfaces.IMovable;

public class MoveForwardCommand implements Command {
    IMovable m;

    public MoveForwardCommand(IMovable m) {
        this.m = m;
    }

    @Override
    public void execute() throws MoveForwardException {
        if (m.getPosition() == null) throw new MoveForwardException("Не указана начальная позиция");
        if (m.getSpeed() == null) throw new MoveForwardException("Не указана скорость");
        if (m.getDirection() == null) throw new MoveForwardException("Не указано направление движения");

        m.setPosition(Vector.simpleMove(m.getPosition(), m.getSpeed(), m.getDirection()));
    }
}
