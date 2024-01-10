<%-- 
    Document   : Formulario
    Created on : 19/06/2019, 10:42:39
    Author     : lefoly
--%>

<%@page import="controller.EmprestimoSrv"%>
<%@page import="controller.LivroSrv"%>
<%@page import="model.Livro"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Cliente"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CadastroLivros</title>
        <link rel="stylesheet" href=""/>
        <link
            href="https://fonts.googleapis.com/icon?family=Material+Icons"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="styles.css" type="text/css">
    </head>

    <%
        String id = request.getParameter("id");
        String acao = request.getParameter("acao");
        String cliente= request.getParameter("cliente");
        String livro= request.getParameter("livro");
        String dataDev = request.getParameter("dataDev");

        EmprestimoSrv srv = new EmprestimoSrv();
        String list = srv.listagem();
        
        
        if(id==null|| cliente==null){
        cliente="";
        livro="";
        dataDev="";
        }


    %>

    <body>
        <div class="content">
            <nav class="navbar">
                <a href="index.html" class="logo" href="#">
                    <i class="material-icons">dataset</i>
                </a>
                <div>
                    <ul class="navlinks">
                        <li>
                            <a><i class="material-icons">book</i></a>
                            <div class="tooltip">Livros</div>
                        </li>
                        <li>
                            <a href="CadastroClientes.jsp?acao=inclusao"><i class="material-icons">contacts</i></a>
                            <div class="tooltip">Clientes</div>
                        </li>
                    </ul>
                </div>
            </nav>
            <main>
                <div class="container">
                    <div class="header">
                        <h1>Livros</h1>

                        <button id="btnCadastrar" onclick="showModal()">
                            <span> Novo Emprestimo </span>
                        </button>
                    </div>
                    <div id="modal" class="modal">
                        <div class="modal-container">
                            <div class="modal-header-style">
                                <div class="modal-header">
                                    <h1>Cadastro de Livros</h1>
                                    <button class="modal-close" id="btnModalClose" onclick="limpaCamposLivros(modal)">
                                        <i class="material-icons">close</i>
                                    </button>
                                </div>
                                <p>Preencha os campos abaixo:</p>
                            </div>
                            <form action="EmprestimoSrv" method="POST">
                                <div class="modal-content">

                                    <input type="hidden" name="acao" value=<%=acao%>> 
                                    <input type="hidden" name="id" value=<%=id%>>

                                    <label for="inpTitulo">Cliente</label>
                                    <input type="text"  name="cliente" id="cliente" value=<%=cliente%> >  

                                    <label for="inpAutor">Titulo do Livro</label>
                                    <input type="text"  name="livro" id="livro" value=<%=livro%> >


                                    <label for="inpValor">data Devolução</label>
                                    <input type="date"  name="data" id="data" value=<%=dataDev%> >

                                    <input type="submit" value="Salvar" id="btnSalvar">
                                </div>
                            </form>


                        </div>
                    </div>

                    <hr />

                    <div class="table-content">
                        <table>
                            <thead>
                                <tr>
                                    <th>Cliente</th>
                                    <th>Livro(es)</th>
                                    <th>DataDev</th>
                                </tr>
                            </thead>

                            <tbody id="bodyLivros">
                                <%=list%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </main>
                                                <script>
                                 let acao = "<%=acao%>";
                                 if (acao === "edicao") {
                                     modal.style.display = 'block';
                                 }

                    </script>
        </div>
        <script src="./funcoes.js"></script>
    </body>
</html>

