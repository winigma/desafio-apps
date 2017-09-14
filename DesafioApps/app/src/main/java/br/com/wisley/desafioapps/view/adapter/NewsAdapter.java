package br.com.wisley.desafioapps.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

import br.com.wisley.desafioapps.R;
import br.com.wisley.desafioapps.model.Content;
import br.com.wisley.desafioapps.view.adapter.viewholder.ViewHolderContent;
import br.com.wisley.desafioapps.view.adapter.viewholder.ViewHolderHeader;
import br.com.wisley.desafioapps.view.interfaces.OnClickDetail;

/**
 * Created by Wisley on 13/09/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0, TYPE_ITEM = 1;

    private List<Content> newsList;
    private Context mContext;
    private OnClickDetail onClickDetail;

    public NewsAdapter(final List<Content> news, final OnClickDetail onClickDetail) {
        this.onClickDetail = onClickDetail;
        newsList = new ArrayList<>();
        if (news != null)
            newsList = news;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        /*
         * choose between the two types of layout.
         */
        if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_header, parent, false);
            return new ViewHolderHeader(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
            return new ViewHolderContent(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //is Header
        if (holder instanceof ViewHolderHeader) {
            final ViewHolderHeader viewHolder = (ViewHolderHeader) holder;
            viewHolder.getTvMainEditorial().setText(getItem(position).getSecao().getNome());
            viewHolder.getTvTittleMain().setText(getItem(position).getTitulo());
            viewHolder.getViewItem().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            //load image in Backgroud RelativeLayout obs: Eu poderia ter usado ImageView
            Picasso.with(mContext).load(getItem(position).getImagens().get(0).getUrl()).into(new Target() {
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    viewHolder.getRlTopNews().setBackground(new BitmapDrawable(bitmap));
                }

                @Override
                public void onBitmapFailed(Drawable errorDrawable) {
                    Log.d("NewsAdapter", "Prepare Load");
                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {
                    Log.d("NewsAdapter", "Prepare Load");
                }
            });


            /* this call open detail of news*/

            viewHolder.getViewItem().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickDetail.onClickOpenDetail(position);
                }
            });
        } else {
            //Is content
            final ViewHolderContent viewHolder = (ViewHolderContent) holder;
            viewHolder.getTvEditorial().setText(getItem(position).getSecao().getNome());
            viewHolder.getTvTittle().setText(getItem(position).getTitulo());
            if (getItem(position).getImagens() != null && getItem(position).getImagens().size() > 0) {
                Picasso.with(mContext)
                        .load(getItem(position).getImagens().get(0).getUrl())
                        .error(R.drawable.logo_oglobo)
                        .placeholder(R.drawable.logo_oglobo)
                        .fit()
                        .centerInside()
                        .into(viewHolder.getIvThumbnail());
            }
            viewHolder.getViewItem().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickDetail.onClickOpenDetail(position);
                }
            });

        }


    }

    @Override
    public int getItemViewType(int position) {
        //checked is is Header and set view Header
        boolean header = getItem(position).isHeader();
        if (header) {
            return TYPE_HEADER;

        }
        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    /**
     * Return item to position
     *
     * @param position
     * @return
     */
    public Content getItem(final int position) {
        if (position < 0 || position > newsList.size()) {
            return null;
        }
        return newsList.get(position);
    }
}
