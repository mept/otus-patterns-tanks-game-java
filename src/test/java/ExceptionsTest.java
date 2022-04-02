import game.MovableAdapter;
import game.Vector;
import game.Vehicle;
import game.commands.MoveCommand;
import game.commands.MoveForwardCommand;
import game.interfaces.Command;
import game.utils.ErrorHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тестирование обработки исключений")
public class ExceptionsTest {

    @Test
    @DisplayName("При первом выбросе исключения повторить команду, при повторном выбросе исключения записать информацию в лог.")
    public void testCommandRetryAndLog() {
        // Манипуляции для перехвата System.err и проверки логгирования в ассерте
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream old = System.err;
        System.setErr(new PrintStream(baos));

        // Создаем команды, выполнение которых генерирует исключения
        MovableAdapter movableAdapter = new MovableAdapter(new Vehicle());
        MoveForwardCommand moveForwardCommand = new MoveForwardCommand(movableAdapter);

        MovableAdapter movableVectorAdapter = new MovableAdapter(new Vehicle());
        movableVectorAdapter.setPosition(new Vector(0, 0));
        MoveCommand moveCommand = new MoveCommand(movableVectorAdapter);

        // Добавляем команды в очередь
        LinkedList<Command> queue = new LinkedList<>();
        queue.add(moveForwardCommand);
        queue.add(moveCommand);

        while (!queue.isEmpty()) {
            Command command = queue.poll();
            try {
                command.execute();
            } catch (Exception e) {
                ErrorHandler.handle(command, e, 1);
            }
        }

        System.setErr(old);
        System.err.println(baos);

        // Первый неудачный запуск команды пишет в WARN, повторный - в ERROR
        assertEquals("[main] WARN game.utils.ErrorHandler - Ошибка при попытке прямолинейного движения - Не указана начальная позиция" + System.lineSeparator() +
                "[main] ERROR game.utils.ErrorHandler - Ошибка при попытке прямолинейного движения (попыток: 1) - Не указана начальная позиция" + System.lineSeparator() +
                "[main] WARN game.utils.ErrorHandler - Ошибка при попытке прямолинейного движения - Не указана векторная скорость" + System.lineSeparator() +
                "[main] ERROR game.utils.ErrorHandler - Ошибка при попытке прямолинейного движения (попыток: 1) - Не указана векторная скорость" + System.lineSeparator(), baos.toString());
    }

    @Test
    @DisplayName("Повторить два раза, потом записать в лог. Тип этой команды будет показывать, что Команду не удалось выполнить два раза.")
    public void testCommandRetryTwiceAndLog() {
        // Манипуляции для перехвата System.err и проверки логгирования в ассерте
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream old = System.err;
        System.setErr(new PrintStream(baos));

        MovableAdapter movableAdapter = new MovableAdapter(new Vehicle());
        MoveForwardCommand moveForwardCommand = new MoveForwardCommand(movableAdapter);

        MovableAdapter movableVectorAdapter = new MovableAdapter(new Vehicle());
        movableVectorAdapter.setPosition(new Vector(0, 0));
        MoveCommand moveCommand = new MoveCommand(movableVectorAdapter);

        LinkedList<Command> queue = new LinkedList<>();
        queue.add(moveForwardCommand);
        queue.add(moveCommand);

        while (!queue.isEmpty()) {
            Command command = queue.poll();
            try {
                command.execute();
            } catch (Exception e) {
                ErrorHandler.handle(command, e, 2);
            }
        }

        System.setErr(old);
        System.err.println(baos);

        // Первый неудачный запуск команды пишет в WARN, повторный - в ERROR. Дополнительно пишется число попыток
        assertEquals("[main] WARN game.utils.ErrorHandler - Ошибка при попытке прямолинейного движения - Не указана начальная позиция" + System.lineSeparator() +
                "[main] ERROR game.utils.ErrorHandler - Ошибка при попытке прямолинейного движения (попыток: 2) - Не указана начальная позиция" + System.lineSeparator() +
                "[main] WARN game.utils.ErrorHandler - Ошибка при попытке прямолинейного движения - Не указана векторная скорость" + System.lineSeparator() +
                "[main] ERROR game.utils.ErrorHandler - Ошибка при попытке прямолинейного движения (попыток: 2) - Не указана векторная скорость" + System.lineSeparator(), baos.toString());
    }
}
