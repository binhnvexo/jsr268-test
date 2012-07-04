<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<portlet:defineObjects/>

<div align="center">
   Welcome, <%= request.getAttribute("name") %>, email: <%= request.getAttribute("email") %>!
   <br/>
   <a href="<portlet:renderURL></portlet:renderURL>">Back</a>
</div>