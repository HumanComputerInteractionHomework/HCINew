$(function () {
    $(".like").attr("onclick", "like_clicked(this)");
    $(".like").attr("onclick","like_clicked(this)");
});


function like_clicked(which) {
    var child = $(which).children()[0];
    if($(child).css("color") == "rgb(254, 107, 114)"){
        $(child).css("color","rgb(254, 107, 113)");
    }else{
        $(child).css("color", "black");
    }
}