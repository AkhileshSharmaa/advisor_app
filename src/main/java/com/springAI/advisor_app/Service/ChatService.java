package com.springAI.advisor_app.Service;

import reactor.core.publisher.Flux;

public interface ChatService {

    String chatTemplate(String query);

    Flux<String> streamChat(String query);
}
