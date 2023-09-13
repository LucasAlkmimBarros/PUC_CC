var vetor = []
var res = document.getElementById('res')

function verificaNum(numero){
    var pos = vetor.indexOf(numero)
    if(pos == -1) return false
    else return true
}


function adicionar(){
    let num = parseFloat(document.getElementById('num').value)
    let txtNum = document.getElementById('num')
    let tab = document.getElementById('seltab')  
    let verifica = verificaNum(num)

    if(num < 1 || num > 100 || verifica) alert("Valor inválido ou já encontrado na lista")
    else if(isNaN(num)) alert("Digite um número válido!")
    else{
        vetor.push(num)
        let item = document.createElement('option')
         item.text = `Valor ${num} adicionado!`
         item.value = tab
         tab.appendChild(item)
         res.innerHTML = ""
        }
        txtNum.value = "" 
        txtNum.focus()   
        }
    


function somaVetor(vet){
    let tam = vet.length
    let soma = 0
    for(var i = 0; i < tam; i++){
        soma += vet[i]
    }
    return soma
}

function calcluaMedia(soma, vet){
    var tamVet = vet.length
    var media = soma / tamVet
    return media
}

function finalizar()
{
    let tam = vetor.length
    let soma = somaVetor(vetor)
    let media = calcluaMedia(soma, vetor)

    vetor.sort(function(a, b) {
        return a - b; // 
    });


    res.innerHTML = ""
    if(tam == 0) alert("Adicione números antes de finalizar")
    else{
        res.innerHTML = 
        `<p>Ao todo, temos ${tam} números cadastrados</p>
        <p>O maior valor informado foi ${vetor[tam-1]}</p>
        <p>O menor valor informado foi ${vetor[0]}</p>
        <p>Somando todos os valores temos ${soma}</p>
        <p>A média dos valaores digitados é ${media}</p>`

    }

}