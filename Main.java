import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    ReentrantLockExercise r = new ReentrantLockExercise();
    List<Thread> threads = new ArrayList<>();

    for (int i = 0; i < 5; i++) {
      threads.add(new IncrementThread(r));
      threads.add(new DecrementThread(r));
    }

    for (var t : threads) {
      t.start();
    }

    for (var t : threads) {
      try {
        t.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println("After threads finished operations, final value: " + r.getCounter());
  }
}
