public class MultiThread {

    public static void main(String[] args) {

        Thread thread2 = new Thread(() -> longTask());
        thread2.start();

        System.out.println("OH NO, A BUG WAS FOUND IN THE MAIN THREAD. LET'S INTERRUPT THE THREAD");
        thread2.interrupt();
        System.out.println("Doing other work on main thread");

    }

    public static void longTask() {

        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            System.out.println("message " + e.getMessage());
        }
        System.out.println("Done Sleeping");

        // long t = System.currentTimeMillis();
        // long end = t + 3000;

        // while (true) {
        // if (System.currentTimeMillis() == end) {
        // System.out.println("Finished long task");
        // break;
        // } else if (Thread.currentThread().isInterrupted()) {
        // System.out.println("This task has been interrupted Prematurely");
        // break;
        // }
        // }
    }

}
