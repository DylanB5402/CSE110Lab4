package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadContent();
    }

    @Override
    protected void onDestroy() {
        saveContent();
        super.onDestroy();
    }

    private void saveContent() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        EditText nameText = findViewById(R.id.name_textview);
        EditText statusText = findViewById(R.id.state_textview);
        editor.putString("Name", nameText.getText().toString());
        editor.putString("Status", statusText.getText().toString());
        editor.apply();
    }

    private void loadContent() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String name = preferences.getString("Name", "");
        String status = preferences.getString("Status", "");
        EditText nameText = findViewById(R.id.name_textview);
        EditText statusText = findViewById(R.id.state_textview);
        nameText.setText(name);
        statusText.setText(status);
    }

    public void onLaunchMainClicked(View view) {
       finish();
    }
}