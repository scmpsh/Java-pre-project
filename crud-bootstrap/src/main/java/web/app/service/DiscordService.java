package web.app.service;

import net.dv8tion.jda.api.JDA;

import javax.security.auth.login.LoginException;
import java.util.List;

public interface DiscordService {

    String SECRET_BOT_TOKEN = "OTU4MzMwMzYxMzY3MTI2MDY2.YkLwsw.QuFyiGXrck6txckGDcBJurDFl9M";

    void startBot() throws LoginException;

    void addEventListeners(Object... listeners);

    JDA getJda();

    void setJda(JDA jda);

    void sendRequest(List<String> adminsDiscordId, Long userId);
}
