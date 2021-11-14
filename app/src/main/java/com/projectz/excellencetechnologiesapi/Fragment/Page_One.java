package com.projectz.excellencetechnologiesapi.Fragment;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.projectz.excellencetechnologiesapi.Model.UserModel;
import com.projectz.excellencetechnologiesapi.Adapter.MyAdapter;
import com.projectz.excellencetechnologiesapi.Network.RetrofitClient;
import com.projectz.excellencetechnologiesapi.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Page_One extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    String page = "1";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page__one, container, false);
        getActivity().setTitle("Users Data");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setElevation(0);
        recyclerView = view.findViewById(R.id.Recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Call<UserModel> call = RetrofitClient.getInstance().getApi().getUserData(
                page
        );

        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                ArrayList<UserModel.data> data = response.body().getData();

                if(response.isSuccessful()){
                    adapter = new MyAdapter(data,getContext());
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );
                Toast.makeText(getContext(), "Something Went Wrong!!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}