package com.springAI.advisor_app.config;

import com.springAI.advisor_app.advisor.TokenPrintAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder){
        return builder
                .defaultAdvisors(new TokenPrintAdvisor(),  new SafeGuardAdvisor(List.of("games")))
                .defaultSystem("You are a helpful coding assistant and an expert programmer.\n" +
                        "Keep the answer concise but complete.\n")
                .defaultOptions(GoogleGenAiChatOptions.builder()
                        .model("gemini-2.5-flash")
                        .temperature(0.3)
                        .maxOutputTokens(2000)
                        .build())
                .build();


    }


}
