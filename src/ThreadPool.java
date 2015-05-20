/**
 * File created by duane
 * 2015-05-20 | 11:01 AM
 */

public class ThreadPool {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("Hello world.");
            }
        };
        t.start();
    }
}
