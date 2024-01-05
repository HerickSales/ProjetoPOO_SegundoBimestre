<%-- 
    Document   : Formulario
    Created on : 19/06/2019, 10:42:39
    Author     : lefoly
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Cliente"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dados do Cliente</title>
    </head>

    <%
        String acao = request.getParameter("acao");
        String id = request.getParameter("id");
        ArrayList<String> listAtributos=new ArrayList<>();
        //Atributos de clientes
        String nome= request.getParameter("nome");
        String email= request.getParameter("email");
        String telefone= request.getParameter("telefone");
        //atributos de Livro
        String titulo= request.getParameter("titulo");
        String autor= request.getParameter("autor");
        String preco= request.getParameter("preco");
        //campos
        String campo1="";   
        String campo2="";
        String campo3="";
        
        if(id==null){
        nome="";
        email="";
        telefone="";
        titulo="";
        autor="";
        preco="";
        }
        
        switch (acao){
            case "inclusaoL":
                campo1= "Titulo";
                campo2="Autor";
                campo3= "Preço";
                break;
            case "inclusaoC":
                campo1= "Nome";
                campo2="Email";
                campo3= "Telefone";
                break;
                
            default:
                break;
        }
        



    %>

    <body>
        <h3>Dados do Cliente</h3>
         
        <div>   
            <form action="ContatoSrv" method="POST">
                <table border="0">
                    <tbody>
                        <tr>
                            <td><input type="hidden" name="acao" value="<%=acao%>" /></td>
                        </tr>
                        <tr>
                            <td><input type="hidden" name="id" value="<%=id%>" /></td>
                        </tr>
                        <tr>
                            <td><%=campo1%>: </td>
                            <td><input type="text" name="<%=campo1%>" value="<%=("inclusaoL".equals(acao)?titulo:nome)%>" /></td>
                        </tr>
                        <tr>
                            <td><%=campo2%>: </td>
                            <td><input type="text" name="<%=campo2%>" value="<%=("inclusaoL".equals(acao)?autor:email)%>" /></td>
                        </tr>
                        <tr>
                            <td><%=campo3%>: </td>
                            <td><input type="text" name="<%=campo3%>" value="<%=("inclusaoL".equals(acao)?preco:telefone)%>" /></td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" value="Gravar" />
                <input type="reset" value="Limpar" />
            </form>
        </div>
    </body>
</html>

