package pl.alex.devnote.domain.api;

public class CategoryNameDTO {
    private final Integer id;
    private final String name;

    public CategoryNameDTO(Integer id, String name) {
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
