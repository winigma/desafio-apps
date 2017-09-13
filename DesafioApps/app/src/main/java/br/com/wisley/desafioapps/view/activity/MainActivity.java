package br.com.wisley.desafioapps.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.wisley.desafioapps.R;
import br.com.wisley.desafioapps.util.ActivityUtils;
import br.com.wisley.desafioapps.view.fragment.HomeFragment;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), new HomeFragment(), R.id.home_container);

    }
}
