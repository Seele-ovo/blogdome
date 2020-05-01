                var num = 1;
				$(document).ready(function(){
					ajaxs(num);
				})
				//给每个事件标签绑定一个事件
				function ajaxs(page){
					$.ajax({
						url:"servlet/JsonServlet",
						dataType:"json",
						beforeSend: function(){
							spinner.spin(target);
						},
						type:"get",
						data:{"page":page},
						success:function(result){
							$.each(result,function(idx,obj){
								createHtml(obj);
								spinner.spin();
								$(".attrsb").off("click").on("click",function(){
           							addHtml($(this));
                               });
							})
						}
					})
				}
				

				//对模板进行操作
				function createHtml(result) {
				    var html = $("#temp").html();
				    html = html.replace(/{title}/, result.title);
				    html = html.replace(/{url}/g, result.link);
				    html = html.replace(/{time}/, result.time);
				    html = html.replace(/{img}/g, result.img);
				    html = html.replace(/{id}/, result.id);
				    html = html.replace(/{browse}/, result.browse);
				    html = html.replace(/{smple}/, result.smple);
				    $("#adds").append(html);
				}
				
				//对返回值进行操作
				function addHtml(result) {	
				    $.ajax({
				    url:"servlet/ServletBlog",
						dataType:"text",
						type:"post",
						data:{"id":result.attr("attr")},
						success:function (result){
						    $("#body").html(result);
						}
				    
				    })
           			$("#myModal").modal("show"); 
				}
				
				var opts = {
            //innerImage: {url: '../img/logo.png', width: 56, height: 56 }, //内部图片            
            lines: 10	, // 花瓣数目
            length: 4, // 花瓣长度
            width: 8, // 花瓣宽度
            radius: 15, // 花瓣距中心半径
            corners: 1, // 花瓣圆滑度 (0-1)
            rotate: 0, // 花瓣旋转角度
            direction: 1, // 花瓣旋转方向 1: 顺时针, -1: 逆时针
            color: '#ffffff', // 花瓣颜色
            speed: 1, // 花瓣旋转速度
            trail: 60, // 花瓣旋转时的拖影(百分比)
            shadow: false, // 花瓣是否显示阴影
            hwaccel: false, //spinner 是否启用硬件加速及高速旋转            
            className: 'spinner', // spinner css 样式名称
            zIndex: 2e9, // spinner的z轴 (默认是2000000000)
            top: 'auto', // spinner 相对父容器Top定位 单位 px
            left: 'auto', // spinner 相对父容器Left定位 单位 px
            position: 'relative', // element position
            progress: true,      // show progress tracker
            progressTop: 0,       // offset top for progress tracker
            progressLeft: 0       // offset left for progress tracker
        };
        var target = document.getElementById('footer');
		var spinner = new Spinner(opts);