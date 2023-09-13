/*
 Guia0304b.v(questao 04b)
 807205 - Lucas Alkmim Barros 
*/

module Guia0304b;
    reg signed [7:0] num1 = 8'b1011_0011; 
    reg signed [6:0] num2 = 8'b1101_111 ; 
    reg signed [5:0] num3 = 8'b0101_11 ; 
    reg signed [7:0] resultado = 0 ; 

    initial
    begin
    $display ( "num1 = %8b = %d", num1, num1 );
    $display ( "num2 = %8b = %d", num2, num2 );
    $display ( "num3 = %8b = %d", num3, num3 );
    resultado = num1-num2;
    $display ( "num1-num2 = %8b-%8b = %8b = %d", num1, num2, resultado, resultado );
    resultado = num2-num1;
    $display ( "num2-num1 = %8b-%8b = %8b = %d", num2, num1, resultado, resultado );
    resultado = num1-num3;
    $display ( "num1-num3 = %8b-%8b = %8b = %d", num1, num3, resultado, resultado );
    resultado = num3-num1;
    $display ( "num3-num1 = %8b-%8b = %8b = %d", num3, num1, resultado, resultado );

    end
endmodule;