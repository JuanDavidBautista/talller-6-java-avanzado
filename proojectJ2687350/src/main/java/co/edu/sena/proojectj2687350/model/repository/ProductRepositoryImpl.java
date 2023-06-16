package co.edu.sena.proojectj2687350.model.repository;

import co.edu.sena.proojectj2687350.model.Product;
import co.edu.sena.proojectj2687350.util.conecction_test.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements Repository<Product>{

    private String sql = null;

    @Override
    public List<Product> listAllObj() throws SQLException {
        sql = " select product_id, product_name , product_value , category_id from products  " ;
        List<Product> products = new ArrayList<>() ;
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement ();
             ResultSet rs = stmt.executeQuery (sql)) {
            while ( rs.next()) {
                Product p = createObj(rs);
                products.add(p);
            } // while
        } // try
        return products ;
    } // listAllObj



    @Override
    public Product byIdObj (Integer id) throws SQLException {
        sql = " select product_id , product_namne , prouct_value , category_id from products  where product_id = ? ";
        Product product = null;

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    product = createObj(rs);
                }
            }
            return product ;}}


    @Override
    public Integer saveObj(Product product) throws SQLException{
        int rowSAffected = 0;

        if (product.getProduct_id() != null && product.getProduct_id() > 0) {
            sql = "update products set product_name = ?, product_value = ?, category_id = ? where category_id = ?";
        } else {
            sql = "insert into products (product_name, product_value, category_id) values (?, ?, ?))";
        }

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, product.getProduct_name());
            ps.setInt(2, product.getProduct_value());
            ps.setInt(3, product.getCategory_id());

            if (product.getProduct_id() != null && product.getProduct_id() > 0) {
                ps.setInt(4, product.getProduct_id());
            }

            rowSAffected = ps.executeUpdate();
            return  rowSAffected ;}

    }


    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql = "delete from products where product_id = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();}
    }

    @Override
    public Product createObj (ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setProduct_id(rs.getInt("product_id"));
        product.setProduct_name(rs.getString("product_name"));
        product.setProduct_value(rs.getInt("product_value"));
        product.setCategory_id(rs.getInt("category_id"));
        return product;
    }


}
