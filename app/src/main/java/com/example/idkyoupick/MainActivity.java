package com.example.idkyoupick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

//our view objects
Button magicButton;
Button yesButton;
Button noButton;

//food database object
foodDatabase ourFood;
//our arraylist of different ethnic group options
ArrayList<String> ethnicityList;
ArrayList<String> chosenList;
//this string will hold the user's chosen ethnic group
String ethnicity;
//random number will allow user to choose ethnic group at random. Will be updated after user presses no
int randomIndex;
//no variable used to determine if user clicked 'no' on ethnic group choice or a food choice
int no;

    //main method
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         //magicbutton declared to allow us to change the text
         magicButton = (Button)findViewById(R.id.magicButton);
         //buttons for yes/no, originally invisible
         yesButton = (Button)findViewById(R.id.yesButton);
         noButton = (Button)findViewById(R.id.noButton);

         //foodDatabase object declared
         ourFood = new foodDatabase();
         ethnicityList = ourFood.getEthnicityList();

         //random number used as index to get ethnicity name from array list of ethnicities
        randomIndex = (int) (Math.random()*(ethnicityList.size()-1))+0;
         //'no' variable initially set to 0
         no=0;
         //random ethnicity name from our array list of ethnicities
         ethnicity = ethnicityList.get(randomIndex);
    }

    //begins the randomizing process
    public void beginMagic(View v) {
            Button inputButton = (Button)v;
            //change text of magic button to give user an ethnic group choice
            inputButton.setText("You feelin' some " + ethnicity + "?");

            //yes/no buttons will be visible to user
            yesButton.setVisibility(View.VISIBLE);
            noButton.setVisibility(View.VISIBLE);

            inputButton.setClickable(false);
    }
    //if user clicks yes/no
    public void continueMagic(View v){

        //when user clicks 'yes':
        if(v.getId()==R.id.yesButton){

           //user's chosen food list
           chosenList = ourFood.getFoodList(ethnicity);

           //temp random index to give user random food option
           randomIndex = (int)(Math.random()*(chosenList.size()-1))+0;

           //gives user choice
            magicButton.setText("How does " + chosenList.get(randomIndex) + " sound?");

            //if user makes a food choice, the randomizing terminates
            if(no>0){
                magicButton.setText("Good choice my g");
                yesButton.setVisibility(View.INVISIBLE);
                noButton.setVisibility(View.INVISIBLE);
            }
            //inc 'no' so when user clicks 'no' on a food choice, it continues giving user a food option
            no++;
        }
        //when user clicks 'no'
        else if(v.getId()==R.id.noButton){
            //if no ethnic group has been chosen yet:
            if(no==0) {
                //remove the declined ethnic group
                ethnicityList.remove(randomIndex);
                //if all ethnic group options have been removed, the process is terminated
                if(ethnicityList.size()==0){
                    magicButton.setText("Sorry fam you a lost cause :(");
                    yesButton.setVisibility(View.INVISIBLE);
                    noButton.setVisibility(View.INVISIBLE);
                }
                //if user still has ethnic group choices:
                else {
                    //new random index
                    randomIndex = (int) (Math.random() * (ethnicityList.size()-1)) + 0;
                    //new ethnic group choice
                    ethnicity = ethnicityList.get(randomIndex);
                    //change text of magic button to give user a new ethnic group choice
                    magicButton.setText("You feelin' some " + ethnicity + "?");
                }
            }
            //if user clicks 'no' on a food choice, continue giving user food choice in the list
            else if(no>0){
                no=0;
                //remove the declined choice
                chosenList.remove(randomIndex);
                if(chosenList.size()==0){
                    magicButton.setText("Sorry fam you a whole lost cause :(");
                    yesButton.setVisibility(View.INVISIBLE);
                    noButton.setVisibility(View.INVISIBLE);
                }
                else {
                    continueMagic(yesButton);
                }
            }
        }
    }
}