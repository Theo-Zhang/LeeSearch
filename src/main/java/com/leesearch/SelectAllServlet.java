package com.leesearch;

import com.alibaba.fastjson.JSON;
import impl.BrandServiceImpl;
import impl.GPowerServiceImpl;
import pojo.Brand;
import pojo.GPower;
import service.BrandService;
import service.GPowerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mapper")
public class SelectAllServlet extends HttpServlet {


//    private BrandService brandService = new BrandServiceImpl();
    private GPowerService gPowerService = new GPowerServiceImpl();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 1.调用service查询
//        List<Brand> brands = brandService.selectAll();
//        System.out.println(brands);
//
//        // 2.转为JSON
//        String jsonString = JSON.toJSONString(brands);
//
//        // 3.写数据
//        response.setContentType("text/json;charset=utf-8");//告知浏览器响应的数据是什么， 告知浏览器使用什么字符集进行解码
//        response.getWriter().write(jsonString);

        // 1.调用service查询
        int ids = 2;
        List<GPower> GPowers = gPowerService.selectById(ids);
        //System.out.println(GPowers);
        for(GPower gPower:GPowers ){
            System.out.println(gPower.getThrust());
            System.out.println(gPower.getWatts());
        }


        // 2.转为JSON
        String jsonString = JSON.toJSONString(GPowers);

        // 3.写数据
        response.setContentType("text/json;charset=utf-8");//告知浏览器响应的数据是什么， 告知浏览器使用什么字符集进行解码
        response.getWriter().write(jsonString);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}



