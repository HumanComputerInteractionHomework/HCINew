/*
* 用户模块
* 登录、注册、修改密码、信息填写
* */

//登录
function signInClicked() {
    var username = $("#signin_user").val();
    var password = $("#signin_pwd").val();
    var pattern_phone = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    var strPhone = pattern_phone.test(username);
    if (!strPhone) {
        $("#signin_user").val("");
        $("#signin_pwd").val("");
        //alert("请输入正确的用户名！");
    } else if (password =="") {
        alert("请输入密码！");
    } else {

        $.ajax({
            type:"POST",
            url:"/user/login",
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            data:JSON.stringify({
                "phone": username,
                "password": password
            }),
            success:function (data) {
                console.log(data)
                if (data.result == true) {
                    //跳转到主页
                    alert("登录成功");
                    setCookie("phone", username, 1);
                    window.location.href = "home.html";
                } else {
                    $("#signin_pwd").val("");
                    alert(data.message);
                }
            }
        });


    }
}

//注册
function signUpClicked() {
    var phone = $("#signup_phone").val();
    var email = $("#signup_email").val();
    var name = $("#signup_name").val();
    var pwd1 = $("#signup_pwd1").val();
    var pwd2 = $("#signup_pwd2").val();
    var pattern_email = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    var pattern_phone = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    var strEmail = pattern_email.test(email);
    var strPhone = pattern_phone.test(phone);
    if (!strPhone) {
        $("#signup_phone").val("");
        alert("请输入正确的用户名！");
    } else if ( !strEmail ) {
        $("#signup_email").val("");
        alert("请输入正确的邮箱！");
    } else if( pwd1 != pwd2 ) {
        $("#signup_pwd1").val("");
        $("#signup_pwd2").val("");
        alert("两次密码输入不一致！");
    } else {
        var signin_url = "/user/sign-up";
        var json_data = {
            "phone": phone,
            "password": pwd1,
            "mail": email,
            "name": name
        };
        $.ajax({
            type:'post',
            url:signin_url,
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(json_data),
            success:function (data) {
                if (data.result == true) {
                    //跳转到信息录入
                    alert("注册成功");
                    setCookie("phone", phone, 1);
                    setCookie("name", name, 1);
                    window.location.href = "page_personalInfo1.html";
                } else {
                    alert(data.message);
                }
            }
        });
    }

}

//修改密码
function updatePwd() {
    var oldPwd = $("#updatepwd_oldpwd").val();
    var newPwd1 = $("#updatepwd_newpwd1").val();
    var newPwd2 = $("#updatepwd_newpwd2").val();
    if ( newPwd1 != newPwd2) {
        $("#updatepwd_newpwd1").val("");
        $("#updatepwd_newpwd2").val("");
        alert("请重复输入新密码！")
    } else {
        var updatePwd_url = "/user/password";
        $.ajax({
            type:'post',
            url:signin_url,
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify({
                "oldPassword": oldPwd,
                "password": newPwd1
            }),
            success: function (data) {
                if (data.result == true) {
                    alert("修改成功");
                } else {
                    alert(data.message);
                }
            }
        });
    }

}



