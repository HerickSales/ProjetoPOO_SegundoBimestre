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
        <title>CadastroLivros</title>
                <link rel="stylesheet" href=""/>
        <link
            href="https://fonts.googleapis.com/icon?family=Material+Icons"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="styles.css" type="text/css">
    </head>

    <%
            String id= request.getParameter("id");
            String titulo=request.getParameter("titulo");
            String autor=request.getParameter("autor");
            String preco= request.getParameter("preco");
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

                            <button id="btnCadastrar" onclick="modal.style.display='block';">
                                <span> Cadastrar Livro </span>
                            </button>
                    </div>
                    <div id="modal" class="modal">
                        <div class="modal-container">
                            <div class="modal-header-style">
                                <div class="modal-header">
                                    <h1>Cadastro de Livros</h1>
                                    <button class="modal-close" id="btnModalClose" onclick="modal.style.display='none'">
                                        <i class="material-icons">close</i>
                                    </button>
                                </div>
                                <p>Preencha os campos abaixo:</p>
                            </div>

                            <div class="modal-content">
                                <label for="inpTitulo">Título</label>
                                <input type="text" id="inpTitulo" />

                                <label for="inpAutor">Autor</label>
                                <input type="text" id="inpAutor" />


                                <label for="inpValor">Preco</label>
                                <input type="number" id="inpValor" />

                                <button id="btnSalvar">
                                    <span><i class="material-icons">save</i></span>
                                    <span>Salvar Registro</span>
                                </button>
                            </div>
                        </div>
                    </div>

                    <hr />

                    <div class="table-content">
                        <table>
                            <thead>
                                <tr>
                                    <th>Título</th>
                                    <th>Autor(es)</th>
                                    <th>Preço</th>
                                </tr>
                            </thead>

                            <tbody id="bodyLivros"></tbody>
                        </table>
                    </div>
                    
                </div>
            </main>
        </div>
    </body>
</html>

