import java.util.ArrayList;
import java.util.Arrays;

public class ResizableArrays {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();

        names.add("Gustavo");
        names.add("Jin");
        names.add("Jhon");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        names.set(0, "TESTING");
        names.add("New one");
        names.remove(2);
        names.clear();
    }
}
