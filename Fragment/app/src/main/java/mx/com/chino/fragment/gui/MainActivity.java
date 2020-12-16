package mx.com.chino.fragment.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import java.util.HashMap;

import mx.com.chino.fragment.R;
import mx.com.chino.fragment.core.FragmentosApplication;
import mx.com.chino.fragment.gui.components.Navigation;

public class MainActivity extends AppCompatActivity implements Navigation {

    public  static HashMap <String, Object> GLOBALS = new HashMap<>();

    private MaterialButton mnTopGames;
    private MaterialButton mnRank;
    private MaterialButton mnFreeToPlay;
    private MaterialButton mnMyGames;
    private MaterialButton mnCategoria;
    private MaterialButton mnOldSchool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mnTopGames =findViewById(R.id.mnTopGames);
        mnRank =findViewById(R.id.mnRank);
        mnFreeToPlay =findViewById(R.id.mnFreetoPlay);
        mnMyGames =findViewById(R.id.mnMyGames);
        mnCategoria =findViewById(R.id.mnCategorias);
        mnOldSchool =findViewById(R.id.mnOldSchool);


        setContentView(R.layout.activity_main);

        configContext();
        configGlobals();

        configFragmentManager(savedInstanceState);

    }

    private void configContext() {

        FragmentosApplication.setAppContext(getApplicationContext());
    }

    private void configGlobals() {
        GLOBALS.put("app",this);
    }

    private void configFragmentManager(Bundle savedInstanceState) {

        if(savedInstanceState==null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentPanel, new TopGames())
                    .commit();

        }
    }

    @Override
    public void navigateTo (Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(
                                R.animator.slide_in_left,
                                R.animator.slide_out_right,
                                R.animator.slide_in_right,
                                R.animator.slide_out_left)

                        .replace(R.id.contentPanel,fragment);
        if(addToBackStack)
            transaction.addToBackStack(null);
        transaction.commit();

    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.mnTopGames:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contentPanel, new TopGames())
                        .commit();
                break;
            case R.id.mnCategorias:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contentPanel, new Categorias())
                        .commit();
                break;
            case R.id.mnFreetoPlay:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contentPanel, new FreeToPlay())
                        .commit();
                break;
            case R.id.mnMyGames:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contentPanel, new MyGames())
                        .commit();

                break;
            case R.id.mnOldSchool:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contentPanel, new OldSchool())
                        .commit();

            case R.id.mnRank:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contentPanel, new Rank())
                        .commit();
                break;
        }


    }
}