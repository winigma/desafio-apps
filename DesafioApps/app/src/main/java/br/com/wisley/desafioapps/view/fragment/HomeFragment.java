package br.com.wisley.desafioapps.view.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import br.com.wisley.desafioapps.R;
import br.com.wisley.desafioapps.model.Content;
import br.com.wisley.desafioapps.model.Result;
import br.com.wisley.desafioapps.model.response.ErrorResponse;
import br.com.wisley.desafioapps.presenter.PresenterContent;
import br.com.wisley.desafioapps.presenter.interfaces.IContentCallback;
import br.com.wisley.desafioapps.util.ActivityUtils;
import br.com.wisley.desafioapps.view.activity.MainActivity;
import br.com.wisley.desafioapps.view.adapter.NewsAdapter;
import br.com.wisley.desafioapps.view.holder.HolderHomeFragment;
import br.com.wisley.desafioapps.view.interfaces.OnClickDetail;

/**
 * Created by Wisley on 12/09/17.
 */

public class HomeFragment extends Fragment implements IContentCallback, OnClickDetail {

    private HolderHomeFragment mHolder;
    private PresenterContent mPresenter;
    private NewsAdapter mAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new PresenterContent(this);
        mPresenter.notifyStart();
        initializeView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mHolder = new HolderHomeFragment(view);

        return view;
    }

    @Override
    public void notifyError(ErrorResponse errorResponse) {
        Toast.makeText(getActivity(), "Error", Toast.LENGTH_LONG).show();
        mHolder.getRvBody().setVisibility(View.GONE);
        mHolder.getIvError().setVisibility(View.VISIBLE);
        mHolder.getTvError().setVisibility(View.VISIBLE);
    }

    @Override
    public void notifyStart() {

    }

    @Override
    public void notifySucces(final Result reponse) {
        mHolder.getRvBody().setVisibility(View.VISIBLE);
        mHolder.getIvError().setVisibility(View.GONE);
        mHolder.getTvError().setVisibility(View.GONE);
        reponse.getConteudos().get(0).setHeader(true);
        this.mAdapter = new NewsAdapter(reponse.getConteudos(), this);
        this.mHolder.getRvBody().setAdapter(this.mAdapter);

    }

    /**
     * call other fragment
     *
     * @param position
     */
    @Override
    public void onClickOpenDetail(final int position) {
        Content mContent = mAdapter.getItem(position);
        //case is materia open in app
        if (mContent.getTipo().equalsIgnoreCase("materia")) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(NewsDetailFragment.KEY_CONTENT, mAdapter.getItem(position));
            NewsDetailFragment frag = new NewsDetailFragment();
            frag.setArguments(bundle);
            ActivityUtils.replaceFragmentToActivityWithBackStack(getActivity().
                    getSupportFragmentManager(), frag, R.id.home_container);
        } else {
            //case not is materia open in exteral link
            Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mContent.getUrl()));
            startActivity(browserIntent);
        }

    }

    private void initializeView() {
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);
        ((MainActivity) getActivity()).enableLogo(true);
    }
}
