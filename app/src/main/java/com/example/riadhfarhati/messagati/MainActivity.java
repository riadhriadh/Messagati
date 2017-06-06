package com.example.riadhfarhati.messagati;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private ArrayList<msg> msgs;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView=(ListView)findViewById(R.id.lsv);

        new   Rest1("dfd").execute();

    }



    private class Rest1 extends AsyncTask<Void, Void, Boolean> {
        String ress = "";



        //   Toast.makeText(getApplicationContext(), ress, Toast.LENGTH_LONG).show();


        // http://boitedenuit.coolpage.biz/listeven.php

        private ProgressDialog mProgressDialog;
        private JSONArray jsonObjectResult1 = null;


        private String imei;


        public Rest1(String imei) {
            this.imei = imei;


        }
        protected void onPreExecute() {
            super.onPreExecute();
            ConnectionDb con = new ConnectionDb();


            String[] params = {"imei",  "nom"};
            //Http Get Method
            try {
                ress = con.Post("https://sharapp.000webhostapp.com/index.php", params);
                Log.e("res1",ress);
            } catch (ExecutionException e1) {
                Log.e("erreur", e1.toString());
                e1.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Log.e("erreur", e.toString());
            }
            msgs=new ArrayList<msg>();
            //  mProgressDialog = ProgressDialog.show(MainActivity.this, "Chargement", "en cours ...", false, false);

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            JSONObject jsonObj;


            //  JSONObject jsonbject = new JSONObject(ress);
            //  Log.e("res2s","mode traville");
            JSONArray jsonArray = null;
            try {
                jsonArray = new JSONArray(ress);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //  JSONArray jsonArray = jsonbject.getJSONArray(ress);
            Log.e("res1s",jsonArray.toString());
            // Log.e("res1ss",jsonbject.toString());

            try {

                if (jsonArray !=null) {
                    for(int i=0;i<jsonArray.length();i++){
                        jsonObj = jsonArray.getJSONObject(i);
                        //  Log.e("res2s", jsonObj.getString("idEvenement").toString());
                        msg msg=new msg(

                                jsonObj.getInt("id"),

                                jsonObj.getString("text").toString()



                        );
                        msgs.add(msg);



                    }
                    return true;
                }if(jsonArray ==null){
                    return  false;

                }
                else{
                    return  false;

                }

            }catch (Exception ex){
                ex.printStackTrace();


            }


            return true;
        }
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            //   mProgressDialog.dismiss();


            if (aBoolean) {

                Remplir repliretavaille=new Remplir(MainActivity.this,msgs);
                mListView.setAdapter(repliretavaille);








            }
            else{

            }
        }


    }








}
