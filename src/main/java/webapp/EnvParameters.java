package webapp;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * EJB-бин. На запрос GET выдает значения переменных окружения ОС.
 * Также привязан к index.jsp.
 */

@Stateless
public class EnvParameters {

    // private List<Map.Entry<String, String>> paramList;

    /**
     * Функция, выдающая значения всех переменных окружения ОС.
     * Работает с сервлетом.
     * @return map, где key=переменная окружения, value=путь/каталог
     */

    @GET
    @Produces("text/html")
    public Map<String, String> getEnv() {
        return System.getenv();
    }

    /**
     * Функция, выдающая значения всех переменных окружения ОС.
     * Работает с JSP страницей.
     * @return list, хранящий значения переменных окружения ОС
     */

    public List<Map.Entry<String, String>> getParamsList() {
        return new ArrayList<>(getEnv().entrySet());
    }

}
