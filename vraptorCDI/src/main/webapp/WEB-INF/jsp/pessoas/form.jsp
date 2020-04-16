<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form Pessoas</h1>
        <form action="${linkTo[PessoasController].salvar}" method="post">
            <input type="hidden" name="pessoa.id" value="${pessoa.id}">
            <input type="text" name="pessoa.nome"  placeholder="Nome">
            <input type="submit" value="Enviar">
        </form>

    </body>
</html>
