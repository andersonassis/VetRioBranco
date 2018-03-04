package br.com.andersonassis.vetriobranco.cardview;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.andersonassis.vetriobranco.R;
import br.com.andersonassis.vetriobranco.adapter.ArtilheirosAdapter;


public class ArtilheirosNovo extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ArtilheirosBojo> listItem;
    String url = "http://www.vetriobranco.qlix.com.br/artilheiros.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.activity_card_view,container,false);

        recyclerView = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        listItem = new ArrayList<>();
        loadDados();
        return view;

    }//fim do onCreateView


    private void loadDados() {
        final ProgressDialog progress = new ProgressDialog(getActivity());

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progress.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array  = jsonObject.getJSONArray("artilheiros");

                            for (int i = 0; i<array.length(); i++){
                                JSONObject o = array.getJSONObject(i);
                                ArtilheirosBojo item = new ArtilheirosBojo(
                                        o.getString("nomeJogador") ,
                                        o.getString("equipe") ,
                                        o.getString("golsMarcados") ,
                                        o.getString("simbolo")
                                );
                                listItem.add(item);

                            }//fim do for

                            adapter = new ArtilheirosAdapter(listItem,getActivity());
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue request = Volley.newRequestQueue(getActivity());
        request.add(stringRequest);
    }//fim do loadDados



}
