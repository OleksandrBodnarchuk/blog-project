package pl.alex.devnote.home;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.alex.devnote.domain.api.CategoryNameDTO;
import pl.alex.devnote.domain.api.CategoryService;
import pl.alex.devnote.domain.api.DiscoveryBasicDTO;
import pl.alex.devnote.domain.api.DiscoveryService;
import pl.alex.devnote.domain.category.CategoryDAO;
import pl.alex.devnote.domain.discovery.Discovery;
import pl.alex.devnote.domain.discovery.DiscoveryDAO;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("")
public class HomeController extends HttpServlet {
    private final DiscoveryService discoveryService = new DiscoveryService();
    private final CategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DiscoveryBasicDTO> discoveries = discoveryService.findAllDiscoveries();
        List<CategoryNameDTO> categories = categoryService.findAllCategories();
       req.setAttribute("categories", categories);
       req.setAttribute("discoveries", discoveries);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}

