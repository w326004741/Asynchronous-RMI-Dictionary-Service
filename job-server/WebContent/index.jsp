<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Insert title here</title>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
	var timer;
	$(function() {
		$("#wait").hide();
		$("#inpt").show();
		$("#outque").hide();
	});

	function lookup() {
		var str = $("#str").val();
		$("#inpt").hide();
		$("#wait").show();

		$.ajax({
			url : "LookUpServlet",
			type : "post",
			dataType : "text",
			data : {
				lookupstr : str
			},
			success : function(datajob) {
				if (datajob.error) {
					alert("wrong!");
				} else {
					timer = window.setInterval("timedtask('" + datajob + "')",
							10000);
				}
			},
			error : function() {
				alert("error!");
			}
		});
	}

	function timedtask(datajob) {
		$.ajax({
			url : "CheckOutServlet",
			type : "post",
			dataType : "text",
			data : {
				jobnum : datajob
			},
			success : function(datastr) {
				if (datastr.error) {
					alert("wrong!");    //警告弹窗
				} else {
					if (datastr != null && datastr != "") {
						$("#wait").hide();
						$("#inpt").hide();
						$("#outstr").html("Response: " + datastr);
						window.clearInterval(timer);
						$("#outque").show();
					}
				}
			},
			error : function() {
				alert("error!");
			}
		});
	}

	function restart() {
		$("#wait").hide();
		$("#inpt").show();
		$("#outque").hide();
	}
</script>
</head>
<body>
	<h1>Dictionary Service</h1>
	<div id="wait">Waiting for response...</div>
	<div id="inpt">
		<input type="text" style="width: 300px" id="str" placeholder="Enter query here" />
		<button type="submit" onclick="lookup()">Submit</button>
	</div>
	<div id="outque">
		<h3 id="outstr"></h3>
		<button onclick="restart()">Make another query</button>
	</div>
</body>
</html>