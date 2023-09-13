/*
 Guia_0101.v (questao 01c)
 807205 - Lucas Alkmim Barros
*/

function dec2bin(x) {
    return (x >>> 0).toString(2);
}


const decimal = 10;
const binario = dec2bin(decimal);
console.log(binario); 
