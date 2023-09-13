/*
 Guia0305b.v(questao 05b)
 807205 - Lucas Alkmim Barros 
*/

module Guia0305b;
    reg signed [7:0] num1;
    reg signed [7:0] num2;
    reg signed [7:0] resultado;
    reg [7:0] binResultado;
    
    initial begin
        num1 = 8'b101011;
        num2 = 8'b1110;
        resultado = num1 - num2;
        if (resultado < 0) begin
            binResultado = -resultado;
            binResultado = ~binResultado + 1;
            binResultado = {1'b1, binResultado};
        end else begin
            binResultado = resultado;
        end
        $display("%b - %b = %b", num1, num2, binResultado);

    end
endmodule;