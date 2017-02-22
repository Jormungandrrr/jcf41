/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.text.Normalizer;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import timeutil.TimeStamp;

/**
 *
 * @author Jorrit
 */
public class sortwords {
    
    TimeStamp Count = new TimeStamp();
    TimeStamp Sort = new TimeStamp();
    TimeStamp Frequence = new TimeStamp();
    TimeStamp Concordance = new TimeStamp();
    
     public String[] getWords(String input) {
        input = input.toLowerCase();
        //The normalizer which transforms Unicode text into an equivalent composed or decomposed form, allowing for easier sorting and searching of text.
        input = Normalizer.normalize(input, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return (input.split("[^a-zA-Z0-9]+"));
    }
     
    // O(n) loops once through all elements in collection
    // I chose to use a hashset because it automatically gets the unique values and it is faster because it is not sorted.
    public String countWords(String input)
    {
        Count.setBegin();
        int count = 0;
        Set<String> words = new HashSet<>();
        for ( String s :  getWords(input)) {
            count++;
            words.add(s);
        }
        Count.setEnd();
        System.out.println(Count.toString());
        return "Unique: " + words.size() + " All: " + count;
    }
    
    // O(n) loops once through all elements in collection
    // I chose to use a treeset because it automatically orders the words on aplhabethic order.
    // The treeset uses binary search which is especially good for large quantity of words O(log n).
    public String sortWords(String input)
    {   
        Sort.setBegin();
        TreeSet<String> words = new TreeSet<>(Collections.reverseOrder());
        for ( String s : getWords(input)) {
             words.add(s);
        }
        Sort.setEnd();
        System.out.println(Sort.toString());
        return words.toString();
    }
    
    // O(n) loops once through all elements in collection
    // I chose to use a HashMap because is the fastest with inputting elements in the map
    // and because it combines two values in one map
    public String frequenceWords(String input)
    {
        Frequence.setBegin();
        Map<String, Integer> words = new HashMap();
        for ( String s : getWords(input)) {
            Integer count = words.get(s);
            if (count == null) {
                words.put(s,1);
            }
            else {
                words.put(s,count + 1);
            }
        }
        
        //overrides the comparator of the collection
        List<Map.Entry<String, Integer>> sortedList = new LinkedList<>(words.entrySet());
        Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>()
        {
            @Override
            public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2)
            {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        Frequence.setEnd();
        System.out.println(Frequence.toString());
        return sortedList.toString();
    }
    
    // O(2n) loops twice through all elements in collection
    // I chose to use a HashMap because it is the best collection for input. I compared the time with th treemap and the hashset was faster.
    // The map consists of a String (key) and HashSet (value).
    // The hashset contains the integers of the line where the word is located.
    // the hashset also only uses unique values so there will be no duplicates.
    public String concordanceWords(String rawInput)
    {
        Concordance.setBegin();
        Map<String,Set<Integer>> words = new HashMap();
        rawInput = rawInput.toLowerCase();    
        rawInput = Normalizer.normalize(rawInput, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        int lineCount = 0;

        for (String l : rawInput.split("\n")) {
            lineCount++;
            for (String s : l.split("[^a-zA-Z0-9]+")) {
                if (words.get(s) != null) { 
                    words.get(s).add(lineCount);
                }
                else{
                    HashSet<Integer> hash = new HashSet();
                    hash.add(lineCount);
                    words.put(s, hash);
                }      
            }
             
        }
        Concordance.setEnd();
        System.out.println(Concordance.toString());
        return words.toString();
    }
}
