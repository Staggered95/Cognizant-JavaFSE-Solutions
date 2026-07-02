package com.solution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExerciseThree {
  private static final Logger logger = LoggerFactory.getLogger(ExerciseThree.class);

  public static void main(String[] args) {
    logger.debug("System diagnostic: Memory check passed.");
    logger.info("Application startup sequence initiated.");
    logger.warn("Deprecation warning: Using old API endpoint.");
    logger.error("FATAL: Database connection lost!");

    System.out.println(
        "\nCheck your project root folder. You should now see an 'app.log' file containing these exact messages!");
  }
}
