/*
Lucas Alkmim Barros - 807205
Guia 08 - Exercício 04
*/



module Guia_0804;

  reg [5:0] operandoA; // Operando A de 6 bits
  reg [5:0] operandoB; // Operando B de 6 bits
  reg desigualdade;

  // Lógica para operando A (usado como exemplo)
  initial begin
    operandoA = 6'b001010; // Exemplo de operando A (ou qualquer outro valor desejado)
    operandoB = 6'b000110; // Exemplo de operando B (ou qualquer outro valor desejado)

    // Verifica a desigualdade entre operandoA e operandoB
    if (operandoA != operandoB)
      desigualdade = 1'b1; // Se forem diferentes, desigualdade é 1
    else
      desigualdade = 1'b0; // Se forem iguais, desigualdade é 0

    // Imprime os operandos e o resultado da desigualdade
    $display("Operando A: %b", operandoA);
    $display("Operando B: %b", operandoB);
    $display("Resultado da Desigualdade: %b", desigualdade);

    // Encerra a simulação
    $finish;
  end

endmodule
