package pl.alex.devnote.domain.api;

import java.time.LocalDateTime;

public class DiscoveryBasicDTO {
    private final String title;
    private final String url;
    private final String description;
    private final LocalDateTime dateAdded;

    public DiscoveryBasicDTO(String title, String url, String description, LocalDateTime dateAdded) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.dateAdded = dateAdded;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }
}
