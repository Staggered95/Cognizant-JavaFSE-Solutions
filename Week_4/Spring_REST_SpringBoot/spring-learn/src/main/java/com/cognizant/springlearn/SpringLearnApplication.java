package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

  public static void main(String[] args) throws Exception {
    SpringApplication.run(SpringLearnApplication.class, args);

    displayDate();
    displayCountry();
    displayCountries();
  }

  public static void displayDate() throws Exception {
    LOGGER.info("START displayDate");
    ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
    SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

    Date date = format.parse("31/12/2018");
    LOGGER.debug("Formatted Date: {}", date);
    LOGGER.info("END displayDate");
  }

  public static void displayCountry() {
    LOGGER.info("START displayCountry (Testing Scopes)");
    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

    // This tests HO5: Because it is "prototype", the constructor fires twice.
    Country country = context.getBean("country", Country.class);
    Country anotherCountry = context.getBean("country", Country.class);

    LOGGER.debug("Country: {}", country.toString());
    LOGGER.info("END displayCountry");
  }

  public static void displayCountries() {
    LOGGER.info("START displayCountries");
    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
    ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);

    LOGGER.debug("Country List: {}", countries);
    LOGGER.info("END displayCountries");
  }
}
