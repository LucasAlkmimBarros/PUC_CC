const characterProfile = document.getElementById('characterProfile');
const btnSendMessage = document.getElementById('btnSendMessage');
const messageBox = document.getElementById('messageBox');
const forum = document.getElementById('forumList');
let hpCharacter = [];
let lid;
let uid;
let username;

btnSendMessage.addEventListener('click', (e) => {
    const msg = messageBox.value;
    console.log(msg);

    displayMessages(msg, username);

    messageBox.value = "";

    // Salvar mensagens no localStorage
    const savedMessages = localStorage.getItem('forumMessages');
    let messages = [];

    if (savedMessages) {
        messages = JSON.parse(savedMessages);
    }

    let user_msg = {};
    user_msg.from_id = lid;
    user_msg.to_id = uid;
    user_msg.msg = msg;

    messages.push(user_msg);
    localStorage.setItem('forumMessages', JSON.stringify(messages));
});


const displayMessages = (msg, from) => {
    forum.innerHTML = forum.innerHTML + `
        <div>
            <span>${from}:</span>
            <br>
            ${msg}
        </div>
    `;
};

const loadForum = async () => {
    try {
        const url_string = window.location.href;
        const url = new URL(url_string);
        uid = url.searchParams.get('id');
        //const res = await fetch('https://hp-api.onrender.com/api/character/' + uid);
        //hpCharacter = await res.json();

        var hpCharacters = JSON.parse(localStorage.getItem('users')) || [];
        var hpCharacter = [hpCharacters[uid]];

        displayOneCharacter(hpCharacter);
        displayOneCharacterMessages(uid);
    } catch (err) {
        console.error(err);
    }
};

const displayOneCharacter = (characters) => {
    const htmlString = characters
        .map((character) => {
            return `
            <li class="character">
                <h1>${character.name}</h1>
                <p>e-mail: ${character.email}</p>
            </li>
        `;
        })
        .join('');
    characterProfile.innerHTML = htmlString;

};

const displayOneCharacterMessages = (ind) => {
    var charMessages = JSON.parse(localStorage.getItem('forumMessages')) || [];
    var msg = charMessages.filter((message) => {
        return message.to_id == ind
    });

    var users = JSON.parse(localStorage.getItem('users')) || [];
    msg.map((message) => {
        displayMessages(message.msg, users[message.from_id].name);
    });
    
};

loadForum();

window.onload = function() {
    // Verifica SE usuário está logado
    var logged = localStorage.getItem('user_active') || -1;
    if (!(logged >= 0)) {
      alert("Você não está logado!");
      window.location.href='/principal/index.html'
    }

    // informação do usario logado
    var logged_user = JSON.parse(localStorage.getItem('users')) || [];
    lid = logged;
    username = logged_user[logged].name;
  };