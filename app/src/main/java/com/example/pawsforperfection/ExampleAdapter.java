package com.example.pawsforperfection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private ArrayList<Pet> petsArrayList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView petShow, breedShow, weightShow, instructionShow;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            petShow = itemView.findViewById(R.id.petNameShow);
            breedShow = itemView.findViewById(R.id.breedShow);
            weightShow = itemView.findViewById(R.id.weightShow);
            instructionShow = itemView.findViewById(R.id.instructionsShow);
        }
    }

    public ExampleAdapter(ArrayList<Pet> petsArrayList) {
        this.petsArrayList = petsArrayList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Pet currentPet = petsArrayList.get(position);
        holder.petShow.setText(currentPet.getName());
        holder.breedShow.setText(currentPet.getBreed());
        holder.weightShow.setText("" + currentPet.getWeight());
        holder.instructionShow.setText(currentPet.getSpecialInstructions());
    }

    @Override
    public int getItemCount() {
        return petsArrayList.size();
    }
}
