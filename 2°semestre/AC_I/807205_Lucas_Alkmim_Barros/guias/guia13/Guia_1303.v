module jk_flip_flop (
    output q_output, output qnot_output,
    input j_input, input k_input,
    input clk_input, input preset_input, input clear_input
);

    reg q, qnot;

    always @(posedge clk_input or posedge preset_input or posedge clear_input) begin
        if (clear_input) begin 
            q <= 0; qnot <= 1; 
        end
        else if (preset_input) begin 
            q <= 1; qnot <= 0; 
        end
        else if (j_input & ~k_input) begin 
            q <= 1; qnot <= 0; 
        end
        else if (~j_input & k_input) begin 
            q <= 0; qnot <= 1; 
        end
        else if (j_input & k_input) begin 
            q <= ~q; qnot <= ~qnot; 
        end
    end

    assign q_output = q;
    assign qnot_output = qnot;

endmodule // jk_flip_flop

module contador_decadico_crescente_4bit (
    output [3:0] count_output,
    input clk_input, input clear_input
);

    reg clr;

    always @(posedge clk_input) begin
        if (count_output[0] & ~count_output[1] & ~count_output[2] & count_output[3]) begin
            clr = 1;
        end
        else
            clr = clear_input;
    end

    jk_flip_flop jk1(count_output[0], , 1'b1, 1'b1, clk_input, 1'b0, clr);
    jk_flip_flop jk2(count_output[1], , 1'b1, 1'b1, ~count_output[0], 1'b0, clr);
    jk_flip_flop jk3(count_output[2], , 1'b1, 1'b1, ~count_output[1], 1'b0, clr);
    jk_flip_flop jk4(count_output[3], , 1'b1, 1'b1, ~count_output[2], 1'b0, clr);

endmodule

module contador_4bit_crescente_decadico_tb;
    reg clk = 0;
    reg clear = 0;
    wire [3:0] contador;

    contador_decadico_crescente_4bit uut (contador, clk, clear);
   
    always #5 clk = ~clk; 

    // Test sequence
    initial begin
    
        // Reset sequence
        clear = 1;  
        #10;        
        clear = 0;  
        #295;       

        $finish;   
    end

    initial begin	
        $monitor("Time = %0t, Contador: %b", $time, contador);
    end
endmodule
