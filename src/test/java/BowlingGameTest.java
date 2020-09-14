import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Test
    void should_throw_when_given_empty_list() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BowlingGame bowlingGame = new BowlingGame();
            int actual = bowlingGame.getTotalScore(new ArrayList<>());
        });
        assertEquals(exception.getMessage(), "input should not be empty");
    }

    @Test
    void should_return_0_when_calculate_given_0_hit_pins() {
        BowlingGame bowlingGame = new BowlingGame();
        List<Integer> hitPinsList = Stream.generate(() -> 0).limit(20).collect(Collectors.toList());
        int actual = bowlingGame.getTotalScore(hitPinsList);
        assertEquals(0, actual);
    }

    @Test
    void should_return_300_when_calculate_given_full_hit_pins() {
        BowlingGame bowlingGame = new BowlingGame();
        List<Integer> hitPinsList = Stream.generate(() -> 10).limit(12).collect(Collectors.toList());
        int actual = bowlingGame.getTotalScore(hitPinsList);
        assertEquals(300, actual);
    }
}
