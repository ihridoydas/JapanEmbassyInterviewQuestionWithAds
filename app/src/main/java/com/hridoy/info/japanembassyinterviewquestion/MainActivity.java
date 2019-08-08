package com.hridoy.info.japanembassyinterviewquestion;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import hotchemi.android.rate.AppRate;

public class MainActivity extends AppCompatActivity {

    public Button mPreparationBtn;

    private Button mSelftBtn;
    private Button mBasicBtn;
    private Button mEduBtn;
    private Button mFamillyInfoBtn;
    private Button mEmbassyBtn;
    private Button mEliBtn;
    private Button mOthersBtn;

    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        AppRate.with(this)
                .setInstallDays(1)
                .setLaunchTimes(3)
                .setRemindInterval(2)
                .monitor();




        if(!amIConnected()) buildDialog(MainActivity.this).show();
        else {
            setContentView(R.layout.activity_main);
            AppRate.showRateDialogIfMeetsConditions(this);
        }





        mPreparationBtn = findViewById(R.id.preparationBtn);
        mSelftBtn = findViewById(R.id.selfBtn);
        mBasicBtn = findViewById(R.id.basicBtn);
        mEduBtn = findViewById(R.id.educationBtn);
        mFamillyInfoBtn = findViewById(R.id.fmailyBtn);
        mEmbassyBtn = findViewById(R.id.embassyBtn);
        mEliBtn = findViewById(R.id.eligibiltyBtn);
        mOthersBtn = findViewById(R.id.othersBtn);


        //instrastial ad start
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.Interstitial_ads));



        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {

                startActivity(new Intent(MainActivity.this,BasicQuestionActivity.class));
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());

            }

        });


        mPreparationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent prepareationIntent = new Intent(MainActivity.this, PreparationActivity.class);

                startActivity(prepareationIntent);

            }
        });


        mSelftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent SelfIntent = new Intent(MainActivity.this, SelfIntroduction.class);

                startActivity(SelfIntent);

            }
        });

        mBasicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    startActivity(new Intent(MainActivity.this,BasicQuestionActivity.class));
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                }
            }
        });


        mEduBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent EduIntent = new Intent(MainActivity.this, EduQuestionActivityOne.class);

                startActivity(EduIntent);

            }
        });



        mFamillyInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent Famiintent = new Intent(MainActivity.this, FamillyInfo.class);

                startActivity(Famiintent);

            }
        });

        mEmbassyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent Emintent = new Intent(MainActivity.this, EmbassyActivity.class);

                startActivity(Emintent);

            }
        });


        mEliBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent Emintent = new Intent(MainActivity.this, EligibalityActivity.class);

                startActivity(Emintent);

            }
        });

        mOthersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent Emintent = new Intent(MainActivity.this, OthersQuestionOne.class);

                startActivity(Emintent);

            }
        });
    }

    private boolean amIConnected(){

        ConnectivityManager connectivityManager=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo =connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have Mobile Data or wifi to access this. Press ok to Exit");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }



}
