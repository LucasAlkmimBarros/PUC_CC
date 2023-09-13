/*
 Guia_0203b.v(questao 03b)
 807205 - Lucas Alkmim Barros 
*/
module Guia_0203b;
 real x = 0; 
 reg [7:0] b = 8'b0100_1000 ; 

 initial
 begin : main
 $display ( "b = 0.%8b = 0.%x%x (16) = 0.%o%o%o (8)", b, b[7:4],b[3:0], b[7:6],b[5:3],b[2:0] );

 end // main
endmodule // Guia_0203b