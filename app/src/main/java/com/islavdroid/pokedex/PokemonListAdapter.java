package com.islavdroid.pokedex;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.islavdroid.pokedex.model.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by islav on 19.11.2016.
 */

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.ViewHolder> {

    private ArrayList<Pokemon>dataset;

    public PokemonListAdapter() {
       dataset=new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pokemon p =dataset.get(position);
        holder.nameTextView.setText(p.getName());
        Picasso.with(holder.nameTextView.getContext()).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+p.getNumber()+".png").into(holder.photoImage);


    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addPokemonToList(ArrayList<Pokemon> pokemonArrayList) {
        dataset.addAll(pokemonArrayList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView photoImage;
        private TextView nameTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            photoImage =(ImageView)itemView.findViewById(R.id.photoImageView);
            nameTextView =(TextView)itemView.findViewById(R.id.nameTextView);
        }
    }
}
