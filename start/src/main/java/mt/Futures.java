package mt;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Futures {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    CompletableFuture<String> cFuture1 = CompletableFuture.supplyAsync(() -> {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return "hello";
    });

    CompletableFuture<String> cFuture2 = CompletableFuture.supplyAsync(() -> {
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return "World";
    });

    CompletableFuture<String> cFuture3 = CompletableFuture.supplyAsync(() -> {
      try {
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return "Kranthi";
    });

    CompletableFuture<String> result = cFuture1.thenCombine(cFuture2, (r1, r2) -> {
      return r1 + r2;
    });

    // String restul1 = Stream.of(cFuture1, cFuture2, cFuture3)
    // .map(CompletableFuture::join).collect(Collectors.joining(" "));

    CompletableFuture[] tasks = { cFuture1, cFuture2, cFuture3 };

    CompletableFuture<String> combineResult = CompletableFuture.allOf(tasks).thenApply(v -> {
      List<Object> list = Stream.of(tasks).map(CompletableFuture::join).collect(Collectors.toList());
      // System.out.println(list);
      return list;
    }).thenApply(list -> {
      String k = "";
      for (Object str : list) {
        k = k + str;
      }
      return k;
    });

    combineResult.thenRunAsync(() -> {

    });

    System.out.println(result.get());
  }

  public static void sleep(int seconds) throws InterruptedException {
    Thread.sleep(seconds * 1000);
  }

}
