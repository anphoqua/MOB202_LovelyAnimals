package com.codelabss.anphoqua.lovelyanimals;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AnimalAdapter extends BaseAdapter {
    Context context;
    ArrayList<Animal> animalArrayList = new ArrayList<Animal>();

    public AnimalAdapter(Context context, ArrayList<Animal> animalArrayList) {
        this.context = context;
        this.animalArrayList = animalArrayList;
    }

    @Override
    public int getCount() {
        return animalArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = ((Activity)context).getLayoutInflater().inflate(R.layout.animal_item,null);
        ImageView item_animal_avt = view.findViewById(R.id.imageViewItemAnimalAvtID);
        TextView item_animal_name = view.findViewById(R.id.textViewItemAnimalNameID);

        Animal animal = animalArrayList.get(i);
        item_animal_avt.setImageResource(animal.avatar);
        item_animal_name.setText(animal.name);

        return view;

    }
}
