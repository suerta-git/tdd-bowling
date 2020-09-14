import java.util.List;

public class BowlingGame {
    public int getTotalScore(List<Integer> hitPins) {
        if (hitPins == null) {
            throw new IllegalArgumentException("input should not be null");
        }

        if (hitPins.isEmpty()) {
            throw new IllegalArgumentException("input should not be empty");
        }
        return 0;
    }
}
