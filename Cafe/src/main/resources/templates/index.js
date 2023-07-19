document.addEventListener("DOMContentLoaded", function() {
    var form = document.querySelector("form");
  
    form.addEventListener("submit", function(event) {
      event.preventDefault();
  
      var nome = document.querySelector(".nome").value;
      var cpf = document.querySelector(".cpf").value;
      var comida = document.querySelector(".comida").value;
  
      var formData = {
        "nome": nome,
        "cpf": cpf,
        "comida": comida
      };
  
      var xhr = new XMLHttpRequest();
      xhr.open("POST", "http://localhost:8080/Registrar");
      xhr.setRequestHeader("Content-Type", "application/json");
  
      xhr.onload = function() {
        if (xhr.status === 200) {
          console.log("JSON enviado com sucesso.");
        } else {
          console.log("Erro ao enviar JSON.");
        }
      };
  
      xhr.send(JSON.stringify(formData));
    });
  });
  