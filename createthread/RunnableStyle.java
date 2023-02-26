package createthread;

/**
 * Runnable 接口实现线程
 * 这种方式更好 ：解耦 资源的节约上 -- > 可以使用 线程池工具。 可扩展强。
 * @author zm
 * @date 2023/02/26
 */
public class RunnableStyle implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(
                "用 Runnable 接口实现线程"
        );
    }
}
