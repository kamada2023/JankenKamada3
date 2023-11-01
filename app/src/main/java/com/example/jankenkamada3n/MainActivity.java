package com.example.jankenkamada3n;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.jankenkamada3n.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CountApp countApp = (CountApp) this.getApplication();
        int count = countApp.getAddCount();

        int gu = 0,tyo = 1,pa = 2;

        if(count > 0){
            binding.battleShout.setText("第"+ (count+1) +"戦目：じゃーんけーん......");
        }

        Intent intent = new Intent(getApplication(), ResultActivity.class);
        binding.Gu.setOnClickListener(v -> {
            intent.putExtra("hand", gu);
            startActivity(intent);
        });
        binding.Tyo.setOnClickListener(v -> {
            intent.putExtra("hand", tyo);
            startActivity(intent);
        });
        binding.Pa.setOnClickListener(v -> {
            intent.putExtra("hand", pa);
            startActivity(intent);
        });

    }
}