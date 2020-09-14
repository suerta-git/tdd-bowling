import java.util.ArrayList;
import java.util.List;

public class HitsRecord {
    private final List<Integer> hitPinsList;
    private int index = -1;

    public HitsRecord(List<Integer> hitPinsList) {
        this.hitPinsList = new ArrayList<>(hitPinsList);
    }

    public int getNextHitPins() {
        int result;
        try {
            result = hitPinsList.get(++index);
        } catch (Exception ignore) {
            throw new IllegalArgumentException("input is not complete");
        }
        return result;
    }

    public int getBonusOn(int level) {
        int bonus = 0;
        try {
            if (level == 1) {
                bonus = hitPinsList.get(index + 1);
            }
            if (level == 2) {
                bonus = hitPinsList.get(index + 1) + hitPinsList.get(index + 2);
            }
        } catch (Exception ignore) {
            throw new IllegalArgumentException("input is not complete");
        }
        return bonus;
    }
}
