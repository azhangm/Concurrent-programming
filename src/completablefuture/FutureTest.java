package completablefuture;

import java.util.concurrent.*;

/**
 * Future 接口定义了操作异步任务执行一些方法。 获取异步任务的执行结果、取消任务的执行、判断任务执行是否完毕等。
 * 子线程 叫做 FutureTask
 * @author zm
 * @date 2023/02/28
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<Integer> integerFutureTask = new FutureTask<>(() -> {
//            子线程去执行 耗时任务
            System.out.println(Thread.currentThread().getName() + "\t" + "-----come in");
            TimeUnit.SECONDS.sleep(2);
            return 1024;
        });
        new Thread(integerFutureTask,"t1").start();

//        System.out.println(integerFutureTask.get()); // 不见不散

        while (true) {
            if (integerFutureTask.isDone()) {
                System.out.println("-------result " + integerFutureTask.get());
                break;
            }else System.out.println("还在计算中");
        }

        System.out.println(integerFutureTask.get(1,TimeUnit.SECONDS)); // 过时不候

        System.out.println("--------------- 主线程继续干它该干事情");

    }
}
