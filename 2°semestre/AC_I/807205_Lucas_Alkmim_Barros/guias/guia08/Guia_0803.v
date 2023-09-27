/*
Lucas Alkmim Barros - 807205
Guia 08 - Exercício 03
*/



module Guia_0803;

  reg [5:0] operandoA; // Operando A de 6 bits
  reg [5:0] operandoB; // Operando B de 6 bits
  reg igualdade;

  // Lógica para operando A (usado como exemplo)
  initial begin
    operandoA = 6'b001010; // Exemplo de operando A (ou qualquer outro valor desejado)
    operandoB = 6'b001010; // Exemplo de operando B (ou qualquer outro valor desejado)

    // Verifica a igualdade entre operandoA e operandoB
    if (operandoA == operandoB)
      igualdade = 1'b1; // Se forem iguais, igualdade é 1
    else
      igualdade = 1'b0; // Se forem diferentes, igualdade é 0

    // Imprime os operandos e o resultado da igualdade
    $display("Operando A: %b", operandoA);
    $display("Operando B: %b", operandoB);
    $display("Resultado da Igualdade: %b", igualdade);

    // Encerra a simulação
    $finish;
  end

endmodule
