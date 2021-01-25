# JavaWeb笔记

## XML

xml是可扩展标记性语言

### xml目的

用来保存数据，而且这些数据具有自我描述性

它还可以作为项目或者模块的配置文件

还可以作为网络传输数据的格式（JSON为主）

### xml属性

xml的标签属性和HTML的属性非常相似，属性可以提供元素的额外信息

在标签上可以书写属性：

​	一个标签上可以书写多个属性。每个属性的值必须使用引号引起来的规则和标签的书写规则一致。

### xml语法规则

必须关闭标签

### xml案例



#### books.xml

```xml
<?xml version="1.0" encoding="utf-8" ?>

<books>
    <book sn="SN123123123">
        <name>时间简史</name>
        <author>霍金</author>
        <price>75</price>
    </book>
    <book sn="SN223123123">
        <name>Java从入门到放弃</name>
        <author>沙老师</author>
        <price>9.9</price>
<!--        <price><![CDATA[<<9.9]]]></price>-->
    </book>
</books>
```

#### Book类

```java
public class Book {
    private String sn;
    private  String name;
    private String author;
    private double price;

    public Book() {
    }

    public Book(String sn, String name, String author, double price) {
        this.sn = sn;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
```

#### 读取books.xml文件生成Book类

```java
public void test2() throws DocumentException {
    //1.读取books.xml文件
    SAXReader saxReader = new SAXReader();
    Document document = saxReader.read("src/books.xml");
    //2.通过document对象获取根元素
    Element rootElement = document.getRootElement();
    System.out.println(rootElement);
    //3.通过根元素获取book标签元素
    List<Element> books = rootElement.elements("book");
    //4.通过处理每个book标签转换为Book类
    for (Element book: books) {
        Element element = book.element("name");
        String name = element.getText();

        String price = book.elementText("price");
        String author = book.elementText("author");

        String sn = book.attributeValue("sn");

        System.out.println(new Book(sn,name,author,Double.parseDouble(price)));
    }
}
```



## HTTP协议

协议是指双方，或多方，相互约定好,大家都需要遵守的规则,叫协议。

所谓HTTP协议，就是指，客户端和服务器之间通信时，发送的数据，需要遵守的规则，叫HTTP协议。

HTTP协议中的数据又叫报文。

### 请求的HTTP协议格式

客户端给服务器发送数据叫请求。

服务器给客户端回传数据叫响应。

请求又分为GET请求，和POST请求两种

#### GET请求

**1、请求行**

(1)请求的方式---------GET

(2)请求的资源路径[+?+请求参数]---------/06_Servlet_Servers/HttpServlet3?url=222

(3)请求的协议和版本号   ---------Http/1.1

**2、请求头**

key : value 组成――不同的键值对，表示不同的含义。

> :Accept:告诉服务零，客户端可以接收的数据类型
>
> 'Accept-Language:告诉服务器客户端可以接收的语言类型
>
> 'User-Agent:就是浏览器的信息
>
> 'Accept-Encoding:告诉服务器，客户端可以接收的数据编码（压缩)格式tHost:表示请求的服务器ip和病口号
>
> 'Connection:告诉服务容请求连接如何处理
>
> ​	Keep-Alive	告诉服务器回传数据不要马上关闭，保持一小段时间的连接
>
> ​	Closed	马上关闭

#### POST请求

**1、请求行**

(1)请求的方式---------POST

(2)请求的资源路径---------/06_Servlet_Servers/HttpServlet3

(3)请求的协议和版本号   ---------Http/1.1

**2、请求头**

key : value 组成――不同的键值对，表示不同的含义。

> .Accept:表示客户粥可以接收的数据类型
>
> Accept-Language:表示客户漓可以接收的语言类型
>
> 'Referer :衣示请求发起时，浏览器地址栏中的地址（从哪来)'User-Agent:表示浏览器的信息
>
> 'Content-Type:表示发送的数据的类型
>
> ​	application/ x-www-form-urlencoded	表示提交的数据格式是:name=value&name=value,然后对其进行url编码url铸码是把非英文内容转换为:%xx%xx
> ​			multipart/form-data 	表示以多段的形式操交数据给服务器（以流的形式提交，用于上传)
>
> Content-Lnegth: 表示发送的数据的长度
>
> 'Cache-Control表示如何控制缓存no-cache不缓存│

**空行**

#### 常用请求头

Accept:表示客户端可以接收的数据类型

Accpet-Languege:表示客户端可以接收的语言类型

User-Agent:表示客户端浏览器的信息

Host:表示请求时的服务器ip和端口号



### 响应的HTTP协议格式

**1、响应行**

(1)响应的协议和版本号   ---------Http/1.1

(1)响应的状态码  

(2)响应的状态描述符   

**2、响应头**

key : value 组成――不同的响应头，表示不同的含义。