//信息填写，提交第一页,非必填项若为空以空串形式
function infoSubmit_1() {
    var birthday = $("#birthday").val();
    var jobYear = $("#jobYear").val();
    var gender = $("#gender").val();
    var salary = $("#salary").val();
    var highSalary;
    var lowSalary;
    if (salary != "0") {
        if (salary != ">50k"){
            var pos=salary.indexOf("-");
            lowSalary=salary.substring(0,pos -1) + "000";
            highSalary=salary.substring(pos+1,salary.length -1)+"000";
        }
        else {
            lowSalary="50000";
            highSalary="100000"
        }
    }
    var address = $("#address").val();
    var basicSalary = $("#basicSalary").val();
    var bonus = $("#bonus").val();
    var commission = $("#Commission").val();
    var stockShareOption = $("#stockShareOption").val();
    var submit_data;
    if (birthday == "") {
        alert("请输入您的生日");
    } else if (jobYear == "") {
        alert("请输入您的开始工作年份");
    } else if (address =="居住地址") {
        alert("请输入您的居住地");
        $("#address").focus();
    } else if (gender == "0") {
        $("#gender").val("0")
        alert("请选择您的性别");
    } else if (salary == "0") {
         alert("请输入您的收入");
    } else if ( (basicSalary != "基本工资" && (isNaN(basicSalary)) || (bonus != "补贴" && isNaN(bonus)) || (commission != "奖金/佣金" && isNaN(commission)) ||
            (stockShareOption != "股票期权" && isNaN(stockShareOption)))) {
        alert("请将工资福利折价输入")
    } else
        {
        if (basicSalary != "基本工资")
            basicSalary = basicSalary;
        else
            basicSalary = "0";
        if (bonus != "补贴")
            bonus = bonus;
        else
            bonus = "0";
        if (commission != "奖金/佣金")
            commission = commission;
        else
            commission = "0";
        if (stockShareOption != "股票期权")
            stockShareOption = stockShareOption;
        else
            stockShareOption = "0";
        var phone = getCookie("phone");
        var realName = getCookie("name");
        submit_data = {
            "phone": phone,
            "realName":realName,
            "birthday": birthday,
            "gender": gender,
            "jobYear": jobYear,
            "address": address,
            "salary": salary,
            "lowSalary":lowSalary,
            "highSalary":highSalary,
            "basicSalary":basicSalary,
            "bonus": bonus,
            "Commission": commission,
            "stockShareOption": stockShareOption
        };
        var url="/user/userBasicMessage";
        $.ajax({
            type:'post',
            url:url,
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(submit_data),
            success:function (data) {
                if (data.result == true) {
                    //跳转
                    alert("基本信息输入完成！");
                    window.location.href = "page_personalInfo2.html";
                } else {
                    alert(data.message);
                }
            }
        });

    }
}

//第二个页面提交
function infoSubmit_2() {
    var educationDegree = $("#educationDegree").val();
    var school = $("#school").val();
    var major = $("#major").val();
    var fromTime = $("#fromTime").val();
    var toTime = $("#toTime").val();
    var honor_name = new Array();
    var honor_level = new Array();
    var submit_data;
    var phone = getCookie("phone");
    if (educationDegree != "0" && school != "请填写学校全称！" && major != "" && fromTime != "" && toTime !="") {
        $(".honor-name").each(function () {
            honor_name.push($(this).val())
        });
        $(".honor-level").each(function () {
            honor_level.push($(this).val())
        });

        var honor = "[";
        var count =0;
        for (var i = 0; i < honor_name.length; i++) {
            if (honor_name[i] != "荣誉与奖励" && honor_level[i] != "0") {
                count++;
            }
        }

        for (var i = 0; i < honor_name.length; i++) {
            if (honor_name[i] != "荣誉与奖励" && honor_level[i] != "0") {
                if(i != count-1) {
                    honor+="{\"name\":\""+honor_name[i]+"\",\"level\":\""+ honor_level[i] +"\"},"
                } else {
                    honor+="{\"name\":\""+honor_name[i]+"\",\"level\":\""+ honor_level[i] +"\"}"
                }
            }
        }
        honor+="]";
        submit_data = {
            "phone":phone,
            "educationDegree": educationDegree,
            "school": school,
            "major": major,
            "fromTime": fromTime,
            "toTime": toTime,
            "honorBeans": honor
        };
    } else {
        alert("请将必填信息填写完整！");
        return false;
    }
    var url="/user/education";
    $.ajax({
        type:'post',
        url:url,
        contentType:'application/json;charset=utf-8',
        data:JSON.stringify(submit_data),
        success:function (data) {
            if (data.result == true) {
                //跳转下个页面
                alert("教育经历输入完成！");
                window.location.href = "page_personalInfo3.html";
            } else {
                alert(data.message);
                //失败，是否该清空输入栏？
            }
        }
    });

}

