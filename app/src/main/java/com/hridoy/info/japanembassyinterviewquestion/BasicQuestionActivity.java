package com.hridoy.info.japanembassyinterviewquestion;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Locale;

public class BasicQuestionActivity extends AppCompatActivity {


    private AdView mAdView;
    private AdView mAdView1;
    private InterstitialAd mInterstitialAd;

    private TextToSpeech mTTS;

    private Button mBasicTwoBtn;


    //1st question
    private TextView mQ1Text;
    private TextView mAns1Text;

    private Button mQ1SayBtn;
    private Button mAns1SayBtn;

    private Button mQ1EnBtn;
    private Button mAns1EnBtn;


    //2nd Question

    private TextView mQ2Text;
    private TextView mAns2Text;

    private Button mQ2SayBtn;
    private Button mAns2SayBtn;

    private Button mQ2EnBtn;
    private Button mAns2EnBtn;


    //3rd Question

    private TextView mQ3Text;
    private TextView mAns3Text;

    private Button mQ3SayBtn;
    private Button mAns3SayBtn;

    private Button mQ3EnBtn;
    private Button mAns3EnBtn;


    //4th Question

    private TextView mQ4Text;
    private TextView mAns4Text;

    private Button mQ4SayBtn;
    private Button mAns4SayBtn;

    private Button mQ4EnBtn;
    private Button mAns4EnBtn;


    //5th Question

    private TextView mQ5Text;
    private TextView mAns5Text;

    private Button mQ5SayBtn;
    private Button mAns5SayBtn;

    private Button mQ5EnBtn;
    private Button mAns5EnBtn;




    //6th Question

    private TextView mQ6Text;
    private TextView mAns6Text;

    private Button mQ6SayBtn;
    private Button mAns6SayBtn;

    private Button mQ6EnBtn;
    private Button mAns6EnBtn;



    //7th Question

    private TextView mQ7Text;
    private TextView mAns7Text;

    private Button mQ7SayBtn;
    private Button mAns7SayBtn;

    private Button mQ7EnBtn;
    private Button mAns7EnBtn;


    //8th Question

    private TextView mQ8Text;
    private TextView mAns8Text;

    private Button mQ8SayBtn;
    private Button mAns8SayBtn;

    private Button mQ8EnBtn;
    private Button mAns8EnBtn;


    //9th Question

    private TextView mQ9Text;
    private TextView mAns9Text;

    private Button mQ9SayBtn;
    private Button mAns9SayBtn;

    private Button mQ9EnBtn;
    private Button mAns9EnBtn;


    //10th Question

    private TextView mQ10Text;
    private TextView mAns10Text;

    private Button mQ10SayBtn;
    private Button mAns10SayBtn;

    private Button mQ10EnBtn;
    private Button mAns10EnBtn;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Basic Question");
        setContentView(R.layout.activity_basic_question);



        //banner1 ads Start
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


        //banner1 ads End


        //banner2 ads Start
        MobileAds.initialize(this,
                "ca-app-pub-1352722733825128~1995353232");
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView adView1 = new AdView(this);
        adView1.setAdSize(AdSize.BANNER);
        adView1.setAdUnitId("ca-app-pub-1352722733825128/5076812145");

        // TODO: Add adView to your view hierarchy.
        mAdView1 = findViewById(R.id.adView1);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView1.loadAd(adRequest1);


        //banner2 ads End

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

