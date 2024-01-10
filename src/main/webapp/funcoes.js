/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

    

let modal= document.querySelector("#modal");

function showModal(){
    modal.style.display="block";
}


 
function limpaCamposCliente() {
   
    let nome = document.querySelector("#nome");
    let email = document.querySelector("#email");
    let telefone = document.querySelector("#telefone");
    nome.value = "";
    email.value = "";
    telefone.value = "";
    modal.style.display = "none";
    
}

function limpaCamposLivros(modal) {
   
    let titulo = document.querySelector("#titulo");
    let autor = document.querySelector("#autor");
    let preco = document.querySelector("#preco");
    titulo.value = "";
    autor.value = "";
    preco.value = 0;
    modal.style.display = "none";
    
};


 



