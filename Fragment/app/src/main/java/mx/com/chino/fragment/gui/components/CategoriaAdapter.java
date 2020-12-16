package mx.com.chino.fragment.gui.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mx.com.chino.fragment.R;
import mx.com.chino.fragment.gui.Categorias;
import mx.com.chino.fragment.model.Categoria;

public class CategoriaAdapter extends RecyclerView.Adapter <CategoriaAdapter.ViewHolder> {
    private List<Categoria> categorias;
    private Context context;

    public CategoriaAdapter(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_categoria,parent,false);
        context = parent.getContext();
        return  new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Categoria categoria = categorias.get(position);
        String imgUri = "@drawable/"+categoria.getImagen();
        int imgResource = context.getResources().getIdentifier
                (imgUri,null,context.getPackageName());
        holder.imgCategoria.setImageResource(imgResource);
        holder.txtNombreCategoria.setText(categoria.getNomCategoria());

    }
    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public class   ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private AppCompatImageView imgCategoria;
        private TextView txtNombreCategoria;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCategoria= itemView.findViewById(R.id.imgCategoria);
            txtNombreCategoria= itemView.findViewById(R.id.txtNombrecategoria);
            this.view = itemView;
        }
    }
}
