package co.edu.sena.proojectj2687350.model.repository;

import co.edu.sena.proojectj2687350.model.User;
import co.edu.sena.proojectj2687350.util.conecction_test.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements Repository<User>{
    private String sql = null;

    @Override
    public List<User> listAllObj() throws SQLException {
        sql = " select user_id, user_firstname , user_lastname , user_email, user_password from users_tbl order by user_lastname , user_firstname " ;
        List<User> users = new ArrayList<>() ;
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement ();
             ResultSet rs = stmt.executeQuery (sql)) {
            while ( rs.next()) {
                User u = createObj(rs);
                users.add(u);
            } // while
        } // try
        return users ;
    } // listAllObj



    @Override
    public User byIdObj (Integer id) throws SQLException {
        sql = " select user_id , user_firstname , user_lastname , user_email , user_password from users_tbl  where user_id = ? ";
        User user = null;

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = createObj(rs);
                }
            }
            return user ;}}




    @Override
    public Integer saveObj(User user) throws SQLException{
        int rowSAffected = 0;

        if (user.getUser_id() != null && user.getUser_id() > 0) {
            sql = "update users_tbl set user_firstname = ?, user_lastname = ?, user_email = ?, " +
                    "user_password = aes_encrypt(?, '$2a$12$JN0yilj9Qsc8e.aIIcEANuJiTE/CyTJKWfBIH3swVkXgyQ7h5O5QK') " +
                    "where user_id = ?";
        } else {
            sql = "insert into users_tbl (user_firstname, user_lastname, user_email, user_password) " +
                    "values (upper(?), upper(?), lower(?), aes_encrypt(?, '$2a$12$JN0yilj9Qsc8e.aIIcEANuJiTE/CyTJKWfBIH3swVkXgyQ7h5O5QK'))";
        }

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getUser_firstname());
            ps.setString(2, user.getUser_lastname());
            ps.setString(3, user.getUser_email());
            ps.setString(4, user.getUser_password());

            if (user.getUser_id() != null && user.getUser_id() > 0) {
                ps.setInt(5, user.getUser_id());
            }

            rowSAffected = ps.executeUpdate();
            return  rowSAffected ;}

    }


    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql = "delete from users_tbl where user_id = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();}
    }

    @Override
    public User createObj (ResultSet rs) throws SQLException {
        User user = new User();
        user.setUser_id(rs.getInt("user_id"));
        user.setUser_firstname(rs.getString("user_firstname"));
        user.setUser_lastname(rs.getString("user_lastname"));
        user.setUser_email(rs.getString("user_email"));
        user.setUser_password(rs.getString("user_password"));
        return user;
    }


}
