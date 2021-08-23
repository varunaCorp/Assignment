package com.minda.erouteassignment.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.minda.erouteassignment.R;
import com.minda.erouteassignment.model.User;
import com.minda.erouteassignment.viewmodel.UserViewModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder> {

    Activity context;
    ArrayList<User.UserModel> userArrayList;


    public UserRecyclerViewAdapter(Activity context, ArrayList<User.UserModel> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }
    public void setUserArrayList(ArrayList<User.UserModel> userList) {
        this.userArrayList = userList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(userArrayList.get(position).getName());
        holder.email.setText(userArrayList.get(position).getEmail());
        if(userArrayList.get(position).getGender().equalsIgnoreCase("male")){
        holder.name.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.outline_man_black_18,0,0,0);}
        else {
            holder.name.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.outline_woman_black_18, 0, 0, 0);
        }
        if(userArrayList.get(position).getStatus().equalsIgnoreCase("active")){
            holder.status.setImageResource(R.drawable.active_bg);
        }
        else {
            holder.status.setImageResource(R.drawable.inactive_bg);

        }
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
         }


    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.email)
        TextView email;
        @BindView(R.id.gender)
        TextView gender;
        @BindView(R.id.status)
        ImageView status;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);



        }
    }




}
