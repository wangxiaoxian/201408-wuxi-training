<%@page import="java.net.URLEncoder"%>
<%@page import="com.one.longshine.entity.PagerModel"%>
<%@page import="com.one.longshine.entity.UserFileInfo"%>
<%@page import="java.util.List"%>
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

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
function deleteConfirm(msg) {
	if(confirm(msg)) {
		return true;
	} else {
		return false;
	}
}
</script>

</head>

<body>
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
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：用户档案中心</td>
              </tr>
            </table></td>
            <td width="54%"><table border="0" align="right" cellpadding="0" cellspacing="0">
              <tr>
                <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center">
                    </div></td>
                  </tr>
                </table></td>
                <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center">
                    <a href="userFile.do?method=addUserFileInput"><img src="images/22.gif" width="14" height="14" />新增</a></div></td>
                    <td class="STYLE1"><div align="center"></div></td>
                  </tr>
                </table></td>
              </tr>
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
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
<!-- 搜索框begin -->
	        <tr><td colspan="8">
			<form action="searchFile.do" method="get">
	        <div align="left" class="STYLE4" style="margin:6px;"><span class="STYLE1">
	        	<input type="hidden" name="method" value="getPagedUserFile"/>
					用户编号：<input type="text" name="userId" value="${sff.userId }"/>&nbsp;&nbsp;
					用户名：<input type="text" name="userName" value="${sff.userName }" /> 
					<input type="submit" value="搜索" /> 
				</span></div>
				</form>
			</td></tr>
<!-- 搜索框end -->

          <tr>
            <td width="5%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">用户编号</span></div></td>
            <td width="7%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">用户名</span></div></td>
            <td width="10%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">立户日期</span></div></td>
            <td width="25%" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">用户地址</span></div></td>
            <td width="5%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">是否销户</span></div></td>
            <td width="10%" height="22" background="images/bg.gif" bgcolor="#FFFFFF" class="STYLE1"><div align="center">销户日期</div></td>
            <td width="13%" height="22" background="images/bg.gif" bgcolor="#FFFFFF" class="STYLE1"><div align="center">详情</div></td>
            <td width="10%" height="22" background="images/bg.gif" bgcolor="#FFFFFF" class="STYLE1"><div align="center">操作</div></td>
          </tr>
          
<!-- 主窗体的数据开始 -->
<%
// PagerModel<UserFileInfo> ufPage = (PagerModel<UserFileInfo>)request.getAttribute("ufPage");
// List<UserFileInfo> ufs = ufPage.getDatas();
// request.setAttribute("ufs", ufs);
%>
<logic:notEmpty name="ufPage" property="datas">
<logic:iterate id="uf" name="ufPage" property="datas">
          <tr>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center">${uf.userId }</div>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">
            	<logic:match value="y" name="uf" property="state">
            		<a href="userFile.do?method=editUserNameInput&userSerialId=${uf.userSerialId }">${uf.userName } <img src="images/33.gif" width="14" height="14" /></a>
            	</logic:match>
            	<logic:match value="n" name="uf" property="state">
            		${uf.userName } <img src="images/del.gif" width="16" height="16" />
            	</logic:match>
            	</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><bean:write name="uf" property="createDate" format="yyyy-MM-dd HH:mm:ss" /></span></div></td>
            <td bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">
            	<logic:match value="y" name="uf" property="state">
            	<a href="userFile.do?method=editUserAddressInput&userSerialId=${uf.userSerialId }">${uf.address } <img src="images/33.gif" width="14" height="14" /></a>
            	</logic:match>
            	<logic:match value="n" name="uf" property="state">
            		${uf.address } <img src="images/del.gif" width="16" height="16" />
            	</logic:match>
            	</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">
            	<logic:match value="y" name="uf" property="state">否</logic:match>
            	<logic:match value="n" name="uf" property="state">是</logic:match>
            	</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">
            	<logic:equal value="n" name="uf" property="state">
            		<bean:write name="uf" property="logoutDate" format="yyyy-MM-dd HH:mm:ss" />
            	</logic:equal>
            	</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><a href="listFinancal.do?uid=${uf.userSerialId }">账务信息</a> | <a href="listContact.do?uid=${uf.userSerialId }">联系信息</a></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE4">
<!--             	<a href="javascript:void(0);"><img src="images/edt.gif" width="16" height="16" />编辑</a>&nbsp; &nbsp; -->
				<logic:match value="y" name="uf" property="state">
            	<a href="logoff.do?method=logOff&userSerialId=${uf.userSerialId }" onclick="javascript:return deleteConfirm('确认注销用户 [${uf.userId }]${uf.userName } ？');"><img src="images/del.gif" width="16" height="16" />注销</a>
				</logic:match>
            	</span></div></td>
          </tr>
</logic:iterate>
</logic:notEmpty>
<logic:empty name="ufPage" property="datas">
		  <tr><td bgcolor="#FFFFFF" colspan="8"><div align="center" class="STYLE1">
              <div align="center" style="margin: 7px">找不到任何数据</div>
            </div></td></tr>
</logic:empty>
<!-- 主窗体的数据结束 -->

        </table></td>
        <td width="8" background="images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0" style="font-size:14px">
          <tr>
            <td class="STYLE4">&nbsp;共有 ${ufPage.rowsCount } 条记录</td>
            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr><td width="100%" class="STYLE4" style="font-size:15px">
<%
PagerModel<UserFileInfo> ufPage = (PagerModel<UserFileInfo>)request.getAttribute("ufPage");

for(int i=0; i<ufPage.getPageCount(); i++){
%>
<%
	if(ufPage.getRecodeNo() == ufPage.getPageSize()*i + 1) {
%>
[<%=i+1 %>]
<%
	} else {
%>

[<a href="searchFile.do?method=getPagedUserFile&recordNo=<%=ufPage.getPageSize()*i %>&userName=${searchFileForm.userName }&userId=${searchFileForm.userId }"><%=i+1 %></a>]
<%
	}
}
%>
                </td></tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
