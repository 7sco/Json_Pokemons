package com.example.franciscoandrade.pokemon.models;

/**
 * Created by franciscoandrade on 11/29/17.
 */

public class Pokemon {

    //From the json we can get the name and URL
    private String name;
    private String url;
    //add number variable to interact with the image url
    private int number;

    //Create Getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public int getNumber() {
       // get url last number
        String[] urlParts= url.split("/");
        Integer newNum = Integer.parseInt(urlParts[urlParts.length-1]);

        return newNum;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
