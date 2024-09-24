import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReentrantLockExercise exercise = new ReentrantLockExercise();

        ArrayList<Thread> threads = new ArrayList<>(List.of(
                new DecrementThread(exercise), // -3 = -3
                new IncrementThread(exercise), // +5 = 2
                new DecrementThread(exercise), // -3 = -1
                new IncrementThread(exercise) // +5 = 4
        ));

        threads.forEach(Thread::start); // or for(var thread : threads) { thread.start(); }

        threads.forEach(thread -> { // or for (var thread : threads) { try thread.join }
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        System.out.println("Final value: " + exercise.counter);
    }
}
