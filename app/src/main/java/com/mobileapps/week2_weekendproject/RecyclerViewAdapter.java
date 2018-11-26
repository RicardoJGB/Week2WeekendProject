package com.mobileapps.week2_weekendproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<ConstantInfo> list;

    public RecyclerViewAdapter (Context context, ArrayList<ConstantInfo> passedList){
        this.context = context;
        this.list= passedList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder viewHolder = new ViewHolder(inflater.inflate(R.layout.item,viewGroup,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tvFirstName.setText(list.get(i).FIRST_NAME);
        viewHolder.tvLastName.setText(list.get(i).LAST_NAME);
        viewHolder.tvAddress.setText(list.get(i).ADDRESS);
        viewHolder.tvPhoneNumber.setText(list.get(i).PHONE_NUMBER);
        viewHolder.tvSkypeID.setText(list.get(i).SKYPE_ID);
        viewHolder.tvEmail.setText(list.get(i).EMAIL_ADDRESS);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvFirstName;
        TextView tvLastName;
        TextView tvPhoneNumber;
        TextView tvAddress;
        TextView tvSkypeID;
        TextView tvEmail;


        public ViewHolder(@NonNull View itemView){
            super (itemView);
            tvFirstName=itemView.findViewById(R.id.tvFirstName);
            tvLastName=itemView.findViewById(R.id.tvLastName);
            tvAddress=itemView.findViewById(R.id.tvAddress);
            tvPhoneNumber=itemView.findViewById(R.id.tvPhoneNumber);
            tvSkypeID=itemView.findViewById(R.id.tvSkypeID);
            tvEmail=itemView.findViewById(R.id.tvEmailAddress);


        }
    }
}