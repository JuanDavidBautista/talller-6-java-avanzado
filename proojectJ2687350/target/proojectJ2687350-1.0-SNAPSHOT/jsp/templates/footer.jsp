<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: APRENDIZ
  Date: 6/06/2023
  Time: 2:40 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer><p class="mt-3 mb-3 text-muted">Todos los Derechos Reservados RICK
  @<%=displayDate()%>
</p>
<%!
  public String displayDate() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
    Date date = Calendar.getInstance().getTime();
    return dateFormat.format(date);
  }
%>
</footer>