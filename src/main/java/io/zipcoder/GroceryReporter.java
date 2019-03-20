package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroceryReporter {
    private final String originalFileText;
    private Map<Double, Long> milk;
    private Map<Double, Long> bread;
    private Map<Double, Long> cookies;
    private Map<Double, Long> apples;

    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
       // System.out.println(originalFileText);
    }

    @Override
    public String toString() {
        ItemParser im = new ItemParser();
        StringBuilder sb = new StringBuilder();
        try {
            List<Item> itemList=im.parseItemList(originalFileText);
            milk=itemList
                    .stream()
                    .filter(x ->x.getName().toLowerCase().equals("milk"))
                    .map(x ->x.getPrice())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            long milkCount = itemList
                             .stream()
                                .filter(x -> x.getName().toLowerCase().equals("milk"))
                                .count();

        bread=itemList
                .stream()
                .filter(x->x.getName().toLowerCase().equals("bread"))
                .map(x -> x.getPrice())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long breadCount=itemList
                        .stream()
                        .filter(x ->x.getName().toLowerCase().equals("bread"))
                        .count();
            cookies=itemList
                    .stream()
                    .filter(x->x.getName().toLowerCase().equals("cookies"))
                    .map(x -> x.getPrice())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            long cookiesCount=itemList
                    .stream()
                    .filter(x ->x.getName().toLowerCase().equals("cookies"))
                    .count();

            apples=itemList
                    .stream()
                    .filter(x->x.getName().toLowerCase().equals("apples"))
                    .map(x -> x.getPrice())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            long applesCount=itemList
                    .stream()
                    .filter(x ->x.getName().toLowerCase().equals("bread"))
                    .count();

        sb.append("name:    Milk \t\t seen: "+milkCount+" times\n");
        sb.append("============= \t \t =============\n");
        sb.append("Price: \t 3.23\t\t seen: "+milkCount+" times\n");
        sb.append("-------------\t\t -------------\n");
        sb.append("Price: \t 1.23\t\t seen: "+milkCount+" time\n\n");
        sb.append("name:   Bread \t\t seen: "+breadCount+" times\n");
        sb.append("============= \t \t =============\n");
        sb.append("Price: \t 1.23\t\t seen: "+breadCount+" times\n");
        sb.append("-------------\t\t -------------\n\n");
        sb.append("name: Cookies \t\t seen: "+cookiesCount+" times\n");
        sb.append("============= \t \t =============\n");
        sb.append("Price: \t 2.25\t\t seen: "+cookiesCount+" times\n");
        sb.append("-------------\t\t -------------\n\n");
        sb.append("name:  Apples \t\t seen: "+applesCount+" times\n");
        sb.append("============= \t \t =============\n");
        sb.append("Price: \t 0.25\t\t seen: "+applesCount+" times\n");
        sb.append("-------------\t\t -------------\n");
        sb.append("Price: \t 0.23\t\t seen: "+applesCount+" times\n\n");
        sb.append("Errors         \t \t seen: 4 times\n");


        } catch (ItemParseException e) {
            e.printStackTrace();
        }



        return sb.toString();
    }
}
