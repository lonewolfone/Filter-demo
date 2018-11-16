## 过滤器Filter

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\109.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\110.png)

### Filter的作用

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\111.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\112.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\113.png)

### Filter的拦截的实现

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\114.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\115.png)

#### Filter开发步骤

##### Filter

##### 配置过滤器方式

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\116.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\117.png)

###### web.xml中配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <!--在web.xml中注册filter-->
    <filter>
        <filter-name>firstFilter</filter-name>
        <filter-class>org.lanqiao.filterTest.firstFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>firstFilter</filter-name>
        <!--拦截所有请求-->
        <url-pattern>/*</url-pattern>
    </filter-mapping>
</web-app>
```



###### 注解方式

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\118.png)

firstFilter类中

```java
@javax.servlet.annotation.WebFilter(filterName = "firstFilter",urlPatterns = "/*")
public class firstFilter implements javax.servlet.Filter {
    public void destroy() {
        System.out.println("destroy 方法执行。。。。。。。。。。。。。。。。。。。。");
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        System.out.println("doFilter 方法前执行 。。。。。。。。。。。。。。");
        //放行
        chain.doFilter(req, resp);
        System.out.println("doFilter 方法后执行 。。。。。。。。。。 ");
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {
        System.out.println("init 方法执行");
    }

}
```

##### Filter的部署

###### 初始化参数配置

web.xml中

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <!--在web.xml中注册filter-->
    <filter>
        <filter-name>firstFilter</filter-name>
        <filter-class>org.lanqiao.filterTest.firstFilter</filter-class>
        <!--初始化参数配置-->
        <init-param>
            <param-name>username</param-name>
            <param-value>张三</param-value>
        </init-param>
        <init-param>
            <param-name>password</param-name>
            <param-value>123321</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>firstFilter</filter-name>
        <!--拦截所有请求-->
        <url-pattern>/*</url-pattern>
    </filter-mapping>
</web-app>
```

firstServlet类中

```java
//@javax.servlet.annotation.WebFilter(filterName = "firstFilter",urlPatterns = "/*")
public class firstFilter implements javax.servlet.Filter {
    public void destroy() {
        System.out.println("destroy 方法执行。。。。。。。。。。。。。。。。。。。。");
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        System.out.println("doFilter 方法前执行 。。。。。。。。。。。。。。");
        //放行
        chain.doFilter(req, resp);
        System.out.println("doFilter 方法后执行 。。。。。。。。。。 ");
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {
        //获取初始化参数
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        System.out.println("init 方法执行");
        System.out.println(username);
        System.out.println(password);
    }

}

```



###### 映射Filter

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\119.png)

#### Filter的生命周期

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\120.png)

##### init

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\121.png)

##### destroy

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\122.png)

##### doFilter

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\123.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\124.png)

#### Filter的四种拦截方式

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\125.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\126.png)

web.xml

```xml
<filter-mapping>
        <filter-name>firstFilter</filter-name>
        <!--拦截所有请求-->
        <url-pattern>/*</url-pattern>
        <!--<dispatcher>REQUEST</dispatcher>-->
        <dispatcher>INCLUDE</dispatcher>
    </filter-mapping>
```

firstServlet类

```java
@WebServlet("/fristServlet")
public class fristServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("fristServlet........................................");
        //转发：一次请求
        //request.getRequestDispatcher("/secondServlet").forward(request,response);
        //重定向
        //response.sendRedirect("/secondServlet");
        //请求包含
        request.getRequestDispatcher("/secondServlet").include(request,response);
    }
}
```

secondServlet类

```java
@WebServlet( "/secondServlet")
public class secondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            System.out.println("secondServlet.............................");
            PrintWriter printWriter = response.getWriter();
            printWriter.print(" secondServlet response ");
            printWriter.close();
    }
}
```

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\131.png)

##### forword和include

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\127.png)

为forword时：

```
@WebServlet("/fristServlet")
public class fristServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("fristServlet........................................");
        //转发：一次请求
        //request.getRequestDispatcher("/secondServlet").forward(request,response);
        //重定向
        //response.sendRedirect("/secondServlet");
        //请求包含
        //request.getRequestDispatcher("/secondServlet").include(request,response);
        request.getRequestDispatcher("/secondServlet").forward(request,response);
    }
}
```

结果如图：

![ ](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\128.png)

对比forword和include的不同

第一：

web.xml

```xml
<filter-mapping>
        <filter-name>firstFilter</filter-name>
        <!--拦截所有请求-->
        <url-pattern>/*</url-pattern>
        <!--<dispatcher>REQUEST</dispatcher>-->
        <dispatcher>FORWARD</dispatcher>
    </filter-mapping>
```

fristServlet类

```java
//转发
        request.getRequestDispatcher("/secondServlet").forward(request,response);
        System.out.println("fristServlet........................................");
        out.write("firstServlet.................................");
```

结果图：

![ ](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\129.png)

第二：

web.xml

```xml

```

fristServlet类

```java

```

结果图：

![ ](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\130.png)

### Filter链

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\132.png)

web.xml

```xml
<!--三个拦截器的注册  多个拦截器的拦截顺序，与注册顺序无关-->
    <filter>
        <filter-name>Filter1</filter-name>
        <filter-class>org.lanqiao.filterTest.Filter1</filter-class>
    </filter>
    <filter>
        <filter-name>Filter2</filter-name>
        <filter-class>org.lanqiao.filterTest.Filter2</filter-class>
    </filter>
    <filter>
        <filter-name>Filter3</filter-name>
        <filter-class>org.lanqiao.filterTest.Filter3</filter-class>
    </filter>
    &lt;!&ndash;三个拦截器的映射 多个拦截器的拦截顺序，与映射顺序有关 &ndash;&gt;
    <filter-mapping>
        <filter-name>Filter1</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    <filter-mapping>
        <filter-name>Filter2</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    <filter-mapping>
        <filter-name>Filter3</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```

Filter1中

```java
//@WebFilter(filterName = "Filter1",urlPatterns ="/*" )
public class Filter1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter1 前拦截");
        chain.doFilter(req, resp);
        System.out.println("Filter1 后拦截");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
```

### FilterConfig

- 在开发中，如果配置了拦截器，有可能登陆页面 或者 index页面 都会访问不到，一般情况下不对页面进行拦截(页面可以被用户直接通过地址栏请求到  不允许)，只拦截Servlet
- 将页面放在WEB-INF下，则用户无法通过地址栏访问到页面

Filter1类中

```java
//@WebFilter(filterName = "Filter1",urlPatterns ="/*" )
public class Filter1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
    /*
        在开发中，如果配置了拦截器，有可能登陆页面 或者 index页面 都会访问不到，一般情况下不对页面进行拦截(页面可以被用户直接通过地址栏请求到  不允许)，只拦截Servlet
        将页面放在WEB-INF下，则用户无法通过地址栏访问到页面

        1、页面不被用户直接通过地址栏请求到
        只将index或者login页面直接放在web目录下，其他一律放在WEB-INF下
        2、只拦截Servlet
        *.do 或者 *.action
    */
        System.out.println("Filter1 前拦截");
        if(1 == 1){
            return;
        }
        chain.doFilter(req, resp);//执行改方法，则意味着请求Servlet 或 传递给下一个filter
        System.out.println("Filter1 后拦截");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
