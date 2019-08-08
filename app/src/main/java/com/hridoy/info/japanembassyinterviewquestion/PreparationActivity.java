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

public class PreparationActivity extends AppCompatActivity {

    private TextToSpeech mTTS;

    private TextView mPreTextContent;

    private Button mPreSayBtn;
    private Button mPreBanSayBtn;

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Entry Preparation");
        setContentView(R.layout.activity_preparation);


        //banner ads Start
        MobileAds.initialize(this,
                getString(R.string.App_id));
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("R.string.App_id");

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



        mPreTextContent=findViewById(R.id.precontent);

        mPreSayBtn=findViewById(R.id.presayit);
        mPreBanSayBtn=findViewById(R.id.prebansayit);



        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });


        mPreBanSayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPreTextContent.setText("রুম - এ ঢুকার পূর্বে দরজা দুইবার নক করে, দরজা টান দিবেন ।দরজাটা একটু খানি ফাঁক হলে, সাথে সাথে (はいってもいですか) কথা বলে ভিতরে ঢুকবেন। দরজাটা আস্তে করে বন্ধ করবেন ,ভিতরে প্রবেশ করে (しつれいします) বলে (こんにちは) বলে সাক্ষাৎকার এর জন্য প্রস্তুত হবেন। কোন প্রশ্ন না বুঝলে (すみませんもういちどおねがいします) বলবেন । আর প্রশ্ন না পারলে (せんせいこのしつもんがわかりません) বলবেন। কানজি পড়ার সময় ,কোন কানজি না পারলে কানজি টি আঙ্গুল দিয়ে দেখিয়ে (あのせんせいこのかんじがすこしわかりません)বলবেন।  জাপানি (ありがとうございました) বলে সাক্ষাৎকার শেষ করবেন।  সাক্ষাৎকার শেষ হওয়ার সাথে সাথেই (どうもありがとうございました) বলে রুম থেকে বের হবেন ।");
            }
        });

        mPreSayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPreTextContent.setText("Before entering the room, the door will knock twice, pull the door. If the room is a little empty, then immediately (haittemoidesuka) will talk to go inside. Close the door slowly, and go inside to say (shitsureishimasu) and another word to say (kon'nichiha) to be prepared for the interview. If you do not understand the question (sumimasenmouichidoonegaishimasu) And if you dont know any questions (say to- senseikonoshitsumongawakarimasen). At the time of you dont understand any Kanji to reading, if you cant, you can tell the Kanji with your fingers (anosenseikonokanjigasukoshiwakarimasen). End the interview with say (arigatougozaimashita). As soon as the interview ends (doumoarigatougozaimashita) will be out of the room.\n Please Keeping your Politeness.Best Of Luck");


            }
        });
    }

    private void speak() {
        String text = mPreTextContent.getText().toString();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
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
