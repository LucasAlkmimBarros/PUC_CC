module memoria_1x4(
    input clk,
    input rst,
    input leitura_escrita,
    input [3:0] dados_entrada,
    output reg [3:0] dados_saida
);

reg [3:0] registro;

always @(posedge clk or posedge rst) begin
    if (rst) begin
        registro <= 4'b0;
    end else if (leitura_escrita) begin
        registro <= dados_entrada;
    end
end

always @(negedge clk) begin
	if(!leitura_escrita) begin
		dados_saida <= registro;
	end
	else begin
		dados_saida <= 4'bx;
	end	
end

endmodule

module memoria_1x8(
    input clk,
    input rst,
    input leitura_escrita,
    input [7:0] dados_entrada,
    output [7:0] dados_saida
);

    wire [3:0] dados_saida_menor;
    wire [3:0] dados_saida_maior;

    memoria_1x4 memoria_menor(
        .clk(clk),
        .rst(rst),
        .leitura_escrita(leitura_escrita),
        .dados_entrada(dados_entrada[3:0]),
        .dados_saida(dados_saida_menor)
    );

    memoria_1x4 memoria_maior(
        .clk(clk),
        .rst(rst),
        .leitura_escrita(leitura_escrita),
        .dados_entrada(dados_entrada[7:4]),
        .dados_saida(dados_saida_maior)
    );

    assign dados_saida = {dados_saida_maior, dados_saida_menor};

endmodule

module memoria_1x8_tb; 

    reg clk;
    reg rst;
    reg leitura_escrita;
    reg [7:0] dados_entrada;
    wire [7:0] dados_saida;
	
    memoria_1x8 uut ( 
        .clk(clk),
        .rst(rst),
        .leitura_escrita(leitura_escrita),
        .dados_entrada(dados_entrada),
        .dados_saida(dados_saida)
    );

    initial begin
        clk = 0;
        forever #5 clk = ~clk; 
    end

    initial begin
        rst = 1; leitura_escrita = 0; dados_entrada = 8'b0;
        #10;

        rst = 0;
        leitura_escrita = 1;
        dados_entrada = 8'b10101010;
        #10;

        leitura_escrita = 0;
        #10;

        leitura_escrita = 1;
        dados_entrada = 8'b11111111;
        #10;

        leitura_escrita = 0;
        #10;
        
        $finish;
    end

    initial begin
        $monitor("No tempo %t, dados_saida = %b", $time, dados_saida);
    end

endmodule
