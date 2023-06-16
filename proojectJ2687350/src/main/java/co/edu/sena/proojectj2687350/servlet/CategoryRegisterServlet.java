package co.edu.sena.proojectj2687350.servlet;

import co.edu.sena.proojectj2687350.model.Category;
import co.edu.sena.proojectj2687350.model.Product;
import co.edu.sena.proojectj2687350.model.repository.CategoryRepositoryImpl;
import co.edu.sena.proojectj2687350.model.repository.ProductRepositoryImpl;
import co.edu.sena.proojectj2687350.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class CategoryRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  collect all form data
        String category_name = request.getParameter("category_name");


        //  fill it up in a User Bean
        Category category = new Category();
        category.setCategory_name(category_name);



        // call repository layer and save the user object to DB
        Repository<Category> repository = new CategoryRepositoryImpl();
        int rows = 0;
        try {
            repository.saveObj(category);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //todo prepare message for user about success
        //String message = null

        if(rows==0){
            System.out.println("Ocurrio un error");
        }else{
            System.out.println("Registro exitoso");
        }

        // todo write the message back to the page in client browser
    }
}
