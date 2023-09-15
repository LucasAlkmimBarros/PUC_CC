var stars = document.querySelectorAll('.star-icon');
var avaliacao = JSON.parse(localStorage.getItem('avaliacao')) || [];
document.addEventListener('click', function(e){
  var classStar = e.target.classList;
  if (!classStar.contains('ativo')) {
    stars.forEach(function(star){
      star.classList.remove('ativo');
    });
    classStar.add('ativo');
    avaliacao.push(e.target.getAttribute('data-avaliacao'));
    console.log('Avaliação selecionada:', e.target.getAttribute('data-avaliacao'));
    localStorage.setItem('avaliacao', JSON.stringify(avaliacao));
    alert('Obrigado por avaliar!');
    // Atualiza as estrelas
    atualizaEstrelas();
  }
});

// Função para atualizar as estrelas
function atualizaEstrelas() {
  var storedAvaliacao = JSON.parse(localStorage.getItem('avaliacao'));
  if (storedAvaliacao !== null) {
    stars.forEach(function(star, index){
      if (storedAvaliacao.includes((index + 1).toString())) {
        star.classList.add('ativo');
      } else {
        star.classList.remove('ativo');
      }
    });
  }
}

window.onload = function() {
  // Verifica SE usuário está logado
  var logged = localStorage.getItem('user_active') || -1;
  if (!(logged >= 0)) {
    alert("Você não está logado!");
    window.location.href='/principal/index.html'
  }
};