package br.com.wisley.desafioapps.view.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.wisley.desafioapps.R;

/**
 * Created by Wisley on 13/09/17.
 * this class contain header, or first item of recycleview
 */

public class ViewHolderHeader extends RecyclerView.ViewHolder {

    private RelativeLayout rlTopNews;
    private TextView tvMainEditorial;
    private TextView tvTittleMain;

    public ViewHolderHeader(View view) {
        super(view);

        this.rlTopNews = (RelativeLayout) view.findViewById(R.id.topNews);
        this.tvMainEditorial = (TextView) view.findViewById(R.id.tvMainEditorial);
        this.tvTittleMain = (TextView) view.findViewById(R.id.tvTittleMain);
    }

    public RelativeLayout getRlTopNews() {
        return rlTopNews;
    }

    public void setRlTopNews(RelativeLayout rlTopNews) {
        this.rlTopNews = rlTopNews;
    }

    public TextView getTvMainEditorial() {
        return tvMainEditorial;
    }

    public void setTvMainEditorial(TextView tvMainEditorial) {
        this.tvMainEditorial = tvMainEditorial;
    }

    public TextView getTvTittleMain() {
        return tvTittleMain;
    }

    public void setTvTittleMain(TextView tvTittleMain) {
        this.tvTittleMain = tvTittleMain;
    }
}
