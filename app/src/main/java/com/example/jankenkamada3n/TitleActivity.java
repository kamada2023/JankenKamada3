package com.example.jankenkamada3n;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jankenkamada3n.databinding.ActivityTitleBinding;

public class TitleActivity extends AppCompatActivity {
    private CountApp countApp;
    private ActivityTitleBinding binding;
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        binding = ActivityTitleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        countApp = (CountApp)this.getApplication();

        String totalResult = getString(R.string.total_result,countApp.getNumOfWins(),
                countApp.getNumOfLoses(),countApp.getNumOfDraws());
        binding.gameCount.setText(totalResult);

        binding.reset.setOnClickListener(view -> {
            countApp.clearSetCount();
            String resetResult = getString(R.string.total_result,countApp.getNumOfWins(),
                    countApp.getNumOfLoses(),countApp.getNumOfDraws());
            binding.gameCount.setText(resetResult);
        });

        binding.nextSean.setOnClickListener(view -> {
            Intent intent = new Intent(getApplication(), SelectActivity.class);
            startActivity(intent);
        });
    }
}
