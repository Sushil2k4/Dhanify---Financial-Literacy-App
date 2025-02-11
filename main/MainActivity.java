package com.example.dhanify;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Take Quiz button
        ImageButton quizButton = findViewById(R.id.quiz_button);
        if (quizButton != null) {
            quizButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            });
        } else {
            Log.e(TAG, "Quiz button not found");
        }

        // Initialize Go to Forum button (if implemented)
        ImageButton forumButton = findViewById(R.id.forum_button);
        if (forumButton != null) {
            forumButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, ForumActivity.class);
                startActivity(intent);
            });
        } else {
            Log.e(TAG, "Forum button not found");
        }

        // Initialize Run a Simulation button (if implemented)
        ImageButton simulationButton = findViewById(R.id.simulation_button);
        if (simulationButton != null) {
            simulationButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, SimulationActivity.class);
                startActivity(intent);
            });
        } else {
            Log.e(TAG, "Simulation button not found");
        }

        // Initialize My Goals button
        ImageButton goalsButton = findViewById(R.id.goals_button);
        if (goalsButton != null) {
            goalsButton.setOnClickListener(v -> {
                try {
                    Intent intent = new Intent(MainActivity.this, GoalsActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    Log.e(TAG, "Failed to start GoalsActivity", e);
                }
            });
        } else {
            Log.e(TAG, "Goals button not found");
        }

        // Initialize My Courses button
        ImageButton coursesButton = findViewById(R.id.courses_button);
        if (coursesButton != null) {
            coursesButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, CoursesActivity.class);
                startActivity(intent);
            });
        } else {
            Log.e(TAG, "Courses button not found");
        }
    }
}