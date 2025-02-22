package com.maks.gasilskikviz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Quiz extends AppCompatActivity {
    private Button b1, b2, b3, b4;
    private String[] cini = {"g", "g1", "g2", "gc", "gc1", "gc2","mladinec",
            "ngc", "ngc1", "ngc2", "pionir", "pripravnik", "vg", "vg1",
            "vg2", "vgc", "vgc1", "vgc2", "vgcorg", "vgcorg1", "vgcorg2",
            "vkgc", "vkgc1", "vkgc2", "vkgcorg", "vkgcorg1", "vkgcorg2"};
    private  int index = 0;
    private  int pravilniOdgovori = 0;
    private int stodgovorov = 0;

    private String[] imena = {"Gasilec", "Gasilec I.", "Gasilec II.",
        "Gasilski castnik", "Gasilski castnik I.", "Gasilski castnik II.",
        "Mladinec", "Nizji gas. cast.", "Nizji gas. cast. I.",
        "Nizji gas. cast. II,", "Pionir", "Pripravnik", "Visji gas.",
        "Visji gas. I.", "Visji gas. II.", "Visji gas. c.", "Visji gas. c. I",
            "Visji gas. c. II.", "VGC org. smeri", "VGC org. smeri I.",
            "VGC org. smeri II.", "Visoki GC", "Visoki GC I.", "Visoki GC II.",
        "Visoki GC org.", "Visoki GC org. I.", "Visoki GC org. II."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        Button[] btns = {b1, b2, b3, b4};

        TextView stanje = findViewById(R.id.pravilniNepravlini);
        stanje.setText(pravilniOdgovori + "/" + stodgovorov);
        index = switchImage(btns);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              pravilniOdgovori +=  guessed(0);
              stanje.setText(pravilniOdgovori + "/" + stodgovorov);
              System.out.println("stevilo pravilnih odg.:" + pravilniOdgovori);
                index = switchImage(btns);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pravilniOdgovori +=  guessed(1);
                stanje.setText(pravilniOdgovori + "/" + stodgovorov);
                System.out.println("stevilo pravilnih odg.:" + pravilniOdgovori);
                index = switchImage(btns);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pravilniOdgovori +=  guessed(2);
                stanje.setText(pravilniOdgovori + "/" + stodgovorov);
                System.out.println("stevilo pravilnih odg.:" + pravilniOdgovori);
                index = switchImage(btns);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pravilniOdgovori +=  guessed(3);
                stanje.setText(pravilniOdgovori + "/" + stodgovorov);
                System.out.println("stevilo pravilnih odg.:" + pravilniOdgovori);
                index = switchImage(btns);
            }
        });

    }
    public int guessed(int button){
        stodgovorov++;
        if(button == index){
            return 1;
        }else{
            return 0;
        }
    }

    public int switchImage(Button[] btns){
        Log.i("info", "Button pressed");
        ImageView image = (ImageView) findViewById(R.id.imageView);
        //image.setImageResource(R.drawable.g1);
        Random r = new Random();
        int j = r.nextInt(26);
        String uri = "@drawable/" + cini[j];  // where myresource (without the extension) is the file
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());

        image= (ImageView)findViewById(R.id.imageView);
        Drawable res = getResources().getDrawable(imageResource);
        image.setImageDrawable(res);


        String pOdg = imena[j];

        int random = r.nextInt(4);
        for(int i = 0; i < 4; i++){
            if(i != random){
                int ime = r.nextInt(26);
                while(ime == j) {
                    ime = r.nextInt(26);
                }
                btns[i].setText(imena[ime]);
            }else{
                btns[i].setText(pOdg);
            }
        }
        return random;

    }



}