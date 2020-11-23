package com.example.billbro.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.billbro.R;
import com.example.billbro.User.User;

import java.util.List;

public class UserListAdapter extends ArrayAdapter<User> {

    private List<User> users;
    private Context context;

    public UserListAdapter(List<User> users, Context context) {
        super(context, R.layout.user_layout, users);
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.user_layout, parent, false);
        User user = this.users.get(position);
        TextView textViewName = (TextView) view.findViewById(R.id.textViewName);
        textViewName.setText(user.getName());
        TextView textViewEmail = (TextView) view.findViewById(R.id.textViewEmail);
        textViewEmail.setText(String.valueOf(user.getEmail()));
        return view;
    }
}
