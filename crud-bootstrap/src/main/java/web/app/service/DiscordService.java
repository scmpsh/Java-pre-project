package web.app.service;

import net.dv8tion.jda.api.JDA;

import javax.security.auth.login.LoginException;

public interface DiscordService {

    String BOT_TOKEN = "OTU4MzMwMzYxMzY3MTI2MDY2.YkLwsw.bm79dZZ7I1RGpVLj5t16wi74eEU";

    void startBot() throws LoginException;

    void addEventListeners(Object... listeners);

    JDA getJda();

    void setJda(JDA jda);
}
