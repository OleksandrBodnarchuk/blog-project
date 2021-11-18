package pl.alex.devnote.domain.category;

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

@WebServlet("/category")
public class CategoryController extends HttpServlet {
    private final CategoryService categoryService = new CategoryService();
    private final DiscoveryService discoveryService = new DiscoveryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        CategoryFullDTO category = categoryService.findCategoryById(id).orElseThrow();
        List<DiscoveryBasicDTO>discoveries = discoveryService.findAllDiscoveriesByCategoryId(id);
        req.setAttribute("category",category);
        req.setAttribute("discoveries",discoveries);
        req.getRequestDispatcher("category.jsp").forward(req,resp);

    }
}
