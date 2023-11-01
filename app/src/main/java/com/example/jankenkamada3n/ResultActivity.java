package com.example.jankenkamada3n;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import com.example.jankenkamada3n.databinding.ActivityResultBinding;

import java.util.Random;


public class ResultActivity extends AppCompatActivity {

    private CountApp countApp;
    private ActivityResultBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        long seed = System.currentTimeMillis();
        Random rnd = new Random(seed);
        int r = rnd.nextInt(3);

        Intent intent = getIntent();
        int id = intent.getIntExtra("hand",0);

        countApp = (CountApp)this.getApplication();
        countApp.setAddCount(1);

        if (id == r) {
            if (countApp.getAddCount() <= countApp.getCount()){
                countApp.setDrawCount(1);
            }
            binding.resultDraw.setImageResource(R.drawable.draw);
            binding.result.setText("引き分け");
        } else if ((id==2 && r==0) || (id+1)==r) {
            if (countApp.getAddCount() <= countApp.getCount()){
                countApp.setWinCount(1);
            }
            binding.resultDraw.setImageResource(R.drawable.win);
            binding.result.setText("あんたの勝ち！！");
        } else {
            if (countApp.getAddCount() <= countApp.getCount()){
                countApp.setLoseCount(1);
            }
            binding.resultDraw.setImageResource(R.drawable.lose);
            binding.result.setText("あなたの負け..");
        }

        if(r==0){
            binding.cpuHand.setImageResource(R.drawable.j_gu02);
        } else if (r==1) {
            binding.cpuHand.setImageResource(R.drawable.j_ch02);
        }else{
            binding.cpuHand.setImageResource(R.drawable.j_pa02);
        }

        if(id==0){
            binding.userHand.setImageResource(R.drawable.j_gu02);
        } else if (id==1) {
            binding.userHand.setImageResource(R.drawable.j_ch02);
        }else{
            binding.userHand.setImageResource(R.drawable.j_pa02);
        }

        if(countApp.getAddCount() == 1){
            binding.nextBattle.setText("次の対戦へ");
        }else {
            binding.nextBattle.setText("次のシーンへ");
        }

        binding.nextBattle.setOnClickListener(v -> {
            ContinueOrEnd();
        });
    }
    private void ContinueOrEnd(){
        Intent ConOrEnd;
        Intent first = new Intent(getApplication(),MainActivity.class);
        Intent con = new Intent(getApplication(),HalfwayProgressActivity.class);
        Intent end = new Intent(getApplication(),FinalResultActivity.class);

        countApp = (CountApp)this.getApplication();
        int game = countApp.getCount();
        int rounds = countApp.getAddCount();
        int win = countApp.getWinCount();
        int lose = countApp.getLoseCount() ;

        if(rounds == 1) {ConOrEnd = first;}
        else {ConOrEnd = con;}

        if (countApp.getBattleFormat() == 1){
            if ((win - lose) > (game-rounds)){
                ConOrEnd = end;
            } else if ((lose - win) > (game-rounds)) {
                ConOrEnd = end;
            } else if (countApp.getDrawCount() > (game/2)) {
                ConOrEnd = end;
            }
        }

        if (game == rounds) {
            ConOrEnd = end;
        } else if (game < rounds){
            ConOrEnd = end;
        }


        startActivity(ConOrEnd);
    }
}
