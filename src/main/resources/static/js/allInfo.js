$(document).ready(function () {
    $("#base_index").attr("onclick","base_index_clicked()");
    $("#edu_index").attr("onclick","edu_index_clicked()");
    $("#projecy_index").attr("onclick","projecy_index_clicked()");
    $("#career_index").attr("onclick","career_index_clicked()");
    $("#skill_index").attr("onclick","skill_index_clicked()");
    $("#expect_index").attr("onclick","expect_index_clicked()");
});

function base_index_clicked() {
    $(".nav_item_active").attr("class","nav_item");
    $("#base_index").attr("class","nav_item_active");
}

function edu_index_clicked() {
    $(".nav_item_active").attr("class","nav_item");
    $("#edu_index").attr("class","nav_item_active");
}

function projecy_index_clicked() {
    $(".nav_item_active").attr("class","nav_item");
    $("#projecy_index").attr("class","nav_item_active");
}

function career_index_clicked() {
    $(".nav_item_active").attr("class","nav_item");
    $("#career_index").attr("class","nav_item_active");
}

function skill_index_clicked() {
    $(".nav_item_active").attr("class","nav_item");
    $("#skill_index").attr("class","nav_item_active");
}

function expect_index_clicked() {
    $(".nav_item_active").attr("class","nav_item");
    $("#expect_index").attr("class","nav_item_active");
}

//侧边栏固定效果
$(function() {
    var elm = $("#nav_body_index");
    var startPos = $(elm).offset().top;
    $.event.add(window, "scroll", function() {
        var p = $(window).scrollTop();
        $(elm).css('position',((p) > startPos) ? 'fixed' : 'static');
        $(elm).css('top',((p) > startPos) ? '0px' : '');
    });
});

function click_basicInfo_1() {
    document.getElementById("basicInfo_icon_div").innerHTML = '<button type="button" class="modifyBtn" onclick="click_basicInfo_2()"><span class="glyphicon glyphicon-upload" style="font-size: 20px;"></span></button>';
    document.getElementById("show_birth").readOnly = false;
    document.getElementById("show_sex").readOnly = false;
    document.getElementById("show_year").readOnly = false;
    document.getElementById("show_salary").readOnly = false;
    document.getElementById("show_address").readOnly = false;
    document.getElementById("show_basicSalary").readOnly = false;
    document.getElementById("show_bonus").readOnly = false;
    document.getElementById("show_Commission").readOnly = false;
    document.getElementById("show_stockShareOption").readOnly = false;
}

function click_basicInfo_2() {
    document.getElementById("basicInfo_icon_div").innerHTML = '<button type="button" class="modifyBtn" onclick="click_basicInfo_1()"><span class="glyphicon glyphicon-pencil" style="font-size: 20px;"></span></button>';
    document.getElementById("show_birth").readOnly = true;
    document.getElementById("show_sex").readOnly = true;
    document.getElementById("show_year").readOnly = true;
    document.getElementById("show_salary").readOnly = true;
    document.getElementById("show_address").readOnly = true;
    document.getElementById("show_basicSalary").readOnly = true;
    document.getElementById("show_bonus").readOnly = true;
    document.getElementById("show_Commission").readOnly = true;
    document.getElementById("show_stockShareOption").readOnly = true;
}

function click_education_1() {
    document.getElementById("education_icon_div").innerHTML = '<button type="button" class="modifyBtn" onclick="click_education_2()"><span class="glyphicon glyphicon-upload" style="font-size: 20px;"></span></button>';
    document.getElementById("show_eduDegree").readOnly = false;
    document.getElementById("show_school").readOnly = false;
    document.getElementById("show_major").readOnly = false;
    document.getElementById("show_fromTime").readOnly = false;
    document.getElementById("show_toTime").readOnly = false;
}

function click_education_2() {
    document.getElementById("education_icon_div").innerHTML = '<button type="button" class="modifyBtn" onclick="click_education_1()"><span class="glyphicon glyphicon-pencil" style="font-size: 20px;"></span></button>';
    document.getElementById("show_eduDegree").readOnly = true;
    document.getElementById("show_school").readOnly = true;
    document.getElementById("show_major").readOnly = true;
    document.getElementById("show_fromTime").readOnly = true;
    document.getElementById("show_toTime").readOnly = true;
}

function click_expect_click1() {
    document.getElementById("expect_icon_div").innerHTML = '<button type="button" class="modifyBtn" onclick="click_expect_click2()"><span class="glyphicon glyphicon-upload" style="font-size: 20px;"></span></button>';
    document.getElementById("show_expect_salary").readOnly = false;
    document.getElementById("show_expect_lowsalary").readOnly = false;
    document.getElementById("show_expect_highsalary").readOnly = false;
    document.getElementById("show_expect_type").readOnly = false;
    document.getElementById("show_company_type").readOnly = false;
    document.getElementById("show_expect_position").readOnly = false;
    document.getElementById("show_other_info").readOnly = false;
}

function click_expect_click2() {
    document.getElementById("expect_icon_div").innerHTML = '<button type="button" class="modifyBtn" onclick="click_expect_click1()"><span class="glyphicon glyphicon-pencil" style="font-size: 20px;"></span></button>';
    document.getElementById("show_expect_salary").readOnly = true;
    document.getElementById("show_expect_lowsalary").readOnly = true;
    document.getElementById("show_expect_highsalary").readOnly = true;
    document.getElementById("show_expect_type").readOnly = true;
    document.getElementById("show_company_type").readOnly = true;
    document.getElementById("show_expect_position").readOnly = true;
    document.getElementById("show_other_info").readOnly = true;
}



























