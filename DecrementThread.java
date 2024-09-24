public class DecrementThread extends Thread {
  ReentrantLockExercise sharedResource;

  public DecrementThread(ReentrantLockExercise sharedResource) {
    this.sharedResource = sharedResource;
  }

  @Override
  public void run() {
    sharedResource.decrement();
  }
}
