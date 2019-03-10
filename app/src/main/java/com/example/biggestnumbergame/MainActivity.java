package com.example.biggestnumbergame;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    int buttonNumber = 9;
    Button[] btns = new Button[buttonNumber]; //Buttons Addresses
    int level = 0;  // 0     Starts Page
                    // 1-10  Level Pages
                    // 11    Game Over Page
                    // 12    Successful Page
    TextView[] txts = new TextView[5];  //Text View Addresses
    LinearLayout[] layouts = new LinearLayout[6];  //Layout Addresses
    int randomNumbers[];
    int BigNum;
    int BestScore;
    CountDownTimer countDownTimer;
    int time, SelectedNumber;
    int score=0; //your score
    boolean refresh;
    long msec = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //get the addresses of buttons, textviews, and layouts
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btns[1]=(Button) findViewById(R.id.btn_1);
        btns[2]=(Button) findViewById(R.id.btn_2);
        btns[3]=(Button) findViewById(R.id.btn_3);
        btns[4]=(Button) findViewById(R.id.btn_4);
        btns[5]=(Button) findViewById(R.id.btn_5);
        btns[6]=(Button) findViewById(R.id.btn_6);
        btns[7]=(Button) findViewById(R.id.btn_7);
        btns[8]=(Button) findViewById(R.id.btn_8);

        txts[1]=(TextView) findViewById(R.id.txt_level);
        txts[2]=(TextView) findViewById(R.id.txt_bestScore);
        txts[3]=(TextView) findViewById(R.id.txt_time);
        txts[4]=(TextView) findViewById(R.id.txt_score);

        layouts[1]=findViewById(R.id.layout_1);
        layouts[2]=findViewById(R.id.layout_2);
        layouts[3]=findViewById(R.id.layout_3);
        layouts[4]=findViewById(R.id.layout_4);
        layouts[5]=findViewById(R.id.layout_5);
    }

    public void btn_1_clicked(View v){ // If the clicked on button 1,check the level. And set the visibility of buttons for your level.
        switch (level){
            case 0:  //First page
                updateLevel();
                break;
            case 1: // For example this case for level 1 and clicked button 1
                    // This case is created new unique random numbers for your level.
                    // And refresh the button's text.
                SelectedNumber=randomNumbers[0];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(2,0,10); //create 2 numbers(c) in range [0,10]
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                }
                break;
            case 2:
                SelectedNumber=randomNumbers[0];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(3,0,20);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                }
                break;
            case 3:
                SelectedNumber=randomNumbers[0];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(3,0,30);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);

                }
                break;
            case 4:
                SelectedNumber=randomNumbers[0];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(4,0,40);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[5].setText("" + randomNumbers[2]);
                    btns[6].setText("" + randomNumbers[3]);

                }
                break;
            case 5:
                SelectedNumber=randomNumbers[0];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(4,-40,40);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[5].setText("" + randomNumbers[2]);
                    btns[6].setText("" + randomNumbers[3]);

                }
                break;
            case 6:
                SelectedNumber=randomNumbers[0];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(4,-60,60);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[5].setText("" + randomNumbers[2]);
                    btns[6].setText("" + randomNumbers[3]);

                }
                break;
            case 7:
                SelectedNumber=randomNumbers[0];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(4,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[5].setText("" + randomNumbers[2]);
                    btns[6].setText("" + randomNumbers[3]);

                }
                break;
            case 8:
                SelectedNumber=randomNumbers[0];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(5,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[5].setText("" + randomNumbers[3]);
                    btns[6].setText("" + randomNumbers[4]);
                }
                break;
            case 9:
                SelectedNumber=randomNumbers[0];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(6,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[5].setText("" + randomNumbers[3]);
                    btns[6].setText("" + randomNumbers[4]);
                    btns[7].setText("" + randomNumbers[5]);
                }
                break;
            case 10:
                SelectedNumber=randomNumbers[0];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(8,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[4].setText("" + randomNumbers[3]);
                    btns[5].setText("" + randomNumbers[4]);
                    btns[6].setText("" + randomNumbers[5]);
                    btns[7].setText("" + randomNumbers[6]);
                    btns[8].setText("" + randomNumbers[7]);
                }
                break;
            case 11:
                updateLevel();
                break;
            case 12:
                updateLevel();
                break;
            default:

                break;
        }
    }

    public void btn_2_clicked(View v){
        switch (level){
            case 0:
                //Doesn't use
                break;
            case 1:
                SelectedNumber=randomNumbers[1];
                boolean refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(2,0,10);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                }
                break;
            case 2:
                SelectedNumber=randomNumbers[1];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(3,0,20);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                }
                break;
            case 3:
                SelectedNumber=randomNumbers[1];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(3,0,30);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);

                }
                break;
            case 4:
                SelectedNumber=randomNumbers[1];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(4,0,40);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[5].setText("" + randomNumbers[2]);
                    btns[6].setText("" + randomNumbers[3]);

                }
                break;
            case 5:
                SelectedNumber=randomNumbers[1];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(4,-40,40);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[5].setText("" + randomNumbers[2]);
                    btns[6].setText("" + randomNumbers[3]);

                }
                break;
            case 6:
                SelectedNumber=randomNumbers[1];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(4,-60,60);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[5].setText("" + randomNumbers[2]);
                    btns[6].setText("" + randomNumbers[3]);

                }
                break;
            case 7:
                SelectedNumber=randomNumbers[1];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(4,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[5].setText("" + randomNumbers[2]);
                    btns[6].setText("" + randomNumbers[3]);

                }
                break;
            case 8:
                SelectedNumber=randomNumbers[1];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(5,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[5].setText("" + randomNumbers[3]);
                    btns[6].setText("" + randomNumbers[4]);
                }
                break;
            case 9:
                SelectedNumber=randomNumbers[1];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(6,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[5].setText("" + randomNumbers[3]);
                    btns[6].setText("" + randomNumbers[4]);
                    btns[7].setText("" + randomNumbers[5]);
                }
                break;
            case 10:
                SelectedNumber=randomNumbers[1];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(8,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[4].setText("" + randomNumbers[3]);
                    btns[5].setText("" + randomNumbers[4]);
                    btns[6].setText("" + randomNumbers[5]);
                    btns[7].setText("" + randomNumbers[6]);
                    btns[8].setText("" + randomNumbers[7]);
                }
                break;
            case 11:
                //Doesn't use
                break;
            case 12:
                //Doesn't use
                break;
            default:

                break;
        }
    }

    public void btn_3_clicked(View v){
        switch (level){
            case 0:
                //Doesn't use
                break;
            case 1:
                //Doesn't use
                break;
            case 2:
                SelectedNumber=randomNumbers[2];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(3,0,20);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                }
                break;
            case 3:
                SelectedNumber=randomNumbers[2];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(3,0,30);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                }
                break;
            case 4:
                //Doesn't use
                break;
            case 5:
                //Doesn't use
                break;
            case 6:
                //Doesn't use
                break;
            case 7:
                //Doesn't use
                break;
            case 8:
                SelectedNumber=randomNumbers[2];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(5,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[5].setText("" + randomNumbers[3]);
                    btns[6].setText("" + randomNumbers[4]);
                }
                break;
            case 9:
                SelectedNumber=randomNumbers[2];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(6,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[5].setText("" + randomNumbers[3]);
                    btns[6].setText("" + randomNumbers[4]);
                    btns[7].setText("" + randomNumbers[5]);
                }
                break;
            case 10:
                SelectedNumber=randomNumbers[2];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(8,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[4].setText("" + randomNumbers[3]);
                    btns[5].setText("" + randomNumbers[4]);
                    btns[6].setText("" + randomNumbers[5]);
                    btns[7].setText("" + randomNumbers[6]);
                    btns[8].setText("" + randomNumbers[7]);
                }
                break;
            case 11:
                //Doesn't use
                break;
            case 12:
                //Doesn't use
                break;
            default:

                break;
        }
    }

    public void btn_4_clicked(View v){
        switch (level){
            case 0:
                //Doesn't use
                break;
            case 1:
                //Doesn't use
                break;
            case 2:
                //Doesn't use
                break;
            case 3:
                //Doesn't use
                break;
            case 4:
                //Doesn't use
                break;
            case 5:
                //Doesn't use
                break;
            case 6:
                //Doesn't use
                break;
            case 7:
                //Doesn't use
                break;
            case 8:
                //Doesn't use
                break;
            case 9:
                //Doesn't use
                break;
            case 10:
                SelectedNumber=randomNumbers[3];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(8,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[4].setText("" + randomNumbers[3]);
                    btns[5].setText("" + randomNumbers[4]);
                    btns[6].setText("" + randomNumbers[5]);
                    btns[7].setText("" + randomNumbers[6]);
                    btns[8].setText("" + randomNumbers[7]);
                }
                break;
            case 11:
                //Doesn't use
                break;
            case 12:
                //Doesn't use
                break;
            default:

                break;
        }
    }

    public void btn_5_clicked(View v){
        switch (level){
            case 0:
                //Doesn't use
                break;
            case 1:
                //Doesn't use
                break;
            case 2:
                //Doesn't use
                break;
            case 3:
                //Doesn't use
                break;
            case 4:
                SelectedNumber=randomNumbers[2];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(4,0,40);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[5].setText("" + randomNumbers[2]);
                    btns[6].setText("" + randomNumbers[3]);

                }
                break;
            case 5:
                SelectedNumber=randomNumbers[2];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(4,-40,40);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[5].setText("" + randomNumbers[2]);
                    btns[6].setText("" + randomNumbers[3]);

                }
                break;
            case 6:
                SelectedNumber=randomNumbers[2];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(4,-60,60);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[5].setText("" + randomNumbers[2]);
                    btns[6].setText("" + randomNumbers[3]);

                }
                break;
            case 7:
                SelectedNumber=randomNumbers[2];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(4,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[5].setText("" + randomNumbers[2]);
                    btns[6].setText("" + randomNumbers[3]);

                }
                break;
            case 8:
                SelectedNumber=randomNumbers[3];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(5,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[5].setText("" + randomNumbers[3]);
                    btns[6].setText("" + randomNumbers[4]);
                }
                break;
            case 9:
                SelectedNumber=randomNumbers[3];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(6,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[5].setText("" + randomNumbers[3]);
                    btns[6].setText("" + randomNumbers[4]);
                    btns[7].setText("" + randomNumbers[5]);
                }
                break;
            case 10:
                SelectedNumber=randomNumbers[4];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(8,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[4].setText("" + randomNumbers[3]);
                    btns[5].setText("" + randomNumbers[4]);
                    btns[6].setText("" + randomNumbers[5]);
                    btns[7].setText("" + randomNumbers[6]);
                    btns[8].setText("" + randomNumbers[7]);
                }
                break;
            case 11:
                //Doesn't use
                break;
            case 12:
                //Doesn't use
                break;
            default:

                break;
        }
    }

    public void btn_6_clicked(View v){
        switch (level){
            case 0:
                //Doesn't use
                break;
            case 1:
                //Doesn't use
                break;
            case 2:
                //Doesn't use
                break;
            case 3:
                //Doesn't use
                break;
            case 4:
                SelectedNumber=randomNumbers[3];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(4,0,40);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[5].setText("" + randomNumbers[2]);
                    btns[6].setText("" + randomNumbers[3]);

                }
                break;
            case 5:
                SelectedNumber=randomNumbers[3];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(4,-40,40);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[5].setText("" + randomNumbers[2]);
                    btns[6].setText("" + randomNumbers[3]);

                }
                break;
            case 6:
                SelectedNumber=randomNumbers[3];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(4,-60,60);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[5].setText("" + randomNumbers[2]);
                    btns[6].setText("" + randomNumbers[3]);

                }
                break;
            case 7:
                SelectedNumber=randomNumbers[3];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(4,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[5].setText("" + randomNumbers[2]);
                    btns[6].setText("" + randomNumbers[3]);

                }
                break;
            case 8:
                SelectedNumber=randomNumbers[4];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(5,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[5].setText("" + randomNumbers[3]);
                    btns[6].setText("" + randomNumbers[4]);
                }
                break;
            case 9:
                SelectedNumber=randomNumbers[4];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(6,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[5].setText("" + randomNumbers[3]);
                    btns[6].setText("" + randomNumbers[4]);
                    btns[7].setText("" + randomNumbers[5]);
                }
                break;
            case 10:
                SelectedNumber=randomNumbers[5];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(8,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[4].setText("" + randomNumbers[3]);
                    btns[5].setText("" + randomNumbers[4]);
                    btns[6].setText("" + randomNumbers[5]);
                    btns[7].setText("" + randomNumbers[6]);
                    btns[8].setText("" + randomNumbers[7]);
                }
                break;
            case 11:
                //Doesn't use
                break;
            case 12:
                //Doesn't use
                break;
            default:

                break;
        }
    }

    public void btn_7_clicked(View v){
        switch (level){
            case 0:
                //Doesn't use
                break;
            case 1:
                //Doesn't use
                break;
            case 2:
                //Doesn't use
                break;
            case 3:
                //Doesn't use
                break;
            case 4:
                //Doesn't use
                break;
            case 5:
                //Doesn't use
                break;
            case 6:
                //Doesn't use
                break;
            case 7:
                //Doesn't use
                break;
            case 8:
                //Doesn't use
                break;
            case 9:
                SelectedNumber=randomNumbers[5];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(6,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[5].setText("" + randomNumbers[3]);
                    btns[6].setText("" + randomNumbers[4]);
                    btns[7].setText("" + randomNumbers[5]);
                }
                break;
            case 10:
                SelectedNumber=randomNumbers[6];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(8,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[4].setText("" + randomNumbers[3]);
                    btns[5].setText("" + randomNumbers[4]);
                    btns[6].setText("" + randomNumbers[5]);
                    btns[7].setText("" + randomNumbers[6]);
                    btns[8].setText("" + randomNumbers[7]);
                }
                break;
            case 11:
                //Doesn't use
                break;
            case 12:
                //Doesn't use
                break;
            default:
                //Doesn't use
                break;
        }
    }

    public void btn_8_clicked(View v){
        switch (level){
            case 0:
                //Doesn't use
                break;
            case 1:
                //Doesn't use
                break;
            case 2:
                //Doesn't use
                break;
            case 3:
                //Doesn't use
                break;
            case 4:
                //Doesn't use
                break;
            case 5:
                //Doesn't use
                break;
            case 6:
                //Doesn't use
                break;
            case 7:
                //Doesn't use
                break;
            case 8:
                //Doesn't use
                break;
            case 9:
                //Doesn't use
                break;
            case 10:
                SelectedNumber=randomNumbers[7];
                refresh = isBiggerNumber(SelectedNumber);
                if(refresh == true){
                    randomNumbers = createUniqueRandomNumbers(8,-100,100);
                    BigNum = getMax(randomNumbers);

                    btns[1].setText("" + randomNumbers[0]);
                    btns[2].setText("" + randomNumbers[1]);
                    btns[3].setText("" + randomNumbers[2]);
                    btns[4].setText("" + randomNumbers[3]);
                    btns[5].setText("" + randomNumbers[4]);
                    btns[6].setText("" + randomNumbers[5]);
                    btns[7].setText("" + randomNumbers[6]);
                    btns[8].setText("" + randomNumbers[7]);
                }
                break;
            case 11:
                //Doesn't use
                break;
            case 12:
                //Doesn't use
                break;
            default:

                break;
        }
    }

    public boolean isBiggerNumber(int a){   // Check the biggest number
                                            // If "a" is not biggest number, this goes to game over and return false.
                                            // If "a" is biggest number, increase "score".
                                            // If "score" is bigger than the "BestScore", refresh "BestScore".
        if(a==BigNum){
            score++;
            if(score>BestScore){
                BestScore=score;
                txts[2].setText("BEST SCORE: " + BestScore);
            }
            txts[4].setText("SCORE: " + score);

            countDownTimer.cancel();

            if(score%5 == 0){               // Every five point, update level.
                updateLevel();
            }
            else{
                countDownTimer.start();     // For time
                return true;
            }
            return false;       //It is actually bigger number, But level is updated
        }
        else{
            countDownTimer.cancel();
            gameOver();
            return false;
        }
    }

    public void updateLevel(){      // When update the level, set design of page for every level.For example buttons and txts visibility.
        switch (level){
            case 0:                 // first page, when clicked the button, start game
            case 11:                // game over page, when clicked the button, try again
            case 12:                // successful page, when clicked the button, play again
                readBestScore();    // read "BestScore" from txt file
                level = 1;
                msec=10000;
                startTimeCounter(msec); //start timer.
                score=0;
                randomNumbers = createUniqueRandomNumbers(2,0,10);
                BigNum = getMax(randomNumbers);

                layouts[1].setVisibility(View.VISIBLE);
                layouts[2].setVisibility(View.VISIBLE);
                layouts[3].setVisibility(View.VISIBLE);
                layouts[4].setVisibility(View.VISIBLE);
                layouts[5].setVisibility(View.GONE);

                txts[1].setVisibility(View.VISIBLE);
                txts[2].setVisibility(View.VISIBLE);
                txts[3].setVisibility(View.VISIBLE);
                txts[4].setVisibility(View.VISIBLE);

                btns[1].setVisibility(View.VISIBLE);
                btns[2].setVisibility(View.VISIBLE);
                btns[3].setVisibility(View.GONE);
                btns[4].setVisibility(View.GONE);
                btns[5].setVisibility(View.GONE);
                btns[6].setVisibility(View.GONE);
                btns[7].setVisibility(View.GONE);
                btns[8].setVisibility(View.GONE);

                btns[1].setBackgroundResource(R.drawable.level1);  //Buttons design change for every level. So it calls the java code.
                btns[2].setBackgroundResource(R.drawable.level1);

                for(int i=1;i<=4;i++) {                            // text colors change for every level with buttons color
                    txts[i].setTextColor(Color.parseColor("#21618C"));
                }

                // Update text of textviews.

                txts[1].setText("LEVEL: 1");
                txts[2].setText("BEST SCORE: " + BestScore);
                txts[3].setText("TIME: " + time);
                txts[4].setText("SCORE: " + score);

                btns[1].setText("" + randomNumbers[0]);
                btns[2].setText("" + randomNumbers[1]);

                countDownTimer.start();

                break;

            case 1:
                level = 2;
                msec=9000;
                randomNumbers = createUniqueRandomNumbers(3,0,20);
                BigNum = getMax(randomNumbers);

                layouts[1].setVisibility(View.VISIBLE);
                layouts[2].setVisibility(View.VISIBLE);
                layouts[3].setVisibility(View.VISIBLE);
                layouts[4].setVisibility(View.VISIBLE);
                layouts[5].setVisibility(View.GONE);

                txts[1].setVisibility(View.VISIBLE);
                txts[2].setVisibility(View.VISIBLE);
                txts[3].setVisibility(View.VISIBLE);
                txts[4].setVisibility(View.VISIBLE);

                btns[1].setVisibility(View.VISIBLE);
                btns[2].setVisibility(View.VISIBLE);
                btns[3].setVisibility(View.VISIBLE);
                btns[4].setVisibility(View.GONE);
                btns[5].setVisibility(View.GONE);
                btns[6].setVisibility(View.GONE);
                btns[7].setVisibility(View.GONE);
                btns[8].setVisibility(View.GONE);

                btns[1].setBackgroundResource(R.drawable.level2);
                btns[2].setBackgroundResource(R.drawable.level2);
                btns[3].setBackgroundResource(R.drawable.level2);

                for(int i=1;i<=4;i++) {
                    txts[i].setTextColor(Color.parseColor("#D81B60"));
                }

                txts[1].setText("LEVEL: 2");
                txts[2].setText("BEST SCORE: " + BestScore);
                txts[3].setText("TIME: " + time);
                txts[4].setText("SCORE: " + score);

                btns[1].setText("" + randomNumbers[0]);
                btns[2].setText("" + randomNumbers[1]);
                btns[3].setText("" + randomNumbers[2]);

                countDownTimer.start();

                break;

            case 2:
                level = 3;
                msec=8000;
                randomNumbers = createUniqueRandomNumbers(3,0,30);
                BigNum = getMax(randomNumbers);

                layouts[1].setVisibility(View.VISIBLE);
                layouts[2].setVisibility(View.VISIBLE);
                layouts[3].setVisibility(View.VISIBLE);
                layouts[4].setVisibility(View.VISIBLE);
                layouts[5].setVisibility(View.GONE);

                txts[1].setVisibility(View.VISIBLE);
                txts[2].setVisibility(View.VISIBLE);
                txts[3].setVisibility(View.VISIBLE);
                txts[4].setVisibility(View.VISIBLE);

                btns[1].setVisibility(View.VISIBLE);
                btns[2].setVisibility(View.VISIBLE);
                btns[3].setVisibility(View.VISIBLE);
                btns[4].setVisibility(View.GONE);
                btns[5].setVisibility(View.GONE);
                btns[6].setVisibility(View.GONE);
                btns[7].setVisibility(View.GONE);
                btns[8].setVisibility(View.GONE);

                btns[1].setBackgroundResource(R.drawable.level3);
                btns[2].setBackgroundResource(R.drawable.level3);
                btns[3].setBackgroundResource(R.drawable.level3);

                for(int i=1;i<=4;i++) {
                    txts[i].setTextColor(Color.parseColor("#117A65"));
                }

                txts[1].setText("LEVEL: 3");
                txts[2].setText("BEST SCORE: " + BestScore);
                txts[3].setText("TIME: " + time);
                txts[4].setText("SCORE: " + score);

                btns[1].setText("" + randomNumbers[0]);
                btns[2].setText("" + randomNumbers[1]);
                btns[3].setText("" + randomNumbers[2]);


                countDownTimer.start();

                break;

            case 3:
                level = 4;
                msec=7000;
                randomNumbers = createUniqueRandomNumbers(4,0,40);
                BigNum = getMax(randomNumbers);

                layouts[1].setVisibility(View.VISIBLE);
                layouts[2].setVisibility(View.VISIBLE);
                layouts[3].setVisibility(View.VISIBLE);
                layouts[4].setVisibility(View.VISIBLE);
                layouts[5].setVisibility(View.VISIBLE);

                txts[1].setVisibility(View.VISIBLE);
                txts[2].setVisibility(View.VISIBLE);
                txts[3].setVisibility(View.VISIBLE);
                txts[4].setVisibility(View.VISIBLE);

                btns[1].setVisibility(View.VISIBLE);
                btns[2].setVisibility(View.VISIBLE);
                btns[3].setVisibility(View.GONE);
                btns[4].setVisibility(View.GONE);
                btns[5].setVisibility(View.VISIBLE);
                btns[6].setVisibility(View.VISIBLE);
                btns[7].setVisibility(View.GONE);
                btns[8].setVisibility(View.GONE);

                btns[1].setBackgroundResource(R.drawable.level4);
                btns[2].setBackgroundResource(R.drawable.level4);
                btns[5].setBackgroundResource(R.drawable.level4);
                btns[6].setBackgroundResource(R.drawable.level4);

                for(int i=1;i<=4;i++) {
                    txts[i].setTextColor(Color.parseColor("#D35400"));
                }

                txts[1].setText("LEVEL: 4");
                txts[2].setText("BEST SCORE: " + BestScore);
                txts[3].setText("TIME: " + time);
                txts[4].setText("SCORE: " + score);

                btns[1].setText("" + randomNumbers[0]);
                btns[2].setText("" + randomNumbers[1]);
                btns[5].setText("" + randomNumbers[2]);
                btns[6].setText("" + randomNumbers[3]);



                countDownTimer.start();

                break;

            case 4:
                level = 5;
                msec=6000;
                randomNumbers = createUniqueRandomNumbers(4,-40,40);
                BigNum = getMax(randomNumbers);

                layouts[1].setVisibility(View.VISIBLE);
                layouts[2].setVisibility(View.VISIBLE);
                layouts[3].setVisibility(View.VISIBLE);
                layouts[4].setVisibility(View.VISIBLE);
                layouts[5].setVisibility(View.VISIBLE);

                txts[1].setVisibility(View.VISIBLE);
                txts[2].setVisibility(View.VISIBLE);
                txts[3].setVisibility(View.VISIBLE);
                txts[4].setVisibility(View.VISIBLE);

                btns[1].setVisibility(View.VISIBLE);
                btns[2].setVisibility(View.VISIBLE);
                btns[3].setVisibility(View.GONE);
                btns[4].setVisibility(View.GONE);
                btns[5].setVisibility(View.VISIBLE);
                btns[6].setVisibility(View.VISIBLE);
                btns[7].setVisibility(View.GONE);
                btns[8].setVisibility(View.GONE);

                btns[1].setBackgroundResource(R.drawable.level5);
                btns[2].setBackgroundResource(R.drawable.level5);
                btns[5].setBackgroundResource(R.drawable.level5);
                btns[6].setBackgroundResource(R.drawable.level5);

                for(int i=1;i<=4;i++) {
                    txts[i].setTextColor(Color.parseColor("#6C3483"));
                }

                txts[1].setText("LEVEL: 5");
                txts[2].setText("BEST SCORE: " + BestScore);
                txts[3].setText("TIME: " + time);
                txts[4].setText("SCORE: " + score);

                btns[1].setText("" + randomNumbers[0]);
                btns[2].setText("" + randomNumbers[1]);
                btns[5].setText("" + randomNumbers[2]);
                btns[6].setText("" + randomNumbers[3]);



                countDownTimer.start();

                break;

            case 5:
                level = 6;
                msec=5000;
                randomNumbers = createUniqueRandomNumbers(4,-60,60);
                BigNum = getMax(randomNumbers);

                layouts[1].setVisibility(View.VISIBLE);
                layouts[2].setVisibility(View.VISIBLE);
                layouts[3].setVisibility(View.VISIBLE);
                layouts[4].setVisibility(View.VISIBLE);
                layouts[5].setVisibility(View.VISIBLE);

                txts[1].setVisibility(View.VISIBLE);
                txts[2].setVisibility(View.VISIBLE);
                txts[3].setVisibility(View.VISIBLE);
                txts[4].setVisibility(View.VISIBLE);

                btns[1].setVisibility(View.VISIBLE);
                btns[2].setVisibility(View.VISIBLE);
                btns[3].setVisibility(View.GONE);
                btns[4].setVisibility(View.GONE);
                btns[5].setVisibility(View.VISIBLE);
                btns[6].setVisibility(View.VISIBLE);
                btns[7].setVisibility(View.GONE);
                btns[8].setVisibility(View.GONE);

                btns[1].setBackgroundResource(R.drawable.level6);
                btns[2].setBackgroundResource(R.drawable.level6);
                btns[5].setBackgroundResource(R.drawable.level6);
                btns[6].setBackgroundResource(R.drawable.level6);

                for(int i=1;i<=4;i++) {
                    txts[i].setTextColor(Color.parseColor("#D3220A"));
                }

                txts[1].setText("LEVEL: 6");
                txts[2].setText("BEST SCORE: " + BestScore);
                txts[3].setText("TIME: " + time);
                txts[4].setText("SCORE: " + score);

                btns[1].setText("" + randomNumbers[0]);
                btns[2].setText("" + randomNumbers[1]);
                btns[5].setText("" + randomNumbers[2]);
                btns[6].setText("" + randomNumbers[3]);



                countDownTimer.start();

                break;

            case 6:
                level = 7;
                msec=4000;
                randomNumbers = createUniqueRandomNumbers(4,-100,100);
                BigNum = getMax(randomNumbers);

                layouts[1].setVisibility(View.VISIBLE);
                layouts[2].setVisibility(View.VISIBLE);
                layouts[3].setVisibility(View.VISIBLE);
                layouts[4].setVisibility(View.VISIBLE);
                layouts[5].setVisibility(View.VISIBLE);

                txts[1].setVisibility(View.VISIBLE);
                txts[2].setVisibility(View.VISIBLE);
                txts[3].setVisibility(View.VISIBLE);
                txts[4].setVisibility(View.VISIBLE);

                btns[1].setVisibility(View.VISIBLE);
                btns[2].setVisibility(View.VISIBLE);
                btns[3].setVisibility(View.GONE);
                btns[4].setVisibility(View.GONE);
                btns[5].setVisibility(View.VISIBLE);
                btns[6].setVisibility(View.VISIBLE);
                btns[7].setVisibility(View.GONE);
                btns[8].setVisibility(View.GONE);

                btns[1].setBackgroundResource(R.drawable.level7);
                btns[2].setBackgroundResource(R.drawable.level7);
                btns[5].setBackgroundResource(R.drawable.level7);
                btns[6].setBackgroundResource(R.drawable.level7);

                for(int i=1;i<=4;i++) {
                    txts[i].setTextColor(Color.parseColor("#1F9326"));
                }

                txts[1].setText("LEVEL: 7");
                txts[2].setText("BEST SCORE: " + BestScore);
                txts[3].setText("TIME: " + time);
                txts[4].setText("SCORE: " + score);

                btns[1].setText("" + randomNumbers[0]);
                btns[2].setText("" + randomNumbers[1]);
                btns[5].setText("" + randomNumbers[2]);
                btns[6].setText("" + randomNumbers[3]);



                countDownTimer.start();

                break;

            case 7:
                level = 8;
                msec=3000;
                randomNumbers = createUniqueRandomNumbers(5,-100,100);
                BigNum = getMax(randomNumbers);

                layouts[1].setVisibility(View.VISIBLE);
                layouts[2].setVisibility(View.VISIBLE);
                layouts[3].setVisibility(View.VISIBLE);
                layouts[4].setVisibility(View.VISIBLE);
                layouts[5].setVisibility(View.VISIBLE);

                txts[1].setVisibility(View.VISIBLE);
                txts[2].setVisibility(View.VISIBLE);
                txts[3].setVisibility(View.VISIBLE);
                txts[4].setVisibility(View.VISIBLE);

                btns[1].setVisibility(View.VISIBLE);
                btns[2].setVisibility(View.VISIBLE);
                btns[3].setVisibility(View.VISIBLE);
                btns[4].setVisibility(View.GONE);
                btns[5].setVisibility(View.VISIBLE);
                btns[6].setVisibility(View.VISIBLE);
                btns[7].setVisibility(View.GONE);
                btns[8].setVisibility(View.GONE);

                btns[1].setBackgroundResource(R.drawable.level8);
                btns[2].setBackgroundResource(R.drawable.level8);
                btns[3].setBackgroundResource(R.drawable.level8);
                btns[5].setBackgroundResource(R.drawable.level8);
                btns[6].setBackgroundResource(R.drawable.level8);

                for(int i=1;i<=4;i++) {
                    txts[i].setTextColor(Color.parseColor("#D23E7F"));
                }

                txts[1].setText("LEVEL: 8");
                txts[2].setText("BEST SCORE: " + BestScore);
                txts[3].setText("TIME: " + time);
                txts[4].setText("SCORE: " + score);

                btns[1].setText("" + randomNumbers[0]);
                btns[2].setText("" + randomNumbers[1]);
                btns[3].setText("" + randomNumbers[2]);
                btns[5].setText("" + randomNumbers[3]);
                btns[6].setText("" + randomNumbers[4]);


                countDownTimer.start();

                break;

            case 8:
                level = 9;
                msec=2000;
                randomNumbers = createUniqueRandomNumbers(6,-100,100);
                BigNum = getMax(randomNumbers);

                layouts[1].setVisibility(View.VISIBLE);
                layouts[2].setVisibility(View.VISIBLE);
                layouts[3].setVisibility(View.VISIBLE);
                layouts[4].setVisibility(View.VISIBLE);
                layouts[5].setVisibility(View.VISIBLE);

                txts[1].setVisibility(View.VISIBLE);
                txts[2].setVisibility(View.VISIBLE);
                txts[3].setVisibility(View.VISIBLE);
                txts[4].setVisibility(View.VISIBLE);

                btns[1].setVisibility(View.VISIBLE);
                btns[2].setVisibility(View.VISIBLE);
                btns[3].setVisibility(View.VISIBLE);
                btns[4].setVisibility(View.GONE);
                btns[5].setVisibility(View.VISIBLE);
                btns[6].setVisibility(View.VISIBLE);
                btns[7].setVisibility(View.VISIBLE);
                btns[8].setVisibility(View.GONE);

                btns[1].setBackgroundResource(R.drawable.level9);
                btns[2].setBackgroundResource(R.drawable.level9);
                btns[3].setBackgroundResource(R.drawable.level9);
                btns[5].setBackgroundResource(R.drawable.level9);
                btns[6].setBackgroundResource(R.drawable.level9);
                btns[7].setBackgroundResource(R.drawable.level9);

                for(int i=1;i<=4;i++) {
                    txts[i].setTextColor(Color.parseColor("#5370E7"));
                }

                txts[1].setText("LEVEL: 9");
                txts[2].setText("BEST SCORE: " + BestScore);
                txts[3].setText("TIME: " + time);
                txts[4].setText("SCORE: " + score);

                btns[1].setText("" + randomNumbers[0]);
                btns[2].setText("" + randomNumbers[1]);
                btns[3].setText("" + randomNumbers[2]);
                btns[5].setText("" + randomNumbers[3]);
                btns[6].setText("" + randomNumbers[4]);
                btns[7].setText("" + randomNumbers[5]);


                countDownTimer.start();

                break;

            case 9:
                level = 10;
                msec=1000;
                randomNumbers = createUniqueRandomNumbers(8,-100,100);
                BigNum = getMax(randomNumbers);

                layouts[1].setVisibility(View.VISIBLE);
                layouts[2].setVisibility(View.VISIBLE);
                layouts[3].setVisibility(View.VISIBLE);
                layouts[4].setVisibility(View.VISIBLE);
                layouts[5].setVisibility(View.VISIBLE);

                txts[1].setVisibility(View.VISIBLE);
                txts[2].setVisibility(View.VISIBLE);
                txts[3].setVisibility(View.VISIBLE);
                txts[4].setVisibility(View.VISIBLE);

                btns[1].setVisibility(View.VISIBLE);
                btns[2].setVisibility(View.VISIBLE);
                btns[3].setVisibility(View.VISIBLE);
                btns[4].setVisibility(View.VISIBLE);
                btns[5].setVisibility(View.VISIBLE);
                btns[6].setVisibility(View.VISIBLE);
                btns[7].setVisibility(View.VISIBLE);
                btns[8].setVisibility(View.VISIBLE);

                btns[1].setBackgroundResource(R.drawable.level10);
                btns[2].setBackgroundResource(R.drawable.level10);
                btns[3].setBackgroundResource(R.drawable.level10);
                btns[4].setBackgroundResource(R.drawable.level10);
                btns[5].setBackgroundResource(R.drawable.level10);
                btns[6].setBackgroundResource(R.drawable.level10);
                btns[7].setBackgroundResource(R.drawable.level10);
                btns[8].setBackgroundResource(R.drawable.level10);

                txts[1].setText("LEVEL: 10");
                txts[2].setText("BEST SCORE: " + BestScore);
                txts[3].setText("TIME: " + time);
                txts[4].setText("SCORE: " + score);

                btns[1].setText("" + randomNumbers[0]);
                btns[2].setText("" + randomNumbers[1]);
                btns[3].setText("" + randomNumbers[2]);
                btns[4].setText("" + randomNumbers[3]);
                btns[5].setText("" + randomNumbers[4]);
                btns[6].setText("" + randomNumbers[5]);
                btns[7].setText("" + randomNumbers[6]);
                btns[8].setText("" + randomNumbers[7]);

                for(int i=1;i<=4;i++) {
                    txts[i].setTextColor(Color.parseColor("#680063"));
                }

                countDownTimer.start();

                break;

            case 10:
                countDownTimer.cancel();
                successfulPage();
                break;

        }
        if(level != 12){
            startTimeCounter(msec);
        }
    }

    public static int getMax(int[] arr){  // Get maximum number of array
        int maxValue = arr[0];
        for(int i=1;i < arr.length;i++){
            if(arr[i] > maxValue){
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    public int createRandomNumberInRange(int min,int max){ // Create a random number in range

        Random random = new Random();
        int number = random.nextInt((max-min+1)) + min;
        return number;
    }

    public int[] createUniqueRandomNumbers(int c , int min, int max){  //Create Unique Random Numbers in range
        int uniqueRandomNumbers[]=new int[c];
        Vector<Integer> vec= new Vector<Integer>();

        for (int i = min;i<=max;i++){
            vec.addElement(i);
        }
        for (int i=0;i<c;i++){
            int num = createRandomNumberInRange(0,vec.size()-1-i);
            uniqueRandomNumbers[i]= vec.get(num);
            vec.remove(num);
        }
        return uniqueRandomNumbers;
    }

    public void gameOver() {    // game over page design
        writeBestScore();
        layouts[1].setVisibility(View.VISIBLE);
        layouts[2].setVisibility(View.VISIBLE);
        layouts[3].setVisibility(View.VISIBLE);
        layouts[4].setVisibility(View.VISIBLE);
        layouts[5].setVisibility(View.GONE);

        txts[1].setVisibility(View.VISIBLE);
        txts[2].setVisibility(View.GONE);
        txts[3].setVisibility(View.VISIBLE);
        txts[4].setVisibility(View.VISIBLE);

        btns[1].setVisibility(View.VISIBLE);
        btns[2].setVisibility(View.GONE);
        btns[3].setVisibility(View.GONE);
        btns[4].setVisibility(View.GONE);
        btns[5].setVisibility(View.GONE);
        btns[6].setVisibility(View.GONE);
        btns[7].setVisibility(View.GONE);
        btns[8].setVisibility(View.GONE);

        btns[1].setBackgroundResource(R.drawable.gameover);

        for(int i=1;i<=4;i++) {
            txts[i].setTextColor(Color.parseColor("#AE0D00"));
        }

        txts[1].setText("SCORE: " + score);
        txts[3].setText("BEST SCORE: " + BestScore);
        txts[4].setText("GAME OVER!");

        btns[1].setText("TRY AGAIN");
        level=11;//Game Over Level
    }

    public void successfulPage() {          // Successful page design
        writeBestScore();
        layouts[1].setVisibility(View.VISIBLE);
        layouts[2].setVisibility(View.VISIBLE);
        layouts[3].setVisibility(View.VISIBLE);
        layouts[4].setVisibility(View.VISIBLE);
        layouts[5].setVisibility(View.GONE);

        txts[1].setVisibility(View.VISIBLE);
        txts[2].setVisibility(View.GONE);
        txts[3].setVisibility(View.VISIBLE);
        txts[4].setVisibility(View.VISIBLE);

        btns[1].setVisibility(View.VISIBLE);
        btns[2].setVisibility(View.GONE);
        btns[3].setVisibility(View.GONE);
        btns[4].setVisibility(View.GONE);
        btns[5].setVisibility(View.GONE);
        btns[6].setVisibility(View.GONE);
        btns[7].setVisibility(View.GONE);
        btns[8].setVisibility(View.GONE);

        btns[1].setBackgroundResource(R.drawable.level7);

        for(int i=1;i<=4;i++) {
            txts[i].setTextColor(Color.parseColor("#1F9326"));
        }

        txts[1].setText("SCORE: " + score);
        txts[3].setText("BEST SCORE: " + BestScore);
        txts[4].setText("YOU WON");

        btns[1].setText("PLAY AGAIN");
        level=12;//Successful level
    }

    public void writeBestScore() {  // write the best score to txt file(bestScore.txt)
        // add-write text into file
        try {
            FileOutputStream fileout=openFileOutput("bestScore.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write("" + BestScore);
            outputWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readBestScore() {  // read the best score from txt file(bestScore.txt)
        //reading text from file
        try {
            FileInputStream fileIn=openFileInput("bestScore.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[2];    //Max Best Score is 50.
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }

            BestScore = Integer.parseInt(s);

            InputRead.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startTimeCounter (long milisec) {       //Time counter for each level
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }

        countDownTimer=new CountDownTimer(milisec,1000){
            @Override
            public void onTick(long millisUntilFinished){
                txts[3].setText("TIME: "+String.valueOf(millisUntilFinished/1000+1));
                time = (int) (millisUntilFinished/1000) + 1;
            }

            public void onFinish(){
                gameOver();
            }
        }.start();
    }
}
