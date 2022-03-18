<%--
  Created by IntelliJ IDEA.
  User: lab
  Date: 2022/3/15
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>json</title>
    <script type="text/javascript">
        var list=[{"name":"中国",
            "value":"86",
            "province":[{"name":"湖北",
                "value":"430000",
                "city":[{"name":"武汉","value":"wh"},
                    {"name":"黄冈","value":"hg"},
                    {"name":"襄阳","value":"xy"}]},
                {"name":"河北",
                    "value":"100000",
                    "city":[{"name":"邯郸","value":"hd"},
                        {"name":"保定","value":"bd"},
                        {"name":"石家庄","value":"sjz"}]},

                {"name":"湖南",
                    "value":"440000",
                    "city":[{"name":"长沙","value":"cs"},
                        {"name":"株洲","value":"zz"},
                        {"name":"衡阳","value":"hy"}]}]},
            {"name":"美国",
                "value":"22",
                "province":[{"name":"阿肯色",
                    "value":"990000",
                    "city":[{"name":"纽约","value":"ny"},
                        {"name":"华盛顿","value":"hsd"},
                        {"name":"波士顿","value":"bsd"}]},

                    {"name":"阿哈哈",
                        "value":"980000",
                        "city":[{"name":"AA","value":"ahd"},
                            {"name":"BB","value":"abd"},
                            {"name":"CC","value":"asjz"}]}]

            }];

        function init(){
            var _country=document.getElementById("country");
            for(var e in list){
                var opt_1=new Option(list[e].name,list[e].value);
                _country.add(opt_1);
            }
        }



        function toProvince(){
            var _country=document.getElementById("country");
            var _province=document.getElementById("province");
            var _city=document.getElementById("city");
            var v_country=_country.value;

            _province.options.length=1;
            _city.options.length=1;

            for(var e in list){
                if(list[e].value==v_country){
                    for( var p in list[e].province){
                        var opt_2=new Option(list[e].province[p].name,list[e].province[p].value);
                        _province.add(opt_2);

                    }
                    break;
                }
            }
        }


        function toCity(){
            var _country=document.getElementById("country");
            var _province=document.getElementById("province");
            var _city=document.getElementById("city");

            var v_country=_country.value;
            var v_province=_province.value;

//_province.options.length=1;
            _city.options.length=1;


            for(var e in list){
                if(list[e].value==v_country){
                    for( var p in list[e].province){
//alert(list[e].province[p].value);
                        if(list[e].province[p].value==v_province){
// alert(list[e].province[p].value);
                            for(var cc in list[e].province[p].city){
                                var opt_3=new Option(list[e].province[p].city[cc].name,list[e].province[p].city[cc].value);
                                _city.add(opt_3);
                            }

                            return;
                        }


                    }
                    break;
                }
            }
        }
    </script>
</head>

<body onload="init();";>
    <select id="country" onchange="toProvince();">
        <option value="-1">--请选择国家---</option>
    </select>
    <select id="province" onchange="toCity();">
      <option value="-1">--请选择省份---</option>
    </select>
    <select id="city">
        <option value="-1">--请选择市区---</option>
    </select>

</body>
</html>


