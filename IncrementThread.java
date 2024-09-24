public class IncrementThread extends Thread {
    private final Counter counter;
    private final int incrementValue;

    public IncrementThread(Counter counter, int incrementValue) {
        this.counter = counter;
        this.incrementValue = incrementValue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment(incrementValue);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
