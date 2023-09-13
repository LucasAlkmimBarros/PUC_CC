/*
 Guia_0204b.v(questao 04b)
 807205 - Lucas Alkmim Barros 
*/
module Guia_0204b;
 real x = 0; 
 reg [7:0] b = 8'b1010_0000 ; 
 integer q [3:0];

 initial
 begin : main
 $display ( "b = 0.%8b", b );
 $display ( "b = 0.%x%x (16)", b[7:4],b[3:0] );
 q[3] = b[7:6];
 q[2] = b[5:4];
 q[1] = b[3:2];
 q[0] = b[1:0];
 $display ( "b = 0.%2b %2b %2b %2b (2)", b[7:6],b[5:4],b[3:2],b[1:0] );
 $display ( "q = 0.%2d %2d %2d %2d (4)", q[3] ,q[2] ,q[1] ,q[0] );
 end // main
endmodule // Guia_0204b