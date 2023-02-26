package createthread.wrongways;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable {
    @Override
    public Object call() throws Exception {
        return new Object();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new CallableTest());
        futureTask.run();
        System.out.println(futureTask.get());
    }
}
