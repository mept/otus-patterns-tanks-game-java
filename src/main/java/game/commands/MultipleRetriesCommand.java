package game.commands;

import game.interfaces.Command;

public class MultipleRetriesCommand implements Command {
    private Command command;
    private int retryTimes;

    public MultipleRetriesCommand(Command command, int retryTimes) {
        this.command = command;
        this.retryTimes = retryTimes;
    }

    @Override
    public void execute() throws Exception {
        for (int i = 1; i <= retryTimes; i++) {
            try {
                command.execute();
            } catch (Exception e) {
                if (i == retryTimes) {
                    throw new Exception("Неудачных попыток: " + retryTimes);
                }
            }
        }
    }
}
