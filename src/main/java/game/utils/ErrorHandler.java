package game.utils;


import game.commands.*;
import game.exceptions.MoveException;
import game.exceptions.MoveForwardException;
import game.interfaces.Command;
import org.slf4j.event.Level;

import java.util.LinkedList;

public class ErrorHandler {

    public static void handle(Command command, Exception exception, int retryTimes) {
        Command retryCommand;
        // Количество перезапусков команды в случае неудачи
        if (retryTimes > 1) {
            retryCommand = new MultipleRetriesCommand(command, retryTimes);
        } else {
            retryCommand = new RetryCommand(command);
        }

        LinkedList<LogCommand> logsQueue = new LinkedList<>();

        if (command instanceof MoveForwardCommand && exception instanceof MoveForwardException) {
            try {
                logsQueue.add(new LogCommand(exception, Level.WARN, "Ошибка при попытке прямолинейного движения"));
                retryCommand.execute(); // повторяем команду
            } catch (Exception e) {     // если снова ловим ошибку, то пишем в лог
                logsQueue.add(new LogCommand(exception, Level.ERROR, "Ошибка при попытке прямолинейного движения (попыток: " + retryTimes + ")"));
            }
        }

        if (command instanceof MoveCommand && exception instanceof MoveException) {
            try {
                logsQueue.add(new LogCommand(exception, Level.WARN, "Ошибка при попытке прямолинейного движения"));
                retryCommand.execute(); // повторяем команду
            } catch (Exception e) {     // если снова ловим ошибку, то пишем в лог
                logsQueue.add(new LogCommand(exception, Level.ERROR, "Ошибка при попытке прямолинейного движения (попыток: " + retryTimes + ")"));
            }
        }

        while (!logsQueue.isEmpty()) logsQueue.poll().execute();
    }
}
