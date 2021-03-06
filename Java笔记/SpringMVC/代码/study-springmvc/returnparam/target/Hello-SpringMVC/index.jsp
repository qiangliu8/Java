<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2021/2/28
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#submit").click(function (){
                $.ajax({
                    url:"returnVoid.do",
                    data:{
                        name:"刘强",
                        age:23
                    },
                    type:"POST",
                    dataType:"json",
                    success:function (data){
                        console.log(data)
                    }
                })
            })
            $("#submit2").click(function (){
                $.ajax({
                    url:"returnVoid2.do",
                    data:{
                        name:"刘强",
                        age:23
                    },
                    type:"POST",
                    dataType:"json",
                    success:function (data){
                        console.log(data)
                    }
                })
            })
            $("#submit3").click(function (){
                $.ajax({
                    url:"returnVoid3.do",
                    data:{
                        name:"刘强",
                        age:23
                    },
                    type:"POST",
                    dataType:"json",
                    success:function (data){
                        $.each(data,function (index,n){
                            console.log(index+".name:"+n.name)
                            console.log(index+".age:"+n.age)
                        })
                    }
                })
            })
            $("#submit4").click(function (){
                $.ajax({
                    url:"returnVoid4.do",
                    data:{
                        name:"刘强",
                        age:23
                    },
                    type:"POST",
                    //dataType:"json",
                    dataType:"text",
                    success:function (data){
                        console.log(data)
                    }
                })
            })
        })

    </script>
</head>
<body>

    <p>处理器方法返回String表示视图名称</p>
    <form action="returnString.do" method="post">
        <input type="text" name="name"/>
        <input type="text" name="age"/>
        <input type="submit" value="提交参数">
    </form>

    <p>处理器方法返回完整视图路径名称</p>
    <form action="returnString2.do" method="post">
        <input type="text" name="name"/>
        <input type="text" name="age"/>
        <input type="submit" value="提交参数">
    </form>
    <button id="submit">发起ajax请求</button>
    <button id="submit2">发起ajax请求</button>
    <button id="submit3">发起ajax请求</button>
    <button id="submit4">发起ajax请求</button>
</body>
</html>
