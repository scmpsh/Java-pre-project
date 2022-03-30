package web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import web.app.bot.LoginEventListener;
import web.app.dao.UserDao;
import web.app.service.DiscordService;

@SpringBootApplication
public class CrudBootstrapApp implements CommandLineRunner {

    @Autowired
    private DiscordService discordService;

    @Autowired
    private UserDao userDao;

    public static void main(String[] args) {
        SpringApplication.run(CrudBootstrapApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        discordService.startBot();
        discordService.addEventListeners(
                new LoginEventListener()
        );
    }
}
