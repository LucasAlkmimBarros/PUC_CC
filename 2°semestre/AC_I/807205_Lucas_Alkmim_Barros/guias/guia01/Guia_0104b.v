/*
 Guia_0104b.v (questao 04b)
 807205 - Lucas Alkmim Barros
*/

module Guia_0104b;
reg [7:0] b = 8'b00000101;

initial
begin : main
    $display("Decimal = %d", b);
    $display("Hexadecimal = %h", b);
    $display("Octal = %o", b);
    $display("Base 4 = %d%d%d%d", b[7:6], b[5:4], b[3:2], b[1:0]);
    end // main
endmodule // Guia_0104b