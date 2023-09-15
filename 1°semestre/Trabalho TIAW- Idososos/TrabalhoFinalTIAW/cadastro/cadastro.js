function store(){
    var name = document.getElementById('name').value;
    var pw = document.getElementById('pw').value;
    var idade = document.getElementById('idade').value;
    var telefone = document.getElementById('telefone').value;
    var email = document.getElementById('email').value;
    var emergencia = document.getElementById('emergencia').value;
    var endereco = document.getElementById('endereco').value;
    /*
    var lowerCaseLetters = /[a-z]/g;
    var upperCaseLetters = /[A-Z]/g;
    var numbers = /[0-9]/g;

     if(name.length == 0 || pw.length == 0 || idade.length == 0 || telefone.length == 0 || email.length == 0 || emergencia.length == 0 || endereco.length == 0){
        alert('Por favor, preencha todos os campos');
    }else if(pw.length > 8){
        alert('Máximo de 8 caracteres na senha');
    }else if(!pw.match(numbers)){
        alert('Por favor, adicione pelo menos 1 número na senha');
    }else if(!pw.match(upperCaseLetters)){
        alert('Por favor, adicione pelo menos 1 letra maiúscula na senha');
    }else if(!pw.match(lowerCaseLetters)){
        alert('Por favor, adicione pelo menos 1 letra minúscula na senha');
    }else{ */

        // Cria um objeto com os dados do novo usuário
        var newUser = {
            name: name,
            pw: pw,
            idade: idade,
            telefone: telefone,
            email: email,
            emergencia: emergencia,
            endereco: endereco
        };

        // Recupera o array de usuários do localStorage, ou cria um novo array se ele não existir ainda
        var users = JSON.parse(localStorage.getItem('users')) || [];

        // Adiciona o novo usuário ao array de usuários
        users.push(newUser);

        // Armazena o array atualizado de usuários no localStorage
        localStorage.setItem('users', JSON.stringify(users));

        var users = JSON.parse(localStorage.getItem('users')) || [];
        alert('Sua conta foi criada com sucesso');

        localStorage.setItem('user_active', users.length);

    // } //
}

function check(){
    var userEmail = document.getElementById('userEmail').value;
    var userPw = document.getElementById('userPw').value;

    // Recupera o array de usuários do localStorage
    var users = JSON.parse(localStorage.getItem('users')) || [];

    // Verifica se o usuário existe no array
    var user = users.findIndex(function(u){
        return u.email == userEmail && u.pw == userPw;
    });

    if(user >= 0){
        localStorage.setItem('user_active', user);
        alert('Você está logado como '+users[user].name);
        location.href='/principal/index.html'
    }else{
        alert('Erro no login');
    }
}

//Fazendo a transição de login para cadastro 
window.onload = function() {
  document.getElementsByClassName("signin")[0].style.display = "none";
  var botaoIrParaCadastro = document.getElementById("linkCreateAccount");


  // Evento de clique do botão "nao tem uma conta? registre-se"
  botaoIrParaCadastro.addEventListener("click", function() {
      var divLogin = document.getElementsByClassName("login")[0];
      var divSignin = document.getElementsByClassName("signin")[0];

      divLogin.style.display = "none";
      divSignin.style.display = "block";
  });

  // Verifica SE usuário está logado

  var logged = localStorage.getItem('user_active') || -1;
  if (logged >= 0) {
    window.location.href='/principal/index.html'
  }

};


// Esconde a div "signin"
var telaSignin = document.getElementsByClassName("signin")[0];
telaSignin.style.display = "none";

// Adiciona evento de clique ao botão "Não tem uma conta? Registre-se"
var botaoIrParaCadastro = document.getElementById("linkCreateAccount");
botaoIrParaCadastro.addEventListener("click", function(event){
  event.preventDefault(); // previne o comportamento padrão do link


  // Verifica se a div "signin" está visível ou não e alterna entre as telas
  if (telaSignin.style.display === "none") {
    telaSignin.style.display = "block";
    document.getElementsByClassName("login")[0].style.display = "none";
  } else {
    telaSignin.style.display = "none";
    document.getElementsByClassName("login")[0].style.display = "block";
  }
});

// Adicionando botão para voltar à tela de login
var telaLogin = document.getElementsByClassName("login")[0];
var botaoVoltar = document.getElementById("voltar");

botaoVoltar.addEventListener("click", function(){
  telaSignin.style.display = "none";
  telaLogin.style.display = "block";
  divVisivel = false;
});






