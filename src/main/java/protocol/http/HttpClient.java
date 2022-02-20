package protocol.http;

import framework.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName HttpClient
 * @Author xuwen_chen
 * @Date 2021/1/3 0:36
 * @Version 1.0
 */

public class HttpClient {

    public String send(String hostname, Integer port, Invocation invocation) throws IOException {
        URL url = new URL("http", hostname, port, "/");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("POST");
        urlConnection.setDoOutput(true);

        OutputStream outputStream = urlConnection.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);

        oos.writeObject(invocation);
        oos.flush();
        oos.close();
        return IOUtils.toString(urlConnection.getInputStream());
    }

}
