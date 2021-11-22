package pl.alex.devnote.domain.api;

import pl.alex.devnote.domain.user.User;
import pl.alex.devnote.domain.user.UserDAO;

import java.time.LocalDateTime;

public class UserService {
    private final UserDAO dao = new UserDAO();

    public void register(UserRegistrationDTO dto) {
        User user = UserMapper.map(dto);
        dao.save(user);
    }


    private static class UserMapper {
        static User map(UserRegistrationDTO dto) {
            return new User(
                    dto.getUsername(),
                    dto.getEmail(),
                    dto.getPassword(),
                    LocalDateTime.now()
            );
        }
    }
}
