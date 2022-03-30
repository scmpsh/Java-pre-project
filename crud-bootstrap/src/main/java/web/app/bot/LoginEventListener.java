package web.app.bot;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.hooks.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.app.dao.UserDao;

import java.util.Objects;

@Component
public class LoginEventListener {

    @Autowired
    private UserDao userDao;

    @SubscribeEvent
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        String username = Objects.requireNonNull(event.getMember()).getUser().getName();
        String userId = event.getMember().getUser().getId();

        if (args[0].equalsIgnoreCase("!login")) {
            if (!event.getMember().getUser().isBot()) {
                event.getMessage().reply("Привет, " + username +
                        ", пожалуйста напиши email, который ты указал на сайте через команду " +
                        "!email \"твой email без кавычек\"").queue();
            }
        }
        if (args[0].equalsIgnoreCase("!email") && !args[1].isEmpty()) {
            if (!event.getMember().getUser().isBot()) {
                userDao.getUserByEmail(args[1]).setDiscord(userId);
                event.getMessage().reply("Ваш ID добавлен в базу").queue();
            }
        }
    }
}
