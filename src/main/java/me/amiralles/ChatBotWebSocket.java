package me.amiralles;

import io.smallrye.mutiny.infrastructure.Infrastructure;
import jakarta.inject.Inject;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;

@ServerEndpoint("/chatbot")
public class ChatBotWebSocket {

    @Inject
    SkillMuse skillMuse;

    @Inject
    ChatMemoryBean chatMemoryBean;

    @OnOpen
    public void onOpen(Session session) {
        Infrastructure.getDefaultExecutor().execute(() -> {
            String response = "Hello, I'm SkillMuse, how can I help you? Introduce the skill you are interested in";
            try {
                session.getBasicRemote().sendText(response);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @OnClose
    void onClose(Session session) {
        chatMemoryBean.clear(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        Infrastructure.getDefaultExecutor().execute(() -> {
            String response = skillMuse.chat(session, message);
            try {
                session.getBasicRemote().sendText(response);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

}
