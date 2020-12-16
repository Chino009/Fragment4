package mx.com.chino.fragment.gui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mx.com.chino.fragment.R;
import mx.com.chino.fragment.databinding.FragmentRankBinding;
import mx.com.chino.fragment.gui.components.GamesAdapter;
import mx.com.chino.fragment.gui.components.NavigationIconClickListener;
import mx.com.chino.fragment.model.Juego;

public class Rank extends Fragment {
    private FragmentRankBinding binding;
    private View view;
    private Context context;
    private List<Juego> juegos = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        configGlobals();
        configView(inflater,container);
        configToolbar();
        configUI();
        configRecycler();
        return view;
    }

    private void configGlobals() {
        MainActivity.GLOBALS.put("topRankeadosFragment",this);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentRankBinding.inflate(inflater,container,false);
        view = binding.getRoot();
        context = container.getContext();
    }

    private void configToolbar() {
        AppCompatActivity activity = (AppCompatActivity)getActivity();
        if(activity!=null){
            activity.setSupportActionBar(binding.appBar);
        }
        binding.appBar.setNavigationOnClickListener(new NavigationIconClickListener(
                context,
                view.findViewById(R.id.gridRank),
                new AccelerateDecelerateInterpolator(),
                context.getDrawable(R.drawable.menu),
                context.getDrawable(R.drawable.menu_open)
        ));
    }

    private void configUI() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            view.findViewById(R.id.gridRank).setBackground(getContext().getDrawable(R.drawable.product_grid_background_shape));
        }
    }

    private void configRecycler() {
        juegos.add(new Juego(1,"persona","Persona 5 The Royal", 5, "Roban corazones"));
        juegos.add(new Juego(2,"ff","Final Fantasy",5,"Un gran juego de RPG"));
        juegos.add(new Juego(3,"cod","cod", 3, "Comienza la guerra"));
        juegos.add(new Juego(4,"supersmash","Super Smash Bros",5,"Gran juego de peleas entre amigos"));
        juegos.add(new Juego(5,"fifa","Fifa 97",4,"Uno de los primeros fifas"));

        binding.rclvRank.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false);
        binding.rclvRank.setLayoutManager(layoutManager);
        binding.rclvRank.setAdapter(new GamesAdapter(juegos));

    }
}
