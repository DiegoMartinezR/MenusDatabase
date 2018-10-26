package diego.rayme.martinez.menusdatabase.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.github.curioustechizen.ago.RelativeTimeTextView;
import com.orm.SugarRecord;

import java.util.List;

import diego.rayme.martinez.menusdatabase.Home;
import diego.rayme.martinez.menusdatabase.R;
import diego.rayme.martinez.menusdatabase.modelo.Notas;
import diego.rayme.martinez.menusdatabase.repositories.NotasRepository;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolder> {
    private static final String TAG = NotaAdapter.class.getSimpleName();
    private List<Notas> notas;

    public NotaAdapter(List<Notas> notas) {
        this.notas = notas;
    }

    public void setNotas(List<Notas> notas) {
        this.notas = notas;
    }
    @NonNull
    @Override
    public NotaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notas,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final NotaAdapter.ViewHolder holder, final int position) {
        final Notas note = this.notas.get(position);
        int color = ColorGenerator.MATERIAL.getColor(note.getTitulo());
        TextDrawable drawable = TextDrawable.builder().buildRect(note.getTitulo().substring(0,1),color);
        holder.pictureImage.setImageDrawable(drawable);
        holder.titulo.setText(note.getTitulo());
        holder.descri.setText(note.getContenido());
        holder.fecha.setReferenceTime(note.getFecha().getTime());

        holder.archivar2.setChecked(note.getArchivar());

        holder.favorito.setChecked(note.getFavorito());


        holder.favorito.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                note.setFavorito(b);
                SugarRecord.save(note);
            }
        });
        holder.archivar2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                note.setArchivar(b);
                SugarRecord.save(note);
            }
        });
        holder.archivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotasRepository.eliminar(note.getId());
                notas.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,getItemCount());
                Toast.makeText(view.getContext(),"Nota Eliminada",Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Home.class);
                intent.putExtra("ID",note.getId());
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return  notas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titulo;
        public TextView descri;
        public RelativeTimeTextView fecha;
        public ImageView pictureImage;
        public ImageButton archivar;
        public CheckBox favorito;
        public CheckBox archivar2;
        public ViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView)itemView.findViewById(R.id.notas_titulo);
            descri = (TextView)itemView.findViewById(R.id.notas_descripcion);
            fecha = (RelativeTimeTextView)itemView.findViewById(R.id.notas_fecha);
            pictureImage = (ImageView)itemView.findViewById(R.id.picture_image);
            //Eliminar es el boton archivar

            archivar = (ImageButton)itemView.findViewById(R.id.archivar);
            favorito = (CheckBox)itemView.findViewById(R.id.favorito);

            archivar2 = (CheckBox)itemView.findViewById(R.id.archivar2);
        }
    }
  /*  public void updateFavorito(Boolean favorito,Long id){
        Nota nota = SugarRecord.findById(Nota.class,id);
        nota.setFavorito(true);
        SugarRecord.save(nota);
    }*/
}