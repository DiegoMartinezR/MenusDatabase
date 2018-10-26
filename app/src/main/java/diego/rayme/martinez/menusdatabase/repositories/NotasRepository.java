package diego.rayme.martinez.menusdatabase.repositories;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import diego.rayme.martinez.menusdatabase.modelo.Notas;
import diego.rayme.martinez.menusdatabase.modelo.User;

public class NotasRepository {


    public static List<Notas> listar(){
        List<Notas> notas = SugarRecord.listAll(Notas.class);
        return notas;
    }
    public static Notas get(Long id){
        List<Notas> notas = SugarRecord.listAll(Notas.class);
        for (Notas nota : notas){
            if (nota.getId().equals(id)){
                return nota;
            }
        }
        return null;
    }
    public static void registrar(String titulo, String descripcion, Date fecha, Boolean favorito, Boolean archivar){
        Notas nota = new Notas(titulo,descripcion,fecha,favorito,archivar);
        SugarRecord.save(nota);
    }
    public static void eliminar(Long id){
        Notas nota = SugarRecord.findById(Notas.class,id);
        SugarRecord.delete(nota);
    }

    public static List<Notas> listarFavoritos(){
        List<Notas> notas =SugarRecord.listAll(Notas.class);
        List<Notas> favoritos = new ArrayList<>();
        for (Notas nota :  notas) {
            if (nota.getFavorito()){
                favoritos.add(nota);
            }
        }
        return favoritos;
    }

    public static List<Notas> listarArchivados(){
        List<Notas> notas =SugarRecord.listAll(Notas.class);
        List<Notas> archivados = new ArrayList<>();
        for (Notas nota: notas) {
            if (nota.getArchivar()){
                archivados.add(nota);
            }
        }
        return archivados;
    }

}
