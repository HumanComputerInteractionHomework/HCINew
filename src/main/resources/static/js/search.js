
var pp = 1;
function fuzzySearchRequest(page) {

    var phone = getCookie("phone");
    if(phone =="") {
        alert("请先登录！");
        window.location.href = "page_signin.html";
    }

    var fuzzy_url = "/joblist/fuzzySearch";
    var jobName = $("#jobName").val();
    var sum = 0;
    var json_data = {"page":page,
    "num":10,
    "keyword":jobName};
    $.ajax({
        type:'post',
        url:fuzzy_url,
        contentType:'application/json;charset=utf-8',
        data: JSON.stringify(json_data),
        success:function (data) {
            sum= Math.floor(data.totalCount/10);
            pp = data.page;
            showCareerItems(data.result,true);//true为模糊搜索
            if (data.page ==1) {
                showBottomBtn(data.page, data.size, data.totalCount)
            }
            $("#pageId").html("第"+ page + "页/共" + sum +"页")
        }
    });
    // $("#pageId").html("第"+ page + "页/共" + sum +"页")
}

function allMatchSearch(page) {
    var phone = getCookie("phone");
    if(phone =="") {
        alert("请先登录！");
        window.location.href = "page_signin.html";
    }

    var url_match = "/joblist/job/search";
    var jobCity = $("#jobCity").val() + "";
    var jobQuality = $("#jobQuality").val();
    var edu = $("#eduRequire").val();
    var workYear = $("#workYear").val();
    var salary = $("#salary").val();
    var sum = 0;

    var jobCity = jobCity.split(",");
    var locationBeans = "["
    for(var i = 0; i < jobCity.length; i++) {
        var temp = jobCity[i];
        if (i == 0) {
            locationBeans += "\""+ temp +"\"";
        } else {
            locationBeans += "\""+ temp +"\"";
        }
    }
    locationBeans+="]"

    var json_data = {
        "page":page,
        "num":10,
        "jobCity": locationBeans,
        "jobQuality": jobQuality,
        "eduRequire": edu,
        "workYear": workYear,
        "salary":salary
    }

    // $.ajax({
    //     type: 'post',
    //     url: url_match,
    //     contentType:'application/json;charset=utf-8',
    //     data: JSON.stringify(json_data),
    //     success:function (data) {
    //         showCareerItems(data.result,false);
    //         if(data.page ==1) {
    //             showBottomBtn(data.page, data.size, data.totalCount);
    //         }
    //     }
    // });
    data={result:[
        {"jobId":61193454,"jobName":"大数据开发工程师","jobLocation":"上海-嘉定区","salary":"0.8-1万/月","companyName":"上海瀛太信息科技有限公司","matchDegree":0.95},
        {"jobId":61370170,"jobName":"iOS开发工程师","jobLocation":"南京-鼓楼区","salary":"1-1.5万/月","companyName":"悦岚数据服务有限公司","matchDegree":0.92},
        {"jobId":62441360,"jobName":"软件开发工程师","jobLocation":"深圳-南山区","salary":"1.2-1.8万/月","companyName":"深圳市懒人在线科技有限公司","matchDegree":0.91},
        {"jobId":62680837,"jobName":"资深Java开发工程师","jobLocation":"南京-江宁区","salary":"1.5-1.8万/月","companyName":"万得信息技术股份有限公司","matchDegree":0.90},
        {"jobId":41891070,"jobName":"GIS数据工程师","jobLocation":"上海-徐汇区","salary":"1.5-2.5万/月","companyName":"百丽集团体育事业总部","matchDegree":0.75},
        {"jobId":41991684,"jobName":"C++软件开发工程师","jobLocation":"上海-宝山区","salary":"1.5-2万/月","companyName":"上海创为信息科技有限公司","matchDegree":0.99},
        {"jobId":63040447,"jobName":"华为HCIE工程师","jobLocation":"北京","salary":"1.6-1.7万/月","companyName":"北京中科信软科技有限公司","matchDegree":0.84},
        {"jobId":63093869,"jobName":"JAVA开发工程师","jobLocation":"上海","salary":"1.5-2万/月","companyName":"上海贯信信息技术有限公司","matchDegree":0.83},
        {"jobId":64184924,"jobName":"JAVA软件开发工程师","jobLocation":"深圳","salary":"1.6-1.8w/月","companyName":"广东碧软信息科技有限公司","matchDegree":0.81},
        {"jobId":61193454,"jobName":"大数据开发工程师","jobLocation":"上海-嘉定区","salary":"0.8-1万/月","companyName":"上海瀛太信息科技有限公司","matchDegree":0.77},
        {"jobId":50351181,"jobName":"数据库开发工程师","jobLocation":"上海","salary":"0.7-1.4万/月","companyName":"上海布雷克索信息科技有限公司","matchDegree":0.84}],
    page : 1,
    size: 10,
    totalCount: 53};
    showCareerItems(data.result,false);
    if(data.page ==1) {
        showBottomBtn(data.page, data.size, data.totalCount);
    }

}

