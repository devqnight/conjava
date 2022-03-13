package back;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.stream.Collectors;

import com.formdev.flatlaf.json.Json;
import com.sun.net.httpserver.*;

import back.conjugaison.Conjugator;
import back.conjugaison.conjugate.Mode;
import back.conjugaison.conjugate.Tense;
import back.conjugaison.utils.Helper;
import back.conjugaison.utils.Utils;

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
      var value = path.split("/");
      var verb = value[value.length - 3];
      var tense = value[value.length - 2];
      var mode = Mode.getMode(Integer.parseInt(value[value.length - 1]));
      var response = conjugate(verb, tense, mode);
      exchange.sendResponseHeaders(200, response.length());
      OutputStream os = exchange.getResponseBody();
      os.write(response.getBytes());
      os.flush();
    } else {
      exchange.sendResponseHeaders(418, 0);
    }
  }

  private static void getTenseMap(HttpExchange exchange) throws IOException {
    if (exchange.getRequestMethod().equals("GET")) {
      var path = exchange.getRequestURI().getPath();
      var value = path.split("/");
      var tenseInt = value[value.length - 1];
      var map = Tense.tenseMap(Integer.parseInt(tenseInt));
      var response = Helper.convertToJson(map);
      exchange.sendResponseHeaders(200, response.length());
      OutputStream os = exchange.getResponseBody();
      os.write(response.getBytes());
      os.flush();
    } else {
      exchange.sendResponseHeaders(418, 0);
    }
  }

  private static void getModeMap(HttpExchange exchange) throws IOException {
    if (exchange.getRequestMethod().equals("GET")) {
      var map = Mode.modeMap();
      var response = Helper.convertToJson(map);
      System.out.println(response);
      exchange.sendResponseHeaders(200, response.length());
      OutputStream os = exchange.getResponseBody();
      os.write(response.getBytes());
      os.flush();
    } else {
      exchange.sendResponseHeaders(418, 0);
    }

  }

  private static String conjugate(String stringVerb, String tense, String mode) {
    try {
      return Conjugator.getInstance().conjugatePronouns(stringVerb, mode, tense);
    } catch (Exception e) {
      return e.getMessage();
    }
  }
}
