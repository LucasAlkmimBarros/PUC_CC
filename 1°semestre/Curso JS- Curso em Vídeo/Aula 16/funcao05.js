//Recursividade
function fatorial(n){
    var fat
    if(n < 2) fat = 1
    else fat = n*fatorial(n-1)
    return fat
}

console.log(fatorial(5))