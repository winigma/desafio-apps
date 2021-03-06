package br.com.wisley.desafioapps.view.holder;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.wisley.desafioapps.R;

/**
 * Created by Wisley on 12/09/17.
 */

public class HolderHomeFragment extends AbstractHolderFragment {

    private RecyclerView rvBody;
    private TextView tvError;
    private ImageView ivError;


    public HolderHomeFragment(View siteSelectionView) {
        super(siteSelectionView);
    }

    /**
     * Initilize all fields in view
     */
    @Override
    protected void initializeFields() {
        this.rvBody = (RecyclerView) getField(R.id.rvBody);
        this.tvError = (TextView) getField(R.id.tvError);
        this.ivError = (ImageView) getField(R.id.ivError);

    }

    @Override
    protected void initializeActions() {
        rvBody.setHasFixedSize(true);
        rvBody.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvBody.setNestedScrollingEnabled(false);
    }

    public RecyclerView getRvBody() {
        return rvBody;
    }

    public void setRvBody(RecyclerView rvBody) {
        this.rvBody = rvBody;
    }

    public TextView getTvError() {
        return tvError;
    }

    public ImageView getIvError() {
        return ivError;
    }
}
