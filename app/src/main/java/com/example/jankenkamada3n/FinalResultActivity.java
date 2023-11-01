package com.example.jankenkamada3n;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jankenkamada3n.databinding.ActivityFinalresultBinding;

public class FinalResultActivity extends AppCompatActivity {

    private ActivityFinalresultBinding binding;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFinalresultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CountApp countApp = (CountApp) this.getApplication();
        int countWin_fin = countApp.getWinCount();
        int countLose_fin = countApp.getLoseCount();
        int countDraw_fin = countApp.getDrawCount();

        Intent intent = new Intent(getApplication(),TitleActivity.class);

        if (countWin_fin > countLose_fin){
            binding.resultDrawFinal.setImageResource(R.drawable.youwin);
            countApp.setNumOfWins(1);
        } else if (countLose_fin > countWin_fin){
            binding.resultDrawFinal.setImageResource(R.drawable.youlose);
            countApp.setNumOfLoses(1);
        } else {
            binding.resultDrawFinal.setImageResource(R.drawable.drawgame);
            countApp.setNumOfDraws(1);
        }
        if(countApp.getBattleFormat() == 1){
            if (countDraw_fin > (countApp.getCount() / 2)){
                binding.resultDrawFinal.setImageResource(R.drawable.drawgame);
                countApp.setNumOfDraws(1);
            }
        }

        binding.finCountWin.setText("勝った数："+countWin_fin);
        binding.finCountLose.setText("負けた数："+countLose_fin);
        binding.finCountDraw.setText("引き分け数："+countDraw_fin);

        binding.backTitle.setOnClickListener(view -> {
            countApp.clearCount();
            startActivity(intent);
        });
    }
}
