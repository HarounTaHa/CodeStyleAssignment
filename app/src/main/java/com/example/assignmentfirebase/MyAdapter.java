package com.example.assignmentfirebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    List<Book> books;
    public MyAdapter(Context context ,List<Book> books ) {
    this.context=context;
    this.books=books;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.design_item,null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Book book = books.get(i);
        myViewHolder.tvName.setText(book.getNameBook());
        myViewHolder.tvAuthor.setText(book.getAuthorName());
        myViewHolder.tvDescription.setText(book.getDescriptionBook());
        myViewHolder.tvNumberOfPage.setText(Float.toString( book.getNumberOfPages()));
        myViewHolder.tvYearOfPublishing.setText(Float.toString(book.getYearOfPublishing()));

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{
         TextView tvName;
         TextView tvAuthor;
         TextView tvDescription;
         TextView tvNumberOfPage;
         TextView tvYearOfPublishing;
         public MyViewHolder(@NonNull View itemView) {
             super(itemView);
          tvName= itemView.findViewById(R.id.name_book_tv);
          tvAuthor=itemView.findViewById(R.id.name_author_tv);
          tvDescription=itemView.findViewById(R.id.description_book_tv);
          tvNumberOfPage=itemView.findViewById(R.id.number_of_pages_tv);
          tvYearOfPublishing=itemView.findViewById(R.id.year_of_publishing_tv);
         }
     }
}
