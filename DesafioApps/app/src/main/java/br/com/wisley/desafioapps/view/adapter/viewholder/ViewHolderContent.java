package br.com.wisley.desafioapps.view.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.wisley.desafioapps.R;

/**
 * Created by Wisley on 13/09/17.
 * Content of All news
 */

public class ViewHolderContent extends RecyclerView.ViewHolder {


    private ImageView ivThumbnail;
    private TextView  tvEditorial;
    private TextView tvTittle;
    public ViewHolderContent(View view) {
        super(view);
        this.ivThumbnail = (ImageView) view.findViewById(R.id.ivThumbnail);
        this.tvEditorial = (TextView) view.findViewById(R.id.tvEditorial);
        this.tvTittle = (TextView) view.findViewById(R.id.tvTittle);
    }

    public ImageView getIvThumbnail() {
        return ivThumbnail;
    }

    public void setIvThumbnail(ImageView ivThumbnail) {
        this.ivThumbnail = ivThumbnail;
    }

    public TextView getTvEditorial() {
        return tvEditorial;
    }

    public void setTvEditorial(TextView tvEditorial) {
        this.tvEditorial = tvEditorial;
    }

    public TextView getTvTittle() {
        return tvTittle;
    }

    public void setTvTittle(TextView tvTittle) {
        this.tvTittle = tvTittle;
    }
}
