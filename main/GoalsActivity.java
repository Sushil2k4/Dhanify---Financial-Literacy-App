package com.example.dhanify;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class GoalsActivity extends AppCompatActivity {

    private EditText notesInput;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        notesInput = findViewById(R.id.notes_input);
        Button saveButton = findViewById(R.id.save_button);
        Button viewGoalsButton = findViewById(R.id.view_goals_button);
        Button backButton = findViewById(R.id.back_button);

        sharedPreferences = getSharedPreferences("goalsPrefs", MODE_PRIVATE);

        saveButton.setOnClickListener(v -> {
            String newGoal = notesInput.getText().toString();
            if (!newGoal.isEmpty()) {
                // Load the current goals from SharedPreferences
                String savedGoals = sharedPreferences.getString("goals", "");

                // Append the new goal to the existing goals
                savedGoals += newGoal + "\n";

                // Save the updated list of goals back to SharedPreferences
                sharedPreferences.edit().putString("goals", savedGoals).apply();

                // Clear the input field after saving
                notesInput.setText("");
            }
        });

        viewGoalsButton.setOnClickListener(v -> {
            // Start the ViewGoalsActivity to display the saved goals
            Intent intent = new Intent(GoalsActivity.this, ViewGoalsActivity.class);
            startActivity(intent);
        });

        backButton.setOnClickListener(v -> finish());
    }
}
