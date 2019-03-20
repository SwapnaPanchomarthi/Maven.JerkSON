package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    private FileReader file = new FileReader();

    List<Item> item;

    public List<Item> parseItemList(String valueToParse) throws ItemParseException {
        item =new ArrayList<Item>();
        String[] arr = valueToParse.split("##");

            for (int i = 0; i < arr.length; i++) {
                try {
                    item.add(parseSingleItem(arr[i]));


                } catch (ItemParseException e) {
                    e.printStackTrace();
                }
            }
        //item = new Item("", 0., "", "");
        return item;

    }


    public Item parseSingleItem(String singleItem) throws ItemParseException  {

        String[] splitted = singleItem.toLowerCase().split("[;#]");

        String name="";
        Double price=0.0;
        String type="";
        String expiration="";
        Map<String, String> values = new HashMap<>();

      try {
          for (String split : splitted) {
              //System.out.println(split);
              String[] pair = split.split("[:^@%*]");
                 // throw new ItemParseException();

              values.put(pair[0], pair[1]);
              System.out.println();

          }

           name = values.get("name");
           price = Double.valueOf(values.get("price"));
           type = values.get("type");
           expiration = values.get("expiration");
          //System.out.println(new Item(name, price, type, expiration));
      }catch (Exception e)
      {
          throw new ItemParseException();
      }

        return new Item(name, price, type, expiration);
    }
}
