package co.edu.sena.proojectj2687350.model.repository;

import co.edu.sena.proojectj2687350.model.User;

import java.sql.SQLException;

public class TestUserRepositoryImp {


    public static void main(String[] args) throws SQLException {
        Repository<User> repository = new UserRepositoryImpl();


        System.out.println("====== saveObj Insert ======");
        User userInsert = new User();
        userInsert.setUser_firstname("carlos");
        userInsert.setUser_lastname("rojas");
        userInsert.setUser_email("carlos@LoQueSea.com");
        userInsert.setUser_password("jfhbv123654");
        repository.saveObj(userInsert);
        userInsert.setUser_firstname("pEpE");
        userInsert.setUser_lastname("perez");
        userInsert.setUser_email("PEPE@correo.com");
        userInsert.setUser_password("46448biviewu");
        repository.saveObj(userInsert);


        System.out.println("====== byIdObj ======");
        System.out.println(repository.byIdObj(1));
        System.out.println();


        System.out.println("====== saveObj ======");
        User userUpdate = new User();
        userUpdate.setUser_id(2);
        userUpdate.setUser_firstname("jorge");
        userUpdate.setUser_lastname("palacios");
        userUpdate.setUser_email("jorge@example.com");
        userUpdate.setUser_password("48iufduwgd");
        repository.saveObj(userInsert);
        repository.listAllObj().forEach(System.out::println);
        System.out.println();


        System.out.println("====== deleteObj ======");
        repository.deleteObj(2);
        repository.listAllObj().forEach(System.out::println);
    }
}
