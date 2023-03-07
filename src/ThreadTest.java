public class ThreadTest {

    public static void main(String[] args) {
        Runnable test1 = new ThreadTestRun();
        Runnable test2 = new ThreadTestRun();
        Runnable test3 = new ThreadTestRun();

        new Thread(test1).start();
        new Thread(test2).start();
        new Thread(test3).start();
    }
}


