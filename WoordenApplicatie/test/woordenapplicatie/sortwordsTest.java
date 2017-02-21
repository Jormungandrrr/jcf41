/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.Arrays;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorrit
 */
public class sortwordsTest {
    
    public sortwordsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getWords method, of class sortwords.
     */
    @Test
    public void testGetWords() {
        System.out.println("getWords");
        String input = "";
        sortwords instance = new sortwords();
        String[] expResult = null;
        String[] result = instance.getWords(input);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of countWords method, of class sortwords.
     */
    @Test
    public void testCountWords() {
        System.out.println("countWords");
        String input = "test test oke";
        sortwords instance = new sortwords();
        String expResult = "Unique: " + 2 + " All: " + 3;;
        String result = instance.countWords(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of sortWords method, of class sortwords.
     */
    @Test
    public void testSortWords() {
        System.out.println("sortWords");
        String input = "";
        sortwords instance = new sortwords();
        String expResult = "";
        String result = instance.sortWords(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of frequenceWords method, of class sortwords.
     */
    @Test
    public void testFrequenceWords() {
        System.out.println("frequenceWords");
        String input = "";
        sortwords instance = new sortwords();
        String expResult = "";
        String result = instance.frequenceWords(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of concordanceWords method, of class sortwords.
     */
    @Test
    public void testConcordanceWords() {
        System.out.println("concordanceWords");
        String rawInput = "";
        sortwords instance = new sortwords();
        String expResult = "";
        String result = instance.concordanceWords(rawInput);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
     public String generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return Arrays.toString(randomStrings);
    }
    
}
