package stopthread;

/**
 * 不能中断
 * 如果在 while 里面放 try/catch ，会导致中断失效
 *
 * @author zm
 * @date 2023/02/27
 */
public class CantInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()  -> {
            int num = 0;
            while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0)
                    System.out.println(num + "是100 倍数");
                num ++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.sleep(5000);
        thread.interrupt();
    }
}
