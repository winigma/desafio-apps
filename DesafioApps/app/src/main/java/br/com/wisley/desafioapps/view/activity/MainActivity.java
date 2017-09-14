package br.com.wisley.desafioapps.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.wisley.desafioapps.R;
import br.com.wisley.desafioapps.util.ActivityUtils;
import br.com.wisley.desafioapps.view.fragment.HomeFragment;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    TextView title;
    ImageView logo;
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), new HomeFragment(), R.id.home_container);
        initializeView();

    }

    private void initializeView(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        logo = (ImageView) findViewById(R.id.ivToolbar);
        title = (TextView) findViewById(R.id.toolbarTitle);
        setSupportActionBar(mToolbar);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void showCustomTitle(final String tittle){
        title.setText(tittle);

    }
    public void enableLogo(final boolean isVisible){
        if(isVisible){
            logo.setVisibility(View.VISIBLE);
            title.setVisibility(View.GONE);
        }else{
            logo.setVisibility(View.GONE);
            title.setVisibility(View.VISIBLE);
        }
    }
}
