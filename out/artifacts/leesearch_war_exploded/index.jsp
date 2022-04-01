<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>能源载荷匹配网站</title>



    <script>

        var num1=3;
        function generateInputPower(type,id,name){
            num1++;
            // 最多输入十个
            if (num1>10) {
                alert("不能再添加");
                return;
            }
            var input;
            if(document.all){
                //如果名称不为空
                if(name != null && name != ""){
                    input = document.createElement('<input  name="' + name + '">');//IE代码
                    input.style.width="120px";

                }else{
                    input = document.createElement('<input');//IE代码

                }
            }else{
                input = document.createElement('input'); //其他
                if(name != null && name != ""){
                    input.name = name+num1;
                }
                input.style.width="120px";
            }
            //如果输入type的元素为空
            if(type == null || type == ""){
                type = "text"
            }else{
                input.type = type;
            }
            //如果id不为空
            if(id != null && id != ""){
                input.id = id;
            }
            input.value = "";
            document.getElementById("power").appendChild(input);
            document.getElementById("power").append("W");
            //限制用户只能输入小数点和数字
            input.oninput=function(){clearNoNum(input)};
        };

        var num2=3;
        function generateInputThrust(type,id,name){
            num2++;
            if (num2>10) {
                alert("不能再添加");
                return;
            }
            var input;
            if(document.all){
                if(name != null && name != ""){
                    input = document.createElement('<input  name="' + name + '">');//IE代码
                    input.style.width="120px";

                }else{
                    input = document.createElement('<input');//IE代码
                }
            }else{
                input = document.createElement('input'); //其他
                if(name != null && name != ""){
                    input.name = name+num2;
                }
                input.style.width="120px";

            }
            if(type == null || type == ""){
                type = "text"
            }else{
                input.type = type;

            }
            if(id != null && id != ""){
                input.id = id;
            }
            input.value = "";
            document.getElementById("g").appendChild(input);
            document.getElementById("g").append("kg");
            input.oninput=function(){clearNoNum(input)};

        };

        //限制用户只能输入小数点和数字
        function clearNoNum(obj){
            obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符
            obj.value = obj.value.replace(/^\./g,"");  //验证第一个字符是数字而不是.
            obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的.
            obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
        };


            function addElement()
            {
                var obj = document.getElementByIdx_x("motor");
                var index = obj.selectedIndex; // 选中索引
                var text = obj.options[index].text; // 选中文本
                var value = obj.options[index].value; // 选中值
            }
    </script>


    <script type="text/javascript">
        // 多维数组存储数据
        var list=[
            {"name":"自定义",
                "value":"1",
            },

            {"name":"SunnySky(朗宇)",
            "value":"2",
            "motorType":[{"name":"X4112S V2-KV340",
                "value":"1",
                "propellerType":[{"name":"1447","value":"1447"},
                    {"name":"1555","value":"1555"},
                    {"name":"1660","value":"1660"},
                    {"name":"1762","value":"1762"},
                ]},
                {"name":"X4112S V2-KV400",
                    "value":"2",
                    "propellerType":[{"name":"1238","value":"1238"},
                        {"name":"1447","value":"1447"},
                        {"name":"1555","value":"1555"},
                        {"name":"1660","value":"1660"}
                        ]},

                {"name":"X4112S V2-KV450",
                    "value":"3",
                    "propellerType":[{"name":"1447","value":"1447"},
                        {"name":"1555","value":"1555"},
                        {"name":"1660","value":"1660 "}]}]},

            {"name":"大疆(DJI)",
                "value":"3",
                "motorType":[{"name":"6010-KV130",
                    "value":"1",
                    "propellerType":[{"name":"2270","value":"2"}]},]

            }
        ];

        //初始化函数，实现电机品牌下拉框效果
        function init(){
            var _motor=document.getElementById("motor");
            for(var e in list){
                var opt_1=new Option(list[e].name,list[e].value);
                _motor.add(opt_1);
            }
        }


        // 选择电机类型函数，实现电机类型下拉框效果
        function toMotorType(){
            var _motor = document.getElementById("motor");
            var _motorType=document.getElementById("motorType");
            var _propellerType=document.getElementById("propellerType");
            var v_motor=_motor.value;

            _motorType.options.length=1;
            _propellerType.options.length=1;

            for(var e in list){
                if(list[e].value==v_motor){
                    for( var p in list[e].motorType){
                        var opt_2=new Option(list[e].motorType[p].name,list[e].motorType[p].value);
                        _motorType.add(opt_2);

                    }
                    break;
                }
            }
        }

        // 选择螺旋桨类型函数，实现螺旋桨类型下拉框效果
        function toPropellerType(){
            var _motor=document.getElementById("motor");
            var _motorType=document.getElementById("motorType");
            var _propellerType=document.getElementById("propellerType");

            var v_motor=_motor.value;
            var v_motorType=_motorType.value;

            _propellerType.options.length=1;

            for(var e in list){
                if(list[e].value==v_motor){
                    for( var p in list[e].motorType){
                        if(list[e].motorType[p].value==v_motorType){
                            for(var cc in list[e].motorType[p].propellerType){
                                var opt_3=new Option(list[e].motorType[p].propellerType[cc].name,list[e].motorType[p].propellerType[cc].value);
                                _propellerType.add(opt_3);
                            }
                            return;
                        }
                    }
                    break;
                }
            }
        }

        // 隐藏函数
        function hide(){
            // 获取motor的ID对象
            var o = document.getElementById('motor');
            // 获取其对象的选项值
            var strValue = o.options[o.options.selectedIndex].value;
            //隐藏和显示gPower框
            if(strValue == "1")
            {
                document.getElementById('motorType').style.display = "none";
                document.getElementById('propellerType').style.display = "none";
                document.getElementById('gPower').style.display = "inline";
                document.getElementById('gPower').ariaRequired = "true";
            }
            else
            {
                document.getElementById('motorType').style.display = "inline";
                document.getElementById('propellerType').style.display = "inline";
                document.getElementById('gPower').style.display = "none";
                document.getElementById('gPower').ariaRequired = "false";
            }

        }


    </script>


    <!-- 网页效果和颜色设计 -->
    <style>
        /* 标题样式，为空心字体 */
        .title{
            color: #f1f1f1 !important;
            text-shadow: 1px 1px black,-1px -1px black,1px -1px black,-1px 1px black;
            font-family: Arial;
        }

        /* 背景样式 */
        body {
            font-family: Arial;
            padding: 10px;
            background: #f1f1f1;
        }
        /* 输入质量框样式 虚线 */
        .classUavMass{
            border-style:dashed;
            border-radius: 25px;
            width:900px;
            margin: auto
        }
        /* 输入参数框样式 虚线 */
        .uavBasic
        {
            border-style:dashed;
            border-radius: 25px;
            width:900px;
            margin: auto
        }
        /* 输入框样式 虚线 */
        input {
            margin: 8px;
            box-sizing: border-box;
            border: dashed;
            border-color: #8c939d;
            border-radius: 15px;
            padding: 10px
        }
        /* 选择框样式 虚线 */
        select{
            border: none;
            border-radius: 25px;
        }
        /* 提交框样式 */
        .submit {
            background-color: whitesmoke;
            border-style: dashed;
            border-radius: 25px;
            border-color:gray;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            cursor: pointer;
            position: center;

        }
        /* 外边框样式 */
        .calc{
            width:900px;
            margin: auto;
        }
        /* 添加框样式 */
        .uavs{
            margin: 8px;
            box-sizing: border-box;
            border: dashed;
            border-color: #8c939d;
            border-radius: 15px;
            padding: 10px
        }
        .motor {
            margin: 8px;
            box-sizing: border-box;
            border: dashed;
            border-color: #8c939d;
            border-radius: 15px;
            padding: 10px
        }
        .motorType {
            margin: 8px;
            box-sizing: border-box;
            border: dashed;
            border-color: #8c939d;
            border-radius: 15px;
            padding: 10px
        }
        .propellerType {
            margin: 8px;
            box-sizing: border-box;
            border: dashed;
            border-color: #8c939d;
            border-radius: 15px;
            padding: 10px
        }
        /* 结果框样式 */
        .result{
            border-style:dashed;
            border-radius: 25px;
            width:900px;
            margin: auto
        }

    </style>


