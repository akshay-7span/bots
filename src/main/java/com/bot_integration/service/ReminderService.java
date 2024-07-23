package com.bot_integration.service;

public interface ReminderService {
  void sendReminder(String message);

  void dailyReminder();
}
