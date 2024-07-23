package com.bot_integration.controller;

import com.bot_integration.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ReminderController {
  @Autowired private ReminderService reminderService;

  @PostMapping("/send-reminder")
  public String sendReminder(@RequestParam String message) {
    reminderService.sendReminder(message);
    return "Reminder sent!";
  }
}
