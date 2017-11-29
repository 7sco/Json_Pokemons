package com.example.franciscoandrade.pokemon;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.franciscoandrade.pokemon.models.Pokemon;

import java.util.ArrayList;

/**
 * Created by franciscoandrade on 11/29/17.
 */

public class ListPokemonAdapter extends RecyclerView.Adapter<ListPokemonAdapter.ViewHolder>{

    private ArrayList<Pokemon> dataset;
    private Context context;


    public ListPokemonAdapter(Context context) {
        dataset = new ArrayList<>();
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Pokemon p= dataset.get(position);
        holder.nameTextView.setText(p.getName());
        String url= "https://pokeapi.co/media/sprites/pokemon/";

        Glide.with(context)
                .load(url+ p.getNumber() +".png").into(holder.pictureImageView);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addListPokemon(ArrayList<Pokemon> pokemonList) {

        dataset.addAll(pokemonList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView pictureImageView;
        private TextView nameTextView;


        public ViewHolder(View itemView) {
            super(itemView);

            pictureImageView= itemView.findViewById(R.id.pictureImageView);
            nameTextView= itemView.findViewById(R.id.nameTextView);


        }
    }
}
