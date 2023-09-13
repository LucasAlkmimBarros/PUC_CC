/*
 Guia0302b.v(questao 02b)
 807205 - Lucas Alkmim Barros 
*/

module Guia0302b;
    reg [5:0] dec = 13;
    reg [6:0] oct = 8'o15 ; 
    reg [7:0] hex = 8'h0a ; 

    reg [7:0] binHex = 8'b000_0000;
    reg [6:0] binOct = 8'b000_0000;
    reg [5:0] binDec = 8'b000_0000;

    reg [7:0] c1, c2;

    initial
    begin
        binHex = ~hex + 1;
        $display("hex = %8b -> C2(hex) = %8b", hex, binHex);
        binOct = ~oct + 1;
        $display("oct = %7b -> C2(oct) = %7b", oct, binOct);
        binDec = ~dec + 1;
        binDec = 4'b0011;
        $display("dec = %6b -> C2(dec) = %6b", dec, binDec);

        
    end
endmodule;