package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class EvenNumberCheckerTest {

    int number;
    boolean result;

    public EvenNumberCheckerTest(int number, boolean result){
        this.number = number;
        this.result = result;
    }

    @org.junit.Test
    public void testEven(){
        assertEquals(result, isEven(number));
    }

    /**
     * Is the method to be tested.
     * @param num is the number passed to the method
     * @return true if the argument passed is even.
     */
    public boolean isEven(int num){
        return num%2==0;
    }

    @Parameterized.Parameters
    public static Collection evenNumbers(){
        Object[][] ob = new Object[][]{ {2, true}, {3, false}, {4, true}};
        return Arrays.asList(ob);
    }
}