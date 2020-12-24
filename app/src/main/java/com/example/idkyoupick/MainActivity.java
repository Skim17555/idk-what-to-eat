package com.example.idkyoupick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

//Our widget objects
TextView title1;
TextView title2;
Button magicButton;

    //main method
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializes our widget objects to the ones we created in the xml file
        title1 = (TextView)findViewById(R.id.txt1);
        title2 = (TextView)findViewById(R.id.txt2);
        magicButton = (Button)findViewById(R.id.magicButton);

        //calls onClick method when the button is clicked by user
        magicButton.setOnClickListener(this);

    }
    //Overridden onClick method from View.OnClickListener interface
    public void onClick(View v) {
        //if input object's id is equal to our magic button's ID, print
        if(v.getId()==R.id.magicButton){
            magicButton.setText("You feelin' some chinese?");
        }

    }
}