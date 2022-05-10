package priv.dhx.bookstore.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
@WebFilter("/api/*")
public class FirstFilter implements Filter
{
    private final static Set<String> pathSet = new HashSet<>();

    static
    {
        pathSet.add("http://localhost:8080");
        pathSet.add("http://localhost:63342");
        pathSet.add("http://119.91.225.190");
    }

    public void init(FilterConfig config) throws ServletException
    {
        System.out.println("FirstFilter启动成功！");
    }

    public void destroy()
    {
        System.out.println("FirstFilter销毁成功！");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String curOrigin = req.getHeader("Origin");
        if (pathSet.contains(curOrigin))
        {
            resp.setHeader("Access-Control-Allow-Origin", "*");
            resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, GET");
            resp.setHeader("Access-Control-Max-Age", "3600");
            resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        }
        System.out.println("跨域过滤器->当前访问来源->" + curOrigin);

        if (req.getMethod().equalsIgnoreCase("OPTIONS"))
        {
            return;
        }

        chain.doFilter(req, resp);
    }
}