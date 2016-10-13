package thread;

/**
 * Created by yuandl on 2016-09-30.
 */
public class ThreadTest extends Thread {
    private static int tick = 60;

    @Override
    public void run() {
        super.run();
        while (true) {
            if (tick == 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() +"========="+ tick--);
        }
    }
}
