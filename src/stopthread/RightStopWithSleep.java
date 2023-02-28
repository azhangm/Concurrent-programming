package stopthread;

/**
 * 带有 sleep 的中断线程写法
 *
 * @author zm
 * @date 2023/02/27
 */
public class RightStopWithSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
            while (num <= 300 && !Thread.currentThread().isInterrupted() ) {
                if (num++ % 100 == 0)
                    System.out.println(num - 1 + " 是 100 的倍数");
            }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
//        让子线程执行 到睡 1000 ms
        Thread.sleep(500);
        thread.interrupt();
    }
}
