public class Browser {
  public void navigate(String address) {
    String ip = findUpAddress(address);

    String html = sendHttpRequest(ip);

    System.out.println(html);
  }

  private String sendHttpRequest(String ip) {
    return "<html></html>";
  }

  private String findUpAddress(String address) {
    return "127.0.0.1";
  }

}
