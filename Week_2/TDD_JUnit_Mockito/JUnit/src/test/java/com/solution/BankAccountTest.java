package com.solution;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {
  private BankAccount account;

  @Before
  public void setUp() {
    account = new BankAccount(100.0);
    System.out.println("Running setup: Creating a fresh bank account...");
  }

  @After
  public void tearDown() {
    account = null;
    System.out.println("Running teardown: Destroying the bank account...");
  }

  @Test
  public void testDepositLogic() {
    double depositAmount = 50.0;
    account.deposit(depositAmount);
    assertEquals(150.0, account.getBalance(), 0.001);
  }
}
