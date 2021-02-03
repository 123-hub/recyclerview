package com.example.myapplication;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class adapter< O > extends ArrayAdapter<objectes> {

    private Context mContext;
    private List< objectes > List = new ArrayList<>();
    public adapter(@NonNull Context context, @NonNull ArrayList < objectes > objects) {
        super(context, 0, objects);
        mContext=context;
        List = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(mContext).inflate(
                    R.layout.item_layout ,parent, false);
        }
        objectes currentWord = List.get(position);

        TextView ids=(TextView) listItemView.findViewById(R.id.id);
        TextView emails=(TextView) listItemView.findViewById(R.id.email);
        TextView firsts=(TextView) listItemView.findViewById(R.id.first);
        TextView lasts=(TextView) listItemView.findViewById(R.id.last);
        TextView avatars=(TextView) listItemView.findViewById(R.id.avatar);




        ids.setText(currentWord.getId());
        emails.setText(currentWord.getEmail());
        firsts.setText(currentWord.getFistname());
        lasts.setText(currentWord.getLastname());
        avatars.setText(currentWord.getAvatar());


        return listItemView;
    }
}
