package br.com.wisley.desafioapps.view.holder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.wisley.desafioapps.R;

/**
 * Created by Wisley on 12/09/17.
 */

public class HolderHomeFragment extends AbstractHolderFragment {

    private RelativeLayout topNews;
    private TextView tvMainEditorial;
    private TextView tvTittleMain;

    public HolderHomeFragment(View siteSelectionView) {
        super(siteSelectionView);
    }

    /**
     * Initilize all fields in view
     */
    @Override
    protected void initializeFields() {
        this.topNews = (RelativeLayout) getField(R.id.topNews);
        this.tvMainEditorial = (TextView) getField(R.id.tvMainEditorial);
        this.tvTittleMain = (TextView) getField(R.id.tvTittleMain);
    }

    @Override
    protected void initializeActions() {

    }

    public RelativeLayout getTopNews() {
        return topNews;
    }

    public TextView getTvMainEditorial() {
        return tvMainEditorial;
    }

    public TextView getTvTittleMain() {
        return tvTittleMain;
    }
}
