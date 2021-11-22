package pl.alex.devnote.signup;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.alex.devnote.domain.api.UserRegistrationDTO;
import pl.alex.devnote.domain.api.UserService;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserRegistrationDTO registrationDTO = getUserData(request);
        userService.register(registrationDTO);
        response.sendRedirect(request.getContextPath());
    }

    private UserRegistrationDTO getUserData(HttpServletRequest request) {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        return new UserRegistrationDTO(username,email,password);
    }

}
