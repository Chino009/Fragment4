package mx.com.chino.fragment.gui.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentViewHolder;

import java.util.List;

import mx.com.chino.fragment.R;
import mx.com.chino.fragment.model.Juego;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ViewHolder>  {

    private List<Juego> games;
    private Context context;

    public GamesAdapter(List<Juego> games) {
        this.games = games;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_juego,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GamesAdapter.ViewHolder holder, int position) {
        Juego juego = games.get(position);
        String imgUri = "@drawable/"+ juego.getImagen();
        int imgResource =  context.getResources().getIdentifier
                (imgUri,null,context.getPackageName());
        holder.imgJuego.setImageResource(imgResource);

        holder.txtTitulo.setText(juego.getTitulo());
        holder.rbClasificacion.setRating(juego.getClasificacion());
        holder.txtDescripcion.setText(juego.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private AppCompatImageView imgJuego;
        private TextView txtTitulo;
        private AppCompatRatingBar rbClasificacion;
        private TextView txtDescripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgJuego = itemView.findViewById(R.id.imgJuego);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            rbClasificacion = itemView.findViewById(R.id.rbClasificacion);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
            this.view = itemView;
        }
    }
    }
