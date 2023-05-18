package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService;
    @Override
    public void init() throws ServletException {
        productService = new ProductServiceImp();
        productService.initProducts();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateProduct(request,response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "view":
                showDetailProduct(request,response);
                break;
            default:
                showListProducts(request,response);
                break;
        }
    }

    private void showCreateProduct(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/products/created.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showDetailProduct(HttpServletRequest request, HttpServletResponse response) {
        int index = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getAll().get(index);
        request.setAttribute("product",product);
        try {
            request.getRequestDispatcher("/products/view.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showListProducts(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("list",productService.getAll());
        try {
            request.getRequestDispatcher("/products/list.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addNewProduct(request,response);
                break;
            case "edit":
                updateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "view":
                showDetailProduct(request,response);
                break;
            default:
                showListProducts(request,response);
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        //only update of prices
        int index = Integer.parseInt(request.getParameter("product_id"));
        Product product = productService.findProductByIndex(index);
        long prices = Long.parseLong(request.getParameter("product_price"));
        product.setPrice(prices);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addNewProduct(HttpServletRequest request, HttpServletResponse response) {
        String prodId = request.getParameter("product_id");
        String prodName = request.getParameter("product_name");
        long prodPrice = Long.parseLong(request.getParameter("product_price"));
        String productDesc = request.getParameter("product_desc");
        String productManu = request.getParameter("product_factory");
        Product product = new Product(prodId,prodName,prodPrice,productDesc,productManu);
        productService.addProduct(product);
        request.setAttribute("message","Sản phẩm mới đã được tạo");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/products/created.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int index = Integer.parseInt(request.getParameter("product_id"));
        Product product = productService.deleteProductByIndex(index);
        if (product == null) {
        } else {
            try {
                response.sendRedirect("/products");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
