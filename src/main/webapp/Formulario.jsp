<%-- 
    Document   : Formulario
    Created on : 19/06/2019, 10:42:39
    Author     : lefoly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dados do Contato</title>
    </head>

    <%
        String acao     = request.getParameter("acao");
        String id       = request.getParameter("id");
        String nome     = request.getParameter("nome");
        String email    = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        
        if (id == null) {
            nome = "";
            email = "";
            telefone = "";
        }
    %>

    <body>
        <h3>Dados do Contato</h3>
        <div>            
            <form action="ContatoSrv" method="POST">
                <table border="0">
                    <tbody>
                        <tr>
                            <td><input type="hidden" name="acao" value="<%=acao %>" /></td>
                        </tr>
                        <tr>
                            <td><input type="hidden" name="id" value="<%=id %>" /></td>
                        </tr>
                        <tr>
                            <td>Nome: </td>
                            <td><input type="text" name="nome" value="<%=nome %>" /></td>
                        </tr>
                        <tr>
                            <td>Email: </td>
                            <td><input type="text" name="email" value="<%=email %>" /></td>
                        </tr>
                        <tr>
                            <td>Telefone: </td>
                            <td><input type="text" name="telefone" value="<%=telefone %>" /></td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" value="Gravar" />
                <input type="reset" value="Limpar" />
            </form>
        </div>
    </body>
</html>