> Server:表示服务器的信息
>
> Content-Type:表示响应体的数据类型
>
> Content-Length:响应体的长度
>
> Date:请求响应的时间(这是格林时间）

**空行**

**3、响应体**-----回传给客户端的数据

#### 常用响应码

200				请求成功

302				请求重定向

404				服务器收到了，但是请求资源地址文件错误

500				服务器已经收到请求，但是服务器内部错误

### MIME类型说明

MIME是HTTP协议中数据类型

MIME的英文全称是Multipurpose lnternet Mail Extensions，多功能Internet邮件扩充服务。MIME类型的格式是“大类型/小类型”，并与某一种文件按的扩展名相对应。

![image-20201221162739863](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20201221162739863.png)



## JavaWeb的目录配置

### 简介

​	所有通过Java语言编写可以通过浏览器访问的程序的总称，叫做JavaWeb。Java web是基于请求和响应来开发的。

**请求**是客户端给服务器发送数据，叫做请求Request。

**响应**是服务器给客户端回传数据，叫做响应Response。

### Web资源分类

web资源按实现的技术和呈现的效果的不同，又分为静态资源和动态资源两种。
**静态资源**: html. css、js、txt、mp4视频,jpg图片
**动态资源**:jsp页面、Servlet程序

### 目录分析

#### src目录

存放Java代码

#### web目录

专门存放web工程的资源文件。

WEB-INF目录是一个受服务器保护的目录，浏览器无法直接访问到此目录的内容。

web.xml文件是整个动态web工程的配置部署描述文件。可以再这些配置很多web工程的组件，比如Servlet程序,Filter过滤器，Listener监听器，Session超时。。。。

lib目录用来存放第三方的jar包

## Servlet技术

Servlet是javaEE规范之一，规范就是接口

Servlet是javaWeb三大组件之一，三大组件分别是：Servlet程序，Filter过滤器、Listener监听器。

Servlet是运行在服务器上的一个Java小程序，可以接受客户端发送过来的请求，并响应数据到客户端。

### 手动实现

1. 编写一个类去实现Servlet接口
2. 实现Service方法，处理请求并响应数据
3. 到web.xml中去配置Servlet程序的访问地址

#### 执行步骤

![image-20201220192635204](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20201220192635204.png)

### Servlet生命周期

1. 执行Servlet构造器方法

2. 执行init初始化方法

   步骤1，2会在创建Servlet时调用

3. 执行service方法

   步骤3每次访问都会调用

4. 执行destory销毁方法

   步骤4web工程销毁时调用

### 整个Servlet类的继承体系

1. **类GenericServlet实现接口Servlet**

2. **类HttpServlet继承于类GenericServlet**

3. **自定义的Servlet程序继承于类HttpServlet**

   ![image-20201221102432635](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20201221102432635.png)

Servlet接口，只负责定义Servlet程序的访问规范

GenericServlet类实现了Servlet接口。做了很多空实现，并使有一个ServletConfig类的引用。并对ServletConfig的使用做了一些方法。

HttpServlet实现了Service（）方法，并实现了请求的方法处理。

`String method = req.getMethod()  ==>  GET和POST`

`GET==>doGet()  POST==>doPost()` 负责抛异常，说不支持GET/POST请求

我们只需要根据自己的业务需要去重写doGet() 和doPost()方法

#### 通过继承HttpServlet实现Servlet程序

```java
//类型转换，因为httpServletRequest有getMethod方法
HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
//获取请求方式
String method = httpServletRequest.getMethod();

if("GET".equals(method)){
    doGET();
}else{
    doPOST();
}
```



### ServletConfig类

Servlet程序的配置信息类

Servlet程序和ServletConfig对象都是有Tomcat负责创建的，开发人员负责使用。

Servlet程序默认是第一次访问的时候创建，ServletConfig是每个Servlet程序创建时,就创建一个对应的ServletConfig对象。

```xml
<servlet>
    <!--servLet-name标签ServLet程序起一个别名（一般是类名）-->
    <servlet-name>HelloServlet</servlet-name>
    <!--servLet-cLass是ServLet程序的全类名-->
    <servlet-class>com.qiangliu8.HelloServlet</servlet-class>
    <init-param>
        <param-name>username</param-name>
        <param-value>刘强</param-value>
    </init-param>
    <init-param>
        <param-name>url</param-name>
        <param-value>jdbc:mysql://localhost:3306/test</param-value>
    </init-param>
</servlet>
```

#### ServletConfig类的三个作用

**1.可以获取Servlet程序的别名servlet-name的值**

```java
@Overridepublic void init(ServletConfig servletConfig) throws ServletException {
    System.out.println("别名："+servletConfig.getServletName());
}
```

**2.获取初始化参数init-param**

```java
@Overridepublic void init(ServletConfig servletConfig) throws ServletException {
	System.out.println("初始化参数username的值是"+servletConfig.getInitParameter("username"));
	System.out.println("初始化参数url的值是"+servletConfig.getInitParameter("url"));
}
```

**3.获取ServletContext对象**

```java
@Overridepublic void init(ServletConfig servletConfig) throws ServletException {
	System.out.println(servletConfig.getServletContext());
}
```



### ServletContext类

ServletContext是一个接口，它表示Serlvet上下文对象

一个web工程只有一个ServletContext对象

ServletContext对象是一个域对象，是可以像Map一样存取数据的对象。这里的域知识的是存取数据的操作范围

ServletContext是在web工程部署启动的时候创建，停止时销毁。

```xml
<context-param>
    <param-name>username</param-name>
    <param-value>1102644615</param-value>
</context-param>
<context-param>
    <param-name>password</param-name>
    <param-value>Lq060528</param-value>
</context-param>
```

#### ServletContext的四个作用

1. 获取web.xml中配置的上下文参数contxt-param

   ```java
   ServletContext servletContext =  getServletConfig().getServletContext();
   ```

2. 获取当前的工程路径，格式:/工程路径

   ```java
   System.out.println("当前工程路径为"+servletContext.getContextPath());
   ```

3. 获取工程部署后在服务器硬盘上的绝对路径

   ```java
   System.out.println("当前工程路径:"+servletContext.getContextPath());
   System.out.println("工程部署的路径："+servletContext.getRealPath("/"));
   System.out.println("工程下CSS目录的绝对路径："+servletContext.getRealPath("/"));
   ```

4. 像Map一样存取数据

   ```java
   ServletContext servletContext1 = getServletContext();
   servletContext1.setAttribute("name","俞文竹");
   System.out.println(servletContext1.getAttribute("name"));
   ```

   

### HttpServletRequest类

每次只要有请求进入Tomact服务器，Tomcat服务器就会把请求过来的Http协议信息解析好封装到Request对象中。然后传递到service方法（doGet和doPost）中给我们使用。我们可以通过HttpServletRequest对象，获取到所有请求的信息。

#### 常用方法

> getRequestURI()							获取请求的资源路径
>
> getRequestURL()							获取请求的统一资源定位符(绝对路径)
>
> getRemoteHost()							获取客户端的ip地址
>
> getHeader()									 获取请求头
>
> getParameter()							 获取请求的参数
>
> getParameterValues()				获取请求的参数（多值）
>
> getMethod()								  获取请求的方式GET或POST
>
> setAttribute(key,value)			设置域数据
>
> getAttribute(key)						获取域数据
>
> getRequsetDispatcher()			获取请求转发对象				

```java
System.out.println("URI"+request.getRequestURI());//3_war_exploded/3
System.out.println("URL"+request.getRequestURL());http://localhost:8083/3_war_exploded/3
System.out.println("真实客户端的ip:"+request.getRemoteHost());//0:0:0:0:0:0:0:1
System.out.println("请求头："+request.getHeader("User-Agent"));//Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36
System.out.println(request.getMethod());//GET
System.out.println(request.getParameter("username"));//Liuqiang
System.out.println(request.getParameter("password"));//Lq060528
//获取checkbox多值的标签时候，getParameterValues的出来是个数组，可以转成集合
System.out.println(request.getParameterValues("hobby")[0]);//game
System.out.println(Arrays.asList(request.getParameterValues("hobby")));//[game, love]
```

#### 解决POST请求中文乱码

```java
request.setCharacterEncoding("UTF-8");
```

#### 请求的转发

服务器收到请求后，从一个资源跳到另一个资源的操作叫做请求转发

**Servlet1配置**

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("在Servlet1查看材料"+request.getParameter("username"));
    request.setAttribute("username",request.getParameter("username"));
    //转发
    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/3_Servlet2");
    //走向servlet2
    requestDispatcher.forward(request,response);
}
```

**Servlet2配置**

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("在Servlet2查看材料"+request.getParameter("username"));
    Object object = request.getAttribute("username");
    System.out.println(object);
}
```



![image-20201222135232342](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20201222135232342.png)

#### base标签

直接定位

**c.html**

```html
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <base href="http://localhost:8083/3_war_exploded/a/b/c.html">
</head>
<body>
    <a href="../../index.jsp">a giao!</a>
</body>
```

**inde.jsp**

```jsp
<a href="a/b/c.html">a/b/c.html</a>
<a href="http://localhost:8083/3_war_exploded/forword">请求转发 a/b/c.html</a>
```

**ForwordServlet**

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("经过了Forword程序");
    request.getRequestDispatcher("a/b/c.html").forward(request,response);
}
```

### HttpServletRespone类

HttpServletResponse类和HttpServletRequest类一样。每次请求进来，Tomcat服务器都会创建一个Response对象传递给servlet程序去使用。HttpservletRequest表示请求过来的信息，HttpServletResponse表示所有响应的信息，我们如果需要设置返回给客户端的信息，都可以通过HttpServletResponse对象来进行设置。

#### 输出流

字节流	getOutputStream()		常用于下载（传递二进制数据）

字符流	getWriter()						常用于回传字符串

两个流同时只能使用一个，使用字节流就不能用字符流，反之亦然。

#### 响应乱码

```java
//设置服务器字符集为UTF-8
response.setCharacterEncoding("UTF-8");
//通过响应头，设置浏览器使用UTF-8
response.setHeader("Content-type","text/html;charset=UTF-8");
//或者
response.setContentType("text/html;charset=UTF-8");
```

#### 请求重定向

![image-20201222161303265](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20201222161303265.png)

```java
//设置状态码
response.setStatus(302);
//设置响应头，说明跳转到那里
response.setHeader("Location","http://localhost:8083/3_war_exploded/Resopne2");
//第二种方式
response.sendRedirect("http://localhost:8083/3_war_exploded/Resopne1");
```

**Referer参数可以实现原地址请求后再返回至源地址**

```java
String Referer = req.getHeader("Referer");

