package atomics_task2;

import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Shop extends Thread{
    private final static int CASHBOX_SIZE = 5;
    private final static int MAX_PRICE = 10;
    private int[] cashbox = new int[CASHBOX_SIZE];
    private static LongAdder sum = new LongAdder();
    Report report;

    public Shop (Report report) {
        this.report = report;
    }

    public int[] makeCash() {
        for (int i = 0; i < CASHBOX_SIZE; i++) {
            Random rnd = new Random();
            cashbox[i] = rnd.nextInt(MAX_PRICE);
        }
        return cashbox;
    }

    private long proceeds() {
        for (int i = 0; i < cashbox.length; i++) {
            sum.add(cashbox[i]);
        }
        return sum.sum();
    }

    @Override
    public void run() {
        makeCash();
        System.out.println("Общая выручка составила у " + Thread.currentThread().getName());
        report.addCash(proceeds());
    }
}
