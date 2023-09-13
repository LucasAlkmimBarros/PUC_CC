function contar(){
    var inicio = parseInt(document.getElementById('inicio').value)
    var fim = parseInt(document.getElementById('fim').value)
    var passo = parseInt(document.getElementById('passo').value)
    var res = document.getElementById('resp')
    res.innerHTML = 'Contando: <br>'
    if(passo == 0){
        alert('Esse passo não é válido! Considerando passo "1"')
        passo = 1
    }

    if (isNaN(inicio) || isNaN(fim) || isNaN(passo)) 
    {
        res.innerHTML = ``
        res.innerHTML += `Impossível contar!`
    }
//Contagem crescente
    if(inicio > fim){
        passo = -passo
        for(var i = inicio; i >= fim; i += passo){
            res.innerHTML += `${i}\u{1F449} `
        }
        if (!isNaN(inicio) && !isNaN(fim) && !isNaN(passo)) res.innerHTML += `\u{1F3C1}`
    
    }
    //Contagem Regressiva
    else{
    for(var i = inicio; i <= fim; i += passo){
        res.innerHTML += `${i}\u{1F449} `
    }
    if (!isNaN(inicio) && !isNaN(fim) && !isNaN(passo)) res.innerHTML += `\u{1F3C1}`
}
}
