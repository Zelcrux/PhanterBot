package net.zelcrux.bot;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    private final String botToken;
    private final String webhook;
    public Config() {
        Dotenv config = Dotenv.load();
        botToken = config.get("TOKEN");
        webhook = config.get("WEBHOOK");
    }
    public String getBotToken() {
        return botToken;
    }
    public String getWebhook() {
        return webhook;
    }
}
