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
import mx.com.chino.fragment.databinding.FragmentMyGameBinding;
import mx.com.chino.fragment.gui.components.MyGamesAdapter;
import mx.com.chino.fragment.gui.components.NavigationIconClickListener;
import mx.com.chino.fragment.model.MyGame;

public class MyGames extends Fragment {

    private FragmentMyGameBinding binding;
    private View view;
    private Context context;
    private List<MyGame> myGames = new ArrayList<>();


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
        MainActivity.GLOBALS.put("myGamesFragment",this);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentMyGameBinding.inflate(inflater,container,false);

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
                view.findViewById(R.id.gridMyGames),
                new AccelerateDecelerateInterpolator(),
                context.getDrawable(R.drawable.menu),
                context.getDrawable(R.drawable.menu_open)
        ));

    }

    private void configUI() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            view.findViewById(R.id.gridMyGames).setBackground(getContext().getDrawable(R.drawable.product_grid_background_shape));
        }
    }

    private void configRecycler() {
        myGames.add(new MyGame(1,"persona","Persona 5 The Royal",5,"Roban corazones"));
        myGames.add(new MyGame(2,"re","Resident Evil 2",5,"El comienzo de la infeccion en Racoon City"));
        myGames.add(new MyGame(3,"onimusha","Onimusha Warlords",5,"Un joven samurai debe eliminar demonios"));
        myGames.add(new MyGame(4,"tlou","The Last Of Us II",4,"En busca de venganza"));

        binding.rclvMyGames.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL,false);
        binding.rclvMyGames.setLayoutManager(layoutManager);
        binding.rclvMyGames.setAdapter(new MyGamesAdapter(myGames));
    }


}
