package sixstatus;

/**
 * 从新建 (NEW) 到 可运行的状态 (RUNNABLE )到 终止状态(TERMINATED)的演示
 * @author zm
 * @date 2023/03/02
 */
public class NewRunnableTerminated {

    public static void main(String[] args) {

        Thread thread = new Thread(new MyThread());
        System.out.println("未运行start方法的状态"  +  thread.getState());
        thread.start();
        System.out.println("运行 start后 方法的状态" + thread.getState());

        System.out.println(thread.getState());
    }



    static class MyThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        }
    }
}
