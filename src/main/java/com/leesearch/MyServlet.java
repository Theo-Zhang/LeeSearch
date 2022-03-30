package com.leesearch;


import com.alibaba.fastjson.JSON;
import com.mathworks.toolbox.javabuilder.*;
import fitting.fittingResult;
import com.alibaba.fastjson.JSON;
import impl.GPowerServiceImpl;

import pojo.GPower;
import service.GPowerService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


// 服务器路径
@WebServlet("/result")
public class MyServlet extends HttpServlet {


    private GPowerService gPowerService = new GPowerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        float uavs = Float.parseFloat(request.getParameter("uavs"));
        float uav_mass = Float.parseFloat(request.getParameter("uav_mass"));
        float load_mass = Float.parseFloat(request.getParameter("load_mass"));
        float battery_mass = Float.parseFloat(request.getParameter("battery_mass"));
        float battery_energy_density = Float.parseFloat(request.getParameter("battery_energy_density"));
        int propeller_type = Integer.parseInt(request.getParameter("propellerType"));

        float totalMass = (uav_mass+load_mass+battery_mass)/uavs;
        System.out.println(totalMass);

        // 1.调用service查询
        int ids = propeller_type;
        List<GPower> GPowers = gPowerService.selectById(ids);
        //System.out.println(GPowers);
//        for(GPower gPower:GPowers){
//            System.out.println(gPower.getThrust());
//            System.out.println(gPower.getWatts());
//        }

//        // 2.转为JSON
//        String jsonString = JSON.toJSONString(GPowers);
//
//        // 3.写数据
//        response.setContentType("text/json;charset=utf-8");//告知浏览器响应的数据是什么， 告知浏览器使用什么字符集进行解码
//        response.getWriter().write(jsonString);
//




        ArrayList<Double> powerArrayList=new ArrayList<>();
        // 获取功率拟合函数
        int j = 0;
        for (int i = 1; i <= 10; i++) {

            String power = request.getParameter("power" + i);
            // 解决空指针和空数值问题
            if(power == null || power ==""){
                continue;
            }
            double powerDouble = Double.valueOf(power);
            powerArrayList.add(powerDouble);
            // powerArray[j]= powerDouble;
            j++;
            //System.out.println(powerDouble);
        }
        double[] powerArray = new double[powerArrayList.size()];
        for (int i = 0; i < powerArrayList.size(); i++) {
            powerArray[i]=powerArrayList.get(i);
        }

        for (int i = 0; i < powerArrayList.size(); i++) {
            System.out.println(powerArray[i]);
        }

        ArrayList<Double> gArrayList=new ArrayList<>();
        int k = 0;

        for (int i = 1; i <= 10; i++) {
            String g = request.getParameter("g" + i);
            // 解决空指针和空数值问题
            if(g == null || g ==""){
                continue;
            }
            double gDouble = Double.valueOf(g);
            gArrayList.add(gDouble);
            k++;
            //System.out.println(gDouble);
        }

        double[] gArray = new double[gArrayList.size()];
        for (int i = 0; i < gArrayList.size(); i++) {
            gArray[i]=gArrayList.get(i);
        }

        for (int i = 0; i < gArrayList.size(); i++) {
            System.out.println(gArray[i]);
        }

//        GPower gPower = new GPower();
        if(GPowers.size()>0){
            gArray=new double[GPowers.size()];
            powerArray=new double[GPowers.size()];
        }
        System.out.println(GPowers.size());
        for(int i = 0;i < GPowers.size();i++){
            powerArray[i]=Double.parseDouble(GPowers.get(i).getWatts());
            gArray[i]= Double.parseDouble(GPowers.get(i).getThrust());
        }

        for (int i = 0; i < gArrayList.size(); i++) {
            System.out.println(gArray[i]);
        }
        for (int i = 0; i < powerArrayList.size(); i++) {
            System.out.println(powerArray[i]);
        }


//        for(GPower gPower:GPowers){
//
//            System.out.println(gPower.getWatts());
//        }


