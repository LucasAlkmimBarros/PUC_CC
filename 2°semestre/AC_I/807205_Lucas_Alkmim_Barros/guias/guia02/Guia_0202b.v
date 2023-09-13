/*
 Guia_0202b.v (questao 02b)
 807205 - Lucas Alkmim Barros
*/

module Guia_0202b;
real x = 0.875;
reg [7:0] b = 0;
integer contador = 7;


initial
begin : main
while(x > 0 && contador >= 0)
begin
    if (x*2 >= 1.0)
    begin
        b[contador] = 1;
        x = x*2.0 - 1.0;
    end
    else
    begin
        b[contador] = 0;
        x = x * 2.0;
    end
    contador = contador - 1;
end 

$display("Valor em binario: %8b", b);






end // main
endmodule // Guia_0202b