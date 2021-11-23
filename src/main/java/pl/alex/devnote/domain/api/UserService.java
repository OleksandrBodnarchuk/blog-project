package pl.alex.devnote.domain.api;

import org.apache.commons.codec.digest.DigestUtils;
import pl.alex.devnote.domain.user.User;
import pl.alex.devnote.domain.user.UserDAO;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class UserService {
    private final UserDAO dao = new UserDAO();

    public void register(UserRegistrationDTO dto) {
        User user = UserMapper.map(dto);
        try{
            hashPasswordWithSha256(user);
            dao.save(user);
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }

    }

    private void hashPasswordWithSha256(User user) throws NoSuchAlgorithmException{
        String sha256Password = DigestUtils.sha256Hex(user.getPassword());
        user.setPassword(sha256Password);
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
