/*
Guia0705
Lucas Alkmim Barros - 807205
*/
module Guia_0705;

    reg a, b, chave;
    reg sFinal;

    initial begin
        $display("a  |  b  |  chave  |  sFinal |");
        $display("----------------------------------------------");

        // Combinacoes
        for (a = 0; a < 2; a = a + 1) begin
            for (b = 0; b < 2; b = b + 1) begin
                for (chave = 0; chave < 8; chave = chave + 1) begin
                    case (chave )
                        0: sFinal = 999;
                        1: sFinal = (a & b);
                        2: sFinal = ~(a & b);
                        3: sFinal = (a | b) & ~(a & b);
                        4: sFinal = ~(a | b) & ~(a & b);
                        5: sFinal = (a | b);
                        6: sFinal = ~(a | b);
                        7: sFinal = 999;
                    endcase
                    $display("%d  |  %d  |    %d    |    %d    |", a, b, chave, sFinal);
                end
            end
        end
        $finish;
    end

endmodule

