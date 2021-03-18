package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BankAccountTest {

    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTest(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @org.junit.Before
    public void init() {
        System.out.println("Running the test");
        account = new BankAccount("paramvir", "singh", 1000, BankAccount.CHECKING);
    }


    @org.junit.Test
    public void deposit() {
        System.out.println(amount + "," + branch + "," + expected);
        double balance = account.deposit(amount, branch);
        assertEquals(expected, balance, 0.01);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConds() {
        return Arrays.asList(new Object[][]{
                {100, true, 1100},
                {200, true, 1200},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000, true, 2000}
        });
    }
}