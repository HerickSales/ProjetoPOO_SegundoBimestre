<%-- 
    Document   : Listagem
    Created on : 12/06/2019, 21:04:23
    Author     : lefoly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de clientes</title>
    </head>

    <%
        String listaHTML = request.getParameter("lista");
    %>

    <body>
        <br>
        <br>
    <center>
        <table border="1">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Telefone</th>
                     
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%=listaHTML%>
            </tbody>
        </table>
    </center>
</body>
</html>
