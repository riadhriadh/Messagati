package com.example.riadhfarhati.messagati;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.CLIPBOARD_SERVICE;

/**
 * Created by i on 02/06/2017.
 */

public class Remplir extends ArrayAdapter<msg> {
    private  Context mContext;
    private ArrayList<msg> mData;
    TextView data;
    ImageView img ,shar,coupier;

    public Remplir(Context mContext, ArrayList<msg> mData) {
        super(mContext,R.layout.item, mData);
        this.mContext=mContext;
        this.mData=mData;
    }
    public  int getCount(){

        return  mData.size();
    }
    public View getView(final int position, View convertView, ViewGroup parent)


    {
        final msg s = mData.get(position);
        LayoutInflater mInflater;

        if (convertView == null) {
            mInflater = (LayoutInflater)
                    mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = mInflater.inflate(R.layout.item, null);
        }
        Context context;




        data=(TextView) convertView.findViewById(R.id.textView);
        data.setText(mData.get(position).getText());

        shar=(ImageView) convertView.findViewById(R.id.imageView);
        coupier=(ImageView) convertView.findViewById(R.id.imageView2);
        coupier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        shar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, mData.get(position).getText());
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,mData.get(position).getText());
                mContext.startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });


        return convertView;
    }



    }