function storeTrab() {
    var nameTrab = document.getElementById('nameTrab').value;
    var pwTrab = document.getElementById('pwTrab').value;
    var idadeTrab = document.getElementById('idadeTrab').value;
    var telefoneTrab = document.getElementById('telefoneTrab').value;
    var emailTrab = document.getElementById('emailTrab').value;
    var emergenciaTrab = document.getElementById('emergenciaTrab').value;
    var enderecoTrab = document.getElementById('enderecoTrab').value;
    var CPFTrab = document.getElementById('CPFTrab').value;
    var servicosTrab = document.getElementById('servicosTrab').value;
    var carteiraTrab = document.getElementById('carteiraTrab').value;
    /*
    var lowerCaseLetters = /[a-z]/g;
    var upperCaseLetters = /[A-Z]/g;
    var numbers = /[0-9]/g;
  
    if (
      nameTrab.length == 0 ||
      pwTrab.length == 0 ||
      idadeTrab.length == 0 ||
      telefoneTrab.length == 0 ||
      emailTrab.length == 0 ||
      emergenciaTrab.length == 0 ||
      enderecoTrab.length == 0 ||
      CPFTrab.length == 0 ||
      servicosTrab.length == 0 ||
      carteiraTrab.length == 0
    ) {
      alert('Por favor, preencha todos os campos');
    } else if (pwTrab.length > 8) {
      alert('A senha deve ter no máximo 8 caracteres');
    } else if (!pwTrab.match(numbers)) {
      alert('A senha deve conter pelo menos um número');
    } else if (!pwTrab.match(upperCaseLetters)) {
      alert('A senha deve conter pelo menos uma letra maiúscula');
    } else if (!pwTrab.match(lowerCaseLetters)) {
      alert('A senha deve conter pelo menos uma letra minúscula');
    } else {
      */
      var newUserTrab = {
        nameTrab: nameTrab,
        pw: pwTrab,
        idade: idadeTrab,
        telefone: telefoneTrab,
        email: emailTrab,
        emergencia: emergenciaTrab,
        endereco: enderecoTrab,
        CPF: CPFTrab,
        servicos: servicosTrab,
        carteira: carteiraTrab
      };
  
      var usersTrab = JSON.parse(localStorage.getItem('usersTrab')) || [];
      usersTrab.push(newUserTrab);
      localStorage.setItem('usersTrab', JSON.stringify(usersTrab));
  
      alert('Sua conta de trabalhador foi criada com sucesso');

      localStorage.setItem('user_active', usersTrab.length);
    // } //
  }
  
  
  function checkTrab() {
    var email = document.getElementById('userEmail').value;
    var pw = document.getElementById('userPw').value;
    var users = JSON.parse(localStorage.getItem('usersTrab'));
    var userTrab = users.findIndex(function(userTrab) {
        return userTrab.email == email && userTrab.pw == pw;
    });

    if (userTrab >= 0) {
      localStorage.setItem('user_active', JSON.stringify(userTrab));
        //alert('Você está logado como trabalhador!');
        location.href='/principal/index.html';
    } else {
        alert('Erro no login de trabalhador!');
    }
}
  
        



// Esconde a div "signinTrabalhador"
var telaSigninTrabalhador = document.getElementsByClassName("signinTrabalhador")[0];
telaSigninTrabalhador.style.display = "none";

// Adiciona evento de clique ao botão "Registre-se como trabalhador"
var botaoIrParaCadastroTrab = document.getElementById("linkCreateAccountTrab");
botaoIrParaCadastroTrab.addEventListener("click", function(event){
    event.preventDefault(); // previne o comportamento padrão do link

    // Verifica se a div "signinTrabalhador" está visível ou não e alterna entre as telas
    if (telaSigninTrabalhador.style.display === "none") {
        telaSigninTrabalhador.style.display = "block";
        telaLogin.style.display = "none";
    }
    else {
        telaSigninTrabalhador.style.display = "none";
        telaLogin.style.display = "block";
    }
});

// Adicionando botão para voltar à tela de login
var telaLogin = document.getElementsByClassName("login")[0];
var botaoVoltarTrab = document.getElementById("voltarTrab");

botaoVoltarTrab.addEventListener("click", function(){
    telaSigninTrabalhador.style.display = "none";
    telaLogin.style.display = "block";
    divVisivel = false;
});

//Evento de clique no botão "Entrar"
function realizarLogin() {
  var checkbox = document.getElementById("checkbox");
  
  if (checkbox.checked) {
    // Executar o login de trabalhador
    checkTrab();
    // Restante do código para o login de trabalhador...
  } else {
    // Executar o login normal
    check();
    // Restante do código para o login normal...
  }
}