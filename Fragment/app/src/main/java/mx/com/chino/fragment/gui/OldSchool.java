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
import mx.com.chino.fragment.databinding.FragmentOldSchoolBinding;
import mx.com.chino.fragment.gui.components.GamesAdapter;
import mx.com.chino.fragment.gui.components.NavigationIconClickListener;
import mx.com.chino.fragment.model.Juego;

public class OldSchool extends Fragment {

    private FragmentOldSchoolBinding binding;
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
        MainActivity.GLOBALS.put("oldSchoolFragment",this);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentOldSchoolBinding.inflate(inflater,container,false);
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
                view.findViewById(R.id.gridOldSchool),
                new AccelerateDecelerateInterpolator(),
                context.getDrawable(R.drawable.menu),
                context.getDrawable(R.drawable.menu_open)
        ));
    }

    private void configUI() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){

            view.findViewById(R.id.gridOldSchool).setBackground(getContext().getDrawable(R.drawable.product_grid_background_shape));

        }
    }

    private void configRecycler() {

        juegos.add(new Juego(1,"ff","Final Fantasy",5,"Un gran juego de RPG"));
        juegos.add(new Juego(2,"onimusha", "Onimusha Warlords", 4, "Un joven samurai debe eliminar demonios"));
        juegos.add(new Juego(3,"fifa","Fifa 97",4,"Uno de los primeros fifas"));
        juegos.add(new Juego(4,"re", "Resident Evil 2", 5, "El comienzo de la infeccion en Racoon City"));

        binding.rclvOldSchool.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false);
        binding.rclvOldSchool.setLayoutManager(layoutManager);
        binding.rclvOldSchool.setAdapter(new GamesAdapter(juegos));

    }
}
