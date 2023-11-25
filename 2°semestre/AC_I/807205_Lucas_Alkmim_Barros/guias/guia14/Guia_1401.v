module dff ( output q_out, output qnot_out,
	input d_in, input clk_in,
	input preset_in, input clear_in );

		reg q_reg, qnot_reg;
		always @( posedge clk_in ) begin
			if ( clear_in ) begin 
				q_reg <= 0; qnot_reg <= 1; 
			end
			else
				if ( preset_in ) begin 
					q_reg <= 1; qnot_reg <= 0; 
				end
				else begin 
					q_reg <= d_in; qnot_reg <= ~d_in; 
				end
		end
endmodule 

module left_shift ( output [5:0] number_out, input bit1_in, input load_in, input clk_in, input clr_in);

	wire ld = load_in & bit1_in;

	dff d1(number_out[0], , 1'b0,      clk_in, ld,   clr_in);
	dff d2(number_out[1], , number_out[0], clk_in, 1'b0, clr_in);
	dff d3(number_out[2], , number_out[1], clk_in, 1'b0, clr_in);
	dff d4(number_out[3], , number_out[2], clk_in, 1'b0, clr_in);
	dff d5(number_out[4], , number_out[3], clk_in, 1'b0, clr_in);
	dff d6(number_out[5], , number_out[4], clk_in, 1'b0, clr_in);
	
endmodule

module left_shift_tb;

    reg clk_tb = 0;
    reg clear_tb = 0;
    reg bit1_tb = 0;
   	reg load_tb = 0;
    wire [5:0] number_tb;

	left_shift tbu_tb (number_tb, bit1_tb, load_tb, clk_tb, clear_tb);
    
    always #5 clk_tb = ~clk_tb; 

    initial begin
        clear_tb = 1;
        #10;
        clear_tb = 0;
        bit1_tb = 1;
        load_tb = 1;
       	#10;
       	load_tb = 0;
       	#100;
                 
        $finish;   
    end

    initial begin	
        $monitor("Time = %0t, Output: %b", $time, number_tb);
    end
endmodule
