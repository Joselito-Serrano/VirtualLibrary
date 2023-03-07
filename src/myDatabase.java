import java.util.HashMap;
import java.util.Map;

public class myDatabase {
    private static myDatabase instance;

    private Map<Integer, String> books = new HashMap<>();

    private myDatabase() {
    }

    public static myDatabase getInstance() {
        if (instance == null) {
            instance = new myDatabase();
        }

        return instance;
    }

    public static myDatabase getInstanceThreadSafe() {
        if (instance != null) {
            return instance;
        }

        synchronized (myDatabase.class){
            if (instance == null) {
                instance = new myDatabase();
            }
        }

        return instance;
    }

    public String addBooks(int index, String name) {
        books.put(index, name);
        return "Book successfully added";
    }

    public String addBooks(Map<Integer, String> books) {
        for (Map.Entry<Integer, String> book : books.entrySet()) {
            this.books.put(book.getKey(), book.getValue());
        }
        return "Books successfully added";
    }

    public String viewBooks() {
        return books.entrySet().toString();
    }

    public String prettyviewBooks() {
        String result = "";
        for (Map.Entry<Integer, String> book : books.entrySet()) {
            this.books.put(book.getKey(), book.getValue());
            result += book.getKey() + "= " + book.getValue();
            result += "\n";
        }
        return result;
    }

    public String removeBooks(int index) {
        if (books.remove(index) != null) {
            return "Book successfully removed";
        } else {
            return "Book does not exist in the database.\nNo book has been deleted";
        }

    }

    public String removeBooks(int index, String name) {
        if (books.remove(index, name)) {
            return "Book successfully removed";
        } else {
            return "Book does not exist in the database.\nNo book has been deleted";
        }
    }
}
