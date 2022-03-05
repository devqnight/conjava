package front.conjugation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import front.connection.ConnectionData;

public class ConjugationRequest {

    private ConjugationRequest(){};

    public static String conjugate(String verb){
        String res = "";
        try {
            String urlString = ConnectionData.getInstance().getUrl();
            int port = ConnectionData.getInstance().getPort();
            URL url = new URL("http://" + urlString + ":" + port + "/conjugate/" + verb + "/0");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();

            String line;

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder content = new StringBuilder();
            while((line = in.readLine()) != null)
                content.append(line + "\n");
            in.close();
            con.disconnect();

            res = content.toString();
        } catch (Exception e){
            System.out.println(e);
        }
        return res;
    }
}
