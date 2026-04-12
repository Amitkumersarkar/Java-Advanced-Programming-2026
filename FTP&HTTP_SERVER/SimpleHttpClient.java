import java.io.*;
import java.net.*;

public class SimpleHttpClient {
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:5000/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        int status = conn.getResponseCode();
        System.out.println("Response Code: " + status);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
        );

        String inputLine;
        System.out.println("Response from server:");

        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }

        in.close();
        conn.disconnect();
    }
}