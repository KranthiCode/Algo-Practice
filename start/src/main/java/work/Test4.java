package work;

public class Test4 {
  // algo -> 5 algos
  static CyclicBarrier cb = new CyclicBarrier(3);

  // cyclic-barrier - await()

  public static void main(String[] args) {

    Algo algo1 = new Algo(cb);

    Algo algo2 = new Algo(cb);

    Algo algo3 = new Algo(cb);

    Thread t1 = new Thread(algo1);

    Thread t2 = new Thread(algo2);

    Thread t3 = new Thread(algo3);

    t1.start();

  }
}

class Algo implements Runnable {

  CyclicBarrier obj;

  Algo(CyclicBarrier test) {
    this.obj = test;
  }

  @Override
  public void run() {
    {
      obj.await();
      // algo
    }

  }
}

class CyclicBarrier {
  int counter = 0;
  int maxThreads = 5;

  CyclicBarrier(int maxThreads) {
    this.maxThreads = maxThreads;
  }

  void await() {
    this.counter++;
    if (this.counter != maxThreads) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    } else if (counter == maxThreads) {
      this.notifyAll();
    }
  }

}
