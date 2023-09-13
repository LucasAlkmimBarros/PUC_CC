/*
 Guia_0201b.v (questao 01b)
 807205 - Lucas Alkmim Barros
*/

module Guia_0201b;
real x = 1;
real potencias2 = 1.0;
reg [7:0] b = 8'b11001000;
integer contador = 7; 


initial
begin : main
$display ( "num = %f,%8b" , x , b);

while(contador > 0)
begin
    potencias2 = potencias2 / 2.0;
    if (b[contador] == 1)
    begin
        x = x + potencias2;
    end
    contador = contador -1;
end
$display("Valor em decimal: %f", x);





end // main
endmodule // Guia_0201b
