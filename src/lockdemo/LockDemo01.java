package lockdemo;

/**
 * 锁demo01
 *
 * @author zm
 * @date 2023/03/09
 */
public class LockDemo01 {

    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(phone::sendEmail,"a").start();

//        Thread.sleep(1000);
        new Thread(phone::sendSMS,"b").start();
    }
}


class Phone {

    public synchronized void sendEmail() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendEmail");
    }

    public synchronized void sendSMS() {
        System.out.println("sendSMS");
    }

    public void hello(){
        System.out.println("hello");
    }
}