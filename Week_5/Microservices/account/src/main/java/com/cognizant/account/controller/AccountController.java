package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class AccountController {
  static class AccountData {
    public String number;
    public String type;
    public int balance;

    AccountData(String number, String type, int balance) {
      this.number = number;
      this.type = type;
      this.balance = balance;
    }
  }

  @GetMapping("/account/{number}")
  public AccountData getData(@PathVariable String number) {
    AccountData dummyResponse = new AccountData(number, "savings", 10000);
    return dummyResponse;
  }
}
