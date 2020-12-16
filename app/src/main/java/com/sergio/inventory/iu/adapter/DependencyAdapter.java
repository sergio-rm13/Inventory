package com.sergio.inventory.iu.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sergio.inventory.R;
import com.sergio.inventory.data.model.Dependency;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.List;

public class DependencyAdapter extends RecyclerView.Adapter<DependencyAdapter.ViewHolder> {

    private List<Dependency> list;
    private onDependencyClickListener dependencyClickListener;

    public interface onDependencyClickListener{
        void onClick(Dependency dependency);
    }


    public DependencyAdapter(List<Dependency> list, onDependencyClickListener listener) {
        this.list = list;
        this.dependencyClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dependency, parent, false);

        return new ViewHolder(view, dependencyClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.iconLetter.setLetter(list.get(position).getShortname());
        holder.tvShortName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * Método que actualiza los datos dentro del RecyclerView ys e debe llamar al método
     * notifysetDataChanged() para que la vista se anule y se vuelva  a dibujar
     */
    public void update (List<Dependency> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        MaterialLetterIcon iconLetter;
        TextView tvShortName;
            public ViewHolder(@NonNull View itemView, final onDependencyClickListener listener) {
            super(itemView);
            iconLetter = itemView.findViewById(R.id.iconLetter);
            tvShortName = itemView.findViewById(R.id.tvShortName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(list.get(getAdapterPosition()));
                }
            });
        }
    }
}
