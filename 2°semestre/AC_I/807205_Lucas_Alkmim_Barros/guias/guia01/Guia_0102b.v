/*
 Guia_0102b.v (questao 02b)
 807205 - Lucas Alkmim Barros
*/

module Guia_0102b;
 integer x = 0; 
 reg [7:0] b = 8'b0110111;

 initial
 begin : main

 $display ( "bin = %8b", b );
 x = b;
 $display ( "dec = %d", x );
 end // main
endmodule // Guia_0102b