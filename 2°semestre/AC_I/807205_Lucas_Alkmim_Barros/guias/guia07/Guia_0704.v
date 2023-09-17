/*
Guia0704
Lucas Alkmim Barros - 807205
*/
module Guia_0704;

    reg a, b, chave1, chave2, s1, s2, s3, s4, sFinal;

    initial begin
        $display("a  |  b  |  chave1  |  chave2  |  s1  |  s2  |  sFinal |");
        $display("--------------------------------------------------------");

        // Combinação 1
        a = 0;
        b = 0;
        chave1 = 0;
        chave2 = 0;
        s1 = (a | b) & ~(a & b);
        s2 = ~(a & b);    
        s3 = (a | b);     
        s4 = ~(a | b);    
        sFinal = s1;      //XOR
        $display("%d  |  %d  |    %d    |    %d      |  %d   |  %d   |    %d    |", a, b, chave1, chave2, s1, s2, sFinal);

        // Combinação 2
        a = 0;
        b = 0;
        chave1 = 0;
        chave2 = 1;
        s1 = (a | b) & ~(a & b);
        s2 = ~((a | b) & ~(a & b));    
        s3 = (a | b);     
        s4 = ~(a | b);    
        sFinal = s2;      //XNOR
        $display("%d  |  %d  |    %d    |    %d      |  %d   |  %d   |    %d    |", a, b, chave1, chave2, s1, s2, sFinal);

        // Combinação 3
        a = 0;
        b = 0;
        chave1 = 1;
        chave2 = 0;
        s1 = (a | b) & ~(a & b);
        s2 = ~((a | b) & ~(a & b));    
        s3 = (a | b);     
        s4 = ~(a | b);    
        sFinal = s3;      //OR
        $display("%d  |  %d  |    %d    |    %d      |  %d   |  %d   |    %d    |", a, b, chave1, chave2, s1, s2, sFinal);

        // Combinação 4
        a = 0;
        b = 0;
        chave1 = 1;
        chave2 = 1;
        s1 = (a | b) & ~(a & b);
        s2 = ~((a | b) & ~(a & b));    
        s3 = (a | b);     
        s4 = ~(a | b);    
        sFinal = s4;      //NOR
        $display("%d  |  %d  |    %d    |    %d      |  %d   |  %d   |    %d    |", a, b, chave1, chave2, s1, s2, sFinal);

        // Combinação 5
        a = 0;
        b = 1;
        chave1 = 0;
        chave2 = 0;
        s1 = (a | b) & ~(a & b);
        s2 = ~((a | b) & ~(a & b));    
        s3 = (a | b);     
        s4 = ~(a | b);    
        sFinal = s1;      //XOR
        $display("%d  |  %d  |    %d    |    %d      |  %d   |  %d   |    %d    |", a, b, chave1, chave2, s1, s2, sFinal);

        // Combinação 6
        a = 0;
        b = 1;
        chave1 = 0;
        chave2 = 1;
        s1 = (a | b) & ~(a & b);
        s2 = ~((a | b) & ~(a & b));    
        s3 = (a | b);     
        s4 = ~(a | b);    
        sFinal = s2;      //XNOR
        $display("%d  |  %d  |    %d    |    %d      |  %d   |  %d   |    %d    |", a, b, chave1, chave2, s1, s2, sFinal);

        // Combinação 7
        a = 0;
        b = 1;
        chave1 = 1;
        chave2 = 0;
        s1 = (a | b) & ~(a & b);
        s2 = ~((a | b) & ~(a & b));    
        s3 = (a | b);     
        s4 = ~(a | b);    
        sFinal = s3;      //OR
        $display("%d  |  %d  |    %d    |    %d      |  %d   |  %d   |    %d    |", a, b, chave1, chave2, s1, s2, sFinal);

        // Combinação 8
        a = 0;
        b = 1;
        chave1 = 1;
        chave2 = 1;
        s1 = (a | b) & ~(a & b);
        s2 = ~((a | b) & ~(a & b));    
        s3 = (a | b);     
        s4 = ~(a | b);    
        sFinal = s4;      //NOR
        $display("%d  |  %d  |    %d    |    %d      |  %d   |  %d   |    %d    |", a, b, chave1, chave2, s1, s2, sFinal);

        // Combinação 9
        a = 1;
        b = 0;
        chave1 = 0;
        chave2 = 0;
        s1 = (a | b) & ~(a & b);
        s2 = ~((a | b) & ~(a & b));    
        s3 = (a | b);     
        s4 = ~(a | b);    
        sFinal = s1;      //XOR
        $display("%d  |  %d  |    %d    |    %d      |  %d   |  %d   |    %d    |", a, b, chave1, chave2, s1, s2, sFinal);

        // Combinação 10
        a = 1;
        b = 0;
        chave1 = 0;
        chave2 = 1;
        s1 = (a | b) & ~(a & b);
        s2 = ~((a | b) & ~(a & b));    
        s3 = (a | b);     
        s4 = ~(a | b);    
        sFinal = s2;      //XNOR
        $display("%d  |  %d  |    %d    |    %d      |  %d   |  %d   |    %d    |", a, b, chave1, chave2, s1, s2, sFinal);

        // Combinação 11
        a = 1;
        b = 0;
        chave1 = 1;
        chave2 = 0;
        s1 = (a | b) & ~(a & b);
        s2 = ~((a | b) & ~(a & b));    
        s3 = (a | b);     
        s4 = ~(a | b);    
        sFinal = s3;      //OR
        $display("%d  |  %d  |    %d    |    %d      |  %d   |  %d   |    %d    |", a, b, chave1, chave2, s1, s2, sFinal);

        // Combinação 12
        a = 1;
        b = 0;
        chave1 = 1;
        chave2 = 1;
        s1 = (a | b) & ~(a & b);
        s2 = ~((a | b) & ~(a & b));    
        s3 = (a | b);     
        s4 = ~(a | b);    
        sFinal = s4;      //NOR
        $display("%d  |  %d  |    %d    |    %d      |  %d   |  %d   |    %d    |", a, b, chave1, chave2, s1, s2, sFinal);

        // Combinação 13
        a = 1;
        b = 1;
        chave1 = 0;
        chave2 = 0;
        s1 = (a | b) & ~(a & b);
        s2 = ~((a | b) & ~(a & b));    
        s3 = (a | b);     
        s4 = ~(a | b);    
        sFinal = s1;      //XOR
        $display("%d  |  %d  |    %d    |    %d      |  %d   |  %d   |    %d    |", a, b, chave1, chave2, s1, s2, sFinal);

        // Combinação 14
        a = 1;
        b = 1;
        chave1 = 0;
        chave2 = 1;
        s1 = (a | b) & ~(a & b);
        s2 = ~((a | b) & ~(a & b));    
        s3 = (a | b);     
        s4 = ~(a | b);    
        sFinal = s2;      //XNOR
        $display("%d  |  %d  |    %d    |    %d      |  %d   |  %d   |    %d    |", a, b, chave1, chave2, s1, s2, sFinal);

        // Combinação 15
        a = 1;
        b = 1;
        chave1 = 1;
        chave2 = 0;
        s1 = (a | b) & ~(a & b);
        s2 = ~((a | b) & ~(a & b));    
        s3 = (a | b);     
        s4 = ~(a | b);    
        sFinal = s3;      //OR
        $display("%d  |  %d  |    %d    |    %d      |  %d   |  %d   |    %d    |", a, b, chave1, chave2, s1, s2, sFinal);

        // Combinação 16
        a = 1;
        b = 1;
        chave1 = 1;
        chave2 = 1;
        s1 = (a | b) & ~(a & b);
        s2 = ~((a | b) & ~(a & b));    
        s3 = (a | b);     
        s4 = ~(a | b);    
        sFinal = s4;      //NOR
        $display("%d  |  %d  |    %d    |    %d      |  %d   |  %d   |    %d    |", a, b, chave1, chave2, s1, s2, sFinal);

        $finish;
    end
endmodule
