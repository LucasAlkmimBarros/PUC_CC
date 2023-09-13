/*
 Guia_0205b.v(questao 05b)
 807205 - Lucas Alkmim Barros 
*/

module Guia_0205b;
 reg [7:0] num1 = 8'b000_1010 ; 
 reg [7:0] num2 = 8'b000_1100 ; 
 reg [7:0] resp;

 initial
 begin : main
 $display ( "num1 = %8b", num1 );
 $display ( "num2 = %8b", num2);
 resp = num1+num2;
 $display ( "resp = num1+num2 = %8b", resp );
 resp = num1-num2;
 $display ( "resp = num1-num2 = %8b", resp );
 resp = num2-num1;
 $display ( "resp = num2-num1 = %8b", resp );
 resp = num1*num2;
 $display ( "resp = num1*num2 = %8b", resp );
 resp = num2/num1;
 $display ( "resp = num2/num1 = %8b", resp );
 resp = num2%num1;
 $display ( "resp = num2%%num1 = %8b", resp );
 end // main
endmodule // Guia_0205b