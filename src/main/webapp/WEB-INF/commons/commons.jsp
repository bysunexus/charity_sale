<%@ page import="com.quyeying.framework.utils.JsonMapper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
  var JSON_USER = eval('<%=JsonMapper.nonDefaultMapper().toJson(request.getAttribute("CURRENT_USER"))%>')||{};
</script>