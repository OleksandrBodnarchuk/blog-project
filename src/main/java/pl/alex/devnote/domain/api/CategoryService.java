package pl.alex.devnote.domain.api;

import pl.alex.devnote.domain.category.Category;
import pl.alex.devnote.domain.category.CategoryDAO;
import pl.alex.devnote.domain.category.CategoryFullDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryService {
    private final CategoryDAO categoryDAO = new CategoryDAO();

    public List<CategoryDTO> findAllCategories(){
        return categoryDAO.findAllCategories().stream().map(CategoryMapper::map).collect(Collectors.toList());
    }

    public Optional<CategoryFullDTO> findCategoryById(int id) {
        return categoryDAO.findCategoryById(id).map(FullCategoryMapper::map);
    }

    private static class CategoryMapper {
        static CategoryDTO map(Category category){
            return new CategoryDTO(category.getId(), category.getName());
        }
    }

    private static class FullCategoryMapper{
        static CategoryFullDTO map(Category category){
            return new CategoryFullDTO(category.getId(), category.getName(),category.getDescription());
        }
    }
}
