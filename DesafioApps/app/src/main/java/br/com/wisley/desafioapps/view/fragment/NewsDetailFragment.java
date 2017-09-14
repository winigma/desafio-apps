package br.com.wisley.desafioapps.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.wisley.desafioapps.R;
import br.com.wisley.desafioapps.model.Content;
import br.com.wisley.desafioapps.view.holder.HolderNewsDetailFragment;

/**
 * Created by Wisley on 14/09/17.
 */

public class NewsDetailFragment extends Fragment {
    protected HolderNewsDetailFragment mHolder;
    private Content mContent;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mHolder = new HolderNewsDetailFragment(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
