<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>

<script>
var  highlightcolor='#c1ebff';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}
function check(){
	var cginput = document.getElementById("cginput");
	var bfvalue = document.getElementById("bfvalue");
	var reasonIn = document.getElementById("reasonInput");
	var contentIn = document.getElementById("contentInput");
	var err = document.getElementById("err");
	var tishi = document.getElementById("tishi");
	
	var mailfilter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var qqfilter  = /^\d{5,12}$/;
	var phonefilter = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
	var msnfilter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	
	
	if(cginput.value==null||cginput.value.trim().length==0){
		err.innerHTML="修改不能为空！";
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
	
	if(cginput.value==bfvalue.value){
		err.innerHTML="修改联系内容与原内容一致，请重新修改！";
		err.style.color="#F00";
		return false;
	}
	
	if("${uci.contactType}"=="QQ"){
		if (!qqfilter.test(cginput.value)){ 
			   err.innerHTML="QQ格式不正确！请重新输入，谢谢！";
			   err.style.color="#F00";
			   tishi.innerHTML="温馨提示QQ:数字";
			   tishi.style.color="#03515d";
			   return false;  
			  }
	}
	if("${uci.contactType}"=="联系电话"){
		if (!phonefilter.test(cginput.value)){ 
			   err.innerHTML="电话格式不正确！请重新输入，谢谢！";
			   err.style.color="#F00";
			   tishi.innerHTML="温馨提示电话:13或15开头11位数字";
			   tishi.style.color="#03515d";
			   return false;  
			  }
	}
	if("${uci.contactType}"=="邮箱"){
		if (!mailfilter.test(cginput.value)){ 
			   err.innerHTML="邮箱格式不正确！请重新输入，谢谢！";
			   err.style.color="#F00";
			   tishi.innerHTML="温馨提示邮箱:xxxxx@xx.xxx";
			   tishi.style.color="#03515d";
			   return false;
			  }
	}
	if("${uci.contactType}"=="MSN"){
		if (!msnfilter.test(cginput.value)){ 
			   err.innerHTML="MSN格式不正确！请重新输入，谢谢！";
			   err.style.color="#F00";
			   tishi.innerHTML="温馨提示MSN:xxxxx@xx.xxx";
			   tishi.style.color="#03515d";
			   return false;
			  }
	}
	
	
	if(confirm("确认提交？"))
		return true;
	return false;
}
</script>

</head>

<body>
<html:form action="contact.do?method=updateContact" method="post" onsubmit="return check();">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="5%"><div align="center"><img src="images/tb.gif" width="16" height="16" /></div></td>
                <td width="95%" class="STYLE1"></td>
              </tr>
            </table></td>
            <td width="54%"><table border="0" align="right" cellpadding="0" cellspacing="0">
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="images/tab_12.gif">&nbsp;</td>
        <td>
        
        
        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" >
          
          <tr>
          
            <td width="7%" height="22" background="images/bg.gif" bgcolor="#FFFFFF">
            <div align="center"><span class="STYLE1">当前用户</span></div></td>
            
            <td height="20" bgcolor="#FFFFFF"><div  class="STYLE1">
            <div >&nbsp;&nbsp;<input  type="text" style="width:75px;border: 0px;"  
            value="${ufi.userName}" readonly="readonly"/>
            </div></div></td> 
            
          </tr>
          
          <tr>
            <td width="7%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">账务信息流水号</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div  class="STYLE1"><div >&nbsp;&nbsp;<html:text   readonly="true" style="border:0px;" 
			     property="cr.cTableSerialId" value="${uci.contactSerialId}" /></div></div></td> 
          </tr>
			
		<tr>
            <td width="7%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">联系方式</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div  class="STYLE1"><div >&nbsp;&nbsp;${uci.contactType}</div></div></td> 
          </tr>	
			
          <tr>
          	<td width="12%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">联系内容</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div ><span class="STYLE1">&nbsp;&nbsp;<html:text   styleId="bfvalue" readonly="true" style="border:0px;" 
			     property="cr.cBeforeValue" value="${uci.contactDetails}" /></span></div></td>
          </tr>
          
          <tr>
          	<td width="19%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">修改</span></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div ><span class="STYLE1">&nbsp;&nbsp;<html:text style="height:13px;" styleId="cginput" property="cr.cAfterValue" /></span><span id="err1"></span></div></td>
          </tr>
          
          <tr>
          	<td width="19%" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">修改内容</span></span></div></td>
          	<td bgcolor="#FFFFFF"><div><span class="STYLE1">&nbsp;&nbsp;<html:text  style="width:450px;height:13px;" styleId="contentInput" property="cr.cContent"/></span><span id="err2"></span></div></td>
          </tr>
          
          <tr>
          	<td width="7%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">变更原因</span></div></td>  	
          	<td height="20" bgcolor="#FFFFFF"><div  class="STYLE1"><div >&nbsp;&nbsp;<html:text style="width:450px;height:13px;" styleId="reasonInput" property="cr.cReason"/><span id="err3"></span></div></div></td>
         	<html:hidden property="cr.cField" value="contactdetails"/>
         </tr>
          
        </table></td>
        <td width="8" background="images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  
  <!-- 页尾，放置分页信息 -->
  <tr>
    <td height="35" background="images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="60"><input type="submit" value="提交"/></td>
                  <td width="60"><input type="reset" value="重置"/></td>
                </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</html:form>
<div style="color:#03515d;height: 30px;" id="err" align="center"></div>&nbsp;&nbsp;&nbsp;
<div style="color:#03515d" id="tishi" align="center"></div>
</body>
</html>

