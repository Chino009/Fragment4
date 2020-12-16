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
import mx.com.chino.fragment.databinding.FragmentCategoriasBinding;
import mx.com.chino.fragment.gui.components.CategoriaAdapter;
import mx.com.chino.fragment.gui.components.NavigationIconClickListener;
import mx.com.chino.fragment.model.Categoria;

public class Categorias extends Fragment {

    private FragmentCategoriasBinding binding;
    private View view;
    private Context context;
    private List<Categoria> categoria = new ArrayList<>();


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
        MainActivity.GLOBALS.put("CategoriasFragment",this);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentCategoriasBinding.inflate(inflater,container,false);
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
                view.findViewById(R.id.gridCategorias),
                new AccelerateDecelerateInterpolator(),
                context.getDrawable(R.drawable.menu),
                context.getDrawable(R.drawable.menu_open)
        ));
    }

    private void configUI() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            view.findViewById(R.id.gridCategorias).setBackground(getContext().getDrawable(R.drawable.product_grid_background_shape));
        }
    }

    private void configRecycler() {

        categoria.add(new Categoria(1,"ic_shooter","Shooter"));
        categoria.add(new Categoria(2,"ic_aventura","Aventura"));
        categoria.add(new Categoria(3,"ic_estrategia","Estrategia"));
        categoria.add(new Categoria(4,"ic_deportes","Deportes"));


        binding.rclvCategorias.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL,false);
        binding.rclvCategorias.setLayoutManager(layoutManager);
        binding.rclvCategorias.setAdapter(new CategoriaAdapter(categoria));
    }

}
