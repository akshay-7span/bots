package com.bot_integration.config;

import com.bot_integration.constant.Constants;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
  @Bean
  public JDABuilder jdaBuilder() throws LoginException {
    return JDABuilder.createDefault(Constants.DISCORD_TOKEN);
  }
}
