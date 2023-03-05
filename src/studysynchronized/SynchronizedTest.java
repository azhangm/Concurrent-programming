package studysynchronized;

/**
 * 同步测试
 * @description : 对象锁 和 类锁
 * 对象锁 : 方法锁 同步代码块锁
 * 类锁 ： synchronization 修饰静态的方法 或 指定锁为class 对象
 * @author zm
 * @date 2023/03/05
 */
public class SynchronizedTest implements Runnable{
    static SynchronizedTest synchronizedTest = new SynchronizedTest();
    static  Object lockA = new Object();
    static  Object lockB = new Object();
    @Override
    public void run() {
        synchronized (lockA) {
            try {
                System.out.println("获取 LOCK A " + Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println("释放 LOCK A  " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (lockB) {
            try {
                System.out.println("获取 LOCK B " + Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println("释放   LOCK B  " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        Thread thread = new Thread(synchronizedTest);

        Thread thread1 = new Thread(synchronizedTest);

        thread.start();
        thread1.start();

    }
}
