package com.spring.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    private Object thisIsNOTThreadSafe; //Don't to this

/*    不应该使用Servlet或者Filter的实例变量来存放任何的请求或者会话范围内的数据
    。这些数据会被其他Session的所有请求共享。这是非线程安全的！下面的例子说明了这个问题：*/

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object thisIsThreadSafe;

        thisIsNOTThreadSafe = request.getParameter("foo"); // BAD!! Shared among all requests!
        thisIsThreadSafe = request.getParameter("foo"); // OK, this is thread safe.
    }
}
