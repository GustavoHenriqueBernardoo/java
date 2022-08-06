import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

public class ParseURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com/images");
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPath());

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

}
