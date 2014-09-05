//增加联系信息
function addContactcheck(){
		var cd=document.getElementById("cd");
		var err=document.getElementById("err");
		var t = document.getElementById("typecontroller"); 
		var mailfilter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		var qqfilter  = /^\d{5,12}$/;
		var phonefilter = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
		var msnfilter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		
		if(cd.value==null||cd.value.trim().length==0){
			err.innerHTML="联系内容不能为空！";
			err.style.color="#F00";
			return false;
		}
		if(t.options[t.selectedIndex].value=="QQ"){
			if (!qqfilter.test(cd.value)){ 
				   err.innerHTML="QQ格式不正确！请重新输入，谢谢！";
				   err.style.color="#F00";
				   return false;  
				  }
		}
		if(t.options[t.selectedIndex].value=="联系电话"){
			if (!phonefilter.test(cd.value)){ 
				   err.innerHTML="电话格式不正确！请重新输入，谢谢！";
				   err.style.color="#F00";
				   return false;  
				  }
		}
		if(t.options[t.selectedIndex].value=="邮箱"){
			if (!mailfilter.test(cd.value)){ 
				   err.innerHTML="邮箱格式不正确！请重新输入，谢谢！";
				   err.style.color="#F00";
				   return false;
				  }
		}
		if(t.options[t.selectedIndex].value=="MSN"){
			if (!msnfilter.test(cd.value)){ 
				   err.innerHTML="MSN格式不正确！请重新输入，谢谢！";
				   err.style.color="#F00";
				   return false;
				  }
		}
		if(window.confirm("确认提交？"))
			return true;
		return false;
	}
function addContactTishi(){
	var t = document.getElementById("typecontroller"); 
	var tishi = document.getElementById("tishi");
	var err=document.getElementById("err");
		err.innerHTML="";
	if(t.options[t.selectedIndex].value=="QQ"){
		tishi.innerHTML="温馨提示QQ:数字";
		tishi.style.color="#03515d";
		return;
	}
	if(t.options[t.selectedIndex].value=="联系电话"){
		tishi.innerHTML="温馨提示电话:13或15开头11位数字";
		tishi.style.color="#03515d";
		return;
	}
	if(t.options[t.selectedIndex].value=="邮箱"){
		tishi.innerHTML="温馨提示邮箱:xxxxx@xx.xxx";
		tishi.style.color="#03515d";
		return;
	}
	if(t.options[t.selectedIndex].value=="MSN"){
		tishi.innerHTML="温馨提示MSN:xxxxx@xx.xxx";
		tishi.style.color="#03515d";
		return;
	}
}
function load(){
	var tishi = document.getElementById("tishi");
	var select = document.getElementById("typecontroller");  
	select.options[0].selected = true; 
	tishi.innerHTML="温馨提示电话:13或15开头11位数字";
	tishi.style.color="#03515d";
	
	return;
}
//修改联系方式
function editContactTypeCheck(){
	var bfType = document.getElementById("bfType");
	var tt= document.getElementById("typeController");
	var reasonIn = document.getElementById("reasonInput");
	var contentIn = document.getElementById("contentInput");
	var err = document.getElementById("err");
	
	if(tt.options[tt.selectedIndex].value==bfType.value){
		err.innerHTML="修改联系方式与原联系方式一致，请重新修改！";
		err.style.color="#F00";
		return false;
	}
	
	if(contentIn.value==null||contentIn.value.trim().length==0){
		err.innerHTML="修改内容不能为空！";
		err.style.color="#F00";
		return false;
	}
	if(reasonIn.value==null||reasonIn.value.trim().length==0){
		err.innerHTML="修改原因不能为空！";
		err.style.color="#F00";
		return false;
	}
	if(confirm("确认提交？"))
		return true;
	return false;
}
//增加账务信息
function addFinancalCheck() {
	var accountIn = document.getElementById("accountInput");
	var err = document.getElementById("err");
	var tishi = document.getElementById("tishi");
	var accountfilter =/^(\d{4}[\s\-]?){4,5}\d{3}$/g;
	
	if (accountIn.value == null || accountIn.value.trim().length == 0) {
		err.innerHTML = "账号不能为空！";
		err.style.color = "#F00";
		return false;
	}
	
	if(!accountfilter.test(accountIn.value)){ 
		   err.innerHTML="账号格式不正确！请重新输入，谢谢！";
		   err.style.color="#F00";
		   tishi.innerHTML="温馨提示-账号格式：19或23位数字";
		   tishi.style.color="#03515d";
		   return false;
	}
	
	if (window.confirm("确认提交？"))
		return true;
	return false;
}
//修改开户行
function editFinancalBanlCheck(){
	var bfbank = document.getElementById("bfbank");
	var bt= document.getElementById("bankcontroller");
	var reasonIn = document.getElementById("reasonInput");
	var contentIn = document.getElementById("contentInput");
	var err = document.getElementById("err");
	
	if(bt.options[bt.selectedIndex].value==bfbank.value){
		err.innerHTML="修改银行与原银行一致，请重新修改！";
		err.style.color="#F00";
		return false;
	}
	
	if(contentIn.value==null||contentIn.value.trim().length==0){
		err.innerHTML="修改内容不能为空！";
		err.style.color="#F00";
		return false;
	}
	if(reasonIn.value==null||reasonIn.value.trim().length==0){
		err.innerHTML="修改原因不能为空！";
		err.style.color="#F00";
		return false;
	}
	
	if(confirm("确认提交？"))
		return true;
	return false;
}
//修改账号
function editFinancalAccountCheck(){
	var accountIn = document.getElementById("accountInput");
	var bfvalue = document.getElementById("bfvalue");
	var reasonIn = document.getElementById("reasonInput");
	var contentIn = document.getElementById("contentInput");
	var err = document.getElementById("err");
	var tishi = document.getElementById("tishi");
	var accountfilter =/^(\d{4}[\s\-]?){4,5}\d{3}$/g;
	
	
	
	
	if(accountIn.value==null||accountIn.value.trim().length==0){
		err.innerHTML="修改账号不能为空！";
		err.style.color="#F00";
		return false;
	}
	
	
	if(!accountfilter.test(accountIn.value)){ 
		   err.innerHTML="账号格式不正确！请重新输入，谢谢！";
		   err.style.color="#F00";
		   tishi.innerHTML="温馨提示-账号格式：19或23位数字";
		   tishi.style.color="#03515d";
		   return false;
	}
	
	if(accountIn.value.trim()==bfvalue.value.trim()){
		err.innerHTML="修改账号与原账号一致，请重新修改！";
		err.style.color="#F00";
		return false;
	}
	
	if(contentIn.value==null||contentIn.value.trim().length==0){
		err.innerHTML="修改内容不能为空！";
		err.style.color="#F00";
		return false;
	}
	if(reasonIn.value==null||reasonIn.value.trim().length==0){
		err.innerHTML="修改原因不能为空！";
		err.style.color="#F00";
		return false;
	}
	if(confirm("确认修改？"))
		return true;
	return false;
}
