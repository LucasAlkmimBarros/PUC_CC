var dados = {
    "results": {
        "total_records": 2,
        "data": [
            {
                "name": "Leanne Graham",
                "email": "Sincere@april.biz",
                "address": {
                    "street": "Kulas Light",
                    "suite": "Apt. 556",
                    "city": "Gwenborough"
                }
            },
            {
                "name": "Ervin Howell",
                "email": "Shanna@melissa.tv",
                "address": {
                    "street": "Victor Plains",
                    "suite": "Suite 879",
                    "city": "Wisokyburgh"
                }
            }
        ]
    }
};


//como acessar a cidade de Ervin Howell?
console.log(dados.results.data[1].address.city);