        //instrastial ad start
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1352722733825128/5338388799");



        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {

                startActivity(new Intent(BasicQuestionActivity.this,BasicQuestionActivityTwo.class));
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());

            }

        });

        mBasicTwoBtn= findViewById(R.id.NextButton);

        mBasicTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    startActivity(new Intent(BasicQuestionActivity.this,BasicQuestionActivityTwo.class));
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                }
            }
        });

        //1st question
        mQ1Text=findViewById(R.id.q1Text);
        mAns1Text=findViewById(R.id.ans1Text);

        mQ1SayBtn=findViewById(R.id.q1SayBtn);
        mAns1SayBtn=findViewById(R.id.ans1SayBtn);

        mQ1EnBtn=findViewById(R.id.q1SayEnBtn);
        mAns1EnBtn=findViewById(R.id.ans1EnBtn);


        //2nd question
        mQ2Text=findViewById(R.id.q2Text);
        mAns2Text=findViewById(R.id.ans2Text);

        mQ2SayBtn=findViewById(R.id.q2SayBtn);
        mAns2SayBtn=findViewById(R.id.ans2SayBtn);

        mQ2EnBtn=findViewById(R.id.q2SayEnBtn);
        mAns2EnBtn=findViewById(R.id.ans2EnBtn);





        //3rd question
        mQ3Text=findViewById(R.id.q3Text);
        mAns3Text=findViewById(R.id.ans3Text);

        mQ3SayBtn=findViewById(R.id.q3SayBtn);
        mAns3SayBtn=findViewById(R.id.ans3SayBtn);

        mQ3EnBtn=findViewById(R.id.q3SayEnBtn);
        mAns3EnBtn=findViewById(R.id.ans3EnBtn);



        //4th question
        mQ4Text=findViewById(R.id.q4Text);
        mAns4Text=findViewById(R.id.ans4Text);

        mQ4SayBtn=findViewById(R.id.q4SayBtn);
        mAns4SayBtn=findViewById(R.id.ans4SayBtn);

        mQ4EnBtn=findViewById(R.id.q4SayEnBtn);
        mAns4EnBtn=findViewById(R.id.ans4EnBtn);



        //5th question
        mQ5Text=findViewById(R.id.q5Text);
        mAns5Text=findViewById(R.id.ans5Text);

        mQ5SayBtn=findViewById(R.id.q5SayBtn);
        mAns5SayBtn=findViewById(R.id.ans5SayBtn);

        mQ5EnBtn=findViewById(R.id.q5SayEnBtn);
        mAns5EnBtn=findViewById(R.id.ans5EnBtn);


        //6th question
        mQ6Text=findViewById(R.id.q6Text);
        mAns6Text=findViewById(R.id.ans6Text);

        mQ6SayBtn=findViewById(R.id.q6SayBtn);
        mAns6SayBtn=findViewById(R.id.ans6SayBtn);

        mQ6EnBtn=findViewById(R.id.q6SayEnBtn);
        mAns6EnBtn=findViewById(R.id.ans6EnBtn);



        //7th question
        mQ7Text=findViewById(R.id.q7Text);
        mAns7Text=findViewById(R.id.ans7Text);

        mQ7SayBtn=findViewById(R.id.q7SayBtn);
        mAns7SayBtn=findViewById(R.id.ans7SayBtn);

        mQ7EnBtn=findViewById(R.id.q7SayEnBtn);
        mAns7EnBtn=findViewById(R.id.ans7EnBtn);



        //8th question
        mQ8Text=findViewById(R.id.q8Text);
        mAns8Text=findViewById(R.id.ans8Text);

        mQ8SayBtn=findViewById(R.id.q8SayBtn);
        mAns8SayBtn=findViewById(R.id.ans8SayBtn);

        mQ8EnBtn=findViewById(R.id.q8SayEnBtn);
        mAns8EnBtn=findViewById(R.id.ans8EnBtn);



        //9th question
        mQ9Text=findViewById(R.id.q9Text);
        mAns9Text=findViewById(R.id.ans9Text);

        mQ9SayBtn=findViewById(R.id.q9SayBtn);
        mAns9SayBtn=findViewById(R.id.ans9SayBtn);

        mQ9EnBtn=findViewById(R.id.q9SayEnBtn);
        mAns9EnBtn=findViewById(R.id.ans9EnBtn);



        //10th question
        mQ10Text=findViewById(R.id.q10Text);
        mAns10Text=findViewById(R.id.ans10Text);

        mQ10SayBtn=findViewById(R.id.q10SayBtn);
        mAns10SayBtn=findViewById(R.id.ans10SayBtn);

        mQ10EnBtn=findViewById(R.id.q10SayEnBtn);
        mAns10EnBtn=findViewById(R.id.ans10EnBtn);


        //Start 1st Question

        mQ1SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQ1Text.setText("あなたの名前は何ですか...？");
                String text = mQ1Text.getText().toString();
                mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        mAns1SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAns1Text.setText("私の名前はリドです.");
                String text1 = mAns1Text.getText().toString();
                mTTS.speak(text1, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        mQ1EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mQ1Text.setText(" What is your name...?");
            }
        });


        mAns1EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAns1Text.setText(" My Name is Hridoy");
            }
        });

        //End 1st Question





        //Start 2nd Question

        mQ2SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQ2Text.setText("あなたは何歳ですか.？");
                String text = mQ2Text.getText().toString();
                mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        mAns2SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAns2Text.setText(" 22歳です.");
                String text1 = mAns2Text.getText().toString();
                mTTS.speak(text1, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        mQ2EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mQ2Text.setText(" How old are you...?");
            }
        });


        mAns2EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAns2Text.setText(" I'm 22 years old");
            }
        });

        //End 2nd Question



        //Start 3rd Question

        mQ3SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQ3Text.setText("たんじょびはいつですか? / せいねんがっぴはいつですか？");
                String text = mQ3Text.getText().toString();
                mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        mAns3SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAns3Text.setText(" 1990/1/1です。（せんきゅうひゃくきゅうじゅうねんいちがつついたちです。）");
                String text1 = mAns3Text.getText().toString();
                mTTS.speak(text1, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        mQ3EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mQ3Text.setText(" BirthDate?");
            }
        });


        mAns3EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAns3Text.setText(" 1990/1/1");
            }
        });

        //End 3rd Question






        //Start 4th Question

        mQ4SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQ4Text.setText("あなたは学生ですか。？");
                String text = mQ4Text.getText().toString();
                mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        mAns4SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAns4Text.setText(" はい. 学生です.");
                String text1 = mAns4Text.getText().toString();
                mTTS.speak(text1, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        mQ4EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mQ4Text.setText(" Are you a student ?");
            }
        });


        mAns4EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAns4Text.setText(" Yes,I am.");
            }
        });

        //End 4th Question






        //Start 5th Question

        mQ5SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQ5Text.setText(" どこからきましたか。");
                String text = mQ5Text.getText().toString();
                mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        mAns5SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAns5Text.setText(" ダッカ　から来ました。");
                String text1 = mAns5Text.getText().toString();
                mTTS.speak(text1, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        mQ5EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mQ5Text.setText(" Where you come from ?");
            }
        });


        mAns5EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAns5Text.setText(" I'm come from Dhaka.");
            }
        });

        //End 5th Question






        //Start 6th Question

        mQ6SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQ6Text.setText(" あなたのげんじゅしょはどこですか/おしいてください。");
                String text = mQ6Text.getText().toString();
                mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        mAns6SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAns6Text.setText(" Dhanmondi,Dhaka 県です。");
                String text1 = mAns6Text.getText().toString();
                mTTS.speak(text1, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        mQ6EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mQ6Text.setText(" Where your city ?/Please teach me");
            }
        });


        mAns6EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAns6Text.setText(" Dhanmondi,Dhaka city.");
            }
        });

        //End 6th Question




        //Start 7th Question

        mQ7SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQ7Text.setText(" あなたがうまれた/むらのなまえはなんですか。");
                String text = mQ7Text.getText().toString();
                mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        mAns7SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAns7Text.setText(" Dhanmondi,Dhaka 県です。");
                String text1 = mAns7Text.getText().toString();
                mTTS.speak(text1, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        mQ7EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mQ7Text.setText(" What is the name of the village you were born in?");
            }
        });


        mAns7EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAns7Text.setText(" Dhanmondi,Dhaka city.");
            }
        });

        //End 7th Question




        //Start 8th Question

        mQ8SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQ8Text.setText(" ほんせきはどこですか。");
                String text = mQ8Text.getText().toString();
                mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        mAns8SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAns8Text.setText(" Dhanmondi です。");
                String text1 = mAns8Text.getText().toString();
                mTTS.speak(text1, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        mQ8EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mQ8Text.setText(" Where is the Japanese language school ?");
            }
        });


        mAns8EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAns8Text.setText(" In Dhanmondi.");
            }
        });

        //End 8th Question



        //Start 9th Question

        mQ9SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQ9Text.setText(" あなたは結婚していますか");
                String text = mQ9Text.getText().toString();
                mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        mAns9SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAns9Text.setText(" - いいえ、どくしん　です。");
                String text1 = mAns9Text.getText().toString();
                mTTS.speak(text1, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        mQ9EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mQ9Text.setText(" Are you married ?");
            }
        });


        mAns9EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAns9Text.setText(" No,I'm Single.");
            }
        });

        //End 9th Question





        //Start 10th Question

        mQ10SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQ10Text.setText(" まいあさなんじにおきますか ");
                String text = mQ10Text.getText().toString();
                mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        mAns10SayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAns10Text.setText(" 5じにおきます。");
                String text1 = mAns10Text.getText().toString();
                mTTS.speak(text1, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        mQ10EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mQ10Text.setText(" Everymorning when you getup ?");
            }
        });


        mAns10EnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAns10Text.setText(" 5:00 clock.");
            }
        });

        //End 10th Question



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