function recommendationRequest() {
    var url = "joblist/recomand/get";
    var phone = getCookie("phone");
    if(phone =="") {
        alert("请先登录！");
        window.location.href = "page_signin.html";
    }

    var json_data = {"phone": phone};
    $.ajax({
        type:'post',
        url:url,
        contentType:'application/json;charset=utf-8',
        data: JSON.stringify(json_data),
        success:function (data) {
            showRecommendationItems(data.result,false);
            showBottomBtn(data.page, data.size, data.totalCount);
        }
    });


}

function conlectionRequest() {
    var phone = getCookie("phone");
    if(phone =="") {
        alert("请先登录！");
        window.location.href = "page_signin.html";
    }
    var url = "joblist/save/get";

    var json_data = {"phone": phone};
    $.ajax({
        type:'post',
        url:url,
        contentType:'application/json;charset=utf-8',
        data: JSON.stringify(json_data),
        success:function (data) {
            showConlectionItems(data.result,false);
            showBottomBtn(data.page, data.size, data.totalCount);
        }
    });
    data = {result : [{"jobId":66703365,"jobName":"大数据研发工程师","jobLocation":"南京","salary":"0.8-1.5万/月","companyName":"南京中新赛克科技有限责任公司","matchDegree":0.99},
        {"jobId":66636610,"jobName":"高级JAVA软件工程师","jobLocation":"南京","salary":"8-15万/年","companyName":"上海若雅软件系统有限公司南京办事处","matchDegree":0.99}],
    page:1,
    size:10,
    totalCount :2}
    showConlectionItems(data.result,false);
    showBottomBtn(data.page, data.size, data.totalCount);

}

function showCareerItems(careerItems, flag) {
    $("#heatContent").css("display","none");
    $(".result_content").remove();
    $(".result_title").remove();
    $(".result_content_item1").remove();
    $(".result_content_item0").remove();
    var type;
    if (flag)
        type = "0";
    else
        type = "1";
        var addItems ='<div class="result_title">\n' +
            '                <span class="t1">公司名称</span>\n' +
            '                <span class="t2">职位</span>\n' +
            '                <span class="t3">地点</span>\n' +
            '                <span class="t4">薪酬</span>\n' +
            '                <span class="t5">匹配度</span>\n' +
            '                <span class="t6">收藏</span>\n' +
            '                <span class="t7">不喜欢</span>\n' +
            '            </div>';
        addItems +='<div class="result_content">';
         addItems += '<div style="display: block" ">';
        addItems += '<input type="hidden" value="'+ type+'" id="searchType">'
        var last = 1 - 0.1*(pp -1 );
        for (var j = 0 ; j < 12; j++) {
            if ( j >= careerItems.length)
                break;//不满一页退出
            var item = careerItems[j];
            var jobId = item.jobId;
            var jobName = item.jobName;
            var joblocation = item.jobLocation;
            var salary = item.salary;
            var companyName = item.companyName;
            if (companyName.length >=16) {
                companyName = companyName.substring(0, 15) + "...";
            }
            if (jobName.length >= 9) {
                jobName = jobName.substring(0, 8) +"...";
            }
            var matchDegree = item.matchingDegree;
            if(matchDegree == null) {
                matchDegree = (last - 0.0001 * (Math.random() % 5)).toFixed(2);
                last = matchDegree;
            }
            if (j%2 == 0)
                addItems  += '<div class="result_content_item0" onclick="getdetail('+jobId+')">\n'
             else
                addItems += '<div class="result_content_item1" onclick="getdetail('+jobId+')">\n'

            addItems += '                    <input class="t0" value="'+jobId+'" type="hidden">\n' +
                '                    <span class="t1">'+companyName+'</span>\n' +
                '                    <span class="t2">'+jobName+'</span>\n' +
                '                    <span class="t3">'+joblocation+'</span>\n' +
                '                    <span class="t4">'+salary+'</span>\n' +
                '                    <span class="t5">'+matchDegree+'</span>\n' +
                '                    <button type="button" class="like t6" onclick="like(this,'+jobId+')"><i class="glyphicon glyphicon-heart" ></i></button>\n' +
                '                    <button type="button" class="dislike t7" onclick="dislike(this,'+jobId+')"><i class="fa fa-frown-o fa-lg" ></i></button>\n' +
                '                </div>';
        }
        addItems += '</div></div>';
        $("#baseline").after(addItems);
}

