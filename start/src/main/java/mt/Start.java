package mt;

public class Start {
  public static void main(String[] args) {
    TestThread1 t1 = new TestThread1();
    TestThread2 t2 = new TestThread2();
    Thread t3 = new Thread(new TestThread3());
    t3.setPriority(Thread.MAX_PRIORITY);
    t1.start();
    t2.start();
    t3.start();
  }
}

class TestThread1 extends Thread {
  @Override
  public void run() {
    System.out.println("Thread 1 started.");
    for (int i = 0; i < 100; i++) {
      // try {
      // Thread.sleep(100);
      // } catch (InterruptedException e) {
      // // TODO Auto-generated catch block
      // e.printStackTrace();
      // }
      System.out.println("Thread 1 " + i);
    }
  }
}

class TestThread2 extends Thread {
  @Override
  public void run() {
    System.out.println("Thread 2  started");
    for (int i = 0; i < 100; i++) {
      // try {
      // Thread.sleep(100);
      // } catch (InterruptedException e) {
      // // TODO Auto-generated catch block
      // e.printStackTrace();
      // }
      System.out.println("Thread 2 " + i);
    }
  }
}

class TestThread3 implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println("Thread 3: " + i);
    }

  }

}
