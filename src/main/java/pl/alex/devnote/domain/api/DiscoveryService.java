package pl.alex.devnote.domain.api;

import pl.alex.devnote.domain.discovery.Discovery;
import pl.alex.devnote.domain.discovery.DiscoveryDAO;

import java.util.List;
import java.util.stream.Collectors;

public class DiscoveryService {
    private final DiscoveryDAO discoveryDAO = new DiscoveryDAO();

    public List<DiscoveryBasicDTO> findAllDiscoveries() {
        return discoveryDAO.findAllDiscoveries().stream().map(DiscoveryMapper::map).collect(Collectors.toList());
    }

    private static class DiscoveryMapper {
        static DiscoveryBasicDTO map(Discovery discovery) {
            return new DiscoveryBasicDTO(discovery.getTitle(),
                    discovery.getDateAdded(),
                    discovery.getUrl(),
                    discovery.getDescription());
        }
    }

}
