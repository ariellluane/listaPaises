package com.example.listadepaises;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import Adapter.Adapter;
import Model.Paises;
import dao.Repositorio;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import util.Http;
import util.HttpRetro;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private Adapter adapter;
    private List<Paises> PaisesList;
    private ListView listView;
    private SwipeRefreshLayout swiperefresh;
    Repositorio db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        swiperefresh = (SwipeRefreshLayout) findViewById((R.id.swiperefresh));
        //seta cores
        swiperefresh.setColorScheme(R.color.colorPrimary, R.color.colorAccent);
        swiperefresh.setOnRefreshListener(this);

        listView = (ListView) findViewById(R.id.listView);
        PaisesList = new ArrayList<Paises>();

        getDataHttp();
        listView.setAdapter(adapter);
        db = new Repositorio(getBaseContext());

        getDataRetro();

        listView.setAdapter(adapter);

        adapter = new Adapter(this, PaisesList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplication(), PaisesList.get(position).toString(), Toast.LENGTH_LONG).show();

            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                hasPermission();

                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("Paises",PaisesList.get(position));
                startActivity(intent);
            }
        });


    }

    class PaisesTask extends AsyncTask<Void, Void, List<Paises>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            swiperefresh.setRefreshing(true);
        }

        @Override
        protected List<Paises> doInBackground(Void... voids) {
            return Http.carregarPaisesJson();
        }

        @Override
        protected void onPostExecute(List<Paises> pais) {
            super.onPostExecute(pais);
            if (pais != null) {
                PaisesList.clear();
                PaisesList.addAll(pais);
                adapter.notifyDataSetChanged();
            }
            swiperefresh.setRefreshing(false);
        }
    }

    private void getDataRetro(){
                   // se tiver conexao faz get, senao pega do sqlite
        if (isConnected()) {
                HttpRetro.getPaisesClient().getPaises().enqueue(new Callback<List<Paises>>() {
                    public void onResponse(Call<List<Paises>> call, Response<List<Paises>> response) {
                        if (response.isSuccessful()) {
                            List<Paises> ubsBody = response.body();
                            PaisesList.clear();

                            db.excluirAll();

                            for (Paises paises : ubsBody) {
                                PaisesList.add(paises);
                                db.inserir(paises);
                            }
                            adapter.notifyDataSetChanged();
                        } else {
                            System.out.println(response.errorBody());
                        }
                        swiperefresh.setRefreshing(false);
                    }

                    @Override
                    public void onFailure(Call<List<Paises>> call, Throwable t) {
                        t.printStackTrace();
                    }

                });

            }else {
                swiperefresh.setRefreshing(false);
                Toast.makeText(this,"Sem Conexão, listando Ubs do banco...",Toast.LENGTH_SHORT).show();
                getDataSqlite();
            }

    }
    public Boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if ( cm != null ) {
            NetworkInfo ni = cm.getActiveNetworkInfo();
            return ni != null && ni.isConnected();
        }
        return false;
    }

    void hasPermission(){
        //pede permissao de localizacao
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // ja pediu permissao?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {

                // solicita permissao de localizacao
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
            }
        }
    }



    public void getDataHttp () {
        PaisesTask mTask = new PaisesTask();
        mTask.execute();
    }

    private void getDataSqlite() {
        PaisesList.clear();
        PaisesList.addAll(db.listarPaises());
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onRefresh() {
      //  getData();
     //  getDataHttp();
        getDataRetro();
    }
}