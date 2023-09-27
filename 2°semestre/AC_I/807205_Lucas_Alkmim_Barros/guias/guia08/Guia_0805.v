/*
Lucas Alkmim Barros - 807205
Guia 08 - Exercício 05
*/



module Guia_0805;

  reg [5:0] operandoA;     // Operando A de 6 bits
  reg [5:0] complementoA;  // Complemento de dois de Operando A
  reg [5:0] resultado;     // Resultado do complemento de dois

  // Lógica para operando A (usado como exemplo)
  initial begin
    operandoA = 6'b001010; // Exemplo de operando A (ou qualquer outro valor desejado)
    
    // Calcular o complemento de dois de Operando A
    complementoA = ~operandoA + 1;

    // Imprime o operando e o complemento de dois
    $display("Operando A: %b", operandoA);
    $display("Complemento de Dois de Operando A: %b", complementoA);

    // Encerra a simulação
    $finish;
  end

endmodule