resp.sendRedirect(Referer);
```



## JavaEE架构

![image-20201222162812981](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20201222162812981.png)

分层的目的是为了解耦。解耦就是为了降低代码的耦合度。方便项目后期的维护和升级。

![image-20201222170943925](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20201222170943925.png)



1. 创建数据库和表

2. 编写数据库表对应的JavaBean对象

   ```java
   public class User {
       private Integer id;
       private String username;
       private String password;
       private String email;
   ```

3. 编写工具类 jdbcUtils

   ```java
   public class JdbcUtils {
       private static DruidDataSource dataSource;
       static{
              try {
                  Properties properties = new Properties();
                  //读取jdbc.properties属性配置文件
                  InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
                  //从流中读取加载数据
                  properties.load(inputStream);
                  //创建 数据库连接池
                  dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
   //   获取数据库池中的连接
       public static Connection getConnection(){
           Connection connection = null;
           try{
               connection = dataSource.getConnection();
   
       }catch (SQLException e){
           e.printStackTrace();
       }
      return connection;
   }
   //关闭连接
   public static void close(Connection connection){
       if (connection!=null){
           try{
               connection.close();
           }catch (SQLException e){
               e.printStackTrace();
           }
       }
   }
   public static void main(String[] args) {
       System.out.println(getConnection());
   }
   
   }
   ```

4. 编写BaseDao

   ```java
   public abstract class BaseDao {
   
   //      使用DbUtils操作数据库
   //      update()方法用来执行:InsertlUpdatelDeLete语句
   //      Creturn如果返回-1,说明执行失败<br/>返回其他表示影响的行数
   
       private QueryRunner queryRunner = new QueryRunner();
   
       public int update(String sql,Object ...args){
           Connection connection = JdbcUtils.getConnection();
           try{
               return queryRunner.update(connection,sql,args);
           }catch (SQLException e){
               e.printStackTrace();
           }finally {
               try {
                   connection.close();
               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
           }
           return -1;
       }
   
   //    查询返回一个javaBean的sqL语句
   //    type返回的对象类型
   //    sqL执行的sqL语甸
   //    args sqL对应的参数值
   //    <T>返回的类型的泛型
   //
       public <T> T  queryForOne(Class<T> type,String sql,Object...args){
           Connection connection = JdbcUtils.getConnection();
           try {
               return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }finally {
               try {
                   connection.close();
               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
           }
           return null;
       }
   
   //    查询返回多个javaBean的sqL语句
   //    type返回的对象类型
   //    sqL执行的sqL语甸
   //    args sqL对应的参数值
   //    <T>返回的类型的泛型
   //
       public <T>List<T> queryForList(Class<T>type,String sql,Object...args){
           Connection connection = JdbcUtils.getConnection();
           try{
               return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args)
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           } finally {
               try{
                   connection.close();
               }catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
           }
           return  null;
       }
   
   //    查询返回一行一列的SQL语句
   //    sqL执行的sqL语甸
   //    args sqL对应的参数值
   //
       public Object queryForSingleValue(String sql,Object...args){
           Connection connection = JdbcUtils.getConnection();
           try{
               return queryRunner.query(connection, sql,new ScalarHandler(),args);
           }catch (SQLException throwables) {
               throwables.printStackTrace();
           } finally {
               try{
                   connection.close();
               }catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
           }
           return null;
       }
   }
   ```

5. 编写UserDao和测试





## JSP

全称Java server pages。java的服务器页面。

jsp主要作用是代替servlet程序回传html页面的数据。

因为servlet程序回传html页面是一件非常繁琐的事,开发成本高较繁琐

Jsp都是存放和html一样，访问也是一样。

### 本质

当我们第一次访问jsp页面时，Tomcat服务器会将jsp页面翻译成一个java源文件，并且会它进行编译成为.class字节码程序。我们打开java源文件不难发现：

HttpJspBase类，它直接继承了HttpSerlvet类。也就是说，Jsp翻译出来的java类，简介继承了HttpSerlvet。

### 三种语法

#### jsp头部的page指令

jsp的page指令可以修改jsp页面中的一些重要的属性，或者行为。  表示jsp翻译后时什么语言文件。暂时只支持java

```jsp
<%@ page import="com.qiangliu8.serlvet.PringHtml" %>
<%@ page contentType="text/html;charset=UTF-8" 
    autoFlush="true"
    buffer="8kb"
    errorPage="error.jsp"
    isErrorPage="true"
    session="false"
    extends="javax.servlet.HttpServlet"
    language="java" %>
```

|    属性名    |                                                              |
| :----------: | ------------------------------------------------------------ |
|   language   | 表示jsp翻译后时什么语言文件。暂时只支持java                  |
| contentType  | 表示jsp返回的数据类型是什么，源码中response.setContentype()参数值 |
| pageEncoding | 表示当前jsp页面本身的字符集                                  |
|    import    | 用于导包，导类                                               |
|  autoFlush   | 设置当out输出流缓冲区满了之后，是否自动刷新冲级区。默认值是true |
|    buffer    | 设置out缓冲区大小默认是8kb                                   |
|  errorPage   | 设置当前jsp页面运行运行错误，自动跳转去的页面                |
| isErrorPage  | 设置当前jsp页面是否是错误信息页面，默认为false。如果是true，可以获取异常信息 |
|   session    | 设置访问当前jsp页面，是否会创建HttpSession对象。默认是true   |
|   extends    | 设置jsp翻译出来的java类默认继承谁                            |

#### jsp常用脚本

#### 申明脚本

可以给jsp 翻译出来的Java类定义属性和方法，甚至是静态代码块，内部类等。

```jsp
<%--    声明类属性--%>
<%!
    private Integer id;
private String name;
private static Map<String,Object> map;
%>
<%--申明static静态代码块--%>
<%!
    static {
    map = new HashMap<String,Object>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key2","value2");
}
%>
<%--申明类方法--%>
<%!
    public int abc(){
    return 12;
}
%>
<%--申明内部类--%>
<%!
    public static class A{
        private Integer id = 12;
        private String abc = "abc";
    }
%>
```

#### 表达式脚本

在jsp页面上输出数据

特点：

1. 所有表达式脚本都会变翻译到jspService方法中
2. 表达式脚本都会被翻译成为out.print()输出到页面上
3. 由于表达式脚本翻译的内容都在jspService()方法中，所以jspService()方法中的对象都可以直接使用
4. 不能结尾加分号

```jsp
<%--输出整形--%>
<%=
    1
    %>
<%--    输出浮点型--%>
<%=
    1.0
    %>
<%--    输出字符串--%>
<%=
    "我是字符串"
    %>
<%--    输出对象--%>
<%=
    map
%>

<%=
    request.getMethod()
%>
```

#### 代码脚本

可以在jsp页面中，编写自己需要的功能

特点：

1. 代码脚本都在jspService方法中
2. 代码脚本由于翻译到jspService()方法中，所以jspService()方法中的对象都可以直接使用、
3. 还可以有多个代码脚本块组合完成一个完整的Java语句

```jsp
<%
    int i = 12;
    if (i==12){
        System.out.println(i);
    }
%>
```

### 九大内置对象

是指Tomcat在翻译jsp页面成为Serlvet源代码后，内部提供的九大对象

| request     | 请求对象           |
| ----------- | ------------------ |
| response    | 响应对象           |
| pageContext | jsp的上下文对象    |
| session     | 会话对象           |
| application | ServletContext对象 |
| config      | ServletConfig对象  |
| out         | jsp输出流对象      |
| page        | 指向当前jsp的对象  |
| exception   | 异常对象           |

#### 四大域对象

域对象是可以像Map一样存取数据的对象。四个域对象功能一样，不同的是他们对数据的存取范围、

虽然四个域对象都可以存取数据。在使用上它们是有优先顺序的。

四个域在使用的时候，优先顺序分别是，他们从小到大的范围的顺序

pageContext====>>>request ====>>>session ====>>>application

| PageContext | (PageContextiml类)     | 当前jsp页面范围内有效                                      |
| ----------- | ---------------------- | ---------------------------------------------------------- |
| Request     | (HttpSerlvetRequest类) | 一次请求内有效                                             |
| Session     | (HttpSession类)        | 一次绘画范围内有效（打开浏览器访问服务器，知道关闭浏览器） |
| application | (ServletConext类)      | 整个web工程范围内都有效（只要web工程不停止，数据都在）     |

#### out.write输出和response.getWriter()区别

![image-20201229153545086](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20201229153545086.png)

```jsp
out.write("out1");
out.flush();
out.write("out2");
response.getWriter().write("response1");
response.getWriter().write("response2");
//out1
//response1
//response2
//out2
```

由于 jsp翻译之后，底层源代码都是使用out 来进行输出，所以一般情况下。我们在jsp页面中统一使用out来进行输出。避免打乱页面输出内容的顺序 。

out.write()输出字符串没有问题

out.print()输出任意数据都没有问题（都转换成为字符串后调用的write输出》

### jsp常用标签

#### jsp静态包含

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    头部信息<br>
    主体内容<br>

<%--
    <%@include file=""%>就是静态包含
        file属性指定要包含的jsp页面路径
        地址中第一个斜杠/ 表示http://ip:port/工程路径/ 映射到代码的web目录
--%>
    <%@include file="/include/footer.jsp"%>
</body>
</html>
```

1. 静态包含不会翻译被包含jsp页面
2. 静态包含其实是把被包含的jsp页面的代码拷贝到包含的位置执行输出

#### jsp动态包含

```jsp
<jsp:include page="footer.jsp"></jsp:include>
```

配置属性是指定的jsp页面路径

1. 动态包含可以像静态包含一样，把被包含的内容执行输出到包含位置。
2. 动态包含会把包含的jsp页面也**翻译成java代码**
3. 动态包含底层代码去调用被包含的jsp页面执行输出
4. 动态包含还可以**传递参数**

#### 请求转发

```jsp
<jsp:forward page="../2.jsp"></jsp:forward>
```

![image-20201229201800376](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20201229201800376.png)

### Listener监听器

JavaWeb三大组件：**Servlet程序，Filter过滤器、Listener监听器**

Listener是javaEED的规范，即接口

监听器的作用就是监听某种事物的变化，然后通过回调函数，反馈给用户程序去做一些相应的处理

#### SerlvetContextListener监听器

SerlvetContextListene可以监听SerlvetContex对象的创建和销毁

ServlevtContext对象在web工程启动的时候创建，在web工程停止的时候销毁

监听到创建和销毁之后都会分别调用SerlvetContextListene监听器的方法反馈

```java
public interface ServletContextListener extends EventListener{
	//在ServletContext对象创建之后马上调用，做初始化
	public void contextInitialized(ServletContextEvent sce);
	//在SerlvetContext对象销毁之后调用
	public void contextDestroyed(ServletContextEvent sce);
}
```

#### 实现步骤

1. 编写一个类去实现ServletContextListener
2. 实现其两个回调方法
3. 到web.xml中去配置监听器

```java
public class myListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContextListener对象初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContextListener对象销毁");
    }
}
```

```xml
<listener>
    <listener-class>com.qiangliu8.serlvet.Listener.myListener</listener-class>
</listener>
```

### EL表达式

EL表达式的全称是Expression Language是表达式语言

表达式主要代替jsp页面中的表达式脚本在jsp页面中进行数据的输出

```jsp
<body>
    <%
    request.setAttribute("key1","value1");
    %>
    <%=request.getAttribute("key1")%>
    ${key2}
</body>
```

#### EL表达式搜索域数据的顺序

主要是输出**域对象**中的数据

会根据域对象**从小到大**的顺序输出数据 pageContext>request>session>application

```jsp
<%
    Person person = new Person();
    person.setName("刘强");
    person.setName("15209842010");
    List<String> cities = new ArrayList<String>();
    cities.add("合肥");
    cities.add("南昌");
    person.setCities(cities);
    Map<String,Object> map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    person.setMap(map);

    pageContext.setAttribute("person",person);
%>
${person}
//person{name=15209842010, phones=null, cities=[合肥, 南昌], map={key1=value1, key2=value2, key3=value3}} 
${person.cities} 
//[合肥, 南昌]
```

#### empty运算

empty运算可以判断一个数据是否为空，如果为空，则输出true,不为空输出false 

以下几种情况为空:

1. 值为null 值的时候，为空
2. 值为空串的时候，为空
3. 值是object类型数组，长度为零的时候
4. list集合，元素个数为零
5. map集合，元素个数为零

```jsp
<%
    request.setAttribute("key1",null);
    request.setAttribute("key2","");
    request.setAttribute("key3",new Object[]{});
    List<String> list = new ArrayList<>();
    request.setAttribute("key4", list);
    Map<String,Object> map = new HashMap<>();
    request.setAttribute("key5",map);
%>
${empty key1}//true
${empty key2}//true
${empty key3}//true
${empty key4}//true
${empty key5}//true
```

#### El表达中11个隐含对象

|     变量     |         类型         |                        作用                        |
| :----------: | :------------------: | :------------------------------------------------: |
| pageContext  |   pageContextimpl    |            可以获取jsp中的九大内置对象             |
|              |                      |                                                    |
|  pageScope   |  Map<String,Object>  |          它可以获取pageContext域中的数据           |
| requestScope |  Map<String,Object>  |            它可以获取request域中的数据             |
| sessionScope |  Map<String,Object>  |            它可以获取Session域中的数据             |
| application  |  Map<String,Object>  |         它可以获取SerlvetContext域中的数据         |
|              |                      |                                                    |
|    param     |  Map<String,String>  |                可以获取请求参数的值                |
| ParamValues  | Map<String,String[]> |        可以获取请求参数的值，获取多个值使用        |
|              |                      |                                                    |
|    header    |  Map<String,String>  |                 可以获取请求头信息                 |
| headerValues | Map<String,String[]> |         可以获取请求头信息,获取,多个值使用         |
|              |                      |                                                    |
|    cookie    |  Map<String,Cookie>  |              可以获取请求的Cookie信息              |
|              |                      |                                                    |
|  initParam   |  Map<String,String>  | 它可以获取在web.xml配置的<context-param>上下文参数 |

#### EL获取四个特定域中的属性

省去了重复名的麻烦

```java
<%pageContext.setAttribute("name","刘强");%>
${pageScope.name}

<%request.setAttribute("name","俞文竹");%>
${requestScope.name}

<%session.setAttribute("name","老婆");%>
${sessionScope.name}

<%application.setAttribute("name","我爱你");%>
${applicationScope.name}
```

#### pageContext对象

```jsp
<%--<%=request.getScheme()%>它可以获取请求的协议--%>
协议:${pageContext.request.scheme}<br>  //http
<%--<%=request.getServerName()%>它可以获取请求的服务器ip--%>
服务器ip:${pageContext.request.serverName}<br> //localhost
<%--<%=request.getServerPort()%>它可以获取请求的服务器端口--%>
服务器端口:${pageContext.request.serverPort}<br> //8080
<%--<%=request.getContextPath()%>它可以获取请求的工程路径--%>
获取工程路径:${pageContext.request.contextPath}<br> //  /EL_war_exploded
<%--<%=request.getMethod()%>它可以获取请求的请求方法--%>
获取请求方法:${pageContext.request.method}<br>  //GET
<%--<%=request.getRemoteHost()%>它可以获取请求的工程路径--%>
获取客户端ip地址:${pageContext.request.remoteHost}<br> //0:0:0:0:0:0:0:1
<%--<%=request.getRequestedSessionId()%>它可以获取请求的会话的id编号--%>
获取会话的id编号:${pageContext.request.requestedSessionId}<br> //C33BB1464466FDC556C0A94564414EBA

```

**企业改进技巧**

```java
<%pageContext.setAttribute("req",request);%>
协议:${req.scheme}<br>
ip:${req.serverName}<br>
服务器端口:${req.serverPort}<br>
获取工程路径:${req.contextPath}<br>
获取请求方法:${req.method}<br>
获取客户端ip地址:${req.remoteHost}<br>
获取会话的id编号:${req.session.id}<br>
```

#### Param

```java
//http://localhost:8080/EL_war_exploded/3.jsp?username=123&password=222
${param.username} //123
${paramValues['password'][0]} //222
${paramValues.username[0]} //123
```

#### header

```java
${header['User-Agent']}//Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36
${header.Connection} //keep-alive
等同于
${headerValues['User-Agent'][0]}<br>
${headerValues.Connection[0]}
```

#### cookie

```java
${cookie}//{Idea-df8a462a=javax.servlet.http.Cookie@6a5e767a, JSESSIONID=javax.servlet.http.Cookie@279267af}
${cookie.JSESSIONID}//javax.servlet.http.Cookie@27c25e91
//获取cookie的名称
${cookie.JSESSIONID.name}//JSESSIONID
//获取cookie的值
${cookie.JSESSIONID.value}//C33BB1464466FDC556C0A94564414EBA
```

#### initParam

它可以获取在web.xml配置的<context-param>上下文参数

```xml
<context-param>
    <param-name>username</param-name>
    <param-value>刘强</param-value>
</context-param>
```

```java
${initParam} //{username=刘强}
${initParam.username} //刘强
```

### JSTL标签库

JSTL标签库全称是指JSP Standard Tag Library JSP标准标签库。是一个不断完善的开放源代码的JSP标签库

EL表达式主要是为了替换jsp中的表达式脚本，而标签库则是为了替换代码脚本。这样使得整个jsp页面变得更佳简洁。

![image-20201230141435723](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20201230141435723.png)

#### JSTL标签库的使用步骤

1. 先导入jstl标签库的jar包。

   taglibs-standard-impl-1.2.1.jar

   taglibs-standard-spec-1.2.1.jar

2. 使用taglib指令引入标签库。

```java
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

#### core核心库使用

##### <<c:Set/>>

<<c:Set/>>可以往域中保存数据

scope 属性设置保存到哪个域

page表示Pagecontext域（默认值)

request表示Request域

session表示Session域

application表示Servletcontext域

var属性设置key是多少

vaLue属性设置值

```java
<c:set
scope="request"
var="name"
value="liuqiang"
/>
${requestScope.name} 
```

##### <<c:if/>>

if标签用来做if判断

```java
<c:if test="${12==12}">
    <%--test属性表示判断的条件--%>
    <h1>12==12</h1>
</c:if>
```

##### <<c:hoose/>><<c:when/>><<c:otherwise/>>

多路判断，跟switch...case...default类似

choose标签表示开始选择判断

when标签表示每一种判断情况，满足一个条件就不执行其他的了

​	test属性表示当前这种哦按段情况的值

otherwise表示剩下的情况

```java
    <%
        request.setAttribute("height",1628);
    %>
    <c:choose>
        <c:when test="${height<170}">小矮子</c:when>
        <c:when test="${height<180}">标准身高</c:when>
        <c:when test="${height<190}">大巨人</c:when>
        <c:otherwise>非人类</c:otherwise>
    </c:choose>
```

##### <<c:forEach>>

遍历输出使用

begin属性设置开始的索引

end属性设置结束的索引

setp默认为1表示步长

var属性表示循环的变量(也是当前正在遍历到的数搪)

```java
<c:forEach begin="0" end="10" var="i">
    ${i}
</c:forEach>
```

**forEach遍历Object数组**

```java
<%
    request.setAttribute("arr",new String[]{"186444","444455","4564655"});
%>
<c:forEach items="${arr}" var="item">
    <br/>${item}
</c:forEach>
```

**forEach遍历Map**

```java
<%
    Map<String,Object> map = new HashMap<String,Object>();
    map.put("name","刘强");
    map.put("age","18");
    map.put("sex","男");
	request.setAttribute("map",map);
%>
    //jsp
<%
    for (Map.Entry<String,Object> entry:map.entrySet()) {
        out.println(entry);
    }
%>
    //el
<c:forEach items="${map.entrySet()}" var="item">
	${item.key}:${item.value}
</c:forEach>
```

**forEach遍历List**

```java
   <%
        List<Student> studentList = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            studentList.add(new Student(i,"刘强"+i,"Lq060528"+i,18+i,"15755337162"+i));
        }
        request.setAttribute("studentList",studentList);
    %>

    <table>
        <c:forEach begin="0" end="9" varStatus="status" items="${studentList}" var="item">
            <tr>
                <td>${item.getId()}</td>
                <td>${item.getUsername()}</td>
                <td>${item.getPassword()}</td>
                <td>${item.getAge()}</td>
                <td>${item.getPhone()}</td>
                <td>删除、修改</td>
                <td>${status.index}</td>
                <td>${status.count}</td>
                <td>${status.first}</td>
            </tr>
        </c:forEach>
    </table>
            
0	刘强0	Lq0605280	18	157553371620	删除、修改	0	1	true
1	刘强1	Lq0605281	19	157553371621	删除、修改	1	2	false
2	刘强2	Lq0605282	20	157553371622	删除、修改	2	3	false
3	刘强3	Lq0605283	21	157553371623	删除、修改	3	4	false
4	刘强4	Lq0605284	22	157553371624	删除、修改	4	5	false
5	刘强5	Lq0605285	23	157553371625	删除、修改	5	6	false
6	刘强6	Lq0605286	24	157553371626	删除、修改	6	7	false
7	刘强7	Lq0605287	25	157553371627	删除、修改	7	8	false
8	刘强8	Lq0605288	26	157553371628	删除、修改	8	9	false
9	刘强9	Lq0605289	27	157553371629	删除、修改	9	10	false
```

##### status的属性值

![image-20201230165213619](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20201230165213619.png)

### 文件上传和下载

#### 文件上传

1. 要有一个form标签，method = post请求
2. form标签的encType属性值必须为multipart/form-data值
3. 在form标签中使用input type=file添加上传的文件
4. 编写服务器代码接受处理上传的数据

enctype=multipart/form-data表示提交的数据，以多段（每一个表单项一个数据段）的形式进行拼接，然后以二进制流的形式发送给服务器

boundary表示每段数据的分隔符，浏览器每次随机生成

```java
ServletInputStream servletInputStream = req.getInputStream();
byte[] buffer = new byte[1024000];
int read = servletInputStream.read(buffer);
System.out.println(new String(buffer,0,read));
```

##### commons-fileupload.jar常用API

第一步导入commons-fileupload.jar和commons-io.jar

![](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20201230202029286.png)

![](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20201230202456553.png)

```java
//先判断上传数据是否是多段数据
if (ServletFileUpload.isMultipartContent(req)){
    //创建FileItemFactory工厂实现类
    FileItemFactory fileItemFactory = new DiskFileItemFactory();
    //创建用于解析上传数据的工具类ServletFileUpload类
    ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
    try {
        //解析上传的数据，得到一个每一个表单项FileItem
        List<FileItem> list = servletFileUpload.parseRequest(req);

        for (FileItem fileItem:list) {
            if (fileItem.isFormField()){
                //普通表单项
                System.out.println("表单项的name属性值:"+fileItem.getFieldName());
                //解决乱码问题
                System.out.println("表单项的name属性值"+fileItem.getString("UTF-8"));
            }else{
                //上传的文件
                System.out.println("表单项的name属性值:"+fileItem.getFieldName());
                System.out.println("上传的文件名:"+fileItem.getName());
                fileItem.write(new File("E:\\Project\\Java\\XML\\" + fileItem.getName()));
            }
        }
    } catch (FileUploadException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

#### 文件下载

```java
//1.获取下载的文件名
String downloadFileName = "1.jpg";
//2.读取要下载的文件内容
ServletContext servletContext = getServletContext();
//3.获取要下载的文件类型
String mimeType = servletContext.getMimeType("/file/"+downloadFileName);
//6在回传前，通过响应头告诉客户端返回的数据类型
resp.setContentType(mimeType);
System.out.println(mimeType);
//7告诉客户端收到数据时候用于下载(使用响应头)
//attachment表示附件
//URL编码是把汉字转换成XX%XX的格式
resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(downloadFileName,"UTF-8") );

InputStream inputStream =  servletContext.getResourceAsStream("/file/"+downloadFileName);
//4获取响应的输出流
OutputStream outputStream = resp.getOutputStream();
//5把下载的文件内容回传给客户端
//读取输入流中全部数据，赋值给输出流，输出给客户端
IOUtils.copy(inputStream,outputStream);
```

#### Base64编码

```java
public static void main(String[] args) throws UnsupportedEncodingException {
        String content ="这是需要Base64编码的内容";
        //黄健一个Base64编码器
//        BASE64Encoder base64Encoder = new BASE64Encoder();
        //执行Base64编码操作
        String encodeString = Base64.getEncoder().encodeToString(content.getBytes(StandardCharsets.UTF_8));

        System.out.println(encodeString);

        //执行解码操作
        byte[] b = Base64.getDecoder().decode(encodeString);
        String decodeString = new String(b,"UTF-8");
        System.out.println(decodeString);
}
```

#### 判断浏览器决定编码方式

```java
if (!req.getHeader("User-Agent").contains("Firefox")){
    //如果不是火狐，使用URL编码
    resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(downloadFileName,"UTF-8") );
}else{
    //如果是火狐，使用Base64编码
    resp.setHeader("Content-Disposition","attachment;filename==?UTF-8?B?"+Base64.getEncoder().encode(downloadFileName.getBytes("UTF-8")));
}
```

#### 反射

反射案例

```java
package com.qiangliu8.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServletTest {
    public void login(){
        System.out.println("这是login方法");
    }
    public void regist(){
        System.out.println("这是regist方法");
    }
    public void updateUser(){
        System.out.println("这是updateUser方法");
    }
    public void updateUserPassword(){
        System.out.println("这是updateUserPassword方法");
    }

    public static void main(String[] args) {
        String action = "regist";

        try {
            //获取action业务鉴别字符串，获取相应的业务方法 反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);
            //调用目标业务方法
            method.invoke(new UserServletTest());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
```

#### 通过反射优化登录代码

```java
String action = req.getParameter("action");

try {
    Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
    method.invoke(this,req,resp);
} catch (NoSuchMethodException e) {
    e.printStackTrace();
} catch (IllegalAccessException e) {
    e.printStackTrace();
} catch (InvocationTargetException e) {
    e.printStackTrace();
}
```

### 数据封装和抽取BeanUtils

BeanUtils它可以一次性的把所有请求的参数注入到JavaBean中

BeanUtils不是JDK的类，而是第三方的工具类。

需要导两个包![image-20210101151540238](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210101151540238.png)

```java
public class WebUtils {
    public static <T> T copyParamToBean(Map value, T bean){
        try {
            /*
            把所有请求的注入到User对象中
            * */
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
//泛型更加优雅
```

使用BeanUtils

```java
User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());
```



### MVC

MVC全称:**Model模型**、**View视图**、**Controller 控制器**

MVC最早出现在JavaEE三层中的 web层，它可以有效的指导web层的代码如何有效分离，单独工作。

**View视图**:只负责数据和界面的显示，不接受任何与显示数据无关的代码，便于程序员和美工的分工合作一一JSP/HTML

**Controller控制器**:只负责接收请求,调用业务层的代码处理请求,然后派发页面,是一个“调度者”的角色——Servlet转到某个页面。或者是重定向到某个页面

**Model模型**:将与业务逻辑相关的数据封装为具体的JavaBean类，其中不掺杂任何与数据处理相关的代码——JavaBean/domain/entity 
**Mvc是一种思想**
MVc的理念是将软件代码拆分成为组件，单独开发，组合使用〈目的还是为了**解耦合**〉。

![image-20210101165243046](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210101165243046.png)

#### 分页

![image-20210103145203518](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210103145203518.png)

## Cookie

### 什么是Cookie

1. Cookie翻译过来是饼干的意思。
2. Cookie是服务器通知客户端保存键值对的一种技术。
3. 客户端有了cookie后，每次请求都发送给服务器。
4. 每个 cookie的大小不能超过4kb

### 如何创建Cookie  

```java
//创建Cookie对象
Cookie cookie1 = new Cookie("key1","value1");
Cookie cookie2 = new Cookie("key2","value2");
Cookie cookie3 = new Cookie("key3","value3");
//通过客户端保存cookie
resp.addCookie(cookie1);
resp.addCookie(cookie2);
resp.addCookie(cookie3);
resp.getWriter().write("Cookie创建成功！");
```

### 如何获取Cookie  

```java
Cookie[] cookies = req.getCookies();
Cookie mycookie = null;
for (Cookie cookie:cookies){
 	resp.getWriter().write("Cookie["+cookie.getName()+"="+cookie.getValue()+"]<br/>");
    if(cookie.getName().equals(”key1“)){
        mycookie = cookie;
    }
}

if(mycookie!=null){
    resp.getWriter().write("找到Cookie");
}
```

### Cookie值的修改

方案一:

1. 先创建一个要修改的同名的Cookie对象
2. 在构造器，同时赋于新的 Cookie值
3. 调用response.addCookie( Cookie )

![image-20210104222755285](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210104222755285.png)

方案二:

1. 先查找到需要修改的Cookie对象
2. 调用setValue()方法赋于新的 Cookie值。
3. 调用response.addCookie()通知客户端保存修改

```
Cookie[] cookies = req.getCookies();
Cookie cookie = CookieUtils.findCookie("key2",cookies);
cookie.setValue("asd");
resp.addCookie(cookie);
resp.getWriter().write("Cookie修改成功！");
```

### Cookie生命控制

Cookie的生命控制指的是如何管理Cookie什么时候被销毁

```java
Cookie.setMaxAge()
```

设置cookie的最大生存时间，以秒为单位。

```java
//负值意味着cookie不会被持久存储，将在 Web浏览器退出时删除。
protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie cookie = new Cookie("defautLife","defautLifeName");
    cookie.setMaxAge(-1); //设置存活时间 关闭浏览器cookie消失
    resp.addCookie(cookie);
}
//0值会导致删除cookie
protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie cookie = CookieUtils.findCookie("defautLife",req.getCookies());
    cookie.setMaxAge(0); //立即删除
    resp.addCookie(cookie);
}
//正值表示cookie将在经过该值表示的秒数后过期。
protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie cookie = CookieUtils.findCookie("defautLife",req.getCookies());
    cookie.setMaxAge(3600); //Cookie存活3600秒（1小时）
    resp.addCookie(cookie);
}
```

### Cookie有效路径Path的设置

Cookie的path属性可以有效的过滤哪些Cookie可以发送给服务器，哪些不发。path属性是通过请求的地址来进行有效的过滤。

![image-20210105161253121](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210105161253121.png)

```java
protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie cookie = new Cookie("path1","value1");
    cookie.setPath(req.getContextPath()+"/abc");
    resp.addCookie(cookie);
    resp.getWriter().write("创建了代替有路径的cookie");
}
```

## Session会话

Session就是一个接口，一个会话，它是用来维护一个客户端和服务器直接关联的一种技术。

每个客户端都有自己的一个Session会话

Session会话中，经常用来保存用户登录之后的信息。

### 如何创建Session和获取

```java
//创建和获取Session会话对象
//第一次调用是：创建Sesson会话
//之后调用都是：获取创建好的Session会话对象
HttpSession httpSession = req.getSession();

resp.getWriter().write("Session："+httpSession);
resp.getWriter().write("SessionisNew："+isNew);
resp.getWriter().write("Sessionid："+id);
```

```java
//判断当前Session是否是刚创建出来的 true表示刚创建 false表示之前创建
boolean isNew = httpSession.isNew();
```

```java
//获取Session会话的唯一标识id
String id = httpSession.getId();
```

### Session域中存取数据

```java
//存
protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getSession().setAttribute("session1","valu1");
    resp.getWriter().write("session存进去了");
}
```

```java
//取
protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Object o =  req.getSession().getAttribute("session1");
    resp.getWriter().write("session1："+o);
}
```

### Session生命周期控制

**获取Session的超时时间**

```java
protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int  time = req.getSession().getMaxInactiveInterval();
    resp.getWriter().write("session默认时长："+time);//session默认时长：1800	
}

```

**设置Session的超时时间**（以秒为单位），超过指定时长，自动销毁  -1表示永不超时 0没用

```
protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getSession().setMaxInactiveInterval(3);
    resp.getWriter().write("Session3秒超时销毁");
}
```

session默认的超时时间长为30分钟。
因为在Tomcat服务器的配置文件web.xml中默认有以下的配置,它就表示配置了当前Tomcat服务器下所有的session超时配置默认时长为:30分钟。

```xml
<session-config>
    <session-timeout>20</session-timeout>
</session-config>
```

**销毁删除Session**

```java
protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getSession().invalidate();
    resp.getWriter().write("session时长为0.即Session马上销毁");
}
```

### Session和Cookie的关联

![image-20210105212147108](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210105212147108.png)

#### 验证码流程

1. 导入谷歌验证码的jar包
   			kaptcha-2.3.2.jar

2. 在web.xml中配置用户生成验证码的Servlet程序

   ```xml
   <servlet>
       <servlet-name>KaptchaServlet</servlet-name>
       <servlet-class>com.google.code.kaptcha.servlet.KaptchaServlet</servlet-class>
   </servlet>
   <servlet-mapping>
       <servlet-name>KaptchaServlet</servlet-name>
       <url-pattern>/kaptcha.jpg</url-pattern>
   </servlet-mapping>
   ```

3. 在表单中使用img标签使用它

4. 在服务器获取谷歌生魂的验证码和客户端发送过来的验证码比较使用。

     ```java
     //获取Seesion的验证码
     String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
     //删除服务器中的验证码
     req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
     if (token!=null&&token.equalsIgnoreCase(code)){
     	
     }
     ```

##### 切换验证码

```javascript
$("#codeImg").click(function (){
   this.src="${basePath}/kaptcha.jpg"
})
```

### Filter过滤器

1. Filter过滤器它是JavaWeb的三大组件之一。三大组件分别是:Servlet程序、Listener监听器、Filter过滤器
2. Filter过滤器它是JavaEE的规范。也就是接口
3. Filter过滤器它的作用是:拦截请求，过滤响应

拦截请求常见的应用场景有:

1. 权限检查
2. 日记操作
3. 事务管理

 

要求在web工程下有一个admin目录，要求admin目录底下的所有资源需要用户权限才能访问 

**构建Filter类**

```java
public class AdminFilter implements Filter {
        //专门用来拦截请求，可以做权限检查
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user  = session.getAttribute("user");
        if (user==null){
            httpServletRequest.getRequestDispatcher("./login.jsp").forward(servletRequest,servletResponse);
            return;
        }else{
            //让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
```

**XML配置**

```xml
    <filter>
        <filter-name>AdminFilter</filter-name>
        <filter-class>com.qiangliu8.filter.AdminFilter</filter-class>
    </filter>
<!-- filter-mapping配置Filter过滤器的拦截路径&ndash;&gt;-->
    <filter-mapping>
        <filter-name>AdminFilter</filter-name>
        <url-pattern>/admin/*</url-pattern>
    </filter-mapping>
```

#### Filter生命周期

1. 构造器方法

2. init 初始化方法

   **1,2步在web工程启动时就已经执行**

3. doFilter方法

   **doFilter在每次拦截到请求就会执行**

4. 销毁destroy方法

   **destroy在停止web工程时执行**



#### FilterConfig类

Filter过滤器的配置文件类

Tomcat每次创建Filter的时候，也会同事创建一个FilterConfig类，这里包含了Filter配置文件的配置信息

获取filter过滤器的配置内容

```xml
<filter>
   <init-param>
        <param-name>username</param-name>
        <param-value>root</param-value>
   </init-param>
   <init-param>
        <param-name>url</param-name>
        <param-value>www.baidu.com</param-value>
   </init-param>
</filter>
```

```java

public void init(FilterConfig filterConfig) throws ServletException {
    //获取Filter的名称 filter-name的内容
    System.out.println(filterConfig.getFilterName());
    //获取Filter的init-param的内容
    System.out.println(filterConfig.getInitParameter("username"));
    System.out.println(filterConfig.getInitParameter("url"));
    //获取ServletContext对象
    System.out.println(filterConfig.getServletContext());
}

```

### FilterChain过滤器链

多个过滤器一起工作

FilterChain.doFilter()方法的作用

1. 执行下一个Filter过滤器（如果有Filter）
2. 执行目标资源（没有Filter）

#### FilterChain过滤流程

![image-20210119224747905](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210119224747905.png)

```xml
<filter>
    <filter-name>Filter1</filter-name>
    <filter-class>com.qiangliu8.filter.Filter1</filter-class>
</filter>
<filter-mapping>
    <filter-name>Filter1</filter-name>
    <url-pattern>/target.jsp</url-pattern>
</filter-mapping>

<filter>
    <filter-name>Filter2</filter-name>
    <filter-class>com.qiangliu8.filter.Filter2</filter-class>
</filter>
<filter-mapping>
    <filter-name>Filter2</filter-name>
    <url-pattern>/target.jsp</url-pattern>
</filter-mapping>
```

**Filter1**

```java
@Override
public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    System.out.println("Filter1前置代码1");
    filterChain.doFilter(servletRequest,servletResponse);
    System.out.println("Filter1后置代码1");
}
```

**Filter2**

```java
@Override
public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    System.out.println("Filter2前置代码1");
    filterChain.doFilter(servletRequest,servletResponse);
    System.out.println("Filter2后置代码1");
}
```

**多个Filter过滤器执行的特点：**

1. 所有filter和目标资源默认在同一个线程
2. 多个filter共同执行的时候，共同使用的同一个Request对象

#### Filter的拦截路径

**只关心请求地址是否匹配，不关心资源是否存在**

##### 精确匹配

```xml
<url-pattern>/target.jsp</url-pattern>
```

以上配置的路径，表示请求地址必须为:http://ip:port/工程路径/target.jsp

##### 目录匹配

```xml
<url-pattern>/admin/*</url-pattern>
```

以上配置的路径，表示请求地址必须为:http://ip:port/工程路径/admin/*

##### 后缀名匹配

```xml
<url-pattern>/admin/*.html</url-pattern>
```

以上配置的路径，表示请求地址必须以.html结尾才会拦截到

**不能以斜杠打头！！！！**

### ThreadLocal

可以解决多线程的数据安全问题

可以给当前线程关联一个数据(可以是普通变量，可以是对象，也可以是数组，集合)

特点

1. **ThreadLocal可以为当前线程关联一个数据**（它可以像Map一样存取数据，key为当前线程)
2. **每一个ThreadLocal对象只能为当前线程关联一个数据，如果为当前线程关联多个数据，需要多个ThreadLocal对象**
3. **每个ThreadLocal对象实例定义的时候，一般都是static类型**
4. **ThreadLocal保存的数据，在线程销毁后，会有JVM自动销毁**

**使用ThreadLocal**

```java
public class ThreadLocalTest {
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
    private static  Random random = new Random();

    public static class Task implements Runnable{

        @Override
        public void run() {
            //run方法中随机生成一个变量（线程要关联的数据），然后以当前线程名为key保存到map中
            Integer i = random.nextInt(1000);
            //获取当前线程名
            String name = Thread.currentThread().getName();
            System.out.println("线程名："+name+" 随机数："+i);
            threadLocal.set(i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new OrderService().createOrder();
            //在run方法结束之前，以当前线程名获取出数据并打印，查看是哦福可以取出操作
            Object object = threadLocal.get();
            System.out.println(name+"线程，"+"结束关联的数据为"+object);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <3 ; i++) {
            new Thread(new Task()).start();
        }
    }
}
```

使用data

```java
public class ThreadLocalTest {
    public final static Map<String,Object> data = new ConcurrentHashMap<String,Object>();
    private static  Random random = new Random();

    public static class Task implements Runnable{

        @Override
        public void run() {
            //run方法中随机生成一个变量（线程要关联的数据），然后以当前线程名为key保存到map中
            Integer i = random.nextInt(1000);
            //获取当前线程名
            String name = Thread.currentThread().getName();
            System.out.println("线程名："+name+" 随机数："+i);
            data.put(name,i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new OrderService().createOrder();
            //在run方法结束之前，以当前线程名获取出数据并打印，查看是哦福可以取出操作
            Object object = data.get(name);
            System.out.println(name+"线程，"+"结束关联的数据为"+object);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <3 ; i++) {
            new Thread(new Task()).start();
        }
    }
}
```

**OrderService类**

```
public class OrderService {
    public void createOrder(){
        String name = Thread.currentThread().getName();
        System.out.println("当前线程保存的数据"+ThreadLocalTest.threadLocal.get());
    }
}
```

我们可以使用ThreadLocal对象。来确保所有操作都使用同一个Connection象'

ThreadLocal要确保所有操作都使用同一个Connection连接对象。

那么操作的前提条件是所有操作都必须在同一个线程中完成!



#### tomcat配置错误页面

```
//服务器出错之后，服务器自动跳转的页面
<error-page>
    <location></location>
</error-page>
```

### JSON

JSON(JavaScr ipt Object Notaticn)是一种轻量级的数据交换格式。易于人阅读和编写。同时也易于机器解析和生成。JSON采用完全独立于语言的文本格式，而且很多语言都提供了对json的支持(包括C,C++,C#。Java,JavaScript, Perl, Pythan等)。这样就使得JSON成为理想的数据交换格式。

json是一种轻量级的数据交换格式。

轻量级指的是跟xml做比较。

数据交换指的是客户端和服务器之间业务数据的传递格式。

#### json的定义

json是由壁值对组成，并且由花括号（大括号）包围。每个键由引号引起来，键和值之间使用冒号进行分隔，组键值对之间进行逗号进行分隔。

```javascript
// json的定义
var jsonObj = {
   "name":"刘强",
   "age":23,
   "sex":true,
   "parent":[1,"arr",false],
   "json":{
      "name":"刘强",
      "age":23,
      "sex":true,
      "parent":[1,"arr",false],
   },
   "jsonArr":[{
         "name":"刘强",
         "age":23,
      },
      {
         "name":"刘强",
         "age":23,
      }
   ]
}
```

```javascript
alert(typeof jsonObj);//json就是一个对象
```

#### json的访问

json本身是一个对象。

json中的 key我们可以理解为是对象中的一个属性。

json中的 key访间就跟访问对象的属性一样:json对象.key

```java
// json的访问
console.log(jsonObj.name)
console.log(jsonObj.json)
```

#### json的两个常用方法

一种是：对象的形式存在，我们叫它json对象。

一种是：字符串的形式存在，我们叫它 json字符串。

转换方式：

```javascript
JSON.stringify() //把json对象转换成json字符串
JSON.parse() //把json字符串转换成json的对象
```

#### JSON在Java中的转换

##### javaBean和json的互转

```java
Person person = new Person(1,"刘强");
//创建Gson对象实例
Gson gson = new Gson();
//toJson方法可以将java对象转换成json字符串
String personJsonString = gson.toJson(person);
System.out.println(personJsonString);
//toJson方法可以将json字符串转换成java对象
Person person1 = gson.fromJson(personJsonString,Person.class);
System.out.println(person1);
```

##### List和json的互转

```java
List<Person> list = new ArrayList<>();
list.add(new Person(1,"刘强"));
list.add(new Person(2,"俞文竹"));
Gson gson = new Gson();
String personListString = gson.toJson(list);
System.out.println(personListString);
List list1 = gson.fromJson(personListString,new PersonListType().getType());
Person person = (Person) list1.get(0);
System.out.println(person);
```

```
public class PersonListType extends TypeToken<ArrayList<Person>> {
}
```

##### Map和json的互转

```java
Map<Integer,Person> personMap = new HashMap<>();

personMap.put(1,new Person(1,"刘强"));
personMap.put(2,new Person(2,"俞文竹"));
Gson gson = new Gson();

String personMapString = gson.toJson(personMap);
System.out.println(personMapString);
Map<Integer,Person> map = gson.fromJson(personMapString,new PersonMapType().getType());
System.out.println(map);
System.out.println(map.get(1));
```

```java
public class PersonMapType extends TypeToken<HashMap<Integer,Person>> {
}
```

##### 使用匿名内部类

```java
Map<Integer,Person> map = gson.fromJson(personMapString,new TypeToken<HashMap<Integer,Person>>(){}.getType());
```

### Ajax

#### 原生ajax

```javascript
function ajaxRequest() {
    //1、我们首先要创建XMLHttpRequest 
    var xmlHttpRequest =new XMLHttpRequest();
    //2、调用open方法设置请求参数
    xmlHttpRequest.open("GET","http://localhost:8080/json/ajaxServlet?action=javascriptAjax",true);
    //3、在send方法前绑定onreadystatechange事件，处理请求完成后的操作。
    xmlHttpRequest.onreadystatechange= function (){
        if (xmlHttpRequest.readyState===4&&xmlHttpRequest.status===200){
            var json = JSON.parse(xmlHttpRequest.responseText)
            $("#div01").text(json.name);
        }
    }
    //4、调用send方法发送请求
    xmlHttpRequest.send();
}
```

#### JQuery中的ajax

$.ajax方法

url				表示请求的地址

type			 表示请求的类型GET 或POST请求

data			表示发送给服务器的数据格式有两种:
							一: name=value&name=valu

​					二:{key: value}

success		请求成功，响应的回调函数

dataType	响应的数据类型  常用的数据类型有：

​					text:表示纯文本

​					xml表示xml数据

​					json表示json对象

​					

```javascript
$.ajax({
   url:"http://localhost:8080/json/ajaxServlet",
   data:"action=jqAjax",
   type:"GET",
   dataType:"json",
   success:function (data){
      alert(data)
   }
})
```

**get**

```javascript
$.get("http://localhost:8080/json/ajaxServlet","action=jqAjax",function (data){
   console.log("jquery.get")
},"json");
```

**post**

```javascript
$.post("http://localhost:8080/json/ajaxServlet","action=jqAjax",function (data){
   console.log("jquery.post")
},"json");
```

**getJSON**

```javascript
$.getJSON("http://localhost:8080/json/ajaxServlet","action=jqAjax",function (data){
   console.log(data)
})
```

**serialize()**

可以把表单中所有表单项的内容都获取到，并以name=value&name=value的形式进行拼接

```javascript
$.getJSON("http://localhost:8080/json/ajaxServlet","action=jqserialize&"+$("#form01").serialize(),function (data){
   console.log(data)
})
```

#### i18国际化

![image-20210122171710636](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210122171710636.png)

**获取当前系统默认的语言**

```java
@Test
public void testLocale(){
    Locale locale = Locale.getDefault();
    System.out.println(locale);//zh_CN
   	System.out.println(Locale.CHINA)//获取中文，中文的常量的Locale对象
}
```

根据当前local获取文件名

```java
Locale locale = Locale.getDefault();
System.out.println(locale);
ResourceBundle bundle = ResourceBundle.getBundle("i18n",Locale.CHINA);
System.out.println(bundle.getString("username"));
```

##### 使用JSTL标签进行国际化

```java
<%--   1使用标签设置Locale信息--%>
   <fmt:setLocale value="${param.local}"/>
<%--   //2使用标签设置baseName3--%>
   <fmt:setBundle basename="i18n"/>
<%--      //使用标签输出国际化信息--%>
<fmt:message key="username"/>
<a href="i18n_fmt.jsp?country=zh_CN">中文</a>|
<a href="i18n_fmt.jsp?country=en_US">english</a>
```