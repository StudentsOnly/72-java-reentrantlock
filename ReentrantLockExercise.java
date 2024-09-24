import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExercise {
    public final ReentrantLock lock;
    public int counter;

    public ReentrantLockExercise() {
        this.lock = new ReentrantLock();
        this.counter = 0;
    }

}

class IncrementThread extends Thread {

    ReentrantLockExercise exercise;

    public IncrementThread(ReentrantLockExercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public void run() {
        exercise.lock.lock();
        try {
            exercise.counter += 5;
        } finally {
            exercise.lock.unlock();
        }

    }
}

class DecrementThread extends Thread {
    ReentrantLockExercise exercise;

    public DecrementThread(ReentrantLockExercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public void run() {
        exercise.lock.lock();
        try {
            exercise.counter -= 3;
        } finally {
            exercise.lock.unlock();
        }

    }
}
