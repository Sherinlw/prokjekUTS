package id.ac.polinema.prokjekuts.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.ac.polinema.prokjekuts.R;
import id.ac.polinema.prokjekuts.data.AsmaulHusna;

public class AsmaulHusnaAdapterGrid extends RecyclerView.Adapter<AsmaulHusnaAdapterGrid.GridViewHolder> {
    private Context context;
    private ArrayList<AsmaulHusna> listTokoh;

    public ArrayList<AsmaulHusna> getListTokoh() {
        return listTokoh;
    }

    public void setListTokoh(ArrayList<AsmaulHusna> listTokoh) {
        this.listTokoh = listTokoh;
    }

    public AsmaulHusnaAdapterGrid(Context context) {
        this.context = context;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_grid, parent, false);
        GridViewHolder gridViewHolder = new GridViewHolder(view);
        return gridViewHolder;
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListTokoh().get(position).getPhoto())
                .override(350, 550)
                .into(holder.tPhoto);
    }

    @Override
    public int getItemCount() {
        return getListTokoh().size();
    }
    public class GridViewHolder extends RecyclerView.ViewHolder{
        ImageView tPhoto;
        public GridViewHolder(View itemView) {
            super(itemView);
            tPhoto = (ImageView)itemView.findViewById(R.id.item_img);
        }
    }

}