//第三个页面提交
function infoSubmit_3() {
    var tag = true;//信息是否填写完整
    var jsonStr="[";
    var phone = getCookie("phone");
    if(phone =="") {
        alert("请先登录！");
        window.location.href = "page_signin.html";
    }
    var count =0;
    $(".project").each(function () {
        var name = $(this).find(".project-name").val();
        var level = $(this).find(".project-level").val();
        var fromTime = $(this).find(".project-from").val();
        var toTime = $(this).find(".project-to").val();
        var projectDescription = $(this).find(".project-desc").val();
        var myWork = $(this).find(".project-mywork").val();

        if (name != "项目名称" && level != "0" && fromTime != "" && toTime != "" && myWork != "我的职责") {
            if (count ==0)
                jsonStr += "{\"phone\":\""+phone+"\",\"name\":\""+name+"\",\"level\":\""+level+"\",\"fromTime\":\""+fromTime+"\",\"toTime\":\""+toTime+"\",\"projectDescription\":\""+
                    projectDescription+"\",\"mywork\":\""+myWork+"\"}";
            else
                jsonStr += ",{\"phone\":\""+phone+"\",\"name\":\""+name+"\",\"level\":\""+level+"\",\"fromTime\":\""+fromTime+"\",\"toTime\":\""+toTime+"\",\"projectDescription\":\""+
                    projectDescription+"\",\"mywork\":\""+myWork+"\"}";
            count++;
        } else {
            alert("请将必填信息填写完整！");
            tag = false;
            return false;//跳出本次循环
        }
    });
    jsonStr+="]";
    //填写信息不完整，tag=false
    if (!tag) {
        return false;
    }


    var url="/user/projectExperience";
    $.ajax({
        type:'post',
        url:url,
        contentType:'application/json;charset=utf-8',
        data: jsonStr,
        success:function (data) {
            if (data.result == true) {
                alert("项目经历输入完成");
                window.location.href = "page_personalInfo4.html";
            } else {
                alert(data.message);
            }
        }
    });

}


//第四个页面提交
function infoSubmit_4() {
    var tag = true;//信息是否填写完整

    var phone = getCookie("phone");
    if(phone =="") {
        alert("请先登录！");
        window.location.href = "page_signin.html";
    }

    var jsonStr = "[";
    var count = 0;
    $(".career").each(function () {
        var companyName = $(this).find(".career-name").val();
        var companyQuality = $(this).find(".career-quality").val();
        var companyLevel = $(this).find(".career-level").val();
        var job = $(this).find(".career-job").val();
        var fromTime = $(this).find(".career-from").val();
        var toTime = $(this).find(".career-to").val();
        var description = $(this).find(".career-desc").val();
        if (companyName != "" && companyQuality != "0" && companyLevel != "0" && job != "" && fromTime != "" && toTime != "") {
            if (count == 0) {
                jsonStr += "{\"phone\":\""+phone+"\",\"Companyname\":\""+companyName+"\",\"companyQuality\":\""+companyQuality+"\",\"companyLevel\":\""+companyLevel+
                    "\",\"job\":\""+job+"\",\"fromTime\":\""+job+"\",\"toTime\":\""+toTime+"\",\"description\":\""+description+"\"}";
            } else {
                jsonStr += ",{\"phone\":\""+phone+"\",\"Companyname\":\""+companyName+"\",\"companyQuality\":\""+companyQuality+"\",\"companyLevel\":\""+companyLevel+
                    "\",\"job\":\""+job+"\",\"fromTime\":\""+job+"\",\"toTime\":\""+toTime+"\",\"description\":\""+description+"\"}";
            }
        count++;
        } else {
            alert("请将必填信息填写完整！");
            tag = false;
            return false;
        }
    });
    //填写信息不完整，tag=false
    if (!tag) {
        return false;
    }
    jsonStr+="]";

    var url="/user/jobExperience";
    $.ajax({
        type:'post',
        url:url,
        contentType:'application/json;charset=utf-8',
        data: jsonStr,
        success:function (data) {
            if (data.result == true) {
                alert("工作经历输入成功！");
                window.location.href = "page_personalInfo5.html";
            } else {
                alert(data.message);

            }
        }
    });

}

//第五个页面提交
function infoSubmit_5() {

    var phone = getCookie("phone");
    if(phone =="") {
        alert("请先登录！");
        window.location.href = "page_signin.html";
    }

    var jsonStr = "[";
    var count = 0;
    var tag = true;//信息是否填完整
    $(".skill").each(function () {
        var skillName = $(this).find(".skill-name").val();
        var degree = $(this).find(".skill-degree").val();
        var certification = $(this).find(".skill-certificate").val();
        var description = $(this).find(".skill-desc").val();
        if (skillName != "" && degree != "0") {
            if (count == 0) {
                jsonStr += "{\"phone\":\""+phone+"\",\"skillName\":\""+skillName+"\",\"degree\":\""+degree+"\",\"certificate\":\""+certification+
                    "\",\"description\":\""+ description +"\"}";
            } else {
                jsonStr += ",{\"phone\":\""+phone+"\",\"skillName\":\""+skillName+"\",\"degree\":\""+degree+"\",\"certificate\":\""+certification+
                    "\",\"description\":\""+ description +"\"}";
            }

        }else {
            alert("请将必填信息填写完整！");
            tag = false;
            return false;//退出循环。而非退出函数
        }
    });
        jsonStr +="]";
    //填写信息不完整，tag=false
    if (!tag)
        return false;

    var url="/user/skill";
    $.ajax({
        type:'post',
        url:url,
        contentType:'application/json;charset=utf-8',
        data: jsonStr,
        success:function (data) {
            if (data.result == true) {
                alert("技能特长输入成功！")
                window.location.href = "page_personalInfo6.html";
            } else {
                alert(data.message);
            }
        }
    });
}

