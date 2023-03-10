package lockdemo;

public class LockDemo02 {

    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone1 = new Phone();
        new Thread(phone::sendEmail,"a").start();

//        Thread.sleep(1000);
        new Thread(phone1::sendSMS,"b").start();
    }
}


