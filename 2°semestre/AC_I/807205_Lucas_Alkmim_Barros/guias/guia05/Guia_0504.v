/*
 Guia_0504.v(questao 04)
 807205 - Lucas Alkmim Barros 
*/

module f9 (output s, input a, input b);

    // Implementacao da porta NAND
    assign s = ~(~a & b);


endmodule // f9

module test_f9;
  // Definir dados
  reg a;
  reg b;
  wire s;

  // Instanciar o módulo f9
  f9 moduloF9 (s, ~a, b);

  // Parte principal
  initial begin
    $display("Testando modulo: ");
    $display(" a b s");

    // Projetar testes do módulo
    $monitor("%b %b %b", a, b, s);

    // Testar todas as combinações de a e b
    a = 1'b0; b = 1'b0;
    #1;
    a = 1'b0; b = 1'b1;
    #1; 
    a = 1'b1; b = 1'b0;
    #1;
    a = 1'b1; b = 1'b1;
    #1;
        
    $finish; // Terminar a simulação
  end
endmodule // test_f9