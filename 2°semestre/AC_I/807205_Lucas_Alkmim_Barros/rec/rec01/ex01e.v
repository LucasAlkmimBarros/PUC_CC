module ex01e (
    input a,
    input b,
    input c,
    input d,
    output s);

    assign s = ~(~(~(~(~(~(~(b&b)&c))) & ~(~(~(~(~(~(a&a)& b))&~(c&c)))))) & ~(~(~(~(~(a & b)) & d))));

endmodule

module test_ex01e;
    reg a, b, c, d;
    wire s;

    ex01e UUT (
        .a(a),
        .b(b),
        .c(c),
        .d(d),
        .s(s)
    );

    initial begin
        a = 0; b = 0; c = 0; d = 0;
        #10;
        $display("a = %b, b = %b, c = %b, d = %b, s = %b", a, b, c, d, s);
        a = 0; b = 0; c = 0; d = 1;
        #10;
        $display("a = %b, b = %b, c = %b, d = %b, s = %b", a, b, c, d, s);
        a = 0; b = 0; c = 1; d = 0; 
        #10;
        $display("a = %b, b = %b, c = %b, d = %b, s = %b", a, b, c, d, s);
        a = 0; b = 0; c = 1; d = 1;
        #10;
        $display("a = %b, b = %b, c = %b, d = %b, s = %b", a, b, c, d, s);
        a = 0; b = 1; c = 0; d = 0;
        #10;
        $display("a = %b, b = %b, c = %b, d = %b, s = %b", a, b, c, d, s);
        a = 0; b = 1; c = 0; d = 1;
        #10;
        $display("a = %b, b = %b, c = %b, d = %b, s = %b", a, b, c, d, s);
        a = 0; b = 1; c = 1; d = 0;
        #10;
        $display("a = %b, b = %b, c = %b, d = %b, s = %b", a, b, c, d, s);
        a = 0; b = 1; c = 1; d = 1;
        #10;
        $display("a = %b, b = %b, c = %b, d = %b, s = %b", a, b, c, d, s);
        a = 1; b = 0; c = 0; d = 0;
        #10;
        $display("a = %b, b = %b, c = %b, d = %b, s = %b", a, b, c, d, s);
        a = 1; b = 0; c = 0; d = 1;
        #10;
        $display("a = %b, b = %b, c = %b, d = %b, s = %b", a, b, c, d, s);
        a = 1; b = 0; c = 1; d = 0;
        #10;
        $display("a = %b, b = %b, c = %b, d = %b, s = %b", a, b, c, d, s);
        a = 1; b = 0; c = 1; d = 1;
        #10;
        $display("a = %b, b = %b, c = %b, d = %b, s = %b", a, b, c, d, s);
        a = 1; b = 1; c = 0; d = 0;
        #10;
        $display("a = %b, b = %b, c = %b, d = %b, s = %b", a, b, c, d, s);
        a = 1; b = 1; c = 0; d = 1;
        #10;
        $display("a = %b, b = %b, c = %b, d = %b, s = %b", a, b, c, d, s);
        a = 1; b = 1; c = 1; d = 0;
        #10;
        $display("a = %b, b = %b, c = %b, d = %b, s = %b", a, b, c, d, s);
        a = 1; b = 1; c = 1; d = 1;
        #10;
        $display("a = %b, b = %b, c = %b, d = %b, s = %b", a, b, c, d, s);
        $finish;
    end
endmodule
