package id.ac.polinema.prokjekuts.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.ac.polinema.prokjekuts.R;
import id.ac.polinema.prokjekuts.data.AsmaulHusna;

public class AsmaulHusnaAdapter extends RecyclerView.Adapter<AsmaulHusnaAdapter.CategoryViewHolder> {
    private Context context;
    public ArrayList<AsmaulHusna> getListTokoh() {
        return listTokoh;
    }

    public void setListTokoh(ArrayList<AsmaulHusna> listTokoh) {
        this.listTokoh = listTokoh;
    }

    private ArrayList<AsmaulHusna>listTokoh;

    public AsmaulHusnaAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {

        holder.tName.setText(getListTokoh().get(position).getName());
        holder.tRemarks.setText(getListTokoh().get(position).getRemarks());

        Glide.with(context)
                .load(getListTokoh().get(position).getPhoto())
                .override(50, 50)
                .crossFade()
                .into(holder.tPhoto);
    }

    @Override
    public int getItemCount() {
        return getListTokoh().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView tName;
        TextView tRemarks;
        ImageView tPhoto;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            tName = (TextView)itemView.findViewById(R.id.item_name);
            tRemarks = (TextView)itemView.findViewById(R.id.item_remarks);
            tPhoto = (ImageView)itemView.findViewById(R.id.item_img);
        }
    }
}