        try {
            fittingResult fittingResult = new fittingResult();
            Object[] result;

            //测试数据
//            double[] i={0,0.5,1,1.5,2,2.5,3,3.5,4};
//            double[] j1={0,31.64557,76.92308,136.3636,204.0816,280.8989,375,466.6667,579.7101};

            //result = fittingResult.fitting(1, gArray, powerArray);

            //result = fittingResult.fitting(1, i, j1);

            result = fittingResult.fitting(1, gArray, powerArray);
            System.out.println(getType(result[0].toString()));


            System.out.printf("输出拟合系数abc参数为%s\n",result[0].toString());


            double pList[] = new double[3];
            String [] arr = result[0].toString().split("\\s+");
            for (int index = 0; index < arr.length; index++) {
                pList[index]= Float.parseFloat(arr[index]);
                System.out.println(pList[index]);
            }

            //输出续航时间
            double enduranceTime =
                    (battery_mass*battery_energy_density) / (1.1*uavs*(pList[0]*totalMass*totalMass+pList[1]*totalMass+pList[2]));
            System.out.println(enduranceTime);

            // response.setContentType(MIME)的作用是使客户端浏览器，区分不同种类的数据，并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据
            response.setContentType("text/html;charset=utf-8");
            // 基本数据型态转换成 String
            String s = String.valueOf(enduranceTime);
            // 设置 request 对象属性值,request.setAttribute通常和RequestDispatcher.forward()一起使用
            request.setAttribute("s",s);
            // getRequestDispatcher 是请求转发，前后页面共享一个request
            request.getRequestDispatcher("/index.jsp").forward(request,response);

            //PrintWriter writer = response.getWriter();
            //writer.write("单个电机拉力："+totalMass);

            // writer.write("续航时间："+String.valueOf(enduranceTime));
//            PrintWriter writer1 = response.getWriter();
//            writer.write(s);



        } catch (MWException e) {
            e.printStackTrace();
        }




    }



    private static String getType(Object a) {
        return a.getClass().toString();
    }

    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}


// Matlab 测试代码
//        MWNumericArray x = null ; // 存放x值的数组
//        MWNumericArray y = null ; // 存放y值的数组
//        DrawPlotClass plot = null ; // 自定义plotter实例，即打包时所指定的类名，根据实际情况更改
//
//        int n = 20 ; //做图点数
//        try {
//            int [] dims = { 1 , n};
//            x = MWNumericArray.newInstance(dims, MWClassID.DOUBLE, MWComplexity.REAL);
//            y  = MWNumericArray.newInstance(dims, MWClassID.DOUBLE, MWComplexity.REAL);
//
//            //定义 y = x^2
//            for ( int i = 1 ; i <= n; i++) {
//                x.set(i, i);
//                y.set(i, Math.pow(i, 2 ));
//            }
//
//            //初始化plotter
//            plot = new DrawPlotClass();
//
//            //做图
//            plot.contouree(x, y); // 在脚本文件中的函数名，根据实际情更改
//            plot.waitForFigures(); // 不调用该句，无法弹出绘制图形窗口
//
//        } catch (Exception e) {
//            // TODO: handle exception
//        } finally {
//            MWArray.disposeArray(x);
//            MWArray.disposeArray(y);
//            if (plot != null ) {
//                plot.dispose();
//            }
//        }


// 测试代码
//            for(String ss : arr) {
//
//                System.out.println(ss);
//            }

//            System.out.println("");
//            System.out.println("- 分隔符设置分割份数返回值 :" );
//            for (String retval: result[0].toString().split(" ", 2)){
//                System.out.println(retval);
//            }

//            List<String> pList = new ArrayList<String>(); //定义对象依次存放每一个字符
//            for(int index = 0; index < result[0].toString().length() ; index++){
//
//                String ss = String.valueOf(result[0].toString().charAt(index));
//
//                pList.add(ss);
//            }
//            System.out.println(pList.toString());




//            System.out.printf("输出第2个参数为%s",result[1]);
//            System.out.printf("输出第3个参数为%s",result[2]);

//            List<String> pList = new ArrayList<String>(); //定义对象依次存放每一个字符
//            System.out.println("- 分隔符返回值 :" );
//            for (String retval: result[0].toString().split(" ")){
//                System.out.println(retval);
//            }