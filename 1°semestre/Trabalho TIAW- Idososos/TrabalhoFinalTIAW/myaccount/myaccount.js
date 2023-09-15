window.addEventListener("DOMContentLoaded", function () {
  var editButton = document.getElementById("editbtn");
  var tableCells = document.querySelectorAll(".card-body table td:last-child");

  var displayName = document.querySelector("#d_name");
  var displayEmail = document.querySelector("#d_mail");

  var logout = document.querySelector(".sidenav-url .active");
  
  logout.addEventListener("click", function () {
    localStorage.removeItem("user_active");
    alert("Você saiu do sistema");
    window.location.href='/principal/index.html'
  });

  editButton.addEventListener("click", function () {
    tableCells.forEach(function (cell) {
      cell.contentEditable = true;
      cell.style.backgroundColor = "lightyellow";
    });

    editButton.disabled = true;

    var saveButton = document.createElement("button");
    saveButton.innerHTML = '<i class="fa fa-save fa-xs save"></i>';
    saveButton.classList.add("savebtn");
    tableCells[0].parentNode.appendChild(saveButton);

    saveButton.addEventListener("click", function () {
      tableCells.forEach(function (cell) {
        cell.contentEditable = false;
        cell.style.backgroundColor = "";
      });

      editButton.disabled = false;
      tableCells[0].parentNode.removeChild(saveButton);

      var userData = JSON.parse(localStorage.getItem("users"));
      var uid = localStorage.getItem('user_active');

      // Salvar os dados modificados no localStorage
      userData[uid] = {
        name: tableCells[0].textContent.trim(),
        email: tableCells[1].textContent.trim(),
        numero: tableCells[2].textContent.trim(),
        endereco: tableCells[3].textContent.trim(),
        profissao: tableCells[4].textContent.trim(),
        habilidades: tableCells[5].textContent.trim(),
      };

      localStorage.setItem("users", JSON.stringify(userData));
    });
  });

  // Carregar dados salvos do localStorage, se houver
  var savedUserData = JSON.parse(localStorage.getItem("users"));
  var uid = localStorage.getItem('user_active');
  var savedUserData = [savedUserData[uid]];

  if (savedUserData) {
    //savedUserData = JSON.parse(savedUserData);
    tableCells[0].textContent = savedUserData[0].name;
    tableCells[1].textContent = savedUserData[0].email;
    tableCells[2].textContent = savedUserData[0].numero;
    tableCells[3].textContent = savedUserData[0].endereco;
    tableCells[4].textContent = savedUserData[0].profissao;
    tableCells[5].textContent = savedUserData[0].habilidades;
    //
    displayName.textContent = savedUserData[0].name;
    displayEmail.textContent = savedUserData[0].email;
  }
});

window.onload = function() {
  // Verifica SE usuário está logado
  var logged = localStorage.getItem('user_active') || -1;
  if (!(logged >= 0)) {
    alert("Você não está logado!");
    window.location.href='/principal/index.html'
  }
};