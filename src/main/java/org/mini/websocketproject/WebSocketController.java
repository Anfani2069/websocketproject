package org.mini.websocketproject;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
 //   création d' une classe de gestionnaire pour traiter les messages WebSocket entrants et mettre à jour les états en conséquence.

    @MessageMapping("/updateState")
    @SendTo("/topic/state")
    public String updateState(String message) {
        // Mettre à jour l'état en fonction du message reçu
        // Retourner l'état mis à jour
        return "Nouvel état : " + message;
    }
}
