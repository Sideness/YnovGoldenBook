package com.app.sideness.ynovgoldenbook;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter{
    ArrayList<String> resultNom;
    ArrayList<String> resultMsg;
    Context context;
    ArrayList<String> resultImg;
    private static LayoutInflater inflater=null;
    public CustomAdapter(Context context, ArrayList<String> nomSignataire, ArrayList<String> msgSignataire, ArrayList<String> imgSignataires) {
        // TODO Auto-generated constructor stub
        resultNom = nomSignataire;
        resultMsg = msgSignataire;
        context=context;
        resultImg = imgSignataires;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return resultNom.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tvNom;
        TextView tvMsg;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.signature_adapter, null);
        holder.tvNom=(TextView) rowView.findViewById(R.id.tvNomSignataire);
        holder.tvMsg=(TextView) rowView.findViewById(R.id.tvTextSignature);
        holder.img=(ImageView) rowView.findViewById(R.id.imvSignature);

        try{
            File f=new File(resultImg.get(position));
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            holder.img.setImageBitmap(b);
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
            //holder.img.setImageBitmap("default");
        }


        holder.tvNom.setText(resultNom.get(position));
        holder.tvMsg.setText(resultMsg.get(position));
        return rowView;
    }

}
