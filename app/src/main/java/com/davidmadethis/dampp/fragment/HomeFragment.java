package com.davidmadethis.dampp.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidmadethis.dampp.HomeActivity;
import com.davidmadethis.dampp.ProfileActivity;
import com.davidmadethis.dampp.R;
import com.davidmadethis.dampp.adapter.MatchesAdapter;
import com.davidmadethis.dampp.adapter.SuggestionsAdapter;
import com.davidmadethis.dampp.model.Client;
import com.davidmadethis.dampp.util.RecyclerTouchListener;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

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
    SuggestionsAdapter suggestionsAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        matchesView = (RecyclerView) v.findViewById(R.id.recycler_matches);
        suggestionsView = (RecyclerView) v.findViewById(R.id.recycler_suggestions);
        fetchMatches(getContext());
        fetSuggestions(getContext());
        return v;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

    }

    private void fetchMatches(Context context) {
        users = new ArrayList<>();
        Client clientone = new Client().setUsername("bunnypassion");
        Client clienttwo = new Client().setUsername("butterscotchseven");
        Client clientthree = new Client().setUsername("danieldas");
        users.add(clientone);
        users.add(clienttwo);
        users.add(clienttwo);
        users.add(clienttwo);
        users.add(clientthree);

        matchesAdapter = new MatchesAdapter(users, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        matchesView.setLayoutManager(layoutManager);
        matchesView.setAdapter(matchesAdapter);

        matchesAdapter.notifyDataSetChanged();

    }


    private void fetSuggestions(Context context) {
        users = new ArrayList<>();
        Client clientone = new Client().setUsername("bunnypassion");
        Client clienttwo = new Client().setUsername("butterscotchseven");
        Client clientthree = new Client().setUsername("danieldas");
        users.add(clientone);
        users.add(clienttwo);
        users.add(clienttwo);
        users.add(clienttwo);
        users.add(clientthree);

        suggestionsAdapter = new SuggestionsAdapter(users,getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        suggestionsView.setLayoutManager(layoutManager);
//        suggestionsView.addItemDecoration(
//                new HorizontalDividerItemDecoration.Builder(getContext())
//                        .margin(0)
//                        .
//                        .colorResId(R.color.icons)
//                        .color(R.color.icons)
//                        .build());
        suggestionsView.setAdapter(suggestionsAdapter);


        suggestionsView.addOnItemTouchListener(new RecyclerTouchListener(getContext(),suggestionsView,new RecyclerTouchListener.ClickListener(){

            @Override
            public void onClick(View view, int position) {

                startActivity(new Intent(getActivity(),ProfileActivity.class));
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        suggestionsAdapter.notifyDataSetChanged();

    }


}
