/*
Guia0702
Lucas Alkmim Barros - 807205
*/


module Guia_0702;

    reg a, b, chave, s1, s2, sFinal;

    initial begin
        $display("a  |  b  |  chave  |  s1  |  s2  |  sFinal |");
        $display("----------------------------------------------");

        // Combinação 1
        a = 0;
        b = 0;
        chave = 0;
        s1 = (a | b);
        s2 = ~(a | b);
        sFinal = s1;
        $display("%d  |  %d  |    %d    |  %d   |  %d   |    %d    |", a, b, chave, s1, s2, sFinal);

        // Combinação 2
        a = 0;
        b = 0;
        chave = 1;
        s1 = (a | b);
        s2 = ~(a | b);
        sFinal = s2;
        $display("%d  |  %d  |    %d    |  %d   |  %d   |    %d    |", a, b, chave, s1, s2, sFinal);

        // Combinação 3
        a = 0;
        b = 1;
        chave = 0;
        s1 = (a | b);
        s2 = ~(a | b);
        sFinal = s1;
        $display("%d  |  %d  |    %d    |  %d   |  %d   |    %d    |", a, b, chave, s1, s2, sFinal);

        // Combinação 4
        a = 0;
        b = 1;
        chave = 1;
        s1 = (a | b);
        s2 = ~(a | b);
        sFinal = s2;
        $display("%d  |  %d  |    %d    |  %d   |  %d   |    %d    |", a, b, chave, s1, s2, sFinal);

        // Combinação 5
        a = 1;
        b = 0;
        chave = 0;
        s1 = (a | b);
        s2 = ~(a | b);
        sFinal = s1;
        $display("%d  |  %d  |    %d    |  %d   |  %d   |    %d    |", a, b, chave, s1, s2, sFinal);

        // Combinação 6
        a = 1;
        b = 0;
        chave = 1;
        s1 = (a | b);
        s2 = ~(a | b);
        sFinal = s2;
        $display("%d  |  %d  |    %d    |  %d   |  %d   |    %d    |", a, b, chave, s1, s2, sFinal);

        // Combinação 7
        a = 1;
        b = 1;
        chave = 0;
        s1 = (a | b);
        s2 = ~(a | b);
        sFinal = s1;
        $display("%d  |  %d  |    %d    |  %d   |  %d   |    %d    |", a, b, chave, s1, s2, sFinal);

        // Combinação 8
        a = 1;
        b = 1;
        chave = 1;
        s1 = (a | b);
        s2 = ~(a | b);
        sFinal = s2;
        $display("%d  |  %d  |    %d    |  %d   |  %d   |    %d    |", a, b, chave, s1, s2, sFinal);

        $finish;
    end
endmodule
