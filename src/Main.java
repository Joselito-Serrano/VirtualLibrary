import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        myDatabase mydb = myDatabase.getInstance();

        System.out.println("mydb hashcode: " + mydb.hashCode());

        mydb.addBooks(0, "2105: Evolution");
        mydb.addBooks(1, "Claw of Blood");
        mydb.addBooks(2, "Death of Shrieking Viper");

        System.out.println(mydb.viewBooks());
        System.out.println("--------------");

        demoBooks();

        System.out.println("--------------");

        System.out.println("Removing book index 0 \n" + mydb.removeBooks(0));
        System.out.println(mydb.viewBooks());
    }

    private static void demoBooks() {
        Map<Integer, String> demobooks = new HashMap<>();
        demobooks.put(32, "Hand of Neptune");
        demobooks.put(12, "Avian Exile");
        demobooks.put(45, "2132: Sanctum");

        myDatabase mydb = myDatabase.getInstance();

        //check if same hashcode
        System.out.println("mydb hashcode: " + mydb.hashCode());

        System.out.println("Adding books\n" + mydb.addBooks(demobooks));

        System.out.println(mydb.viewBooks());
    }
}