/*
Lucas Alkmim Barros - 807205
Guia 08 - Exercício 02
*/



module Guia_0802;
  
  reg [5:0] operandoA; // Operando A de 6 bits
  reg [5:0] operandoB; // Operando B de 6 bits
  reg [6:0] complementoDeDois; // Armazena o complemento de dois de B
  reg [5:0] resultado; 
  
  // Lógica para operando A e B (usado como exemplo)
  initial begin
    operandoA = 6'b001010; // Exemplo de operando A (ou qualquer outro valor desejado)
    operandoB = 6'b000110; // Exemplo de operando B (ou qualquer outro valor desejado)
    
    // Calcula o complemento de dois de B
    complementoDeDois = ~operandoB + 1;

    // Realiza a subtração
    resultado = operandoA + complementoDeDois;

    // Imprime os operandos e o resultado
    $display("Operando A: %b", operandoA);
    $display("Operando B: %b", operandoB);
    $display("Resultado da Subtração: %b", resultado);
    
    // Encerra a simulação
    $finish;
  end

endmodule
