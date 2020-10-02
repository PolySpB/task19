package webapp;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Приложение с REST-сервисом, позволяющим получить значения всех переменных окружения операционной системы.
 * При запросе вида: http://localhost:8080/task14_02/response?param=JAVA можно получить значение конкретной переменной по имени.
 * По аналогии реализована JSP страница, в которой в табличном виде отображается информация о переменных окружения ОС.
 * Код работы с переменными окружения вынесен в EJB-бин "EnvParameters".
 * В качестве сервера использовался WildFly.
 */

@WebServlet("/response")
public class MyServlet extends HttpServlet {

    @EJB
    private EnvParameters envParameters;

    /**
     * Функция, обрабатывающая запросы клиента и отправляющая соответсвующий ответ.
     * @param request запрос клиента
     * @param response ответ клиенту
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String param = request.getParameter("param");
        Map<String, String> env = envParameters.getEnv();

        if (param == null || param.isEmpty()) {
            response.getWriter().write("<h1> Standard Response Page </h1>");
            response.getWriter().write("<table>");
            for (Map.Entry<String, String> entry : env.entrySet()) {
                response.getWriter().write("<tr><td>" + entry.getKey() + "</td><td>" + entry.getValue() + "</td></tr>");
            }
            response.getWriter().write("</table>");
        }
        else if (env.containsKey(param)) {
            response.getWriter().write("<table>");
            response.getWriter().write("<tr><td>" + param + "</td>");
            response.getWriter().write("<td>" + env.get(param) + "</td></tr>");
            response.getWriter().write("</table>");
        } else {
            response.getWriter().write("<h2> Parameter \"" + param + "\" doesn't exist! </h2>");
        }
    }

}

