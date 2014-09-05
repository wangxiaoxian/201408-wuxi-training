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
	var cAfterValue=document.getElementById("cAfterValue");
	var cContent=document.getElementById("cContent");
	var cReason=document.getElementById("cReason");
	
	var err2 = document.getElementById("err2");
	var err3 = document.getElementById("err3");
	

	
	
	if(cContent.value==null||cContent.value.trim().length==0){
		
		err3.innerHTML="";
		err2.innerHTML="变更内容不能为空！";
		err2.style.color="#F00";

		return false;
	}
	if(cReason.value==null||cReason.value.trim().length==0){
		err2.innerHTML="";
		
		err3.innerHTML="变更原因不能为空！";
		err3.style.color="#F00";

		return false;
	}
	
	
		
		
	
	
}
</script>

</head>

<body>
<form action="addChangeRecord.do?method=addChangeRecord" method="post" onsubmit="return check();">

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
        
        <!-- 在此添加搜索栏。。。 -->
        
        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" >
          <tr>
            <td width="7%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">用户流水号</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div  class="STYLE1"><div >&nbsp;&nbsp;<input name="userSerialId" type="text" style="width:75px;border:0px;" value="${userSerialId }" readonly="readonly"/></div></div></td> 
          </tr>

          <tr>
          	<td width="12%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">变更前值</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div ><span class="STYLE1">&nbsp;&nbsp;<input name="cBeforeValue" type="text" style="width:135px;border:0px;" value="未注销" readonly="readonly"/></span></div></td>
          </tr>
          
          <tr>
          	<td width="19%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">变更后值</span></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div ><span class="STYLE1">&nbsp;&nbsp;<input id="cAfterValue" name="cAfterValue" type="text" style="width:450px;border:0px;" value="注销" readonly="readonly"/></span></div></td>
          </tr>
          
          <tr>
          	<td width="19%" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">变更内容</span></span></div></td>
          	<td bgcolor="#FFFFFF"><div><span class="STYLE1">&nbsp;&nbsp;<input id="cContent" name="cContent" type="text" style="width:450px;"/></span></div></td>
          </tr>
          
          <tr>
          	<td width="7%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">变更原因</span></div></td>  	
          	<td height="20" bgcolor="#FFFFFF"><div  class="STYLE1"><div >&nbsp;&nbsp;<input id="cReason" name="cReason" type="text" style="width:450px;margin: 0 auto;"/></div></div></td>
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
                  <td width="60"><input type="button" value="返回" onclick="window.history.go(-1);window.location.reload();"/></td>
                  <td width="60"><input type="submit" value="保存"/></td>
                </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
<div align="center">

<span id="err2"></span>
<span id="err3"></span></div>
</body>
</html>
