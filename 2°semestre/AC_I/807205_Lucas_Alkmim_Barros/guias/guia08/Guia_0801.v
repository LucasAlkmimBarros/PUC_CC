/*
Lucas Alkmim Barros - 807205
Guia 08 - Exercício 01
*/



module Guia_0801;
  
  reg [5:0] operandoA; // Operando A de 6 bits
  reg [5:0] operandoB; // Operando B de 6 bits
  integer vaiUm;
  reg[1:0] soma;
  reg[5:0] resultado; 
  
  // Lógica para operando A (usado como exemplo)
  initial begin
    operandoA = 6'b001010; // Exemplo de operando A (ou qualquer outro valor desejado)
    operandoB = 6'b000110; // Exemplo de operando B (ou qualquer outro valor desejado)
    
    // Realiza a soma usando um somador completo de 6 bits
    vaiUm = 0;
    soma = operandoA[0] + operandoB[0] + vaiUm;
    vaiUm = soma[1];
    resultado[0] = soma[0];

    soma = operandoA[1] + operandoB[1] + vaiUm;
    vaiUm = soma[1];
    resultado[1] = soma[0];

    soma = operandoA[2] + operandoB[2] + vaiUm;
    vaiUm = soma[1];
    resultado[2] = soma[0];

    soma = operandoA[3] + operandoB[3] + vaiUm;
    vaiUm = soma[1];
    resultado[3] = soma[0];

    soma = operandoA[4] + operandoB[4] + vaiUm;
    vaiUm = soma[1];
    resultado[4] = soma[0];

    soma = operandoA[5] + operandoB[5] + vaiUm;
    vaiUm = soma[1];
    resultado[5] = soma[0];

    // Imprime os operandos e o resultado
    $display("Operando A: %b", operandoA);
    $display("Operando B: %b", operandoB);
    $display("Resultado da Soma: %b", resultado);
    
    // Encerra a simulação
    $finish;
  end

endmodule
