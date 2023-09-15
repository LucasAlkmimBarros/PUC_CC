const charactersList = document.getElementById('charactersList');
const characterForum = document.getElementById('characterForum');
const searchBar = document.getElementById('searchBar');
let hpCharacters = [];

searchBar.addEventListener('keyup', (e) => {
    const searchString = e.target.value.toLowerCase();

    const filteredCharacters = hpCharacters.filter((character) => {
        return (
            character.name.toLowerCase().includes(searchString) ||
            character.house.toLowerCase().includes(searchString)
        );
    });
    displayCharacters(filteredCharacters);
});

const loadCharacters = async () => {
    try {
        //const res = await fetch('https://hp-api.onrender.com/api/characters');
        //hpCharacters = await res.json();

        var hpCharacters = JSON.parse(localStorage.getItem('users')) || [];

        displayCharacters(hpCharacters);
    } catch (err) {
        console.error(err);
    }
};

const displayCharacters = (characters) => {
    const htmlString = characters
        .map((character, index) => {
            return `
            <li class="character">
                <h2>${character.name}</h2>
                <p>e-mail: ${character.email}</p>
                <a class="chatbtn"  href="char.html?id=${index}"><i class="fa-solid fa-comments fa-lg"></i></a>
            </li>
        `;
        })
        .join('');
    charactersList.innerHTML = htmlString;
};

loadCharacters();

window.onload = function() {
    // Verifica SE usuário está logado
    var logged = localStorage.getItem('user_active') || -1;
    if (!(logged >= 0)) {
      alert("Você não está logado!");
      window.location.href='/principal/index.html'
    }
  };