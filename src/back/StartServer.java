package back;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.stream.Collectors;

import com.sun.net.httpserver.*;

import back.conjugaison.Conjugator;
import back.conjugaison.conjugate.Mode;
import back.conjugaison.utils.Utils;

public class StartServer {

  public static void main(String[] args) {
    runServer();
  }

  private static void runServer() {
    try {
      HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
      server.createContext("/conjugate", StartServer::getConjugation);
      server.setExecutor(null); // creates a default executor
      server.start();
      System.out.println("Server started");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void getConjugation(HttpExchange exchange) throws IOException {
    exchange.getRequestHeaders().forEach((key, value) -> {
      System.out.println(key + " : " + value.stream().collect(Collectors.joining(",")));
    });
    if (exchange.getRequestMethod().equals("GET")) {
      var path = exchange.getRequestURI().getPath();
      var value = path.split("/");
      var verb = value[value.length - 2];
      var tense = value[value.length - 1];
      var response = conjugate(verb, tense);
      exchange.sendResponseHeaders(200, response.length());
      OutputStream os = exchange.getResponseBody();
      os.write(response.getBytes());
      os.flush();
    } else {
      exchange.sendResponseHeaders(418, 0);
    }
  }

  private static String conjugate(String stringVerb, String tense) {
    try{
        return Conjugator.getInstance().conjugatePronouns(stringVerb, Mode.INDICATIVE, Utils.getTense(Integer.parseInt(tense)));
    } catch(Exception e){
        return e.getMessage();
    }
  }
}
