import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExercise {

  private int counter;
  private Lock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();

  public void increment() {

    try { // give decrement thread a head start
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    lock.lock();
    try {
      counter += 5;
      System.out.println(Thread.currentThread().getName() + " increased counter.");
    } finally {
      condition.signalAll();
      lock.unlock();
    }
  }

  public void decrement() {
    lock.lock();
    try {
      condition.await(1, TimeUnit.MINUTES);
      counter -= 3;
      System.out.println(Thread.currentThread().getName() + " decreased counter.");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public int getCounter() {
    return counter;
  }
}
