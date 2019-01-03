


$(function(){
	$("#langImg").click(function(){
		var txt = $(this).data("text");
//		$(this).parent().prev().text(txt);
		
		if(txt == "中文简体"){
			$(this).data("text", "English");
			$(this).attr("src", "./image/english.jpg");
			sessionStorage.setItem("language", "en");
			$("[data-en]").each(function(){
				$(this).html($(this).attr("data-en"));
			});
		}else{
			$(this).data("text", "中文简体");
			$(this).attr("src", "./image/chinese.jpg");
			sessionStorage.setItem("language", "cn");
			$("[data-cn]").each(function(){
//				console.log()
				$(this).html($(this).attr("data-cn"));
			});
			
		}
	});
	
	
	
	var language = sessionStorage.getItem("language");
	if(!language){
		language = "en";
		sessionStorage.setItem("language", "en");
	}
	if(language == "en"){
		$("#langImg").data("text", "English");
		$("#langImg").attr("src", "./image/english.jpg");
		$("[data-en]").each(function(){
			$(this).html($(this).attr("data-en"));
		});
	}else{
		$("#langImg").data("text", "中文简体");
		$("#langImg").attr("src", "./image/chinese.jpg");
		$("[data-cn]").each(function(){
			$(this).html($(this).attr("data-cn"));
		});
	}

});

function GET(params, callback){
	$.ajax({
		type:"get",
		url:"http://www.myfutureclassroom.xyz/article/getArticles?"+params,
		"content-Type": "application/json;charset=UTF-8",
		dataType: "JSON",
		success: function(result){
			callback && callback(result);
		},
		error: function(err){
			
		}
	});
}


