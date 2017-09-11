package com.example.noureldeen.responsiveandnotification;

/**
 * Created by noureldeen on 9/12/2017.
 */

public class MyList {
    private String description;
    private String item;

    private MyList(String item, String description) {
        this.item = item;
        this.description = description;
    }

    public static final MyList[] myList = {
            new MyList("item 1", "item 1 description"),
            new MyList("item 2", "item 2 description"),
            new MyList("item 3", "item 3 description"),
            new MyList("item 4", "item 4 description"),
            new MyList("item 5", "item 5 description"),
            new MyList("item 6", "item 6 description")};

    public String getDescription() {
        return description;
    }

    public String getItem() {
        return item;
    }
}
