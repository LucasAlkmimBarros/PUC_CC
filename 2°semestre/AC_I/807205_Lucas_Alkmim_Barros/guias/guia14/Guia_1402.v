module flip_flop (output q, output qnot,
                  input d, input clk,
                  input preset, input clear);

    reg q_output, qnot_output;

    always @(posedge clk) begin
        if (clear) begin 
            q_output <= 0; qnot_output <= 1; 
        end
        else if (preset) begin 
            q_output <= 1; qnot_output <= 0; 
        end
        else begin 
            q_output <= d; qnot_output <= ~d; 
        end
    end

    assign q = q_output;
    assign qnot = qnot_output;

endmodule // flip_flop

module left_shift_fulldata (output [5:0] shifted_number, input [5:0] data_input, input load, input clk, input clr);

    reg [5:0] data_reg;

    always @(posedge clk) begin
        if (load) begin
            data_reg = data_input;
        end
        else begin
            data_reg = 6'b0;
        end
    end

    flip_flop d1(shifted_number[0], , 1'b0, clk, data_reg[0], clr);
    flip_flop d2(shifted_number[1], , shifted_number[0], clk, data_reg[1], clr);
    flip_flop d3(shifted_number[2], , shifted_number[1], clk, data_reg[2], clr);
    flip_flop d4(shifted_number[3], , shifted_number[2], clk, data_reg[3], clr);
    flip_flop d5(shifted_number[4], , shifted_number[3], clk, data_reg[4], clr);
    flip_flop d6(shifted_number[5], , shifted_number[4], clk, data_reg[5], clr);

endmodule // left_shift

module left_shift_tb;

    reg clk = 0;
    reg clr = 0;
    reg load = 0;
    reg [5:0] data;
    wire [5:0] shifted_number;

    left_shift_fulldata tb_unit(shifted_number, data, load, clk, clr);

    always #5 clk = ~clk; 

    // Test sequence
    initial begin
        // Reset sequence
        #5;
        clr = 1;
        #10;
        clr = 0;
        load = 1;
        data = 6'b010101;
        #5;
        load = 0;
        #100;                 
        $finish;   
    end

    // Monitor changes and display them
    initial begin	
        $monitor("Time = %0t, Output: %b", $time, shifted_number);
    end

endmodule
