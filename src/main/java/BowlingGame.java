import java.util.Iterator;
import java.util.List;

public class BowlingGame {
    public int getTotalScore(List<Integer> hitPinsList) {
        if (hitPinsList == null) {
            throw new IllegalArgumentException("input should not be null");
        }

        if (hitPinsList.isEmpty()) {
            throw new IllegalArgumentException("input should not be empty");
        }

        int totalScore = 0;
        int frame = 1;
        int index = 0;
        while (frame <= 10) {
            int pins = 10;
            pins -= hitPinsList.get(index);
            if (pins == 0) {
                totalScore += 10 + hitPinsList.get(index + 1) + hitPinsList.get(index + 2);
            } else if (pins - hitPinsList.get(index + 1) == 0) {
                totalScore += 10 + hitPinsList.get(++index + 1);
            } else {
                totalScore += hitPinsList.get(index) + hitPinsList.get(++index);
            }
            frame++;
            index++;
        }

        return totalScore;
    }
}
