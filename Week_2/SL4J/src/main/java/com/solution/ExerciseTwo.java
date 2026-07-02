package com.solution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExerciseTwo {
  private static final Logger logger = LoggerFactory.getLogger(ExerciseTwo.class);

  public static void main(String[] args) {
    String username = "admin_user";
    int failedAttempts = 3;
    String ipAddress = "192.168.1.50";

    // Parameterized logging using {} placeholders
    logger.info("Login attempt by user: {}", username);
    logger.warn("Security Alert: User {} failed to log in {} times from IP {}.", username, failedAttempts, ipAddress);
  }
}
