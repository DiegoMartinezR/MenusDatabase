package diego.rayme.martinez.menusdatabase.repositories;

import com.orm.SugarRecord;

import java.util.List;

import diego.rayme.martinez.menusdatabase.modelo.User;

public class UserRepository {
    public static String nombre  = "";
    public static List<User> list(){
        List<User> users = SugarRecord.listAll(User.class);
        return users;
    }

    public static User read(Long id){
        User user = SugarRecord.findById(User.class, id);
        return user;
    }

    public static void create(String nombre, String usuario, String email, String password){
        User user = new User();
        user.setNombre(nombre);
        user.setUsuario(usuario);
        user.setContrasena(password);
        user.setCorreo(email);
        SugarRecord.save(user);
    }

    public static Boolean inicio(String usuario,String contraseña){
        List<User> users = SugarRecord.listAll(User.class);
        for (User user: users) {
            if (user.getNombre().equalsIgnoreCase(usuario) && user.getContrasena().equals(contraseña)){
                nombre = user.getUsuario();
                System.out.println(nombre);
                return true;
            }
        }
        return false;
    }

}