//第六个页面的提交
function infoSubmit_6() {

    var phone = getCookie("phone");
    if(phone =="") {
        alert("请先登录！");
        window.location.href = "page_signin.html";
    }

    var salary = $("#expect-salary").val();
    var lowSalary = $("#expect-low").val();
    var highSalary = $("#expect-high").val();
    var location = $("#expect-city").val()+"";
    var companyQuality = $("#expect-quality").val()+"";
    var companyLevel = $("#expect-level").val()+"";
    var jobType = $("#expect-type").val();
    var description = $("#expect-desc").val();

    //把字符串拆分为数组
    var locationArr = location.split(",");
    var qualityArr = companyQuality.split(",");
    var levelArr = companyLevel.split(",");

    var locationBeans = "["
    for(var i = 0; i < locationArr.length; i++) {
        if (i == 0) {
            locationBeans += "{ \"phone\":\""+ phone+"\",\"expectLocation\":\""+locationArr[i]+"\"}";
        } else {
            locationBeans += ",{ \"phone\":\""+ phone+"\",\"expectLocation\":\""+locationArr[i]+"\"}";
        }
    }
    locationBeans+="]"

    var qualityBeans = "["
    for(var i = 0; i < qualityArr.length; i++) {
        if (i == 0) {
            qualityBeans += "{ \"phone\":\""+ phone+"\",\"expectCompanyQuality\":\""+qualityArr[i]+"\"}";
        } else {
            qualityBeans += ",{ \"phone\":\""+ phone+"\",\"expectCompanyQuality\":\""+qualityArr[i]+"\"}";
        }
    }
    qualityBeans+="]"

    var levelBeans = "["
    for(var i = 0; i < levelArr.length; i++) {
        if (i == 0) {
            levelBeans += "{ \"phone\":\""+ phone+"\",\"expectCompanyLevel\":\""+levelArr[i]+"\"}";
        } else {
            levelBeans += ",{ \"phone\":\""+ phone+"\",\"expectCompanyLevel\":\""+levelArr[i]+"\"}";
        }
    }
    levelBeans+="]"

    if (salary != "" && location != null && companyLevel != null && companyQuality != null &&jobType != "") {
        var submit_data = {
            "phone": phone,
            "salary": salary,
            "lowSalary":lowSalary,
            "highSalary": highSalary,
            "expectLocationBeans": locationBeans,
            "expectCompanyQualityBeans": qualityBeans,
            "expectCompanyLevelBeans": levelBeans,
            "jobType": jobType,
            "description": description
        }
        var url = "/user/expectation";

        $.ajax({
            type:'post',
            url:url,
            contentType:'application/json;charset=utf-8',
            data: JSON.stringify(submit_data),
            success:function (data) {
                if (data.result == true) {
                    alert("求职意向输入成功！")
                    window.location.href = "home.html";
                } else {
                    alert(data.message);
                }
            }
        });
    } else {
        alert("请将必填信息填写完整！");
        return false;
    }

}

//删除动态添加的元素，id表示触发事件的元素， count表示需要删除的父元素相对当前元素的层数
function removeAdd(id, count) {
    var parent = id.parentNode;
    for (var i=0; i < count-1; i++)
         var parent = parent.parentNode;
    parent.remove();
}


function getCookie(c_name)
{
    if (document.cookie.length>0)
    {
        c_start=document.cookie.indexOf(c_name + "=")
        if (c_start!=-1)
        {
            c_start=c_start + c_name.length+1
            c_end=document.cookie.indexOf(";",c_start)
            if (c_end==-1) c_end=document.cookie.length
            return unescape(document.cookie.substring(c_start,c_end))
        }
    }
    return ""
}

function setCookie(c_name,value,expiredays)
{
    var exdate=new Date()
    exdate.setDate(exdate.getDate()+expiredays)
    document.cookie=c_name+ "=" +escape(value)+
        ((expiredays==null) ? "" : ";expires="+exdate.toGMTString())
}






