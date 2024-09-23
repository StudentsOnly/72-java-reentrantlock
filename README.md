## Exercise: ReentrantLock

#### Objective: 

The objective of this exercise is to practice working with reentrant locks to synchronize access to a shared resource. You will use the ReentrantLock class to implement an example of thread synchronization.

#### Instructions:

1.	Create a Java class named ReentrantLockExercise.
2.	Inside the class, define a shared resource (e.g., a counter) that multiple threads will access concurrently.
3.	Create a ReentrantLock instance to protect the shared resource.
4.	Implement two classes that extend the Thread class: IncrementThread and DecrementThread. These threads will increment and decrement the shared resource, respectively.
5.	In each thread, use the ReentrantLock to synchronize access to the shared resource.
6.	In the IncrementThread, increment the shared resource by a fixed amount (e.g., 5).
7.	In the DecrementThread, decrement the shared resource by a fixed amount (e.g., 3).
8.	Create multiple instances of IncrementThread and DecrementThread to simulate concurrent access to the shared resource.
9.	Print the final value of the shared resource.
