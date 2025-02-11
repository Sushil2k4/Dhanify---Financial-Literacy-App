package com.example.dhanify;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        ListView coursesList = findViewById(R.id.courses_list);
        Button backButton = findViewById(R.id.back_button);

        // Sample data for courses
        String[] courses = {
                "Personal Finance 101",
                "Investing Basics",
                "Retirement Planning",
                "Budgeting and Saving",
                "Tax Strategies",
                "Insurance Fundamentals"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courses);
        coursesList.setAdapter(adapter);

        backButton.setOnClickListener(v -> finish());
    }
}
