package com.example.dhanify;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewGoalsActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private LinearLayout goalsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_goals);

        goalsContainer = findViewById(R.id.goals_container);
        sharedPreferences = getSharedPreferences("goalsPrefs", MODE_PRIVATE);

        // Load and display all the saved goals
        String savedGoals = sharedPreferences.getString("goals", "");
        displayGoals(savedGoals);
    }

    private void displayGoals(String savedGoals) {
        // Split the saved goals by newline or other delimiter used
        String[] goalsArray = savedGoals.split("\n");

        for (String goal : goalsArray) {
            TextView goalTextView = new TextView(this);
            goalTextView.setText(goal);
            goalTextView.setTextColor(getResources().getColor(R.color.black)); // Set text color

            // Set margins for each TextView
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, 0, 0, 16); // Bottom margin of 16dp
            goalTextView.setLayoutParams(params);

            goalsContainer.addView(goalTextView);
        }
    }
}
