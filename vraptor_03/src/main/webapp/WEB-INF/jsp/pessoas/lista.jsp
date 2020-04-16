<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Pessoas</h1>
<ul>
<c:forEach items="${pessoaList}" var="pessoa">
    <li>${pessoa.nome} <a href="${linkTo[PessoasController].delete(pessoa.id)}">Delete</a><a href="${linkTo[PessoasController].update(pessoa.id)}">Update</a></li>
</c:forEach>
    
</ul>
       
        
    </body>
</html>
