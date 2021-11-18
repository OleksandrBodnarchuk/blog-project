package pl.alex.devnote.domain.api;

public class CategoryDTO {
    private final Integer id;
    private final String name;

    public CategoryDTO(Integer id, String name) {
        this.id=id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
