package com.example.idkyoupick;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class foodDatabase {

    //list of ethnic groups
    private ArrayList<String> ethnicityList;
    //list of food names to each ethnic group
    private ArrayList<String> asianFood;
    private ArrayList<String> whitePeoplesFood;
    private ArrayList<String> hispanicFood;
    private ArrayList<String> fastFood;


    //food database constructor method will create hashmap of different ethnic foods
    //methods to add elements into hashmap will be called as well
    foodDatabase(){
        //ArrayList will hold names of different ethnic groups
        ethnicityList = new ArrayList<String>();
        //adds names of ethnic groups; will be chosen at random when user clicks button
        ethnicityList.add("Asian food");
        ethnicityList.add("White people's food");
        ethnicityList.add("Hispanic food");
        ethnicityList.add("Fast food");


        //arraylists containing different foods
        asianFood = new ArrayList<String>();
        whitePeoplesFood = new ArrayList<String>();
        hispanicFood = new ArrayList<String>();
        fastFood = new ArrayList<String>();

        //methods to add names of dishes to it's corresponding hashmap
        addAsian();
        addWhitePeoples();
        addFastFood();
        addHispanic();
    }
    //returns ethnicGroup names of foodDatabase
    public ArrayList<String> getEthnicityList(){
        return ethnicityList;
    }
    //returns arraylist of ethnic group chosen by user
    public ArrayList<String> getFoodList(String ethnicity){
        if(ethnicity.equals("Asian food")){
            return asianFood;
        }
        else if(ethnicity.equals("White people's food")){
            return whitePeoplesFood;
        }
        else if(ethnicity.equals("Hispanic food")){
            return hispanicFood;
        }
        return fastFood;
    }

    //adds asian dishes
    public void addAsian() {
        asianFood.add("Soondubu");
        asianFood.add("Bibimpbap");
        asianFood.add("Korean BBQ");
        asianFood.add("Donkatsu and rice");
        asianFood.add("Khao piek");
        asianFood.add("Laap salad");
        asianFood.add("Bun bo hue");
        asianFood.add("Pho Dac biet");
        asianFood.add("Pork belly");
        asianFood.add("Banh xeo");
        asianFood.add("Sushiiiiii");

    }
    //adds white people dishes
    public void addWhitePeoples(){
        whitePeoplesFood.add("Jim-n-nicks");
        whitePeoplesFood.add("Taco Mac burgers");
        whitePeoplesFood.add("Chicken & waffles");
        whitePeoplesFood.add("Biscuit & gravy");
    }
    public void addHispanic(){
        hispanicFood.add("Tacos");
        hispanicFood.add("Enchiladassssss");
        hispanicFood.add("Birriaaaa tacoooooss");
    }
    public void addFastFood(){
        fastFood.add("Zaxby's");
        fastFood.add("Mcdonald's");
        fastFood.add("Pizza");
        fastFood.add("Jimmy John's");
    }
}
