package thread;

public class Eventhread extends Thread {
    private int max;

    public Eventhread(int max) {
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = 2; i <= max; i += 2) {
            System.out.println("EvenThread: " + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
