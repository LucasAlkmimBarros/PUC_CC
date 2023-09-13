function carregar(){
    var msg = document.getElementById('msg')
    var img = document.getElementById('imagem')
    var data = new Date()
    var hora = data.getHours()
    msg.innerHTML = `Agora são ${hora} horas.`
    if(hora >= 0 && hora < 12){
        //BOM DIA!
        img.src = 'foto_manha.png'
        document.body.style.background = 'skyblue'
    } else if(hora < 18){
        //BOA TARDE!
        img.src = 'foto_tarde.png'
        document.body.style.background = 'orange'
    } else{
        //BOA NOITE!
        img.src = 'foto_noite.png'
        document.body.style.background = 'rgb(74, 74, 121);'
    }
}
