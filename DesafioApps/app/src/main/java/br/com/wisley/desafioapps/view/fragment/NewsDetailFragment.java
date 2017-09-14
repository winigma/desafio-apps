package br.com.wisley.desafioapps.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import br.com.wisley.desafioapps.R;
import br.com.wisley.desafioapps.model.Content;
import br.com.wisley.desafioapps.view.activity.MainActivity;
import br.com.wisley.desafioapps.view.holder.HolderNewsDetailFragment;

/**
 * Created by Wisley on 14/09/17.
 */

public class NewsDetailFragment extends Fragment {
    public static final String KEY_CONTENT = "key_content";
    protected HolderNewsDetailFragment mHolder;
    private Content mContent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.getArguments() != null) {
            mContent = this.getArguments().getParcelable(KEY_CONTENT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        mHolder = new HolderNewsDetailFragment(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeView();
    }

    private void initializeView() {
        /**
         * Toolbar
         */
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((MainActivity) getActivity()).enableLogo(false);
        ((MainActivity) getActivity()).showCustomTitle(mContent.getSecao().getNome());


        /**
         * itens view
         */
        mHolder.getTvTitle().setText(this.mContent.getTitulo());
        mHolder.getTvSubTitle().setText(this.mContent.getSubTitulo());
        mHolder.getTvDate().setText(this.mContent.getPublicadoEm());


        //valida se existe autor, pois alguns dados esse item estar estao nulos
        if (this.mContent.getAutores() != null && this.mContent.getAutores().size() > 1)
            mHolder.getTvAuthor().setText(this.mContent.author());
        else
            mHolder.getTvAuthor().setVisibility(View.GONE);

        if (this.mContent.getImagens() != null && this.mContent.getImagens().size()>0){
            Picasso.with(getActivity())
                    .load(this.mContent.getImagens().get(0).getUrl())
                    .error(R.drawable.logo_oglobo)
                    .placeholder(R.drawable.logo_oglobo)
                    .fit()
                    .into(mHolder.getIvThumbnail());
            mHolder.getTvImgLegend().setText(mContent.getImagens().get(0).copyRights());
        }else{
            mHolder.getRlImage().setVisibility(View.GONE);
        }

        mHolder.getTvContent().setText(this.mContent.getTexto());


    }
}
