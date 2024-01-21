package com.example.triviaapptest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/*
RecyclerAdapter "bind" values/data stored in memory to the visual components we see on screen.
In other words, it's the glue between JAVA and XML. More accurately, it's a translation layer.
As you can, this class extends from a class called CountryViewHolder (the class we create below)
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CountryViewHolder> {


    int selection = 0;
    String selectionNames;
    private Context context;
    //ArrayList of that holds all data fields
    private ArrayList<TriviaList> list;
    private ArrayList<String>selectionList = new ArrayList<>();
    //Constructor
    public RecyclerAdapter(ArrayList list, Context context) {
        this.list = list;
        this.context = context;

    }

    /*
    grabs the views from our card_design.xml layout file
    similar to onCreate() methods - initializes the views - connects the Java and XML sides together
     */
    public class CountryViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewCountryName, textViewDetails;
        private ImageView imageView;
        private CardView cardView;
        public  CountryViewHolder(@NonNull View itemView){
            super(itemView);

            textViewCountryName = itemView.findViewById(R.id.textViewCountryName);
          //  textViewDetails = itemView.findViewById(R.id.textViewDetail);
         //   imageView = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);


        }

    }

    @NonNull
    @Override
    //this where you inflate ("draw" the view on screen) the layout
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design, parent, false);
        return new CountryViewHolder((view));
        //return null;
    }

    @Override
    //assigning values/data to the views we created in the card_design.xml layout file
    //based on position (row)
    public void onBindViewHolder(@NonNull CountryViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textViewCountryName.setText(list.get(position).getQuestion());
       // holder.textViewDetails.setText(list.get(position).getA_Choice());
       // holder.imageView.setImageResource(list.get(position).getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context, "You have selected "+list.get(position).getQuestion(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, TriviaActivity.class);

                intent.putExtra("question", list.get(position).getQuestion());
                intent.putExtra("choiceA", list.get(position).getA_Choice());
                intent.putExtra("choiceB", list.get(position).getB_Choice());
                intent.putExtra("choiceC", list.get(position).getC_Choice());
                intent.putExtra("choiceD", list.get(position).getD_Choice());
                intent.putExtra("answer", list.get(position).getAnswer());

//                System.out.println("making intents");
//                intent.putExtra("position", position);
//                intent.putExtra("list", list);
//                System.out.println("done making intents");


//                intent.putParcelableArrayListExtra("list", list);


                context.startActivity(intent);
            }
        });

    }

    @Override
    //recycler view wants to know how many items(rows) will be displayed
    public int getItemCount() {
        return list.size();
    }


}

