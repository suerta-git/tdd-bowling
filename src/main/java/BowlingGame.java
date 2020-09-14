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
        for (int frame = 1, index = 0; frame <= 10; ++frame, ++index) {
            int pins = 10;
            int firstHit = hitPinsList.get(index);
            pins -= firstHit;
            if (pins == 0) {
                totalScore += 10 + hitPinsList.get(index + 1) + hitPinsList.get(index + 2);
                continue;
            }

            int secondHit = hitPinsList.get(++index);
            pins -= secondHit;
            if (pins == 0) {
                totalScore += 10 + hitPinsList.get(index + 1);
                continue;
            }
            totalScore += firstHit + secondHit;
        }

        return totalScore;
    }
}
