package com.example.jankenkamada3n;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jankenkamada3n.databinding.ActivitySelectBinding;

public class SelectActivity extends AppCompatActivity {

    private ActivitySelectBinding binding;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CountApp countApp = (CountApp) this.getApplication();
        Intent intent = new Intent(getApplication(),MainActivity.class);

        countApp.setBattleFormat(0);
        binding.gameMode.setText("総当たり戦");
        binding.roundCount.setText("回数："+countApp.getCount());

        binding.modeChange.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (i == 1){
                    countApp.setBattleFormat(i);
                    binding.gameMode.setText("星取り　戦");
                    binding.rule.setText(
                            "1.対戦形式は任意で1～10まで対戦できます\n" +
                            "2.設定した回戦数の半分以上を満たした場合終了します\n" +
                            "3.設定した回数を達した場合終了します\n"+
                            "4.設定した回数が半分以上があいこだった場合は引き分けとします");

                }else {
                    countApp.setBattleFormat(i);
                    binding.gameMode.setText("総当たり戦");
                    binding.rule.setText(
                            "1.対戦形式は任意で1～10まで対戦できます\n" +
                            "2.対戦は勝敗に問わずカウントします\n" +
                            "3.設定した値まで終了しません\n" +
                            "4.結果は総合的に判断します");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.gameCount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                countApp.setCount(i+1);
                binding.roundCount.setText("回数："+(i+1));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.gameStart.setOnClickListener(v -> {
            startActivity(intent);
        });
    }
}
