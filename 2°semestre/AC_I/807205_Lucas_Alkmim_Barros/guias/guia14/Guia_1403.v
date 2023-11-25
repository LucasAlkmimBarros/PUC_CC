module flip_flop (
    output q_output, output qnot_output,
    input d_input, input clk_input,
    input preset_input, input clear_input
);

    reg q, qnot;

    always @(posedge clk_input) begin
        if (clear_input) begin 
            q <= 0; qnot <= 1; 
        end
        else if (preset_input) begin 
            q <= 1; qnot <= 0; 
        end
        else begin 
            q <= d_input; qnot <= ~d_input; 
        end
    end

    assign q_output = q;
    assign qnot_output = qnot;

endmodule // flip_flop

module right_shift_ring (
    output [5:0] shifted_number,
    input data_input, input load_input,
    input clk_input, input clr_input
);

    flip_flop ff0 (shifted_number[0], , shifted_number[5], clk_input, 1'b0, clr_input);
    flip_flop ff1 (shifted_number[1], , shifted_number[0], clk_input, 1'b0, clr_input);
    flip_flop ff2 (shifted_number[2], , shifted_number[1], clk_input, 1'b0, clr_input);
    flip_flop ff3 (shifted_number[3], , shifted_number[2], clk_input, 1'b0, clr_input);
    flip_flop ff4 (shifted_number[4], , shifted_number[3], clk_input, 1'b0, clr_input);
    flip_flop ff5 (shifted_number[5], , load_input ? data_input : shifted_number[4], clk_input, 1'b0, clr_input);

endmodule // right_shift_ring

module right_shift_tb;

    reg clk = 0;
    reg clear = 0;
    reg load = 0;
    reg data_input = 0;
    wire [5:0] shifted_number;

    right_shift_ring testbench_unit (shifted_number, data_input, load, clk, clear);
    
    always #5 clk = ~clk; 

    // Test sequence
    initial begin
        // Reset sequence
        #5;
        clear = 1;
        #10;
        clear = 0;
        load = 1;
        data_input = 1;
        #5;
        load = 0;
        #170;                 
        $finish;   
    end

    // Monitor changes and display them
    initial begin	
        $monitor("Time = %0t, Output: %b", $time, shifted_number);
    end

endmodule
