package com.javiernunez.puppies.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.javiernunez.puppies.R;
import com.javiernunez.puppies.pojo.MascotaInst;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Javier Núñez on 26/06/2016.
 */
public class MascotaInstagramAdaptador extends RecyclerView.Adapter<MascotaInstagramAdaptador.MascotaInstagramViewHolder>{
    ArrayList<MascotaInst> mascotasInst;
    Activity actividad;

    public MascotaInstagramAdaptador(ArrayList<MascotaInst> mascotasInst, Activity actividad){
        //contructor para pasarle la lista de mascotas
        this.mascotasInst=mascotasInst;
        this.actividad=actividad;
    }


    @Override
    public MascotaInstagramViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Infla nuestro layout cardview y lo pasa al ViewHolder para que obtenga cada elemento (los views)
        View v;
        /*if(actividad != null){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_fav,parent,false);
        }else{*/
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascota,parent,false);
        //}

        return new MascotaInstagramViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaInstagramViewHolder mascotaInstagramViewHolder, int position) {
        //Asocia cada elemento de la lista con cada view
        final MascotaInst mascotaInst = mascotasInst.get(position);

        //mascotaInstagramViewHolder.imgFotoInst.setImageResource(mascota.getUrlImagen());
        Picasso.with(actividad)
                .load(mascotaInst.getUrlImagen())
                .placeholder(R.drawable.dog)
                .into(mascotaInstagramViewHolder.imgFotoInst);
        mascotaInstagramViewHolder.tvLikesInst.setText(String.valueOf(mascotaInst.getLikes()));






    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascotasInst.size();
    }

    public static class MascotaInstagramViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoInst;
        private TextView tvLikesInst;



        public MascotaInstagramViewHolder(View itemView) {
            super(itemView);
            imgFotoInst     =(ImageView) itemView.findViewById(R.id.imgFotoInst);
            tvLikesInst     =(TextView) itemView.findViewById(R.id.tvLikesInst);

        }
    }
}
