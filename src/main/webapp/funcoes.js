/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */




function showModal(modal) {
    modal.style.display = "block";
    desabilitarBtnSalvar();
    
}

function desabilitarBtnSalvar(){
    let btnSalvar= document.querySelector("#btnSalvar");
    btnSalvar.disabled=true;  
}

function habilitarBtnSalvar(){
    let btnSalvar= document.querySelector("#btnSalvar");
    btnSalvar.disabled=false;  
}

function verificaCampos(campo1, campo2,campo3){
    console.log(campo1+campo2+campo3);
    if(campo1!==""&& campo2!==""&&( campo3!==""&& campo3!==0 &&campo3!==null)){
        habilitarBtnSalvar();
    }
    return ;
    
}



function limpaCamposCliente(modal) {
   

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
}

function limpaCamposEmprestimo(modal) {
    let cliente = document.querySelector("#cliente");
    let livro = document.querySelector("#livro");
    let data = document.querySelector("#data");
    cliente.value = "";
    livro.value = "";
    data.value = "";
    modal.style.display = "none";
}




 function filtraElem(filtro, id) {
            filtro = filtro.toLowerCase();
            var linhas = document.querySelectorAll(id);

            linhas.forEach(function(linha) {
                var nomeCliente = linha.querySelector('td:first-child').innerText.toLowerCase();

                if (nomeCliente.includes(filtro)) {
                    linha.style.display = '';
                } else {
                    linha.style.display = 'none';
                }
            });
        }
