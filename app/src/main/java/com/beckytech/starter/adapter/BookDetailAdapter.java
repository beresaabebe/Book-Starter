package com.beckytech.starter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beckytech.starter.model.BookDetailModel;
import com.beckytech.starter.R;

import java.util.List;

public class BookDetailAdapter extends RecyclerView.Adapter<BookDetailAdapter.BookDetailViewHolder> {

    private List<BookDetailModel> bookDetailModels;

    public BookDetailAdapter(List<BookDetailModel> bookDetailModels) {
        this.bookDetailModels = bookDetailModels;
    }

    @NonNull
    @Override
    public BookDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_detail_item_list, parent, false);
        return new BookDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookDetailViewHolder holder, int position) {
        BookDetailModel model = bookDetailModels.get(position);
        holder.imageView.setImageResource(model.getImage());
        holder.itemView.setOnClickListener(v -> Toast.makeText(v.getContext(), "Do you like it? Rate us on play store!", Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return bookDetailModels.size();
    }

    public static class BookDetailViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public BookDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_book_detail);
        }
    }
}
