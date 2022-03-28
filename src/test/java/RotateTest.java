import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тестирование движения объекта")
public class RotateTest {

    @Test
    @DisplayName("Проверка не переполнения максимального количества направлений при повороте")
    public void testMaxRotate() {
        Vehicle vehicle = new Vehicle();

        RotatableAdapter rotatableAdapter = new RotatableAdapter(vehicle);
        rotatableAdapter.setDirection(4);
        rotatableAdapter.setAngularSpeed(1);

        RotateCommand rotateCommand = new RotateCommand(rotatableAdapter);
        rotateCommand.execute();

        assertEquals(1, rotatableAdapter.getDirection());
    }
}
