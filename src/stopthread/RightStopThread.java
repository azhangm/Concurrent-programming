package stopthread;

/**
 * 正确停止线程
 * @description : run 方法内没有 sleep 或 wait 方法时，停止线程
 * @author zm
 * @date 2023/02/27
 */
public class RightStopThread implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        RightStopThread rightStopThread = new RightStopThread();
        Thread thread = new Thread(rightStopThread);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

    }

    @Override
    public void run() {
        int num = 0;
        while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2) {
            if (num % (int)1e4 == 0)
                System.out.println(num + "是1w的倍数");
            num ++;
        }
        System.out.println("线程运行任务结束了");

    }
}
