package com.leesearch;

import com.alibaba.fastjson.JSON;
import impl.BrandServiceImpl;
import pojo.Brand;
import service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/com.leesearch.SelectAllServlet")
public class SelectAllServlet extends HttpServlet {


    private BrandService brandService = new BrandServiceImpl();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.调用service查询
        List<Brand> brands = brandService.selectAll();
        System.out.println(brands);

        // 2.转为JSON
        String jsonString = JSON.toJSONString(brands);

        // 3.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}



