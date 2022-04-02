package game.commands;

import game.interfaces.Command;

public class RetryCommand implements Command {
    private Command command;

    public RetryCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute() throws Exception {
        command.execute();
    }
}
