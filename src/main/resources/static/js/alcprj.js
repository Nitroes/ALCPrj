$("header").load("../page/templet/navber.html");

$.LoadUserIcon=function (fn){
    $.ajax({
        url:"../UserInfo/GetImgUrl",
        success:function(req){
            fn(req.url);
        }
    })
};

$.fn.GetAppUrl=function (){
    var $this=$(this);
    $.ajax({
        url:"../AppManage/GetAppUrl",
        success:function(req){
            console.log(req.length);
            for (var i = 0; i < req.length; i++) {
                var data=req[i];
                console.log(data);
                $this.prepend(AppUrlHtml(data));

            }
        }
    })
    //应用图标的html代码
    function AppUrlHtml(item){
        return '<a class="m-2 clearfix border rounded  text-decoration-none app-item p-1 shadow-sm" href="'+item.urlPath+'" value="'+item.urlId+'" target="_blank">\n' +
            '<i class="bi bi-star position-absolute ms-xl-1 mt-xl-1 text-danger"></i>\n' +
            '<img class="mx-lg-3 my-lg-1" width="45" height="45" src="'+item.urlImg+'">\n' +
            '<h6 class="text-center text-black mb-0">'+item.urlName+'</h6>'+
            '</a>'
    }
}

$.fn.GetAppFile=function (){
    var $this=$(this);
    $.ajax({
        url:"../AppManage/GetAppFile",
        success:function(req){
            console.log(req.length);
            for (var i = 0; i < req.length; i++) {
                var data=req[i];
                console.log(data);
                $this.prepend(AppFileHtml(data));

            }
        }
    })
    //应用图标的html代码
    function AppFileHtml(item){
        return '<a class="m-2 clearfix border rounded  text-decoration-none app-item p-1 shadow-sm" href="'+item.filePath+'" value="'+item.urlId+'" target="_blank">\n' +
            '<i class="bi bi-star position-absolute ms-xl-1 mt-xl-1 text-danger"></i>\n' +
            '<img class="mx-lg-3 my-lg-1" width="45" height="45" src="'+item.fileImg+'">\n' +
            '<h6 class="text-center text-black mb-0">'+item.fileName+'</h6>'+
            '</a>'
    }
}

MouseImg();
function MouseImg(){
    $("body").prepend('<div class="mouse-img"></div>')
    let img = document.querySelector('.mouse-img')
    // 定义小图片的旋转角度
    let deg = 0
    // 定义小图片位于网页左侧的位置
    let imgx = 0
    // 定义小图片位于网页顶部的位置
    let imgy = 0
    // 定义小图片x轴的位置
    let imgl = 0
    // 定义小图片y轴的位置
    let imgt = 0
    // 定义小图片翻转的角度
    let y = 0
    // 定义一个计数器
    let index = 0

    window.addEventListener('mousemove',function(xyz){
        // 获取网页左侧距离的图片位置
        imgx = xyz.x - img.offsetLeft - img.clientWidth /2
        // 多去网页顶部距离图片的位置
        imgy = xyz.y - img.offsetTop - img.clientHeight /2
        // 套入公式，定义图片的旋转角度
        deg = 360*Math.atan(imgy/imgx)/(2*Math.PI)
        // 每当鼠标移动的时候重置index
        index= 0
        // 定义当前鼠标的位置
        let x = event.clientX
        // 当鼠标的x轴大于图片的时候，提普安就要对着鼠标，所以需要将图片翻转过来
        // 否则就不用翻转
        if(img.offsetLeft<x){
            y=-180
        }else{
            y=0
        }
    })
    setInterval(()=>{
        // 设置小图片的旋转和翻转
        img.style.transform = "rotateZ("+deg+"deg) rotateY("+y+"deg)"
        index++
        // 在这里设置小图片的位置和速度，并判断小图片到达鼠标位置时停止移动
        if(index<50){
            imgl+=imgx/50
            imgt+=imgy/50
        }
        img.style.left = imgl+"px"
        img.style.top = imgt+"px"
    },10)
}

