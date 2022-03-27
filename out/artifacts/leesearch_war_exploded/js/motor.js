var list=[
    {"name":"自定义",
        "value":"-1",
    },

    {"name":"朗宇",
    "value":"1",
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

    {"name":"美国",
        "value":"2",
        "motorType":[{"name":"阿肯色",
            "value":"990000",
            "propellerType":[{"name":"纽约","value":"ny"},
                {"name":"华盛顿","value":"hsd"},
                {"name":"波士顿","value":"bsd"}]},

            {"name":"阿哈哈",
                "value":"980000",
                "propellerType":[{"name":"AA","value":"ahd"},
                    {"name":"BB","value":"abd"},
                    {"name":"CC","value":"asjz"}]}]

    }
    ];

function init(){
    var _motor=document.getElementById("motor");
    for(var e in list){
        var opt_1=new Option(list[e].name,list[e].value);
        _motor.add(opt_1);
    }
}



function toMotorType(){
    var _motor = document.getElementById("motor");
    // var index1 = _motor.selectedIndex; // 选中索引
    // alert(index1);
    // var text = _motor.options[index1].text; // 选中文本
    // alert(text);
    var value = _motor.options[index1].value; // 选中值
    alert(value);
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


function toPropellerType(){
    var _motor=document.getElementById("motor");
    var _motorType=document.getElementById("motorType");
    var _propellerType=document.getElementById("propellerType");

    var v_motor=_motor.value;
    var v_motorType=_motorType.value;

//_motorType.options.length=1;
    _propellerType.options.length=1;


    for(var e in list){
        if(list[e].value==v_motor){
            for( var p in list[e].motorType){
//alert(list[e].motorType[p].value);
                if(list[e].motorType[p].value==v_motorType){
// alert(list[e].motorType[p].value);
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