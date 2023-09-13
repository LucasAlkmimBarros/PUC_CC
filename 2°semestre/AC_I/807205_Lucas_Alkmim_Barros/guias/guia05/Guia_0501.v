/*
 Guia_0501.v(questao 01)
 807205 - Lucas Alkmim Barros 
*/

module f6 (output s, input a, input b);


    // Implementacao da porta NOR
    assign s = (~a & ~b);


endmodule // f6

module test_f6;
  // Definir dados
  reg a;
  reg b;
  wire s;

  // Instanciar o módulo f6
  f6 moduloF6 (s, a, b);

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
endmodule // test_f6

