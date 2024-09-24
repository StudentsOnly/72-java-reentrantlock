public class IncrementThread extends Thread {
  ReentrantLockExercise sharedResource;

  public IncrementThread(ReentrantLockExercise sharedResource) {
    this.sharedResource = sharedResource;
  }

  @Override
  public void run() {
    sharedResource.increment();
  }
}
