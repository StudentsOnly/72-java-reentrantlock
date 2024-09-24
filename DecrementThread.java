public class DecrementThread extends Thread {
    private final Counter counter;
    private final int decrementValue;

    public DecrementThread(Counter counter, int decrementValue) {
        this.counter = counter;
        this.decrementValue = decrementValue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.decrement(decrementValue);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
