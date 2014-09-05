<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>增加账务信息</title>
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

<script type="text/javascript" src="js/check.js">
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


</script>

</head>

<body>
<html:form action="addFinancal.do" method="post" onsubmit="return addFinancalCheck()">

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
        
        
        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
          <tr>
          
            <td width="7%" height="22" background="images/bg.gif" bgcolor="#FFFFFF">
            <div align="center"><span class="STYLE1">当前用户</span></div></td>
            
            <td height="20" bgcolor="#FFFFFF"><div  class="STYLE1">
            <div >&nbsp;&nbsp;<input  type="text" style="width:75px;border: 0px;"  
            value="${ufi.userName}" readonly="readonly"/>
            </div></div></td> 
            
          </tr>

          <tr>
          
          	<td width="12%" height="22" background="images/bg.gif" bgcolor="#FFFFFF">
          	<div align="center"><span class="STYLE1">开户行</span></div></td>
          	
            <td height="20" bgcolor="#FFFFFF"><div>
            <span class="STYLE1">&nbsp;
            <html:select property="openingBank"
							styleId="bankController">
							<html:option value="中国银行">中国银行</html:option>
							<html:option value="中国工商银行">中国工商银行</html:option>
							<html:option value="中国农业银行">中国农业银行</html:option>
							<html:option value="中国建设银行">中国建设银行</html:option>
						</html:select>
            </span></div></td>
            
          </tr>
          
          <tr>
          	<td width="19%" height="22" background="images/bg.gif" bgcolor="#FFFFFF">
          	<div align="center"><span class="STYLE1">账号</span></span></div></td>
          	
            <td height="20" bgcolor="#FFFFFF">
            <div ><span class="STYLE1">&nbsp;&nbsp;<html:text styleId="accountInput"  style="width:450px;height:13px;" property="account" value="" />
            </span><span id="err1">
            </span></div></td>
            
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
                  <td width="60"><input type="submit" value="提交""/></td>
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
<div style="color:#03515d;height: 30px;" id="tishi" align="center"></div>
</body>
</html>

