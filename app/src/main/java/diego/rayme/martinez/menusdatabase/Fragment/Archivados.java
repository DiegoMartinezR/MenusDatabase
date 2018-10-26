package diego.rayme.martinez.menusdatabase.Fragment;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.List;

import diego.rayme.martinez.menusdatabase.R;
import diego.rayme.martinez.menusdatabase.adapters.NotaAdapter;
import diego.rayme.martinez.menusdatabase.modelo.Notas;
import diego.rayme.martinez.menusdatabase.repositories.NotasRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class Archivados extends Fragment {

    private RecyclerView recyclerView;
    private CheckBox detalle_archivado;
    public Archivados() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_archivados, container, false);
        detalle_archivado = (CheckBox)view.findViewById(R.id.detalle_archivado);
        recyclerView = (RecyclerView)view.findViewById(R.id.mostrar_item_archivados);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Notas> archivados = NotasRepository.listarArchivados();
        if (archivados.isEmpty()){
            Toast.makeText(getContext(),"NO HAY DATOS",Toast.LENGTH_SHORT).show();
        }else{
            recyclerView.setAdapter(new NotaAdapter(archivados));
        }
        return view;
    }
    public void onButtonPressed(Uri uri) {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        NotaAdapter notaAdaptador = (NotaAdapter)recyclerView.getAdapter();
        List<Notas> notas = NotasRepository.listarArchivados();
        notaAdaptador.setNotas(notas);
        notaAdaptador.notifyDataSetChanged();
    }
    public void m(){

    }
}
