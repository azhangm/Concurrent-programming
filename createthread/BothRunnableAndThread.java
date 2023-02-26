package createthread;

/**
 * 同时使用 Runnable 和 Thread 两种实现线程的方法
 * @description run 方法被 thread 重写 run 方法。
 * @author zm
 * @date 2023/02/26
 */
public class BothRunnableAndThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("Thread");
            }
        }.start();
    }
}
