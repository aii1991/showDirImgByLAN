/**
 * Created by jason on 2017/2/25.
 */

(function($){
    $(".file-item").click(function(){
        var type = $(this).data("type");
        var path = $(this).data("path");
        if(type == 1){
            //�����Ŀ¼
            window.location.href = "?path="+window.encodeURI(path);
        }else{
            //�����ͼƬ
            $('#viewer').viewer({
                url: 'data-original'
            });
        }
    });

})(jQuery);
