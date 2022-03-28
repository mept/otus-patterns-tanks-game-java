import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Тестирование движения объекта")
public class MoveTest {

    @Test
    @DisplayName("Для объекта, находящегося в точке (12, 5) и движущегося со скоростью (-7, 3) движение меняет положение объекта на (5, 8)")
    public void testMove() {
        MovableAdapter movableAdapter = new MovableAdapter(new Vehicle());
        movableAdapter.setPosition(new Vector(12, 5));
        movableAdapter.setSpeed(new Vector(-7, 3));

        MoveCommand moveCommand = new MoveCommand(movableAdapter);
        moveCommand.execute();

        assertEquals(new Vector(5, 8), movableAdapter.getPosition());
    }

    @Test
    @DisplayName("Попытка сдвинуть объект, у которого невозможно прочитать положение в пространстве, приводит к ошибке")
    public void testUnableToGetPosition() {
        MovableAdapter movableAdapter = new MovableAdapter(new Vehicle());
        movableAdapter.setPosition(null);
        movableAdapter.setSpeed(new Vector(-7, 3));

        MoveCommand moveCommand = new MoveCommand(movableAdapter);

        assertThrows(NullPointerException.class, moveCommand::execute);
    }

    @Test
    @DisplayName("Попытка сдвинуть объект, у которого невозможно прочитать значение мгновенной скорости, приводит к ошибке")
    public void testUnableToGetSpeed() {
        MovableAdapter movableAdapter = new MovableAdapter(new Vehicle());
        movableAdapter.setPosition(new Vector(12, 5));
        movableAdapter.setSpeed(null);

        MoveCommand moveCommand = new MoveCommand(movableAdapter);

        assertThrows(NullPointerException.class, moveCommand::execute);
    }

    @Test
    @Disabled("Добавить тест при появлении соответствующего функционала")
    @DisplayName("Попытка сдвинуть объект, у которого невозможно изменить положение в пространстве, приводит к ошибке")
    public void testFailToSetPosition() {
        // todo
    }
}
