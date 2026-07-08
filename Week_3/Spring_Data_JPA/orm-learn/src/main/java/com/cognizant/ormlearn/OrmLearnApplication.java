package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

  private static CountryService countryService;

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

    countryService = context.getBean(CountryService.class);

    LOGGER.info("Inside main - Starting Database Tests...");

    try {
      testGetAllCountries();
      testFindCountryByCode();
      testAddCountry();
      testUpdateCountry();
      testDeleteCountry();
    } catch (Exception e) {
      LOGGER.error("A database test failed: ", e);
    }
  }

  private static void testGetAllCountries() {
    LOGGER.info("--- Start testGetAllCountries ---");
    List<Country> countries = countryService.getAllCountries();
    LOGGER.info("Successfully fetched {} countries from the database.", countries.size());
  }

  private static void testFindCountryByCode() throws Exception {
    LOGGER.info("--- Start testFindCountryByCode ---");
    Country country = countryService.findCountryByCode("IN");
    LOGGER.debug("Found Country: {}", country);
  }

  private static void testAddCountry() throws Exception {
    LOGGER.info("--- Start testAddCountry ---");
    Country newCountry = new Country();
    newCountry.setCode("ZZ");
    newCountry.setName("Shubham's Test Country");

    countryService.addCountry(newCountry);
    LOGGER.debug("Successfully added and found: {}", countryService.findCountryByCode("ZZ"));
  }

  private static void testUpdateCountry() throws Exception {
    LOGGER.info("--- Start testUpdateCountry ---");
    countryService.updateCountry("ZZ", "Shubham's Updated Country");
    LOGGER.debug("Successfully updated to: {}", countryService.findCountryByCode("ZZ"));
  }

  private static void testDeleteCountry() {
    LOGGER.info("--- Start testDeleteCountry ---");
    countryService.deleteCountry("ZZ");
    LOGGER.info("Successfully deleted country ZZ.");
  }
}
