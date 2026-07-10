package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class LoanController {
  static class LoanData {
    public String number;
    public String type;
    public int loan;
    public int emi;
    public int tenure;

    LoanData(String number, String type, int loan, int emi, int tenure) {
      this.number = number;
      this.type = type;
      this.loan = loan;
      this.emi = emi;
      this.tenure = tenure;
    }
  }

  @GetMapping("/loan/{number}")
  public LoanData getData(@PathVariable String number) {
    LoanData dummyData = new LoanData(number, "Home", 500000, 4000, 19);
    return dummyData;
  }
}
