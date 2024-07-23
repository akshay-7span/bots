package com.bot_integration.service.impl;

import com.bot_integration.constant.Constants;
import com.bot_integration.service.ReminderService;
import jakarta.annotation.PostConstruct;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ReminderServiceImpl implements ReminderService {

  private final JDABuilder jdaBuilder;
  private JDA jda;

  public ReminderServiceImpl(JDABuilder jdaBuilder) {
    this.jdaBuilder = jdaBuilder;
  }

  @PostConstruct
  public void start() {
    try {
      jda = jdaBuilder.build();
      jda.awaitReady();
      System.out.println("Bot is online!");
    } catch (LoginException | InterruptedException e) {
      e.printStackTrace();
      throw new RuntimeException("Failed to log in to Discord", e);
    }
  }

  @Override
  public void sendReminder(String message) {
    TextChannel channel = jda.getTextChannelById(Constants.REMINDER_CHANNEL_ID);
    if (channel != null) {
      channel.sendMessage(message).queue();
      System.out.println("Message sent: " + message);

    } else {
      System.out.println("Channel not found!");
    }
  }

  @Scheduled(cron = "0 42 20 * * ?")
  @Override
  public void dailyReminder() {
    sendReminder("Daily Reminder for EOD Update!");
  }
}
