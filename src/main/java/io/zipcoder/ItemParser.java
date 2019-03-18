package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    private FileReader file = new FileReader();

    Item item;

    public List<Item> parseItemList(String valueToParse) {

        item = new Item("", 0., "", "");
        return null;
        /*
        String patternString = searchStr;
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputLine);
        hamletData =matcher.replaceAll(repStr);
        System.out.println(hamletData);
        return String.valueOf(matcher);
         */
    }


    public Item parseSingleItem(String singleItem) throws ItemParseException {
        //Item item = new Item()
        Item result = null;
        String name = null;
        Double price = null;
        String type = null;
        String expiration = null;

        String[] splitted = singleItem.split("[;]");
        for (String split: splitted) {
            //System.out.println(split);
            Pattern pattern=Pattern.compile(split, Pattern.CASE_INSENSITIVE);
            System.out.println(pattern);
            Matcher matcher = pattern.matcher("[: @ ^ * %]");
            System.out.println(matcher);
           // name = matcher.group();


        }

//        String patternString = singleItem;
//        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(singleItem);
//        for (int matchNumber = 0; matcher.find(); matchNumber++) {
//            String value = matcher.group();
//            System.out.println("Match Number = " + matchNumber);
//            System.out.println("Match Value = " + value);
//        }

        result = new Item(name, price, type, expiration);
        return result;
    }
}
