package com.davidmadethis.dampp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davidmadethis.dampp.R;
import com.davidmadethis.dampp.model.Client;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by root on 6/23/17.
 */

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {


    private List<Client> users;
    private Context context;

    public MatchesAdapter(List<Client> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_new_matches, parent, false);

        return new MatchesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.usernameTextView.setText(users.get(position).getUsername());
        holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.girl));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageView;
        TextView usernameTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (CircleImageView) itemView.findViewById(R.id.profile_image);
            usernameTextView = (TextView) itemView.findViewById(R.id.username);
            usernameTextView.setSelected(true);

        }
    }
}
