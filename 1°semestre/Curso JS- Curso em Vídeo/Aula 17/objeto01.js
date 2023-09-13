let amigo ={nome:'José',
sexo: 'M',
peso: 90,
engordar(p){
    console.log('Engordou')
    this.peso += p
 }}
amigo.engordar(2)
console.log(`${amigo.nome} pesa ${amigo.peso}Kg`)