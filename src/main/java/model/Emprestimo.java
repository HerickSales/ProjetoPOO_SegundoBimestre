/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author lefoly
 */
@NamedQuery(
        name = "Emprestimo.filtrarPorNomeOuTitulo",
        query = "SELECT e FROM Emprestimo e WHERE e.clienteId = :id or e.livroId =:id "
)

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column(name = "ID_CLIENTE")
    private int clienteId;

    @Column(name = "ID_LIVRO")
    private int livroId;

    @Column(name = "DT_DEV")
    private String dataDev;

    public Emprestimo() {
    }

    public Emprestimo(int clienteId, int livroId, String dataDev) {
        this.clienteId = clienteId;
        this.livroId = livroId;
        this.dataDev = dataDev;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getLivroId() {
        return livroId;
    }

    public void set(int livroId) {
        this.livroId = livroId;
    }

    public String getDataDev() {
        return dataDev;
    }

    public void setDataDev(String dataDev) {
        this.dataDev = dataDev;
    }

    @Override
    public String toString() {
        return "Emprestimo:" + "id=" + id + ", clienteId=" + clienteId + ", licroId=" + livroId + ", dataDev=" + dataDev + '}';
    }

}
