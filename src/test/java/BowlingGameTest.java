import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BowlingGameTest {

    @Test
    void should_throw_when_given_null() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BowlingGame bowlingGame = new BowlingGame();
            int actual = bowlingGame.getTotalScore(null);
        });
        assertEquals(exception.getMessage(), "input should not be null");
    }
}
