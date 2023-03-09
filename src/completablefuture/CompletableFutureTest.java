package completablefuture;

import java.util.concurrent.*;

/**
 * 可完备化未来测试
 *
 * @author zm
 * @date 2023/02/28
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t----------com in");
        });  //ForkJoinPool.commonPool-worker

        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t-----------comein");
        }, threadPoolExecutor);

        threadPoolExecutor.shutdownNow();
    }
}
