/*
 Guia_0101b.v (questao 01b)
 807205 - Lucas Alkmim Barros
*/

module Guia_0101b;
integer x = 312;
 reg [7:0] b = 0;

 initial
 begin : main
 $display ( "dec = %d" , x );
 b = x;
 $display ( "bin = %8b", b );
 end // main
endmodule // Guia_0101b