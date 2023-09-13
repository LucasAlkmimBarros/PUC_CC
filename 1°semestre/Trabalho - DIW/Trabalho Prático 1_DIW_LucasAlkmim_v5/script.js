  //Carrousel

  const controls = document.querySelectorAll(".control");
  let currentItem = 0;
  const items = document.querySelectorAll(".item"); 
  const maxItems = items.length;

  controls.forEach((control) => {
    control.addEventListener("click", (e) => {
      isLeft = e.target.classList.contains("arrow-left");

      if (isLeft) {
        currentItem -= 1;
      } else {
        currentItem += 1;
      }

      if (currentItem >= maxItems) {
        currentItem = 0;
      }

      if (currentItem < 0) {
        currentItem = maxItems - 1;
      }

      items.forEach((item) => item.classList.remove("item-atual"));

      items[currentItem].scrollIntoView({
        behavior: "smooth",
        inline: "center"
      });

      items[currentItem].classList.add("item-atual");
    });
  });

  //Carrousel


  //Usando API
  var todosProdutos = [];

  function produtosPorCategoria() {
    fetch('https://diwserver.vps.webdock.cloud/products/')
      .then(response => response.json())
      .then(json => {
        todosProdutos = json.products;
        loadProdutos(todosProdutos, document.getElementById('cardsprodutos'));

      })
      .catch(error => console.log(error));
      console.log('mostrou1');

  }

  var produtosMostrados = [];

  function pesquisarPorCategoria(categoria) {
    produtosMostrados = todosProdutos.filter(produto => produto.articleType === categoria);
    loadProdutos(produtosMostrados, document.getElementById('cardsprodutos'));
    console.log('mostrou2');

  }

  function loadProdutos(produtos, card) {
    card.innerHTML = '';
    produtos.forEach(produto => {
      card.innerHTML += `
      <a class="produto" href="detalhes.html?id=${produto.id}" target="_blank">
      <img src="${produto.image}" alt="${produto.title}" class="imgproduto">
      <h3 class="nomeproduto">${produto.title}</h3>
      <p class="nomeproduto">${produto.articleType}</p>
      <p class="nomeproduto">Preço: R$${produto.price}</p>
      <button onclick="adicionarAoCarrinho(${produto.id})" class="botaoproduto">Detalhes</button>
    </a>
      `;
    });
    console.log('mostrou3');

  }

  function carregarProdutos() {
    pesquisarPorCategoria('Wallets');
    console.log('mostrou4');

  }

  function carregarProdutosWatches() {
    pesquisarPorCategoria('Watches');
    console.log('mostrou5');

  }

  // Função para carregar todos os produtos na página principal
  function carregarTodosProdutos() {
    loadProdutos(todosProdutos, document.getElementById('cardsprodutos'));
    console.log('mostrou6');

  }

  produtosPorCategoria();
  carregarTodosProdutos();