```

web.xml中

```xml
<filter>
      <filter-name>Filter1</filter-name>
      <filter-class>org.lanqiao.filterTest.Filter1</filter-class>
   </filter>
   <filter-mapping>
      <filter-name>Filter1</filter-name>
      <!--<url-pattern>/index.jsp</url-pattern>
      <url-pattern>/defult.jsp</url-pattern>-->
      <url-pattern>*.do</url-pattern>
   </filter-mapping>
```



### Filter实际开发中典型应用

#### 字符编码过滤器characterEncodingFilter

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\133.png)

index.jsp页面

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index页面：Filter学习</title>
  </head>
  <body>
      <h4><a href="/fristServlet">firstServlet请求转发到secondServlet请求</a></h4><br><br>
      <h4>Filter实际开发中典型应用</h4><br>
      <form action="/fromServlet" method="get">
          用户名：<input type="text" name="username" id="username" value=""><br><br>
          <input type="submit" value="提交">
      </form>

  </body>
</html>
```

fromServlet类

```java
@WebServlet("/fromServlet")
public class fromServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        out.write(username);

    }
}
```

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\135.png)



 第一种方法：

```java
  response.setCharacterEncoding("utf-8");
```

第二种方法：

![ ](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\136.png)

web.xml

```xml
<!--设置全局编码-->
   <context-param>
      <param-name>encoding</param-name>
      <param-value>utf-8</param-value>
   </context-param>
   <filter>
      <filter-name>characterEncodingFilter</filter-name>
      <filter-class>org.lanqiao.filterTest.characterEncodingFilter</filter-class>
   </filter>
   <filter-mapping>
      <filter-name>characterEncodingFilter</filter-name>
      <url-pattern>/*</url-pattern>
   </filter-mapping>
```

