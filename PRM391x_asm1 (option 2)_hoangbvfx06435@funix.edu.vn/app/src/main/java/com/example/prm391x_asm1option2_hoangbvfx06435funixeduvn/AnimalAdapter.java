package com.example.prm391x_asm1option2_hoangbvfx06435funixeduvn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class AnimalAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Animal> animalList;

    public AnimalAdapter(Context context, int layout, List<Animal> animalList) {
        this.context = context;
        this.layout = layout;
        this.animalList = animalList;
    }

    @Override
    public int getCount() {
        return animalList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        ImageView imageView, icon;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            //anh xa view
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageViewHinh);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.imageIcon);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //gan gia tri
        Animal animal = animalList.get(position);
        viewHolder.imageView.setImageResource(animal.getImg());

        viewHolder.icon.setImageResource(animal.getIc());

        //gan animation
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_list);
        convertView.startAnimation(animation);



        return convertView;
    }
}
