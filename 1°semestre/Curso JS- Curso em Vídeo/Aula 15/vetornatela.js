let valores = [8, 5, 4, 4, 9]


valores.sort()
let posicao =  valores.indexOf(999)
for(let pos in valores)
{ 
    console.log(`A posição ${pos} tem o valor ${valores[pos]}`)
    if( posicao == -1) console.log(`A posicao nao foi encontada`)
}