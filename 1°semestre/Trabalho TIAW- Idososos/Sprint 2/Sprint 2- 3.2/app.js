function store(){
    var name = document.getElementById('name').value;
    var pw = document.getElementById('pw').value;
    var idade = document.getElementById('idade').value;
    var telefone = document.getElementById('telefone').value;
    var email = document.getElementById('email').value;
    var emergencia = document.getElementById('emergencia').value;
    var endereco = document.getElementById('endereco').value;
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
    }else{
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

        alert('Sua conta foi criada com sucesso');
    }
}

function check(){
    var userEmail = document.getElementById('userEmail').value;
    var userPw = document.getElementById('userPw').value;
    var userRemember = document.getElementById('rememberMe').checked;

    // Recupera o array de usuários do localStorage
    var users = JSON.parse(localStorage.getItem('users')) || [];

    // Verifica se o usuário existe no array
    var user = users.find(function(u){
        return u.email == userEmail && u.pw == userPw;
    });

    if(user){
        alert('Você está logado.');
    }else{
        alert('Erro no login');
    }
}

//Fazendo a transição de login para cadastro
window.onload = function() {
    document.getElementsByClassName("signin")[0].style.display = "none";
    var loginButton = document.getElementById('login');
    var signinButton = document.getElementById('signin');
    var botaoIrParaCadastro = document.getElementById("linkCreateAccount");   

    // Evento de clique do botão de login
    loginButton.addEventListener('click', function(){
        check();
    });

    // Evento de clique do botão de cadastro
    signinButton.addEventListener('click', function(){
        store();
    });

    // Evento de clique do botão "nao tem uma conta? registre-se"
    botaoIrParaCadastro.addEventListener("click", function(){
        var divLogin = document.getElementsByClassName("login")[0];
        var divSignin = document.getElementsByClassName("signin")[0];

        divLogin.style.display = "none";
        divSignin.style.display = "block";
    });

    
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