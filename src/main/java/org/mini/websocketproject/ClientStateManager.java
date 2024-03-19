package org.mini.websocketproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.web.socket.WebSocketSession;

@Configuration
public class ClientStateManager {

    private final ApplicationContext applicationContext;

    @Autowired
    public ClientStateManager(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void updateState(WebSocketSession session, String newState) {
        FindByIndexNameSessionRepository sessionRepository =
                applicationContext.getBean(FindByIndexNameSessionRepository.class);

        // Mettre à jour l'état du client dans Spring Session
        sessionRepository.findById(session.getId())
                .setAttribute("state", newState);
    }

    public String getState(WebSocketSession session) {
        FindByIndexNameSessionRepository sessionRepository =
                applicationContext.getBean(FindByIndexNameSessionRepository.class);

        // Récupérer l'état du client à partir de Spring Session
        return (String) sessionRepository.findById(session.getId())
                .getAttribute("state");
    }

}
