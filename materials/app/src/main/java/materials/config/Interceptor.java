package materials.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author pranjal
 * @date 2023-11-29
 */
public class Interceptor implements HandlerInterceptor {

    private static final String AUTH_HEADER_KEY = "x-auth-header-key";

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        System.out.println(request.getHeader(AUTH_HEADER_KEY));

        return true;
    }
}
