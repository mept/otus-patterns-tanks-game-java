package game.commands;

import game.interfaces.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;


public class LogCommand implements Command {
    private Logger logger;
    private Exception exception;
    private String message;
    private Level level;

    public LogCommand(Exception exception, Level level, String message) {
        logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
        this.exception = exception;
        this.level = level;
        this.message = message;
    }

    @Override
    public void execute() {
        switch (level) {
            case ERROR -> logger.error("{} - {}", message, exception.getMessage());
            case WARN -> logger.warn("{} - {}", message, exception.getMessage());
            case DEBUG -> logger.debug("{} - {}", message, exception.getMessage());
            case TRACE -> logger.trace("{} - {}", message, exception.getMessage());
            default -> logger.info("{} - {}", message, exception.getMessage());
        }
    }
}
