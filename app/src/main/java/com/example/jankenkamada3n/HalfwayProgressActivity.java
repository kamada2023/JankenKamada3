package com.example.jankenkamada3n;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jankenkamada3n.databinding.ActivityHalfwayBinding;

public class HalfwayProgressActivity extends AppCompatActivity {

    private ActivityHalfwayBinding binding;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHalfwayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CountApp countApp = (CountApp) this.getApplication();
        int countWin = countApp.getWinCount();
        int countLose = countApp.getLoseCount();
        int countDraw = countApp.getDrawCount();

        binding.battleCount.setText(countApp.getAddCount() + "戦目だよ");
        binding.countWin.setText("勝った数："+countWin);
        binding.countLose.setText("負けた数："+countLose);
        binding.countDraw.setText("引き分け数："+countDraw);

        Intent intent = new Intent(getApplication(),MainActivity.class);
        binding.nextBattle.setOnClickListener(v -> {
            startActivity(intent);
        });
    }

}
