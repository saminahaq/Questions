<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<script type="text/javascript">



</script>
<body>
    <h1>Add new employee</h1>
        
    <form:form modelAttribute="form">
        <form:errors path="" element="div" />
   
        <div>
            <form:label path="name">Name</form:label>
            <form:input path="name" />
            <form:errors path="name" />
        </div>
           <div>
            <form:label path="dept">Dept</form:label>
            <form:input path="dept" />
            <form:errors path="dept" />
        </div>
        <div>
            <input type="submit" />
        </div>
        <div>
            <input name = "Clear" type="button" onClick = clearEmployee() />
        </div>
    </form:form>
</body>
</html>