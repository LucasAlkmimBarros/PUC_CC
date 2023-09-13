/*
 Guia0303b.v(questao 03b)
 807205 - Lucas Alkmim Barros 
*/

module Guia0303b;
    reg [7:0] a = 8'b1001_0001;
    reg [7:0] b = 8'b0000_0000;
    reg [7:0] c = 8'b0000_0000;
    reg [7:0] hex = 8'h00 ; 



    initial
    begin
        b = a - 1;
        c = ~b;
        $display("a = %8b \nb = %8b \nc = %8b = %8h(16)", a, b, c, c);
    end
endmodule;