package br.com.wisley.desafioapps.view.fragment;

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
import br.com.wisley.desafioapps.view.holder.HolderHomeFragment;

/**
 * Created by Wisley on 12/09/17.
 */

public class HomeFragment extends Fragment implements IContentCallback {

    private HolderHomeFragment mHolder;
    private PresenterContent mPresenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter =  new PresenterContent(this);
        mPresenter.notifyStart();
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
        Toast.makeText(getActivity(),"Error",Toast.LENGTH_LONG).show();
    }

    @Override
    public void notifyStart() {

    }

    @Override
    public void notifySucces(Result reponse) {

        Toast.makeText(getActivity(),"Sucesso",Toast.LENGTH_LONG).show();
    }
}
