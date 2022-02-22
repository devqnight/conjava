package back;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.stream.Collectors;

import com.sun.net.httpserver.*;

import back.conjugaison.conjugate.Verb;
import back.conjugaison.cor.Verb1stGroupCOR;
import back.conjugaison.cor.Verb2ndGroupCOR;
import back.conjugaison.cor.Verb3rdGroupAitreCOR;
import back.conjugaison.cor.Verb3rdGroupEttreCOR;
import back.conjugaison.cor.Verb3rdGroupIndreCOR;
import back.conjugaison.cor.Verb3rdGroupOudreCOR;
import back.conjugaison.cor.VerbCOR;
import back.conjugaison.cor.VerbParticularGerCOR;

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
    VerbCOR finder = new Verb2ndGroupCOR(null);
    finder = new Verb1stGroupCOR(finder);
    finder = new VerbParticularGerCOR(finder);
    finder = new Verb3rdGroupAitreCOR(finder);
    finder = new Verb3rdGroupIndreCOR(finder);
    finder = new Verb3rdGroupEttreCOR(finder);
    finder = new Verb3rdGroupOudreCOR(finder);
    Verb verb = finder.findGroup(stringVerb);
    return verb.conjugate1stPersonSingular();
  }
}
