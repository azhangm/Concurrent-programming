package studysynchronized;

/**
 * 同步方法测试
 *
 * @author zm
 * @date 2023/03/05
 */
public class SynchronizedMethodTest implements Runnable {

    static SynchronizedMethodTest instant = new SynchronizedMethodTest();

    synchronized void method(){
        try {
            System.out.println("对象锁方法修饰形式 " + Thread.currentThread().getName() );
            Thread.sleep(3000);
            System.out.println("释放方法形式对象锁 " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        method();
    }

    public static void main(String[] args) {

        Thread thread = new Thread(instant);

        Thread thread1 = new Thread(instant);

        thread.start();
        thread1.start();
        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish");
    }


}
