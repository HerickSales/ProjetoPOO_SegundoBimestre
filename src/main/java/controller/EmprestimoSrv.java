/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Emprestimo;
import model.dao.ClienteDaoJpa;
import model.dao.EmprestimoDaoJpa;
import model.dao.InterfaceDao;
import model.dao.LivroDaoJpa;

/**
 *
 * @author heric
 */
@WebServlet(name = "EmprestimoSrv", urlPatterns = {"/EmprestimoSrv"})
public class EmprestimoSrv extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String acao = request.getParameter("acao");
            String id = request.getParameter("id");
            int livroId = 0;
            int clienteId = 0;

            String clienteIdString = request.getParameter("clienteId");
            String livroIdString = request.getParameter("livroId");
            String dataDev = request.getParameter("data");
            ClienteDaoJpa clienteJpa= new ClienteDaoJpa();
            LivroDaoJpa livroJpa= new LivroDaoJpa();

            System.out.println(acao);

            if (clienteIdString != null) {
                clienteId = Integer.parseInt(clienteIdString);
            }

            if (livroIdString != null) {
                livroId = Integer.parseInt(livroIdString);

            }

            InterfaceDao dao = new EmprestimoDaoJpa();
            RequestDispatcher rd;
            Emprestimo e = null;

            switch (acao) {
                case "inclusao":
                    e = new Emprestimo(clienteId, livroId, dataDev);

                    try {
                        dao.incluir(e);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("index.jsp?acao=inclusao&lista=" + listagem());
                    rd.forward(request, response);
                    break;

                case "pre-edicao":
                    e = (Emprestimo) dao.pesquisarPorId(Integer.parseInt(id));
                    rd = request.getRequestDispatcher("index.jsp?acao=edicao"
                            + "&id=" + e.getId()
                            + "&cliente=" + clienteJpa.pesquisarPorId(e.getClienteId()).getNome()
                            + "&livro=" + livroJpa.pesquisarPorId(e.getLivroId()).getTitulo()
                            + "&dataDev=" + e.getDataDev());
                    rd.forward(request, response);
                    break;

                case "edicao":

                    e = new Emprestimo(clienteId, livroId, dataDev);
                    e.setId(Integer.parseInt(id));
                    try {
                        dao.editar(e);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("index.jsp?acao=inclusao&lista=" + listagem());
                    rd.forward(request, response);
                    break;

                case "exclusao":
                    try {
                        e = new Emprestimo();
                        e.setId(Integer.parseInt(id));
                        dao.excluir(e);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("index.jsp?acao=inclusao&lista=" + listagem());
                    rd.forward(request, response);
                    break;

                case "listagem":
                    rd = request.getRequestDispatcher("index.jsp?acao=inclusao&lista=" + listagem());
                    rd.forward(request, response);
                    break;

                case "pesquisarPorId":
                    int idInt = (Integer) parseInt(id);
                    rd = request.getRequestDispatcher("index.jsp?acao=inclusao&lista=" + listagemFiltrada(idInt));
                    rd.forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(EmprestimoSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String listagem() throws Exception {
        InterfaceDao dao = new EmprestimoDaoJpa();
        List<Emprestimo> lista = null;
        try {
            lista = dao.listar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String listaHTML = "";
        ClienteDaoJpa daoCliente = new ClienteDaoJpa();
        LivroDaoJpa daoLivro = new LivroDaoJpa();

        
        for (Emprestimo emprestimo : lista) {
            String nomeCliente = daoCliente.pesquisarPorId(emprestimo.getClienteId()).getNome();
            String tituloLivro = daoLivro.pesquisarPorId(emprestimo.getLivroId()).getTitulo();
            listaHTML = listaHTML
                    + "<tr>"
                    + "<td>" + nomeCliente + "</td>"
                    + "<td>" + tituloLivro + "</td>"
                    + "<td>" + emprestimo.getDataDev() + "</td>"
                    + "<td><form action=EmprestimoSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id' value="
                    + emprestimo.getId() + "><input type='submit'class='btnBody' value=editar>"
                    + "<i class=\"material-icons\">assignment</i></form></td>"
                    + "</form></td>"
                    + "<form action=EmprestimoSrv?acao=exclusao method='POST'>"
                    + "<td><input type='hidden' name='id' value="
                    + emprestimo.getId() + "><input type='submit'class='btnBody' value=deletar><i class='material-icons'>delete</i></td>"
                    + "</form>"
                    + "</tr>";
        }
        return listaHTML;
    }

    private String listagemFiltrada(int id) throws Exception {
        InterfaceDao dao = new EmprestimoDaoJpa();
        List<Emprestimo> lista = null;
        try {
            lista = dao.filtrarPorNomeOuTitulo(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String listaHTML = "";
        ClienteDaoJpa daoCliente = new ClienteDaoJpa();
        LivroDaoJpa daoLivro = new LivroDaoJpa();
        for (Emprestimo emprestimo : lista) {
            String nomeCliente = daoCliente.pesquisarPorId(emprestimo.getClienteId()).getNome();
            String tituloLivro = daoLivro.pesquisarPorId(emprestimo.getLivroId()).getTitulo();
            listaHTML = listaHTML
                    + "<tr>"
                    + "<td>" + nomeCliente + "</td>"
                    + "<td>" + tituloLivro + "</td>"
                    + "<td>" + emprestimo.getDataDev() + "</td>"
                    + "<td><form action=EmprestimoSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id' value="
                    + emprestimo.getId() + "><input type='submit' value=editar>"
                    + "</form></td>"
                    + "<form action=EmprestimoSrv?acao=exclusao method='POST'>"
                    + "<td><input type='hidden' name='id' value="
                    + emprestimo.getId() + "><input type='submit' value=excluir></td>"
                    + "</form>"
                    + "</tr>";
        }
        return listaHTML;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
