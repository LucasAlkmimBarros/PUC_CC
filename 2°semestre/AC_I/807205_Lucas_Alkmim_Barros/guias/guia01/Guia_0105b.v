/*
 Guia_0105b.v (questao 05b)
 807205 - Lucas Alkmim Barros
*/

module Guia_0105b;
// define data
reg [0:8][7:0] s = "PUC-Minas";

// actions
initial
begin : main
    $display("s = %s", s);

    for (integer i = 0; i < 9; i++)
    begin
        $display("Hexadecimal de '%c' = %h", s[i], s[i]);
    end
end // main

endmodule // Guia_0105b
