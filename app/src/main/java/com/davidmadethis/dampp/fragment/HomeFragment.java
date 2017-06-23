package com.davidmadethis.dampp.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidmadethis.dampp.R;
import com.davidmadethis.dampp.adapter.MatchesAdapter;
import com.davidmadethis.dampp.model.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 6/20/17.
 */

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    RecyclerView matchesView;
    RecyclerView suggestionsView;
    List<Client> users;
    MatchesAdapter matchesAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        matchesView = (RecyclerView) v.findViewById(R.id.recycler_matches);
        suggestionsView = (RecyclerView) v.findViewById(R.id.recycler_suggestions);
        fetchMatches(getContext());
        return v;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {

            fetSuggestions(getContext());
        }

    }

    private void fetchMatches(Context context) {
        users = new ArrayList<>();
        Client clientone = new Client().setUsername("bunnypassion");
        Client clienttwo = new Client().setUsername("butterscotchseven");
        Client clientthree = new Client().setUsername("danieldas");
        users.add(clientone);
        users.add(clienttwo);
        users.add(clientthree);

        matchesAdapter = new MatchesAdapter(users, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        matchesView.setLayoutManager(layoutManager);
        matchesView.setAdapter(matchesAdapter);

        matchesAdapter.notifyDataSetChanged();

    }


    private void fetSuggestions(Context context) {

    }


}
