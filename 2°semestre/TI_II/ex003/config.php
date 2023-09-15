<?php

    $dbHost = 'localhost';
    $dbUsername = 'postgres';
    $dbPassword = 'post123';
    $dbName = 'ex03';

    $conexao = new mysqli($dbHost, $dbUsername, $dbPassword, $dbName);

    if($conexao->connect_errno){
        echo "Erro";
    }
    else{
        echo "Conectado";
    }
    
?>