package com.minda.erouteassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.minda.erouteassignment.adapter.UserRecyclerViewAdapter;
import com.minda.erouteassignment.model.User;
import com.minda.erouteassignment.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.search)
    EditText search;
    UserRecyclerViewAdapter userRecyclerViewAdapter;
    private SearchView searchView;
    ArrayList<User.UserModel> userList = new ArrayList<>();
    ArrayList<User.UserModel> userFilterList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


             UserViewModel userViewModel = ViewModelProviders.of(MainActivity.this).get(UserViewModel.class);
                userViewModel.getUser().observe(MainActivity.this, new Observer<User>() {
                    @Override
                    public void onChanged(User user) {
                        userList.addAll(user.getData());
                        userRecyclerViewAdapter = new UserRecyclerViewAdapter(MainActivity.this,  userList);
                        recyclerView.setAdapter(userRecyclerViewAdapter);
                    }
                });

                search.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        if (editable.toString().length() > 0) {
                            userSearch(editable.toString());
                            userRecyclerViewAdapter.setUserArrayList(userFilterList);
                        } else {
                            userRecyclerViewAdapter.setUserArrayList(userList);
                        }
                        userRecyclerViewAdapter.notifyDataSetChanged();
                    }

                });


            }

    private void userSearch(String inputStr) {
        ArrayList<User.UserModel> filterInfoList = new ArrayList<>();
        for (int idx = 0; idx < userList.size(); idx++) {
            if (userList.get(idx).getName().toLowerCase().startsWith(inputStr.toLowerCase())) {
                filterInfoList.add(userList.get(idx));
            }
        }
        userFilterList = filterInfoList;
    }





}
