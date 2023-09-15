/*
Aluno: Lucas Alkmim Barros
Matricula: 807205
Matéria: Arquitetura de Computadores-1
Guia_0507
*/

module Guia_0701 (
  input wire A,
  input wire B,
  input wire Sel,
  output wire Out_AND,
  output wire Out_NAND
);

  wire AND_enable; // Variável para controlar a operação

  assign AND_enable = (Sel) ? 1'b0 : 1'b1;

  assign Out_AND = (AND_enable) ? (A & B) : 1'b0;
  assign Out_NAND = (AND_enable) ? 1'b0 : ~(A & B);

  // Remova o bloco initial do módulo principal

endmodule
    
module testbench;
  // Crie um testbench separado para testar o módulo

  reg A;
  reg B;
  reg Sel;
  wire Out_AND;
  wire Out_NAND;

  // Instancie o módulo Guia_0701
  Guia_0701 UUT (
    .A(A),
    .B(B),
    .Sel(Sel),
    .Out_AND(Out_AND),
    .Out_NAND(Out_NAND)
  );

  initial begin
    // Configure os valores das entradas
    A = 1'b0;
    B = 1'b1;
    Sel = 1'b1;

    // Teste com operação AND ativada
    #10;  // Aguarde 10 unidades de tempo
    $display("Resultado AND: %b, Resultado NAND: %b", Out_AND, Out_NAND);

    // Teste com operação NAND ativada
    Sel = 1'b0;
    #10;  // Aguarde 10 unidades de tempo
    $display("Resultado AND: %b, Resultado NAND: %b", Out_AND, Out_NAND);

    // Encerre a simulação
    $finish;
  end
endmodule

