package web.app.bot;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import web.app.model.User;
import web.app.service.UserService;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@Component
public class LoginEventListener {

    private final UserService userService;

    public LoginEventListener(UserService userService) {
        this.userService = userService;
    }

    @SubscribeEvent
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        String userId = Objects.requireNonNull(event.getMember()).getUser().getId();

        if (args[0].equals("!email") && args.length == 2) {
            try {
                User user = userService.getUserByEmail(args[1]);
                if (!event.getMember().getUser().isBot()) {
                    userService.addDiscordIdToUserByEmail(user.getEmail(), userId);
                    event.getMessage().reply("Ваш ID добавлен в базу").queue();
                }
            } catch (NullPointerException e) {
                if (!event.getMember().getUser().isBot()) {
                    event.getMessage().reply("Нет такого юзера с такой почтой, друг").queue();
                }
            }
        }
    }
}
