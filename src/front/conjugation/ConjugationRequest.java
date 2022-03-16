package front.conjugation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import front.connection.ConnectionData;
import front.utils.Utils;

public class ConjugationRequest {

    private ConjugationRequest(){};

    public static String conjugate(String verb){
        String res = "";
        try {
            String urlString = ConnectionData.getInstance().getUrl();
            int port = ConnectionData.getInstance().getPort();
            URL url = new URL("http://" + urlString + ":" + port + "/conjugate/" + verb + "/" + Tense.getInstance().actual + "/" + Mode.getInstance().actual);

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

    public static String getModes(){
      String res = "";
      try{
            String urlString = ConnectionData.getInstance().getUrl();
            int port = ConnectionData.getInstance().getPort();
            URL url = new URL("http://" + urlString + ":" + port + "/getModes");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();

            String line;

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            line = in.readLine();
            res = line;
            con.disconnect();
      } catch (Exception e){
        return null;
      }
      return res;
    }

    public static String getTenses(String mode){
      String res = "";
      try{
            String urlString = ConnectionData.getInstance().getUrl();
            int port = ConnectionData.getInstance().getPort();
            URL url = new URL("http://" + urlString + ":" + port + "/getTenses/"+ mode);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();

            String line;

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            line = in.readLine();
            res = line;
            in.close();
            con.disconnect();
      } catch (Exception e){
        return null;
      }
      return res;
    }

    public static boolean updateTenses(){
      String[] tense = Tense.getInstance().getTensesStrings(Integer.parseInt(Mode.getInstance().actual));
      if(tense == null){
        String jsonTenses = ConjugationRequest.getTenses(Mode.getInstance().actual);
        if(jsonTenses == null){
          return false;
        }
        Map<String,String> tenses = Utils.getMap(jsonTenses);
        switch (Mode.getInstance().actual) {
          case "1":
            Tense.getInstance().setSubjonctiveTenses(tenses);
            Tense.getInstance().actual = "0";
            break;
          case "2":
            Tense.getInstance().setConditionalTenses(tenses);
            Tense.getInstance().actual = "0";
            break;
          default:
            Tense.getInstance().setIndicativeTenses(tenses);
            Tense.getInstance().actual = "0";
            break;
        }
      } else {
        Tense.getInstance().actual = "0";
      }
      return true;
    }
}
