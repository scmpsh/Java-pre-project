package web.app.service;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.hooks.AnnotatedEventManager;
import net.dv8tion.jda.api.requests.RestAction;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.List;

@Service
public class DiscordServiceImp implements DiscordService {

    private JDA jda;

    @Override
    public void startBot() {
        try {
            jda = JDABuilder.createDefault(SECRET_BOT_TOKEN)
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

    @Override
    public void sendRequest(List<String> adminsDiscordId, Long userId) {
        for (String id : adminsDiscordId) {
            jda.openPrivateChannelById(id)
                    .flatMap(privateChannel -> privateChannel.sendMessage("Кто-то хочет стать админом" +
                            ", посмотри по ссылке -> http://localhost:8080/admin/"))
                    .queue();
        }
    }
}
