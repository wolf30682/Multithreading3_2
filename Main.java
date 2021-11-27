package atomics_task2;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Report report = new Report();
        Shop shop1 = new Shop(report);
        Shop shop2 = new Shop(report);
        Shop shop3 = new Shop(report);


        Thread threadShop1 = new Thread(null, shop1, "Shop1");
        Thread threadShop2 = new Thread(null, shop2, "Shop2");
        Thread threadShop3 = new Thread(null, shop3, "Shop3");

        threadShop1.start();
        threadShop2.start();
        threadShop3.start();

        threadShop1.join();
        threadShop2.join();
        threadShop3.join();

        report.sumCash();

    }
}
