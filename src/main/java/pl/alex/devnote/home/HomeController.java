package pl.alex.devnote.home;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.alex.devnote.domain.api.CategoryDTO;
import pl.alex.devnote.domain.api.CategoryService;
import pl.alex.devnote.domain.api.DiscoveryBasicDTO;
import pl.alex.devnote.domain.api.DiscoveryService;


import java.io.IOException;
import java.util.List;


@WebServlet("")
public class HomeController extends HttpServlet {
    private final DiscoveryService discoveryService = new DiscoveryService();
    private final CategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DiscoveryBasicDTO> discoveries = discoveryService.findAllDiscoveries();
        List<CategoryDTO> categories = categoryService.findAllCategories();
        req.setAttribute("categories", categories);
        req.setAttribute("discoveries", discoveries);
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }
}

