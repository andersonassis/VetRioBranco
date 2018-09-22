package br.com.andersonassis.vetriobranco.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;
import br.com.andersonassis.vetriobranco.R;
import br.com.andersonassis.vetriobranco.modelos.CartoesModel;

public class CartoesAdapter extends RecyclerView.Adapter<CartoesAdapter.ViewHolder>   {

    private List<CartoesModel> listItem;
    private Context context;

    public CartoesAdapter(List<CartoesModel> listItem, Context context) {
        this.listItem = listItem;
        this.context = context;
    }



    @NonNull
    @Override
    public CartoesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_cartoes_novo,parent,false);
        return new CartoesAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CartoesAdapter.ViewHolder holder, int position) {
        CartoesModel lista =  listItem.get(position);
        Glide.with(context).load(lista.getEquipe()).into(holder.imageTimecartao); //pega a imagem de acordo com o link no banco
        holder.nomejogadorcartao.setText(lista.getAtleta());
        holder.txt_cartao_amarelo.setText(lista.getAmarelo());
        holder.txt_cartao_vermelho.setText(lista.getVermelho());
        holder.txt_cartao_situacao.setText(lista.getSuspenso());

    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }




    public class  ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageTimecartao;// aqui vai a imagem
        TextView nomejogadorcartao;
        TextView txt_cartao_amarelo;
        TextView txt_cartao_vermelho;
        TextView txt_cartao_situacao;




        public ViewHolder(View itemView) {
            super(itemView);
            imageTimecartao = (ImageView) itemView.findViewById(R.id.imageTimecartao);
            nomejogadorcartao = (TextView) itemView.findViewById(R.id.nomejogadorcartao);
            txt_cartao_amarelo = (TextView) itemView.findViewById(R.id.txt_cartao_amarelo);
            txt_cartao_vermelho = (TextView) itemView.findViewById(R.id.txt_cartao_vermelho);
            txt_cartao_situacao = (TextView) itemView.findViewById(R.id.txt_cartao_situacao);


        }
    }//fim ViewHolder


}
