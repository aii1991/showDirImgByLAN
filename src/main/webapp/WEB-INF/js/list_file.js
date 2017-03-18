/**
 * Created by jason on 2017/2/25.
 */

(function($){
    $(".file-item").click(function(){
        var type = $(this).data("type");
        var path = $(this).data("path");
        if(type == 1){
            //点击了目录
            window.location.href = "?path="+window.encodeURI(path);
        }else{
            //点击了图片
            $('#viewer').viewer({
                url: 'data-original'
            });
        }
    });

})(jQuery);
