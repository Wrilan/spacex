import org.nd4j.shade.jackson.core.JsonParseException;
import org.nd4j.shade.jackson.databind.JsonMappingException;
import org.nd4j.shade.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ApiParser {

    final URL baseUrl = new URL("https://api.spacexdata.com/v3/");

    public ApiParser() throws MalformedURLException {
    }

    public Launch[] getAllLaunches() throws IOException {
        URL url = new URL(baseUrl.toString() + "launches");
        HttpURLConnection conn = (HttpURLConnection) baseUrl.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("HttpResponseCode: " + conn.getResponseCode());
        } else {
            String jsonString ="";
            Scanner sc = new Scanner(url.openStream());

            while (sc.hasNext()) {

                jsonString += sc.nextLine();

            }

            sc.close();

            Launch[] launches;
            try {
                ObjectMapper mapper = new ObjectMapper();
                launches = mapper.readValue(jsonString, Launch[].class);


                return launches;
            } catch (JsonParseException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return new Launch[0];
        }


    }
}
