public class ThreadTestRun implements Runnable {
    @Override
    public void run() {
        myDatabase mydb = myDatabase.getInstanceThreadSafe();
//        myDatabase mydb = myDatabase.getInstance(); //This will destroy the singleton if it is not thread safe

        System.out.println("mydb hashcode: " + mydb.hashCode());
        mydb.addBooks((int) (Math.random() * 100 + 1), "");
        mydb.addBooks((int) (Math.random() * 100 + 1), "");
        mydb.addBooks((int) (Math.random() * 100 + 1), "");

        System.out.println("Books in " + mydb.hashCode() + "\n" + mydb.viewBooks() +"\n------------");
    }
}
