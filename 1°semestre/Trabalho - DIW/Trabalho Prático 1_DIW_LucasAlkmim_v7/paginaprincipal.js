function produtosPorCategoria() {
    fetch('https://diwserver.vps.webdock.cloud/products/')
      .then(response => response.json())
      .then(json => {
        console.log(json);
      })
      .catch(error => console.log(error));
  }
  
  var produtosMostrados = [];
  
  function pesquisarPorCategoria(categoria) {
    fetch('https://diwserver.vps.webdock.cloud/products/category/' + categoria)
      .then(response => response.json())
      .then(json => {
        produtosMostrados = json.products;
        loadProdutos(produtosMostrados, document.getElementById('cardsprodutos'));
      })
  }
  
  function loadProdutos(produtos, container) {
    container.innerHTML = '';
    produtos.forEach(produto => {
      container.innerHTML += `
        <a class="produto" href="detalhes.html?id=${produto.id}" target="_blank">
          <img src="${produto.image}" alt="${produto.title}" class="imgproduto">
          <h3 class="nomeproduto">${produto.title}</h3>
          <p class="nomeproduto">${produto.articleType}</p>
          <p class="nomeproduto">Preço: R$${produto.price}</p>
          <button onclick="adicionarAoCarrinho(${produto.id})" class="botaoproduto">Detalhes</button>
        </a>
      `;
    });
  }

  function carregarProdutosOculos() {
    pesquisarPorCategoria('Accessories - Eyewear');
  }
  
  function carregarProdutosBones() {
    pesquisarPorCategoria('Accessories - Headwear');
  }
  
  function carregarProdutosJoias() {
    pesquisarPorCategoria("Accessories - Jewellery");
  }
  
  produtosPorCategoria();
  //carregarProdutosBones();
  //carregarProdutosJoias(); // Carrega os produtos Sandals automaticamente
  carregarProdutosOculos();
  
  const btnOculos = document.createElement('button');
  btnOculos.textContent = 'Mostrar Shoes';
  btnOculos.addEventListener('click', carregarProdutosOculos);
  
  const btnBones = document.createElement('button');
  btnBones.textContent = 'Mostrar Flip Flops';
  btnBones.addEventListener('click', carregarProdutosBones);
  
  const btnJoias = document.createElement('button');
  btnJoias.textContent = 'Mostrar Sandals';
  btnJoias.addEventListener('click', carregarProdutosJoias);
  
  