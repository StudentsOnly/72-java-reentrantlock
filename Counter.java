import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock();  // Lock to protect access to counter

    public void increment(int value) {
        lock.lock();
        try {
            counter += value;
            System.out.println(Thread.currentThread().getName() + " incremented counter by " + value + ". Counter: " + counter);
        } finally {
            lock.unlock();
        }
    }

    public void decrement(int value) {
        lock.lock();
        try {
            counter -= value;
            System.out.println(Thread.currentThread().getName() + " decremented counter by " + value + ". Counter: " + counter);
        } finally {
            lock.unlock();  // Ensure the lock is released
        }
    }

    public int getCounter() {
        return counter;
    }
}
