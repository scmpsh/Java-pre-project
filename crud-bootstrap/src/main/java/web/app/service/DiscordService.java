package web.app.service;

import net.dv8tion.jda.api.JDA;

import javax.security.auth.login.LoginException;

public interface DiscordService {

    String SECRET_BOT_TOKEN = "";

    void startBot() throws LoginException;

    void addEventListeners(Object... listeners);

    JDA getJda();

    void setJda(JDA jda);
}
