package com.example.myapplication.fragmemt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.MessageData;
import com.example.myapplication.R;
import com.example.myapplication.adapter.RoomAdapter;

import java.util.ArrayList;
import java.util.List;

public class MatchFragment extends Fragment {


    private RecyclerView recyclerView;

    private RoomAdapter roomAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match, container, false);


        List<MessageData> demoList = new ArrayList<>();
        // Adding 10 demo data objects
        demoList.add(new MessageData("Hello!", "1", "12:42 am", "normal"));
        demoList.add(new MessageData("https://images.unsplash.com/photo-1724805053809-3c09736b2ade?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHw0fHx8ZW58MHx8fHx8", "1", "12:42 am", "photo"));
        demoList.add(new MessageData("I'm good, thanks!", "1", "12:42 am", "normal"));
        demoList.add(new MessageData("Great to hear!", "2", "12:42 am", "normal"));
        demoList.add(new MessageData("https://images.unsplash.com/photo-1724745603549-4eb259669e44?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHw1fHx8ZW58MHx8fHx8", "3", "12:42 am", "photo"));
        demoList.add(new MessageData("https://images.unsplash.com/photo-1724745603549-4eb259669e44?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHw1fHx8ZW58MHx8fHx8", "4", "12:42 am", "photo"));
        demoList.add(new MessageData("https://images.unsplash.com/photo-1724745603549-4eb259669e44?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHw1fHx8ZW58MHx8fHx8", "3", "12:42 am", "photo"));
        demoList.add(new MessageData("https://images.unsplash.com/photo-1724745603549-4eb259669e44?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHw1fHx8ZW58MHx8fHx8", "4", "12:42 am", "photo"));
        demoList.add(new MessageData("https://images.unsplash.com/photo-1724745603549-4eb259669e44?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHw1fHx8ZW58MHx8fHx8.", "1", "12:42 am", "photo"));
        demoList.add(new MessageData("Sure!", "2", "12:42 am", "normal"));


        roomAdapter = new RoomAdapter(getContext(),demoList);
        recyclerView = view.findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(roomAdapter);

        return view;
    }
}