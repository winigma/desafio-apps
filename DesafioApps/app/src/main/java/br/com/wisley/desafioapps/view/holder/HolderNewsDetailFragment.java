package br.com.wisley.desafioapps.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.wisley.desafioapps.R;

/**
 * Created by Wisley on 14/09/17.
 * Holder Fragment Detail
 *
 */

public class HolderNewsDetailFragment extends  AbstractHolderFragment {


    private TextView tvTitle;
    private TextView tvSubTitle;
    private TextView tvAuthor;
    private TextView tvDate;
    private RelativeLayout rlImage;
    private ImageView ivThumbnail;
    private TextView tvImgLegend;
    private TextView tvContent;



    public HolderNewsDetailFragment(View siteSelectionView) {
        super(siteSelectionView);
    }

    @Override
    protected void initializeFields() {
        this.tvTitle = (TextView) getField(R.id.tvTitle);
        this.tvSubTitle = (TextView) getField(R.id.tvSubTitle);
        this.tvAuthor = (TextView) getField(R.id.tvAuthor);
        this.tvDate = (TextView) getField(R.id.tvDate);
        this.rlImage = (RelativeLayout) getField(R.id.rlImage);
        this.ivThumbnail = (ImageView) getField(R.id.ivThumbnail);
        this.tvImgLegend = (TextView) getField(R.id.tvImgLegend);
        this.tvContent = (TextView) getField(R.id.tvContent);


    }

    @Override
    protected void initializeActions() {

    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public void setTvTitle(TextView tvTitle) {
        this.tvTitle = tvTitle;
    }

    public TextView getTvSubTitle() {
        return tvSubTitle;
    }

    public void setTvSubTitle(TextView tvSubTitle) {
        this.tvSubTitle = tvSubTitle;
    }

    public TextView getTvAuthor() {
        return tvAuthor;
    }

    public void setTvAuthor(TextView tvAuthor) {
        this.tvAuthor = tvAuthor;
    }

    public TextView getTvDate() {
        return tvDate;
    }

    public void setTvDate(TextView tvDate) {
        this.tvDate = tvDate;
    }

    public RelativeLayout getRlImage() {
        return rlImage;
    }

    public void setRlImage(RelativeLayout rlImage) {
        this.rlImage = rlImage;
    }

    public ImageView getIvThumbnail() {
        return ivThumbnail;
    }

    public void setIvThumbnail(ImageView ivThumbnail) {
        this.ivThumbnail = ivThumbnail;
    }

    public TextView getTvImgLegend() {
        return tvImgLegend;
    }

    public void setTvImgLegend(TextView tvImgLegend) {
        this.tvImgLegend = tvImgLegend;
    }

    public TextView getTvContent() {
        return tvContent;
    }

    public void setTvContent(TextView tvContent) {
        this.tvContent = tvContent;
    }
}
