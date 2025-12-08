package thread;


public class Oddthread extends Thread {
    private int max;

    public Oddthread(int max) {
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = 1; i <= max; i += 2) {
            System.out.println("OddThread: " + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }
        }
    }
}
