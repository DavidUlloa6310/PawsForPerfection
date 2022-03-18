package com.example.pawsforperfection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewPets extends AppCompatActivity {

    PetReaderDbHelper dbHelper;

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

    private RecyclerView recyclerView;
    private ExampleAdapter exampleAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<Pet> pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pet);

        dbHelper = new PetReaderDbHelper(getApplicationContext());

        buildRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        buildRecyclerView();
    }

    protected ArrayList<Pet> getPets() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(PetReaderContract.PetEntry.TABLE_NAME, projection, null, null, null, null, null);
        ArrayList<Pet> pets = new ArrayList<>();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(PetReaderContract.PetEntry.COLUMN_NAME_PET_NAME));
            double weight = cursor.getDouble(cursor.getColumnIndexOrThrow(PetReaderContract.PetEntry.COLUMN_NAME_WEIGHT));
            String instructions = cursor.getString(cursor.getColumnIndexOrThrow(PetReaderContract.PetEntry.COLUMN_NAME_INSTRUCTIONS));
            String breed = cursor.getString(cursor.getColumnIndexOrThrow(PetReaderContract.PetEntry.COLUMN_NAME_BREED));
            System.out.println(name + " " + weight);
            pets.add(new Pet(name, weight, instructions, breed));
        }
        return pets;
    }

    public void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);

        ArrayList<Pet> pets = getPets();
        for (Pet pet : pets) {
            System.out.println(pet.getName());
        }
        System.out.println("DONE");

        exampleAdapter = new ExampleAdapter(pets);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(exampleAdapter);
    }
}