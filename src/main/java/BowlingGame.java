import java.util.List;

public class BowlingGame {
    public int getTotalScore(List<Integer> hitPinsList) {
        if (hitPinsList == null) {
            throw new IllegalArgumentException("input should not be null");
        }

        if (hitPinsList.isEmpty()) {
            throw new IllegalArgumentException("input should not be empty");
        }

        return calculateTotalScore(hitPinsList);
    }

    private int calculateTotalScore(List<Integer> hitPinsList) {
        int totalScore = 0;
        HitsRecord hitsRecord = new HitsRecord(hitPinsList);

        for (int frame = 1; frame <= 10; ++frame) {
            int standingPins = 10;

            int firstHitPins = hitsRecord.getNextHitPins();
            standingPins -= firstHitPins;
            if (standingPins == 0) {
                totalScore += 10 + hitsRecord.getBonusOn(2);
                continue;
            }

            int secondHitPins = hitsRecord.getNextHitPins();
            standingPins -= secondHitPins;
            if (standingPins == 0) {
                totalScore += 10 + hitsRecord.getBonusOn(1);
                continue;
            }
            totalScore += firstHitPins + secondHitPins;
        }
        return totalScore;
    }
}
