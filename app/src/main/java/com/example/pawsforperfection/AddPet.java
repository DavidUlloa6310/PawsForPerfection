package com.example.pawsforperfection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddPet extends AppCompatActivity {

    PetReaderDbHelper dbHelper;
    SQLiteDatabase db;

    String[] projection = {
            BaseColumns._ID,
            PetReaderContract.PetEntry.COLUMN_NAME_PET_NAME,
            PetReaderContract.PetEntry.COLUMN_NAME_BREED,
            PetReaderContract.PetEntry.COLUMN_NAME_INSTRUCTIONS,
            PetReaderContract.PetEntry.COLUMN_NAME_WEIGHT
    };

    String selection = PetReaderContract.PetEntry.COLUMN_NAME_PET_NAME + " = ?";
    String[] selectionArgs = { "" };
    String sortOrder = PetReaderContract.PetEntry.COLUMN_NAME_BREED + " DESC";

    TextView nameView, weightView, breedView, instructionsView;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);

        nameView = findViewById(R.id.nameTextView);
        weightView = findViewById(R.id.weightTextView);
        breedView = findViewById(R.id.breedTextView);
        instructionsView = findViewById(R.id.specialInstructions);
        submit = findViewById(R.id.submitButton);

        dbHelper = new PetReaderDbHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put(PetReaderContract.PetEntry.COLUMN_NAME_PET_NAME, nameView.getText().toString());
                values.put(PetReaderContract.PetEntry.COLUMN_NAME_WEIGHT, weightView.getText().toString());
                values.put(PetReaderContract.PetEntry.COLUMN_NAME_BREED, breedView.getText().toString());
                values.put(PetReaderContract.PetEntry.COLUMN_NAME_INSTRUCTIONS, instructionsView.getText().toString());
                db.insert(PetReaderContract.PetEntry.TABLE_NAME, null, values);
                nameView.setText("");
                weightView.setText("");
                breedView.setText("");
                instructionsView.setText("");
                Toast.makeText(getApplicationContext(), "Your pet has been submitted!", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void goToMain(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}