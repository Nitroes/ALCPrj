$.ModalAlert={
    create:function (){

        var $modal=$("body").find(".modal-alert");
        if($modal.length==0){
            var modalHtml="<div class=\"modal modal-alert fade\" tabindex=\"-1\" aria-hidden=\"true\">\n" +
                "    <div class=\"modal-dialog modal-dialog-centered\">\n" +
                "        <div class=\"modal-content rounded-4\">\n" +
                "            <div class=\"modal-body p-4 text-center\">\n" +
                "                <h5 class=\"mb-0 modal-text\"></h5>\n" +
                "            </div>\n" +
                "            <div class=\"modal-footer flex-nowrap p-0\">\n" +
                "                <button type=\"button\" class=\"btn btn-lg btn-link fs-12 text-decoration-none col-12 m-0 rounded-0\" data-bs-dismiss=\"modal\">确定</button>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>"
            $("body").append(modalHtml);
        }
    },
    show:function (opt){
        $.extend({
            msg:"null"
        },opt);
        var modal=new bootstrap.Modal($(".modal-alert"),{keyboard:false});
        $(".modal-alert").find(".modal-text").html(opt.msg);
        modal.show();
    },
    hide:function (){
        var modal=new bootstrap.Modal($(".modal-alert"),{keyboard:false});
        modal.hide();
    }
}

$.ModalLoading={
    create:function (){
        $modal=$("body").find(".modal-loading");
        if($modal.length==0){
            var modalHtml="<div class=\"modal modal-loading fade\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" +
                "    <div class=\"modal-dialog modal-dialog-centered\">\n" +
                "        <div class=\"modal-content rounded-4\">\n" +
                "            <div class=\"modal-body p-4 text-center\">\n" +
                "                <div class=\"spinner-border\"></div>\n" +
                "                <h5 class=\"mb-0 modal-text d-none\"></h5>\n" +
                "            </div>\n" +
                "            <div class=\"modal-footer flex-nowrap p-0  d-none\">\n" +
                "                <button type=\"button\" class=\"btn btn-lg btn-link fs-12 text-decoration-none col-12 m-0 rounded-0\" data-bs-dismiss=\"modal\">确定</button>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>";
            $("body").append(modalHtml);
        }
    },
    show:function (){
        var modal=new bootstrap.Modal($(".modal-loading"),{keyboard:false});
        LoadingStatus({status:true});
        modal.show();
    },
    msg:function (msg){
        LoadingStatus({status:false,msg:msg});
    },
    hide:function (){
        $(".modal-loading").hide();
    }
}
function LoadingStatus(opt){
    $.extend({
        status:true,
        msg:"null"
    },opt);
    var $modal=$(".modal-loading");
    if(opt.status){
        $modal.find(".spinner-border").removeClass("d-none");
        $modal.find(".modal-footer").addClass("d-none");
        $modal.find(".modal-text").addClass("d-none");
    }else {
        $modal.find(".spinner-border").addClass("d-none");
        $modal.find(".modal-footer").removeClass("d-none");
        $modal.find(".modal-text").removeClass("d-none");
    }

    if(opt.msg!="null"){
        $modal.find(".modal-text").html(opt.msg);
    }

}


$.ModalProgress={
    create:function (){
        var $modal=$("body").find(".modal-progress");
        if($modal.length==0){
            var modalHtml="<div class=\"modal modal-progress fade\" tabindex=\"-1\" aria-hidden=\"true\">\n" +
                "    <div class=\"modal-dialog modal-dialog-centered\">\n" +
                "        <div class=\"modal-content rounded-4\">\n" +
                "            <div class=\"modal-body p-4 text-center\">\n" +
                                '<div class="progress">\n' +
                '                     <div class="progress-bar bg-warning progress-bar-striped progress-bar-animated" role="progressbar" style="white:0%" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"></div>\n' +
                '                </div>'+
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>"
            $("body").append(modalHtml);
        }
    },
    show:function (){
        var modal=new bootstrap.Modal($(".modal-progress"),{keyboard:false});
        var $progress=$("body").find(".modal-progress").find('.progress-bar');
        $progress.css("width","0%")
        modal.show();
    },
    hide:function (){
        $(".modal-progress").hide();
    },
    progress:function (now){
        var $progress=$("body").find(".modal-progress").find('.progress-bar');
        $progress.css("width",now+"%")
        if(now>=100){
            $.ModalProgress.hide();
            $.ModalAlert.create();
            $.ModalAlert.show({msg:'上传成功'})
        }
    }
};