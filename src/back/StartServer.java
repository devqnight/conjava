package back;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import com.sun.net.httpserver.*;

import back.conjugaison.Conjugator;
import back.conjugaison.conjugate.Mode;
import back.conjugaison.conjugate.Tense;
import back.conjugaison.utils.Helper;

public class StartServer {

  public static void main(String[] args) {
    runServer();
  }

  private static void runServer() {
    try {
      HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
      server.createContext("/conjugate", StartServer::getConjugation);
      server.createContext("/getTenses", StartServer::getTenseMap);
      server.createContext("/getModes", StartServer::getModeMap);
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
      exchange.getRequestBody();
      var value = path.split("/");
      var verb = value[value.length - 3];
      int tenseInt = Integer.parseInt(value[value.length - 2]);
      int modeInt = Integer.parseInt(value[value.length - 1]);
      String mode = Mode.getMode(modeInt);
      String tense = Tense.tenseMap(modeInt).get(tenseInt);
      var response = conjugate(verb, tense, mode);
      byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
      exchange.sendResponseHeaders(200, bytes.length);
      exchange.getResponseBody().write(bytes);
      exchange.close();
    } else {
      exchange.sendResponseHeaders(418, 0);
    }
  }

  private static void getTenseMap(HttpExchange exchange) throws IOException {
    if (exchange.getRequestMethod().equals("GET")) {
      var path = exchange.getRequestURI().getPath();
      var value = path.split("/");
      var modeInt = value[value.length - 1];
      var map = Tense.tenseMap(Integer.parseInt(modeInt));
      var response = Helper.convertToJson(map);
      byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
      exchange.sendResponseHeaders(200, bytes.length);
      exchange.getResponseBody().write(bytes);
      exchange.close();
    } else {
      exchange.sendResponseHeaders(418, 0);
    }
  }

  private static void getModeMap(HttpExchange exchange) throws IOException {
    if (exchange.getRequestMethod().equals("GET")) {
      var map = Mode.modeMap();
      var response = Helper.convertToJson(map);
      byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
      exchange.sendResponseHeaders(200, bytes.length);
      exchange.getResponseBody().write(bytes);
      exchange.close();
    } else {
      exchange.sendResponseHeaders(418, 0);
    }

  }

  private static String conjugate(String stringVerb, String tense, String mode) {
    try {
      return Conjugator.getInstance().conjugatePronouns(stringVerb, mode, tense);
    } catch (Exception e) {
      e.printStackTrace();
      return e.getMessage();
    }
  }
}
