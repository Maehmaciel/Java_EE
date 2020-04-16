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
        ${pessoa.id}
        <form action="${linkTo[PessoasController].salvar}" method="post">
            <input type="hidden" name="pessoa.id" value="${pessoa.id}">
            Nome:<input type="text" name="pessoa.nome"  placeholder="Nome">
            Idade:<input type="text" name="pessoa.idade" placeholder="Idade">
            <input type="submit" value="Enviar">
        </form>

    </body>
</html>
