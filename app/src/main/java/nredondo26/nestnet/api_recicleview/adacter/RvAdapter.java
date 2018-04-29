package nredondo26.nestnet.api_recicleview.adacter;

import android.content.Context;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import nredondo26.nestnet.api_recicleview.R;
import nredondo26.nestnet.api_recicleview.activities.AnimeiActivity;
import nredondo26.nestnet.api_recicleview.model.Anime;


/**
 * Created by Aws on 28/01/2018.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    private RequestOptions options ;
    private Context mContext ;
    private List<Anime> mData ;


    public RvAdapter(Context mContext, List lst) {


        this.mContext = mContext;
        this.mData = lst;
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_shapes)
                .error(R.drawable.loading_shapes);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.anime_row_item,parent,false);
        final MyViewHolder viewHolder= new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, AnimeiActivity.class);
                i.putExtra("anime_name",mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("anime_description",mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("anime_estudio",mData.get(viewHolder.getAdapterPosition()).getStudio());
                i.putExtra("anime_categori",mData.get(viewHolder.getAdapterPosition()).getCategorie());
                i.putExtra("anime_nb_episode",mData.get(viewHolder.getAdapterPosition()).getNb_episode());
                i.putExtra("anime_rating",mData.get(viewHolder.getAdapterPosition()).getRating());
                i.putExtra("anime_img",mData.get(viewHolder.getAdapterPosition()).getImage_url());

                mContext.startActivity(i);
            }
        });

        // click listener here


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tvname.setText(mData.get(position).getName());
        holder.tv_rate.setText(mData.get(position).getRating());
        holder.tvstudio.setText(mData.get(position).getStudio());
        holder.tvcat.setText(mData.get(position).getCategorie());

        // load image from the internet using Glide
        Glide.with(mContext).load(mData.get(position).getImage_url()).apply(options).into(holder.AnimeThumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvname,tv_rate,tvstudio,tvcat;
        ImageView AnimeThumbnail;
        LinearLayout view_container;


        MyViewHolder(View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.rowname);
            tvstudio = itemView.findViewById(R.id.studio);
            tv_rate = itemView.findViewById(R.id.rating);
            tvcat = itemView.findViewById(R.id.categorie);
            AnimeThumbnail = itemView.findViewById(R.id.thumbnail);
            view_container = itemView.findViewById(R.id.container);
        }
    }


}