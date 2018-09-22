package br.com.andersonassis.vetriobranco.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.andersonassis.vetriobranco.R;
import br.com.andersonassis.vetriobranco.modelos.ArtilheirosBojo;

/**
 * Created by AndersonLuis on 04/03/2018.
 */

public class ArtilheirosAdapter extends RecyclerView.Adapter<ArtilheirosAdapter.ViewHolder>  {

    private List<ArtilheirosBojo> listItem;
    private Context context;


    public ArtilheirosAdapter(List<ArtilheirosBojo> listItem, Context context) {
        this.listItem = listItem;
        this.context = context;
    }



    @Override
    public ArtilheirosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_artilheiros_novo,parent,false);
        return new ArtilheirosAdapter.ViewHolder(v);

    }
    @Override
    public void onBindViewHolder(ArtilheirosAdapter.ViewHolder holder, int position) {
        ArtilheirosBojo lista =  listItem.get(position);
        holder.nomeJogador.setText(lista.getNomeJogador());
        holder.GolsMarcados.setText(lista.getGolsMarcados());
        Glide.with(context).load(lista.getImagem()).into(holder.imagemTime); //pega a imagem de acordo com o link no banco usando a biblioteca Glide



    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }


    public class  ViewHolder extends RecyclerView.ViewHolder {
        TextView nomeJogador;
        TextView GolsMarcados;
        ImageView imagemTime;// aqui vai a imagem


        public ViewHolder(View itemView) {
            super(itemView);
            imagemTime   = (ImageView)itemView.findViewById(R.id.imageTimeNovo);
            nomeJogador  = (TextView) itemView.findViewById(R.id.nomejogadorNovo);
            GolsMarcados = (TextView) itemView.findViewById(R.id.golMarcadosNovo);// aqui vai a imagem

        }//fim ViewHolder
    }//fim ViewHolder extends




}
