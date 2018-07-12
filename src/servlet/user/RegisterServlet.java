package servlet.user;

import entity.User;
import utils.Routes;
import utils.QueryBuilder;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

import javax.mail.*;

@WebServlet(name = "RegisterServlet", urlPatterns = Routes.REGISTER)
public class RegisterServlet extends HttpServlet {
    /**
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet RegisterServlet");

        this.getServletContext().getRequestDispatcher("/user/register.jsp").forward(request, response);
    }

    /**
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doPost RegisterServlet");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password_second = request.getParameter("password_second");
        String status = request.getParameter("status");

        if (!email.isEmpty() && !password.isEmpty() && !password_second.isEmpty()) {
            if (!password.equals(password_second)) {
                request.getSession().setAttribute("flash_warning", "Les deux mots de passe doivent être identiques");
                response.sendRedirect(Routes.REGISTER);

                return;
            }

            if (QueryBuilder.isUserExisting(email)) {
                request.getSession().setAttribute("flash_warning", "L'utilisateur existe déjà");
                response.sendRedirect(Routes.REGISTER);

                return;
            }

            User user = new User(email, password, status);
            QueryBuilder.handleUser(user); // Add the user to the database
            request.getSession().setAttribute("flash_success", "Mail de confirmation envoyé"); //TODO CREATE AND SEND AN EMAIL
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("password", password);

            //Mail.send("axel91evrard@gmail.com", "Test Mail Java", "Coucou");

            response.sendRedirect("/");

            return;
        }

        request.getSession().setAttribute("flash_danger", "Champs non remplis");
        response.sendRedirect(Routes.REGISTER);
    }

    public static class Mail {

        public static void send(String emailTo, String emailObject, String emailMessage) {

            final String username = "test";
            final String password = "test";

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("axel91evrard@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(emailTo));
                message.setSubject(emailObject);
                message.setText(emailMessage);
                Transport.send(message);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

    }

}
