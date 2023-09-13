function store(){

    var name = document.getElementById('name');
    var pw = document.getElementById('pw');
    var idade = document.getElementById('idade');
    var telefone = document.getElementById('telefone');
    var email = document.getElementById('email');
    var emergencia = document.getElementById('emergencia');
    var endereco = document.getElementById('endereco');
    var lowerCaseLetters = /[a-z]/g;
    var upperCaseLetters = /[A-Z]/g;
    var numbers = /[0-9]/g;

    if(name.value.length == 0 || pw.value.length == 0 || idade.value.length == 0 || telefone.value.length == 0 || email.value.length == 0 || emergencia.value.length == 0 || endereco.value.length == 0){
        alert('Por favor, preencha todos os campos');

    }else if(pw.value.length > 8){
        alert('Maximo de 8');

    }else if(!pw.value.match(numbers)){
        alert('Por favor, adicione 1 numero a senha');

    }else if(!pw.value.match(upperCaseLetters)){
        alert('Por favor, adicione 1 letra maiuscula a senha');

    }else if(!pw.value.match(lowerCaseLetters)){
        alert('Por favor, adicione 1 letra minuscula a senha');

    }else{
        localStorage.setItem('name', name.value);
        localStorage.setItem('pw', pw.value);
        localStorage.setItem('idade', idade.value);
        localStorage.setItem('telefone', telefone.value);
        localStorage.setItem('email', email.value);
        localStorage.setItem('emergencia', emergencia.value);
        localStorage.setItem('endereco', endereco.value);
        alert('Your account has been created');
    }
}

//checking
function check(){
    var storedName = localStorage.getItem('name');
    var storedPw = localStorage.getItem('pw');
    var storedIdade = localStorage.getItem('idade');
    var storedTelefone = localStorage.getItem('telefone');
    var storedEmail = localStorage.getItem('email');
    var storedEmergencia = localStorage.getItem('emergencia');
    var storedEndereco = localStorage.getItem('endereco');

    var userEmail = document.getElementById('userEmail');
    var userPw = document.getElementById('userPw');
    var userRemember = document.getElementById("rememberMe");

    if(userEmail.value == storedEmail && userPw.value == storedPw){
        alert('Você está logado.');
    }else{
        alert('Erro no login');
    }
}