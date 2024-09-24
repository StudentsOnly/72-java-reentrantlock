
public class ReentrantLockExercise {
    public static void main(String[] args) {

        Counter counter = new Counter();

        IncrementThread incThread1 = new IncrementThread(counter, 5);
        IncrementThread incThread2 = new IncrementThread(counter, 5);
        DecrementThread decThread1 = new DecrementThread(counter, 3);
        DecrementThread decThread2 = new DecrementThread(counter, 3);

        incThread1.start();
        incThread2.start();
        decThread1.start();
        decThread2.start();

        try {
            incThread1.join();
            incThread2.join();
            decThread1.join();
            decThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + counter.getCounter());
    }
}
