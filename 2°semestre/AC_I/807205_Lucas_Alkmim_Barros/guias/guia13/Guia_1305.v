module t_flip_flop (
    output q_output, output qnot_output,
    input t_input, input clk_input, input preset_input, input clear_input
);

    reg q, qnot;

    always @(posedge clk_input or ~preset_input or ~clear_input) begin
        if (~clear_input) begin 
            q <= 0;
            qnot <= 1;
        end
        else if (~preset_input) begin 
            q <= 1;
            qnot <= 0; 
        end
        else begin
            if (t_input) begin 
                q <= ~q; 
                qnot <= ~qnot; 
            end
        end
    end

    assign q_output = q;
    assign qnot_output = qnot;

endmodule // t_flip_flop

module contador_crescente_modulo9 (
    output [3:0] contador_output,
    input clk_input, input clear_input
);

    reg clr_internal = 1'b0;

    always @(posedge clk_input) begin
        if (contador_output[0] & ~contador_output[1] & ~contador_output[2] & contador_output[3]) begin
            clr_internal <= 1'b1;
        end
        else
            clr_internal <= clear_input;
    end
    
    wire and1 = contador_output[1] & contador_output[0];
    wire and2 = and1 & contador_output[2]; 

    t_flip_flop t1(contador_output[0], , 1'b1, clk_input, 1'b0, clr_internal);
    t_flip_flop t2(contador_output[1], , contador_output[0], clk_input, 1'b0, clr_internal);
    t_flip_flop t3(contador_output[2], , and1, clk_input, 1'b0, clr_internal);
    t_flip_flop t4(contador_output[3], , and2, clk_input, 1'b0, clr_internal);

endmodule

module tb;

    reg clk = 0;
    reg clear = 1;
    wire [3:0] contador;

    contador_crescente_modulo9 tb0 (contador, clk, clear);

    always #5 clk = ~clk;

    initial begin
        #10;
        clear = 0;
        #250;
        $finish;
    end
    
    initial begin
        $monitor("Time = %0t, contador = %b", $time, contador);
    end

endmodule
