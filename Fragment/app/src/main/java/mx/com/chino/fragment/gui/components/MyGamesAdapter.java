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

import java.util.List;

import mx.com.chino.fragment.R;
import mx.com.chino.fragment.gui.MyGames;
import mx.com.chino.fragment.model.MyGame;

public class MyGamesAdapter extends RecyclerView.Adapter<MyGamesAdapter.ViewHolder> {
    private List<MyGame> myGames;
    private Context context;

    public MyGamesAdapter(List<MyGame> myGames) {
        this.myGames = myGames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_my_game,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        MyGame myGame = myGames.get(position);
        String imgUri = "@drawable/"+ myGame.getImagen();
        int imgResource = context.getResources().getIdentifier
                (imgUri,null,context.getPackageName());
        holder.imgMisjuegos.setImageResource(imgResource);
        holder.txtTitulo.setText(myGame.getTitulo());
        holder.rbClasificacion.setRating(myGame.getClasificacion());
        holder.txtDescripcion.setText(myGame.getDescripcion());
    }
    @Override
    public int getItemCount() {
        return myGames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private AppCompatImageView imgMisjuegos;
        private TextView txtTitulo;
        private AppCompatRatingBar rbClasificacion;
        private  TextView txtDescripcion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMisjuegos= itemView.findViewById(R.id.imgJuego);
            txtTitulo = itemView.findViewById(R.id.txtDescripcion);
            rbClasificacion = itemView.findViewById(R.id.rbClasificacion);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
            this.view= itemView;
        }
    }
}
