package diffProcessor;
import java.util.Arrays;

/**
 * Created by VavilauA on 6/19/2015.
 */
public class Processor {
    private long limit;
    public Processor(long limit) {
        this.limit = limit;
    }

    public void doProcess(SortedLimitedList<Double> mustBeEqualTo, SortedLimitedList<Double> expectedOutput) {
        // TODO: make "mustBeEqualTo" list equal to "expectedOutput".
        // 0. Processor will be created once and then will be used billion times.
        // 1. Use methods: AddFirst, AddLast, AddBefore, AddAfter, Remove to modify list.
        // 2. Do not change expectedOutput list.
        // 3. At any time number of elements in list could not exceed the "Limit".
        // 4. "Limit" will be passed into Processor's constructor. All "mustBeEqualTo"
        // and "expectedOutput" lists will have the same "Limit" value.
        // 5. At any time list elements must be in non-descending order.
        // 6. Implementation must perform minimal possible number
        // of actions (AddFirst, AddLast, AddBefore, AddAfter, Remove).
        // 7. Implementation must be fast and do not allocate excess memory.

        SortedLimitedList.Entry z1 = mustBeEqualTo.getFirst();
        SortedLimitedList.Entry z2 = expectedOutput.getFirst();

        while (z1 != null) {
            while (z2 != null && z2.getValue().compareTo(z1.getValue()) < 0) {
                z2 = z2.getNext();
            }
            if (z2 == null || z2.getValue().equals(z1.getValue()) == false) {
                SortedLimitedList.Entry tmp = z1.getNext();
                mustBeEqualTo.remove(z1);
                z1 = tmp;
            } else {
                z1 = z1.getNext();
                z2 = z2.getNext();
            }
        }


        z1 = mustBeEqualTo.getFirst();
        z2 = expectedOutput.getFirst();
        while (z2 != null) {
            while (z1 != null && z1.getValue().compareTo(z2.getValue()) < 0) {
                z1 = z1.getNext();
            }

            if (z1 == null) {
                mustBeEqualTo.addLast((Double) z2.getValue());
            } else if (z1.getValue().equals(z2.getValue())) {
                z1 = z1.getNext();
            } else {
                mustBeEqualTo.addBefore(z1, (Double) z2.getValue());
            }
            z2 = z2.getNext();
        }
    }
}