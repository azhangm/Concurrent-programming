package createthread;

/**
 * 继承 Thread 类方法实现线程
 *
 * @author zm
 * @date 2023/02/26
 */
public class ThreadStyle extends Thread{

    public static void main(String[] args) {
        ThreadStyle threadStyle = new ThreadStyle();
        threadStyle.start();
    }

    @Override
    public void run() {
        System.out.println("Thread 创建的线程");
    }
}
