package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Optional;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLaunchProfileClicked(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void onShowCounterClicked(View view) {
//        Utilities.showAlert(this, "Button doesn't do anything yet");
        Intent intent = new Intent(this, CounterActivity.class);

        TextView maxCountView = findViewById(R.id.max_count_view);
        String maxCountstr = maxCountView.getText().toString();
        Optional<Integer> maybeMaxCount = Utilities.parseCount(maxCountstr);
        if (!maybeMaxCount.isPresent()) {
            Utilities.showAlert(this, "not a number");
            return;
        }

        int maxCount = maybeMaxCount.get();
        if (maxCount <= 0) {
            Utilities.showAlert(this, "please enter a pos number");
            return;
        }
//        Utilities.showAlert(this, "I got the number " + maxCount);
        intent.putExtra("max_count", maxCount);
        startActivity(intent);
    }

}