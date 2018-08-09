package com.neuedu.controller;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ProductC")
public class ProductC extends HttpServlet{
    ProductService  pService;
    @Override
    public void init() throws ServletException {
        //»ñÈ¡IOCÈÝÆ÷
        WebApplicationContext mWebApplicationContext
                = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        pService=(ProductService) mWebApplicationContext.getBean("pService");

    }
    @Override
    protected void service(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if("findProductById".equalsIgnoreCase(method)) {
            findProductById(request , response);
        } else if("findAll".equalsIgnoreCase(method)) {
            //findAll(request , response);
        }
    }
    public  void findProductById(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        String sid=request.getParameter("id");
        int id=0;
        try {
            id=Integer.parseInt(sid);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        Product product=findProductById(id);
        String callback=request.getParameter("callback");
        Gson gson=new Gson();
        String json=gson.toJson(product);
        PrintWriter printWriter=response.getWriter();
        printWriter.write(callback+"("+json+")");
    }
    public Product findProductById(int id) {
        return pService.findProductById(id);
    }
}
