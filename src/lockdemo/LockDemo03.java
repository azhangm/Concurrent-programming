package lockdemo;

/**
 * 锁demo03
 * @description  : 两个静态方法 先打印哪个？
 * @author zm
 * @date 2023/03/09
 */
public class LockDemo03 {

    public static void main(String[] args) throws InterruptedException {
//        类锁
        new Thread(Phone1::sendEmail,"a").start();

//        Thread.sleep(2000);
        new Thread(() -> new Phone().hello(),"b").start();
    }
}


     class Phone1 {

        public static synchronized void sendEmail() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sendEmail");
        }

        public static synchronized void sendSMS() {
            System.out.println("sendSMS");
        }

        public void hello() {
            System.out.println("hello");
        }
    }

