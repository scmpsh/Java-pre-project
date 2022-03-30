package web.app.service;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.hooks.AnnotatedEventManager;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public class DiscordServiceImp implements DiscordService {

    private JDA jda;

    @Override
    public void startBot() {
        try {
            jda = JDABuilder.createDefault(BOT_TOKEN)
                    .setStatus(OnlineStatus.ONLINE)
                    .setEventManager(new AnnotatedEventManager())
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addEventListeners(Object... listeners) {
        jda.addEventListener(listeners);
    }

    @Override
    public JDA getJda() {
        return jda;
    }

    @Override
    public void setJda(JDA jda) {
        this.jda = jda;
    }
}
