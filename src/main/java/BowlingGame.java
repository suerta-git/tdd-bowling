import java.util.List;

public class BowlingGame {
    public int getTotalScore(List<Integer> downPins) {
        if (downPins == null) {
            throw new IllegalArgumentException("input should not be null");
        }

        if (downPins.isEmpty()) {
            throw new IllegalArgumentException("input should not be empty");
        }
        return 0;
    }
}
