package threadandobjmethod;

/**
 * 为什么 wait 和 notify 被定义在 obj 里
 * sleep 被定义在 thread 里
 *
 *  1、 研究代码的执行顺序
 *  2、 wait 释放锁的
 *
 *  执行 同步代码块的前提 获得相应的锁。
 * @author zm
 * @date 2023/03/05
 */
public class WaitAndNotify {

    // 执行 wait 和 notify 的
    public static Object obj = new Object();

    public static void main(String[] args) {
        new Thread(new MyThread1()).start();
        new Thread(new MyThread2()).start();
    }

    static class MyThread1 implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + "开始执行");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程 " + Thread.currentThread().getName() + " 获取到了锁");
            }
        }
    }

    static class MyThread2 implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                obj.notify();
                System.out.println(Thread.currentThread().getName() + "调用了 notify 方法");

                System.out.println("等我 执行完 同步代码块中的内容 0号你在执行吧~~~");
            }
        }
    }

}
