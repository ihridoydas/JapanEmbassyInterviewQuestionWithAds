package com.hridoy.info.japanembassyinterviewquestion;

import android.speech.tts.TextToSpeech;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Locale;

public class SelfIntroduction extends AppCompatActivity {


    private TextToSpeech mTTS;

    private TextView mSelfIntroText;
    private TextView mSelfIntroAnsText;

    private Button mselfInroSayBtn;
    private Button mPreEnSayBtn;



    private Button mselfInroSayAnsBtn;
    private Button mPreEnSayAnsBtn;



    private AdView mAdView;
    private InterstitialAd mInterstitialAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Self Introduction");
        setContentView(R.layout.activity_self_introduction);


        //banner ads Start
        MobileAds.initialize(this,
                "ca-app-pub-1352722733825128~1995353232");
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-1352722733825128/5076812145");

        // TODO: Add adView to your view hierarchy.
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        //banner ads End


        //instrastial ad start
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1352722733825128/5338388799");


        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
        //instrastial ad end



        mSelfIntroText=findViewById(R.id.selfIntroText);
        mSelfIntroAnsText=findViewById(R.id.SelfIntroAnsText);



        mselfInroSayBtn=findViewById(R.id.selfIntroBtn);
        mPreEnSayBtn=findViewById(R.id.selfIntroEnBtn);


        mselfInroSayAnsBtn=findViewById(R.id.selfIntroAnsSayBtn);
        mPreEnSayAnsBtn=findViewById(R.id.selfIntroAnsEnBtn);




        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.JAPAN);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });







        mselfInroSayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSelfIntroText.setText("じこしょかいをおしえてください？");
                speak();
            }
        });


        mPreEnSayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mSelfIntroText.setText("self introduction please?");
            }
        });






        mselfInroSayAnsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSelfIntroAnsText.setText("はじめまして….私 は リドともうします。バングラデッシュ じん です.\n" +
                        "Dhakaから来ました.   2２歳です。私 学生です。父 の 名前はビショナトです。母の名前 ぷスパです。しゅみはサッカーをみることです. 6ヶ月で日本語を勉強しました。私は日本の大学で勉強したいから、日本へいきたいです. どうぞよろしくおねがいします。");
                speak1();
            }
        });


        mPreEnSayAnsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mSelfIntroAnsText.setText(" Nice to meet you .... I am Lido. I'm Bangladeshi.I am from Dhaka. 22 years old. I am a student.My father's name is Bishato. My mother's name is puspa. I Like to look at football. I studied Japanese in 6 months. I would like to go to Japan because I would like to study at a university in Japan.");
            }
        });



    }


    private void speak() {
        String text = mSelfIntroText.getText().toString();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }

    private void speak1() {
        String text1 = mSelfIntroAnsText.getText().toString();
        mTTS.speak(text1, TextToSpeech.QUEUE_FLUSH, null);

    }


    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }

        super.onDestroy();
    }
}
