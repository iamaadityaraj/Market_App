package com.example.marketapp;


import android.content.ClipData;
import android.media.RouteListingPreference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
// mycustomerAdapter extends Recyclerview.adapter which is responsible to bind mycustomAdapter class with Adapter items view.
public class myCutomAdapter extends RecyclerView.Adapter<myCutomAdapter.viewHolder> {

    public ItemClickListner itemClickListner;

    public void setItemClickListner(ItemClickListner myClickListner){
        this.itemClickListner = myClickListner;
    }




    // private variable in which items are store in list form
    private List<item>ListItem;



    // It is normal consturctor which initalize listitem when we create mycoustomAdapter Object
    public myCutomAdapter(List<item> listItem) {
        ListItem = listItem;
    }

    @NonNull
    @Override

    // This are the important methods that we need to implements by extending recyclerview


    // onCreateViewHolder is used to create a new viewHolder object when Recycler needs to new item
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem= LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_layout,
                parent,
                false
        );
        return new viewHolder(viewItem);
    }

    @Override

    // This method is used to bind a data with Specific position of Item
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        // here we item model class then variable = list that we created before and then .get(position) for getting specific position of item
        item i=ListItem.get(position);
        holder.item_title.setText(i.getItem_title());
        holder.item_description.setText(i.getItem_description());
        holder.item_Image.setImageResource(i.getItem_Image());

    }

    @Override
    // This method will return count of total number of items
    public int getItemCount() {
        return ListItem.size();
    }


    // HINDI LANG == yeh method itemView ke parent class(Recyclerview.viewHolder ) ke constructor mein pass karta hai
    // English == this method is used to pass parent class of itemview to  (Recyclerview.viewHolder) of constructor.

    // view Holder class that holds the references to the views within the itemLayout
    public  class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        // Making reference that we created views in custom layout
        ImageView item_Image;
        TextView item_title;
        TextView item_description;
        public viewHolder(@NonNull View itemView) {   // constructor of viewHolder
            super(itemView);

            itemView.setOnClickListener(this);


            // finding Views

            item_Image=itemView.findViewById(R.id.item_Image);
            item_title=itemView.findViewById(R.id.item_title);
            item_description=itemView.findViewById(R.id.item_description);
        }




        @Override
        public void onClick(View view) {
            if(itemClickListner != null){
                itemClickListner.onCLick(view,getAdapterPosition());
            }

        }
    }
}
