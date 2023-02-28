package stopthread;

/**
 * 错误停止线程
 *
 * @author zm
 * @date 2023/02/27
 */
public class ErrorStopThread {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <= 10000) {
                    if (num++ % 100 == 0)
                        System.out.println(num - 1 + " 是 100 的倍数");
                        Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
//        让子线程执行 到睡 1000 ms
        Thread.sleep(5000);
        thread.interrupt();
    }
}
