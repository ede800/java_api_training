package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

class ClientTest {

    @Test
    void accept() throws IOException, URISyntaxException, InterruptedException {
        Client client = new Client(new Server("1234"), "http://localhost:1234");
        client.connect();
    }
}
