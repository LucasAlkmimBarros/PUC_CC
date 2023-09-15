const charactersList = document.getElementById('charactersList');
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
                <p>Email: ${character.email}</p>
                <button class="chatbtn" onclick="location.href='/chat/char.html?id=${index}'">Converse com o profissional</button>
            </li>
        `;
        })
        .join('');
    charactersList.innerHTML = htmlString;
};

loadCharacters();

/*let btnback = document.querySelector('button');
    btnback.addEventListener('click', () => {
    window.history.back();
});*/
