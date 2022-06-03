package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CategoryServlet", value = "/categories")
public class CategoryServlet extends HttpServlet {
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
            default:showList(request,response);
            }




        }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("category/list.jsp").forward(request, response);
    }

    private void showCreateFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("category/create.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("category/create").forward(request,response);

    }
}
