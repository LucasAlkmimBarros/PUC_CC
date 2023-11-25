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

module contador_5bits_decrescente(
    output [4:0] count_output,
    input clk_input, input clear_input
);

    jk_flip_flop jk1(count_output[0], , 1'b1, 1'b1, clk_input, 1'b0, clear_input);
    jk_flip_flop jk2(count_output[1], , 1'b1, 1'b1, count_output[0], 1'b0, clear_input);
    jk_flip_flop jk3(count_output[2], , 1'b1, 1'b1, count_output[1], 1'b0, clear_input);
    jk_flip_flop jk4(count_output[3], , 1'b1, 1'b1, count_output[2], 1'b0, clear_input);
    jk_flip_flop jk5(count_output[4], , 1'b1, 1'b1, count_output[3], 1'b0, clear_input);
  
endmodule

module contador_5bit_decrescente_tb;
    reg clk = 0;
    reg clear = 0;
    wire [4:0] contador;

    contador_5bits_decrescente uut (contador, clk, clear);
    
    always #5 clk = ~clk; 

    // Test sequence
    initial begin
        // Reset sequence
        clear = 1;  
        #10;        
        clear = 0;  
        #325;       

        $finish;   
    end

    // Monitor changes and display them
    initial begin	
        $monitor("Time = %0t, Contador: %b", $time, contador);
    end
endmodule