fromServlet类

```java
@WebServlet("/fromServlet")
public class fromServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
       // response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        out.write(username);

    }
}
```

characterEncodingFilter类

```java
//@WebFilter(filterName = "characterEncodingFilter")
public class characterEncodingFilter implements Filter {
    private String encoding;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("拦截前执行");
        //在拦截请求时
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        chain.doFilter(req, resp);
        System.out.println("拦截后执行");
    }

    public void init(FilterConfig config) throws ServletException {
        //初始化方法： 获取参数值
        encoding = config.getServletContext().getInitParameter("encoding");
    }

}
```



#### 检查用户是否登陆CheckLoginFilter

index.jsp页面

```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index页面：Filter学习</title>
  </head>
  <body>
      <h4><a href="/fristServlet">firstServlet请求转发到secondServlet请求</a></h4><br>

      <%--<h4>Filter实际开发中典型应用</h4><br>
      <form action="/fromServlet" method="get">
          用户名：<input type="text" name="username" id="username" value=""><br><br>
          <input type="submit" value="提交"><br><br>
      </form>--%>

      <h3>Filter实际开发中典型应用之用户登陆</h3><br>
      <form action="/loginServlet" method="get">
          用户名：<input type="text" name="username"  value=""><br><br>
          <input type="submit" value="提交"><br><br>
      </form>
      <span style="color: red">${msg}</span>
  </body>
</html>
```

loginServlet类

```java
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        //用户在登陆后，将用户的信息保存在Session中
        HttpSession session = request.getSession();
        if( !username.equals("") && username != null){
             session.setAttribute("username",username);
             request.getRequestDispatcher("/success.jsp").forward(request,response);
        }
    }
}
```

success.jsp

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功页面</title>
</head>
<body>
    欢迎您：${username}

</body>
</html>
```

loginFilter类

```java
//@WebFilter(filterName = "loginFilter")
public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest)req).getSession();
        String username = (String) session.getAttribute("username");
        String requestURI = ((HttpServletRequest)req).getRequestURI();
        System.out.println(requestURI);
        if ( requestURI.equals("/loginServlet")){
            chain.doFilter(req, resp);
        }else if (username != null && ! username.equals("") ){
            chain.doFilter(req, resp);
        }else {
            req.setAttribute("msg","您尚未登陆，请登陆账号");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
```



#### 权限管理

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\137.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs1\137.png)



### 严重错误

#### 关于form表单提交问题

```html
<form action="/fromServlet" method="get">
          用户名：<input type="text" name="username" id="username" value=""><br><br>
          <input type="submit" value="提交">
      </form>
```

##### input中type类型为： submit