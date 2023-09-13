/*
 Guia0301b.v(questao 01b)
 807205 - Lucas Alkmim Barros 
*/

module Guia0301b;
    reg [7:0] a = 8'b000_1010;
    reg [7:0] c1, c2;

    initial
    begin
        c1 = ~a;
        c2 = ~a + 1;
        $display("a = %8b \nC1(a) = %8b \nC2(a) = %8b", a, c1, c2);        
    end
endmodule;
