import java.net.MalformedURLException;
import java.net.URL;

public class ParseURLTwo {
    public static void main(String[] args) {
        try {
            parseURL("https://www.google.com/images");

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void parseURL(String link) throws MalformedURLException {
        URL url = new URL(link);
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPath());
    }
}
