package com.davidmadethis.dampp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.davidmadethis.dampp.R;
import com.davidmadethis.dampp.model.Client;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by root on 6/23/17.
 */

public class SuggestionsAdapter extends RecyclerView.Adapter<SuggestionsAdapter.ViewHolder> {


    private List<Client> users;
    private Context context;

    public SuggestionsAdapter(List<Client> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_people, parent, false);

        return new SuggestionsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Client user = users.get(position);
        holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.girl));
        holder.username.setText(user.getUsername());
        holder.timeagoView.setText("just now");

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        ImageView activeImageView;
        TextView username;
        TextView timeagoView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (CircleImageView) itemView.findViewById(R.id.profile_image);
            activeImageView = (ImageView) itemView.findViewById(R.id.active);
            username = (TextView) itemView.findViewById(R.id.username);
            timeagoView = (TextView) itemView.findViewById(R.id.timeago);
        }
    }

}
