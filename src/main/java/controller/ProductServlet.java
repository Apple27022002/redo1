package controller;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
import model.Product;
import service.CategoryService;
import service.ProductService;
import service.ProductServiceimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceimpl();
    CategoryService categoryService = new CategoryImpl();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getParameter("act");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateFrom(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            default:showList(request,response);
        }



    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("sua",product);
        request.getRequestDispatcher("product/edit.jsp").forward(request,response);

    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("xoa", product);
        request.getRequestDispatcher("product/delete.jsp").forward(request, response);
    }

    //Tìm kiếm gần đúng with no sql va hien thi danh sach
    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> productList;
        if (name != null & name != "") {
            productList = productService.findByName(name);
        } else {
            productList = productService.findAll();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        request.setAttribute("ds",productList);
        dispatcher.forward(request,response);
    }



    private void showCreateFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("product/create.jsp").forward(request,response);
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("product/create.jsp").forward(request,response);
        String act = request.getParameter("act");
        if (act == null) {
            act = "";
        }
        switch (act) {
            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
        }


    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Locale.Category category = categoryService.findById(categoryId);
        Product product = new Product(id, name);
        productService.update(product);
        response.sendRedirect("/products");
    }


    private void create(HttpServletRequest request, HttpServletResponse response) {
    }
}
