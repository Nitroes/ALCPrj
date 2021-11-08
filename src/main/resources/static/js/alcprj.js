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
    function AppUrlHtml(item){
        return '<a class="m-2 clearfix text-decoration-none app-item" href="'+item.urlPath+'" value="'+item.urlId+'" target="_blank">\n' +
            '<i class="bi bi-star position-absolute ms-1 mt-1"></i>\n' +
            '<img class="border rounded" width="64" height="64" src="'+item.urlImg+'">\n' +
            '<h6 class="text-center text-black">'+item.urlName+'</h6>'+
            '</a>'
    }
}