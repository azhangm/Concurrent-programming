package studysynchronized;

/**
 * 类同步
 * @description : Java 类可能有多个对象，但只有一个 Class 对象。
 * 形式 1 ：加到 static 方法上
 * 代码块  .class 形式。
 * @author zm
 * @date 2023/03/05
 */
public class ClassSynchronized implements Runnable{
    static ClassSynchronized instant1 = new ClassSynchronized();
    static ClassSynchronized instant2 = new ClassSynchronized();

     static synchronized void method(){
        try {
            System.out.println("类锁 " + Thread.currentThread().getName() );
            Thread.sleep(3000);
            System.out.println("释放类锁 " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
            method();
    }


    public static void main(String[] args) {
        Thread thread = new Thread(instant1);
        Thread thread1 = new Thread(instant2);

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
