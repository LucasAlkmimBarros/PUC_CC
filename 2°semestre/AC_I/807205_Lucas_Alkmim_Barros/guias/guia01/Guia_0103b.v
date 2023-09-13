/*
 Guia_0103b.v (questao 03b)
 807205 - Lucas Alkmim Barros
*/

module Guia_0103b;
 integer x = 61; 
 reg [7:0] b = 0;

 initial
 begin : main
 $display ( "Decimal = %d" , x );
 b = x;
 $display ( "Binario = %b", b );
$display("Base 4 = %d%d%d%d", b[7:6], b[5:4], b[3:2], b[1:0]);
 $display ( "Hexadecimal = %x", b );
 end // main
endmodule // Guia_0103