</head>
<body>

<!--<h1>LEESEARCH</h1>-->
<h1 class="title" align="center">能源载荷匹配网站</h1>

<div id ="app">



</div>

<link rel="stylesheet" href="element-ui/lib/theme-chalk/index.css">
<script src="js/vue.js"></script>
<script src="element-ui/lib/index.js"></script>
<%--<script src="js/motor.js" type="text/javascript"></script>--%>

<!--<script src="https://cdn.jsdelivr.net/npm/vue@2.6.14/dist/vue.js"></script>-->
<!--&lt;!&ndash; 引入样式 &ndash;&gt;-->
<!--<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">-->
<!--&lt;!&ndash; 引入组件库 &ndash;&gt;-->
<!--<script src="https://unpkg.com/element-ui/lib/index.js"></script>-->


<script>
    new Vue({
        el:"#app"
    })

</script>

<form  action="/result" method="post" >
    <div class="calc">
    <fieldset class="classUavMass" >
        <legend>输入质量：</legend>
        <br>
        <div class="uavMass">
            空机质量：
            <input type="text" name="uav_mass" value="" oninput = "clearNoNum(this)" required="required"/>kg
        </div>
        <div class="loadMass">
            负载质量：
            <input type="text" name="load_mass" value="" oninput = "clearNoNum(this)" required="required" />kg
        </div>
        <div class="batteryMass">
            电池质量：
            <input type="text" name="battery_mass" value="" oninput = "clearNoNum(this)" required="required"/>kg
        </div>
        <br>
    </fieldset>
    <br>
    <fieldset class="uavBasic">
        <legend>输入参数：</legend>
        <br>
        旋翼个数：
        <select name="uavs" class="uavs">
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="6">6</option>
            <option value="8">8</option>
        </select>

        电池能量密度：
        <input type="text" name="battery_energy_density" value="" oninput = "clearNoNum(this)" required="required">Wh/kg
        <br>


        <body onload="init();">
        <select id="motor" onchange="toMotorType();hide()" class="motor">
            <option value="-1">--请选择电机品牌---</option>
        </select>
        <select id="motorType" onchange="toPropellerType();" class="motorType">
            <option value="-1">--请选择电机型号---</option>
        </select>
        <select id="propellerType" name="propellerType" class="propellerType">
            <option value="-1">--请选择螺旋桨规格---</option>
        </select>

        </body>
        <br>

        <div id="gPower" style="display: none" onclick="addElement()" >
            功率：<br>
            <div id="power" style="display: inline">
                <input type="text" style="width: 120px" name="power1" value="" oninput = "clearNoNum(this)" >W
                <input type="text" style="width: 120px" name="power2" value="" oninput = "clearNoNum(this)" >W
                <input type="text" style="width: 120px" name="power3" value="" oninput = "clearNoNum(this)" >W
            </div>
            <div style="display: inline" class="addPower">
                <input  type="button" onclick="generateInputPower('text','ids','power')" value="+">
            </div>


            <div id="g" style="display: inline" class="addG">
                <br>
                拉力：<br>
                <input type="text" style="width: 120px" name="g1" value="" oninput = "clearNoNum(this)" >kg
                <input type="text" style="width: 120px" name="g2" value="" oninput = "clearNoNum(this)" >kg
                <input type="text" style="width: 120px" name="g3" value="" oninput = "clearNoNum(this)" >kg
            </div>



            <div style="display: inline">
                <input  type="button" onclick="generateInputThrust('text','ids','g')" value="+">
            </div>
            <br>
        </div>
    </fieldset>

    <!--                电池循环充放电次数:<br>-->
    <!--                <div>-->
    <!--                <input type="radio" name="battery_cycles" value="0-30">0-30-->
    <!--                <input type="radio" name="battery_cycles" value="31-100">30-100-->
    <!--                <input type="radio" name="battery_cycles" value="31-100">100以上-->
    <!--                </div>-->



    <br>
    <input class="submit" type="submit" id="submit" value="计算">
        <br>
        <br>
<%--
     ${param.name} 等价于 request.getParamter("name")，这两种方法一般用于服务器从页面或者客户端获取的内容，这些内容都是String的。
     ${requestScope.name} 等价于 request.getAttribute("name")，一般是从服务器传递结果到页面，在页面中取出服务器端保存的值！
          --%>
        <fieldset class="result">
            <legend>结果：</legend>
            <br>
            <span>续航时间：${requestScope.s}h</span>
        </fieldset>

    </div>
</form>


</body>

</html>