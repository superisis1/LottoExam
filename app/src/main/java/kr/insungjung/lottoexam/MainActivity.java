package kr.insungjung.lottoexam;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import kr.insungjung.lottoexam.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    ActivityMainBinding act;

    int[] winArray = new int[6];
    int[] challengeArray = new int[6];

    int spendCost = 0;
    int prizes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        generateWinNumber();

        act.winNumTxt.setText(String.format("%d %d %d %d %d %d",
                winArray[0], winArray[1], winArray[2], winArray[3], winArray[4], winArray[5]));

        act.buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateChallengeNumber();
                spendCost += 1000;
                prizes += 1000;

                act.challengeNumTxt.setText(String.format("%d %d %d %d %d %d",
                        challengeArray[0], challengeArray[1], challengeArray[2], challengeArray[3], challengeArray[4], challengeArray[5]));

                act.spendCostTxt.setText(String.format("사용 금액 : %d", spendCost));
                act.prizesTxt.setText(String.format("누적 당첨금액 : %d", prizes));
            }
        });

    }

    void generateWinNumber() {

        for (int i = 0; i < 6; i++) {
            int winNum = (int) (Math.random() * 89 + 10);
            winArray[i] = winNum;
        }
    }

    void generateChallengeNumber() {

        for (int i = 0; i < 6; i++) {
            int challengeNum = (int) (Math.random() * 89 + 10);
            challengeArray[i] = challengeNum;
        }
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        act = DataBindingUtil.setContentView(this, R.layout.activity_main);

    }
}
