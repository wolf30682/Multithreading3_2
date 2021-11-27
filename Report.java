package atomics_task2;

import java.util.concurrent.atomic.LongAdder;

public class Report {
    static LongAdder totalSum = new LongAdder();

    public void addCash(long cash) {
        totalSum.add(cash);
    }

    public void sumCash() {
        System.out.println(totalSum.sum());
    }

}
