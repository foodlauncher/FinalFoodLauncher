package com.launcher.foodlauncher.ui.find_food;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.launcher.foodlauncher.R;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>{

    private List<Recipe> recipes;
    private Context context;
    private int rowLayout;
    GradientDrawable shape = new GradientDrawable();

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textOne;
        TextView textTwo;
        TextView textThree;

        public ViewHolder(View v) {
            super(v);
            textOne = (TextView) v.findViewById(R.id.textView1);
            textTwo = (TextView) v.findViewById(R.id.textView2);
            textThree = (TextView) v.findViewById(R.id.textView3);
        }
    }

    public FoodAdapter(List<Recipe> recipes, int rowLayout, Context context) {
        this.recipes = recipes;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(FoodAdapter.ViewHolder holder, int position) {
        String readyMinutes = Long.toString(recipes.get(position).getReadyInMinutes());
        holder.textOne.setText(recipes.get(position).getTitle());
        holder.textTwo.setText(recipes.get(position).getDiets().toString());
        holder.textThree.setText(recipes.get(position).getCuisines().toString());
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
}