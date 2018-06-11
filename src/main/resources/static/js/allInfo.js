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






























