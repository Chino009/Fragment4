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
import mx.com.chino.fragment.databinding.FragmentFreeToPlayBinding;
import mx.com.chino.fragment.gui.components.GamesAdapter;
import mx.com.chino.fragment.gui.components.NavigationIconClickListener;
import mx.com.chino.fragment.model.Juego;

public class FreeToPlay extends Fragment {

    private FragmentFreeToPlayBinding binding;
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
        MainActivity.GLOBALS.put("freeToPlayFragment",this);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentFreeToPlayBinding.inflate(inflater,container,false);
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
                view.findViewById(R.id.gridFreeToPlay),
                new AccelerateDecelerateInterpolator(),
                context.getDrawable(R.drawable.menu),
                context.getDrawable(R.drawable.menu_open)
        ));
    }

    private void configUI() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            view.findViewById(R.id.gridFreeToPlay).
                    setBackground(getContext().getDrawable(R.drawable.product_grid_background_shape));
        }
    }

    private void configRecycler() {
        juegos.add(new Juego(1,"among","Among Us",5,"Ser o no ser funado"));
        juegos.add(new Juego(2,"fortnite","Fornite",1,"Juego popular por niños"));
        juegos.add(new Juego(3,"mariorun","Super Mario Run",3,"Simplemente mario"));
        juegos.add(new Juego(4,"codm","Call Of Duty Mobile", 3, "Comienza la guerra ahora desde el celular"));

        binding.rclvFreeToPlay.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false);
        binding.rclvFreeToPlay.setLayoutManager(layoutManager);
        binding.rclvFreeToPlay.setAdapter(new GamesAdapter(juegos));

    }
}