function showRecommendationItems(careerItems) {


    var addItems = '<div style="display: block" ">';
    addItems += '<input type="hidden" value="" id="searchType">'
    for (var j = 0 ; j < 12; j++) {
        if ( j >= careerItems.length)
            break;//不满一页退出
        var item = careerItems[j];
        var jobId = item.jobId;
        var jobName = item.jobName;
        var joblocation = item.jobLocation;
        var salary = item.salary;
        var companyName = item.companyName;
        var matchDegree = item.matchDegree;
        if (companyName.length >=16) {
            companyName = companyName.substring(0, 15) + "...";
        }
        if (jobName.length >= 9) {
            jobName = jobName.substring(0, 8) +"...";
        }
        if (j%2 == 0)
            addItems  += '<div class="result_content_item0" onclick="getdetail('+jobId+')">\n'
        else
            addItems += '<div class="result_content_item1" onclick="getdetail('+jobId+')">\n'

        addItems += '                    <input class="t0" value="'+jobId+'" type="hidden">\n' +
            '                    <span class="t1">'+companyName+'</span>\n' +
            '                    <span class="t2">'+jobName+'</span>\n' +
            '                    <span class="t3">'+joblocation+'</span>\n' +
            '                    <span class="t4">'+salary+'</span>\n' +
            '                    <span class="t5">'+matchDegree+'</span>\n' +
            '                    <button type="button" class="like t6" onclick="like(this,'+jobId+')"><i class="glyphicon glyphicon-heart" ></i></button>\n' +
            '                    <button type="button" class="dislike t7" onclick="dislike(this,'+jobId+')"><i class="fa fa-frown-o fa-lg" ></i></button>\n' +
            '                </div>';
    }
    addItems += '</div>';
    $("#baseline").after(addItems);

    //一下为假数据
    showBottomBtn(1,12,44)

}

function showConlectionItems(careerItems) {
    var addItems = '<div style="display: block" ">';
    addItems += '<input type="hidden" value="" id="searchType">'
    for (var j = 0 ; j < 12; j++) {
        if ( j >= careerItems.length)
            break;//不满一页退出
        var item = careerItems[j];
        var jobId = item.jobId;
        var jobName = item.jobName;
        var joblocation = item.jobLocation;
        var salary = item.salary;
        var companyName = item.companyName;
        var matchDegree = item.matchDegree;

        if (j%2 == 0)
            addItems  += '<div class="result_content_item0" onclick="getdetail('+jobId+')">\n'
        else
            addItems += '<div class="result_content_item1" onclick="getdetail('+jobId+')">\n'

        addItems += '                    <input class="t0" value="'+jobId+'" type="hidden">\n' +
            '                    <span class="t1">'+companyName+'</span>\n' +
            '                    <span class="t2">'+jobName+'</span>\n' +
            '                    <span class="t3">'+joblocation+'</span>\n' +
            '                    <span class="t4">'+salary+'</span>\n' +
            '                    <span class="t5">'+matchDegree+'</span>\n' +
            '<button type="button" class="like t6" onclick="competition(this,'+jobId+')"><i class="glyphicon glyphicon-heart" ></i></button>\n' +
            '                <button type="button" class="dislike t7" onclick="dislike(this,'+jobId+')"><i class="fa fa-frown-o fa-lg" ></i></button>'+
            '                </div>';
    }
    addItems += '</div>';
    $("#baseline").after(addItems);

    //一下为假数据
    showBottomBtn(1,12,12)

}
function showBottomBtn(curr, size, total) {
    var pageSum = total / size;
    pageSum = Math.ceil(pageSum);
    setPageCount( pageSum)
    $("#pageId").html("第"+ curr + "页/共" + pageSum +"页")
}

function like(that, id) {
    var phone = getCookie("phone");
    if(phone =="") {
        alert("请先登录！");
        window.location.href = "page_signin.html";
    } else {
        var child = that.firstElementChild;
        var curColor = child.style.color;
        if (curColor == "rgb(254, 107, 114)") {

            //发送请求取消
            var url = "/job/like/cancel";
            var json_data = {"phone": phone,
                "jobId": id+""};
            $.ajax({
                type:'post',
                url:url,
                contentType:'application/json;charset=utf-8',
                data: JSON.stringify(json_data),
                success:function (data) {
                    child.style.color = "#808080";
                    alert("已取消收藏职位 !")
                }
            });
        }
        else {
            //向后台发送收藏的id
            var url = "/job/like";
            var json_data = {"phone": phone,
                "jobId": id+""};
            $.ajax({
                type:'post',
                url:url,
                contentType:'application/json;charset=utf-8',
                data: JSON.stringify(json_data),
                success:function (data) {
                    alert("已收藏职位 !");
                    child.style.color = "#fe6b72";
                }
            });
        }
    }


}

function dislike(that, id) {
    var phone = getCookie("phone");
    if(phone =="") {
        alert("请先登录！");
        window.location.href = "page_signin.html";
    } else {
        var url = "/job/dislike";
        var json_data = {"phone": phone,
            "jobId": id+""};
        $.ajax({
            type:'post',
            url:url,
            contentType:'application/json;charset=utf-8',
            data: JSON.stringify(json_data),
            success:function (data) {
                alert("我们已删去该职位，并保证今后减少该类型职位的推荐！");
                removeAdd(that, 1);
            }
        });
    }

}

function getdetail(jobid) {
    var phone = getCookie("phone");
    if(phone =="") {
        alert("请先登录！");
        window.location.href = "page_signin.html";
    } else {
        var url = "/job/scan";
        var json_data = {"phone": phone,
            "jobId": jobid};
        $.ajax({
            type:'post',
            url:url,
            contentType:'application/json;charset=utf-8',
            data: JSON.stringify(json_data),
            success:function (data) {
                // do nothing
            }
        });

        window.location.href = "page_detailInfo.html?job="+encodeURI(jobid);
    }


}
