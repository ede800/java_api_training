package fr.lernejo.navy_battle;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class HttpServerExample {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  public static void main(String[] args) throws IOException {
    // Créer un serveur HTTP qui écoutera sur le port 9876
    HttpServer server = HttpServer.create(new InetSocketAddress(9876), 0);

    // Créer un ExecutorService de taille fixe (1 thread)
    Executor executor = Executors.newFixedThreadPool(1);
    server.setExecutor(executor);

    // Créer un contexte pour le chemin /ping et y associer un HttpHandler
    HttpContext pingContext = server.createContext("/ping");
    pingContext.setHandler(new HttpHandler() {
      @Override
      public void handle(com.sun.net.httpserver.HttpExchange exchange) throws IOException {
        // Renvoyer une trame HTTP de statut OK (200) et de corps OK
        exchange.sendResponseHeaders(200, 2);
        exchange.getResponseBody().write("OK".getBytes());
        exchange.close();
      }
    });

    // Créer un contexte pour le chemin /api/game/start et y associer un HttpHandler
    HttpContext gameStartContext = server.createContext("/api/game/start");
    gameStartContext.setHandler(new HttpHandler() {
      @Override
      public void handle(com.sun.net.httpserver.HttpExchange exchange) throws IOException {
        // Vérifier que la méthode de la requête est bien POST
        if (!"POST".equals(exchange.getRequestMethod())) {
          exchange.sendResponseHeaders(404, -1);
          exchange.close();
          return;
        }

        // Vérifier que le corps de la requête respecte le schema donné
        GameStartRequest request;
        try {
          request = OBJECT_MAPPER.readValue(exchange.getRequestBody(), GameStartRequest.class);
        } catch (IOException e) {
          exchange.sendResponseHeaders(400, -1);
          exchange.close();
          return;
        }

        // Répondre avec un statut Accepted (202) et un corps respectant le même schema que le corps de la requête,
        // mais reprenant ses propres informations
        GameStartResponse response = new GameStartResponse();
        response.set

