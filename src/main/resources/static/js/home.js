function goHomeAjax(){
	$.ajax({
		type : "GET",
		url : "index",
		dataType : "json",
		data : "",
		success : function(res){
			alert("SUCCESS! : " + JSON.stringify(res));
			alert("SUCCESS 2 : " + res.testList);
        },
		error : function(err){
			alert("ERROR ! : " + JSON.stringify(err));
		}

    });
}