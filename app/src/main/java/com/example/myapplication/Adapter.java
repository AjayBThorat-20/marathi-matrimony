package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {

    private List<ModelClass> userList;

    public Adapter (List<ModelClass>userList){this.userList=userList;}


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.usersprofile,parent,false);
        return  new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        int image = userList.get(position).getImage();
        String name = userList.get(position).getName();
        String dob = userList.get(position).getDob();
        String edu = userList.get(position).getEdu();
        String job = userList.get(position).getJob();
        String company = userList.get(position).getCompany();
        String from = userList.get(position).getFrom();


        holder.setData(image,name,dob,edu,job,company,from);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView1,textView2,textView3,textView4,textView5,textView6;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView1);
            textView1 = itemView.findViewById(R.id.display_name);
            textView2 = itemView.findViewById(R.id.display_age);
            textView3 = itemView.findViewById(R.id.display_education);
            textView4 = itemView.findViewById(R.id.display_jobtitle);
            textView5 = itemView.findViewById(R.id.display_Company);
            textView6 = itemView.findViewById(R.id.display_address);

        }


        private void setData(int image, String name, String dob, String edu, String job, String company, String from) {
            imageView.setImageResource(image);
            textView1.setText(name);
            textView2.setText(dob);
            textView3.setText(edu);
            textView4.setText(job);
            textView5.setText(company);
            textView6.setText(from);


        }

    }
}


