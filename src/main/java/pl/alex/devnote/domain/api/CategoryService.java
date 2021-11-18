package pl.alex.devnote.domain.api;

import pl.alex.devnote.domain.category.Category;
import pl.alex.devnote.domain.category.CategoryDAO;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryService {
    private final CategoryDAO categoryDAO = new CategoryDAO();

    public List<CategoryNameDTO> findAllCategories(){
        return categoryDAO.findAllCategories().stream().map(CategoryMapper::map).collect(Collectors.toList());
    }

    private static class CategoryMapper {
        static CategoryNameDTO map(Category category){
            return new CategoryNameDTO(category.getId(), category.getName());
        }
    }
}
