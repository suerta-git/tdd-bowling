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
        HitsRecord hitsRecord = new HitsRecord(hitPinsList);
        for (int frame = 1; frame <= 10; ++frame) {
            int pins = 10;

            int firstHit = hitsRecord.getNextHitPins();
            pins -= firstHit;
            if (pins == 0) {
                totalScore += 10 + hitsRecord.getBonusOn(2);
                continue;
            }

            int secondHit = hitsRecord.getNextHitPins();
            pins -= secondHit;
            if (pins == 0) {
                totalScore += 10 + hitsRecord.getBonusOn(1);
                continue;
            }
            totalScore += firstHit + secondHit;
        }

        return totalScore;
    }
}
