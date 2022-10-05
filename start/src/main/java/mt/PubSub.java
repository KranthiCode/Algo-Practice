package mt;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PubSub {
  BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

  // Producer
  final Runnable producer = () -> {
    while (true) {
      try {
        queue.put("Hello");
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  };

  final Runnable consumer = () -> {
    while (true) {
      final String k;
      try {
        k = queue.take();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      // System.out.println(k);
    }
  };
}
