/*
 Guia_0503.v(questao 03)
 807205 - Lucas Alkmim Barros 
*/

module f8 (output s, input a, input b);


    // Implementacao da porta NOR
    assign s = (~a | ~b) & ~(a | b);


endmodule // f8

module test_f8;
  // Definir dados
  reg a;
  reg b;
  wire s;

  // Instanciar o módulo f8
  f8 moduloF8 (s, a, b);

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
endmodule // test_f8