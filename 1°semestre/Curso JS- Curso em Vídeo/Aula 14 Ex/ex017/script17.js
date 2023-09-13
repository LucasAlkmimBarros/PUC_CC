function gerarTabela(){
    var num = parseInt(document.getElementById('num').value)
    var res = document.getElementById('seltab')
    var valor

    if(isNaN(num)) alert('Por favor digite um número válido!')
    else{
    res.innerHTML = ""
    for(var i = 1; i <= 10; i++){
        valor = num*i
        let item = document.createElement('option')
        item.text = `${Number(num)} X ${i} = ${Number(valor)}`
        item.value = `tab${i}`
        res.appendChild(item)
    }
}
}