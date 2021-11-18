package pl.alex.devnote.domain.api;

import java.time.LocalDateTime;

public class DiscoveryBasicDTO {
    private final String title;
    private final LocalDateTime dateAdded;
    private final String url;
    private final String description;

    public DiscoveryBasicDTO(String title, LocalDateTime dateAdded, String url, String description) {
        this.title = title;
        this.dateAdded = dateAdded;
        this.url = url;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}
