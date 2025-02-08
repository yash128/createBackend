import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class sendRequest {
    public void main(String host/* www.example.com */, String pagePath /* /dashboard */) {
        int port = 80; // HTTP port

        try (Socket socket = new Socket(host, port);
             OutputStream outputStream = socket.getOutputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Create HTTP GET request
            String httpRequest = "GET "+pagePath+" HTTP/1.1\r\n"
                    + "Host: " + host + "\r\n"
                    + "Connection: close\r\n"
                    + "\r\n";

            // Send HTTP request
            outputStream.write(httpRequest.getBytes());
            outputStream.flush();

            // Read and print the response
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
