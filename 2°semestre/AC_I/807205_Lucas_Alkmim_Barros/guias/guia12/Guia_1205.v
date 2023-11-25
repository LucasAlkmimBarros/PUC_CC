module memoria_1x4(
    input clk,
    input rst,
    input r_w,
    input [3:0] dados_entrada,
    output reg [3:0] dados_saida
);

reg [3:0] registro_jk;

always @(posedge clk or posedge rst) begin
    if (rst) begin
        registro_jk <= 4'b0;
    end else if (r_w) begin
        registro_jk <= dados_entrada;
    end
end

always @(negedge clk) begin
    if (!r_w) begin
        dados_saida <= registro_jk;
    end
end

endmodule

module memoria_1x8(
    input clk,
    input rst,
    input r_w,
    input [7:0] dados_entrada,
    input enderecos,
    output [7:0] dados_saida
);

    wire [3:0] dados_saida_menor;
    wire [3:0] dados_saida_maior;

    memoria_1x4 memoria_menor(
        .clk(clk),
        .rst(rst),
        .r_w(r_w),
        .dados_entrada(dados_entrada[3:0]),
        .dados_saida(dados_saida_menor)
    );

    memoria_1x4 memoria_maior(
        .clk(clk),
        .rst(rst),
        .r_w(r_w),
        .dados_entrada(dados_entrada[7:4]),
        .dados_saida(dados_saida_maior)
    );

    assign dados_saida = {dados_saida_maior, dados_saida_menor};

endmodule

module memoria_8x8(
    input clk,
    input rst,
    input r_w,
    input [2:0] enderecos,
    input [7:0] dados_entrada,
    output [7:0] dados_saida
);

    wire [7:0] dados_saida0, dados_saida1, dados_saida2, dados_saida3, dados_saida4, dados_saida5, dados_saida6, dados_saida7;
    wire habilitar0, habilitar1, habilitar2, habilitar3, habilitar4, habilitar5, habilitar6, habilitar7;

    assign habilitar0 = (enderecos == 3'b000) & r_w;
    assign habilitar1 = (enderecos == 3'b001) & r_w;
    assign habilitar2 = (enderecos == 3'b010) & r_w;
    assign habilitar3 = (enderecos == 3'b011) & r_w;
    assign habilitar4 = (enderecos == 3'b100) & r_w;
    assign habilitar5 = (enderecos == 3'b101) & r_w;
    assign habilitar6 = (enderecos == 3'b110) & r_w;
    assign habilitar7 = (enderecos == 3'b111) & r_w;

    memoria_1x8 memoria000(
        .clk(clk),
        .rst(rst),
        .r_w(habilitar0),
        .dados_entrada(dados_entrada),
        .dados_saida(dados_saida0)
    );

    memoria_1x8 memoria001(
        .clk(clk),
        .rst(rst),
        .r_w(habilitar1),
        .dados_entrada(dados_entrada),
        .dados_saida(dados_saida1)
    );

    memoria_1x8 memoria010(
        .clk(clk),
        .rst(rst),
        .r_w(habilitar2),
        .dados_entrada(dados_entrada),
        .dados_saida(dados_saida2)
    );

    memoria_1x8 memoria011(
        .clk(clk),
        .rst(rst),
        .r_w(habilitar3),
        .dados_entrada(dados_entrada),
        .dados_saida(dados_saida3)
    );

    memoria_1x8 memoria100(
        .clk(clk),
        .rst(rst),
        .r_w(habilitar4),
        .dados_entrada(dados_entrada),
        .dados_saida(dados_saida4)
    );

    memoria_1x8 memoria101(
        .clk(clk),
        .rst(rst),
        .r_w(habilitar5),
        .dados_entrada(dados_entrada),
        .dados_saida(dados_saida5)
    );

    memoria_1x8 memoria110(
        .clk(clk),
        .rst(rst),
        .r_w(habilitar6),
        .dados_entrada(dados_entrada),
        .dados_saida(dados_saida6)
    );

    memoria_1x8 memoria111(
        .clk(clk),
        .rst(rst),
        .r_w(habilitar7),
        .dados_entrada(dados_entrada),
        .dados_saida(dados_saida7)
    );

    assign dados_saida = (enderecos == 3'b000) ? dados_saida0 :
                      (enderecos == 3'b001) ? dados_saida1 :
                      (enderecos == 3'b010) ? dados_saida2 :
					  (enderecos == 3'b011) ? dados_saida3 :
                      (enderecos == 3'b100) ? dados_saida4 :
					  (enderecos == 3'b101) ? dados_saida5 :
					  (enderecos == 3'b110) ? dados_saida6 :
					  dados_saida7;
endmodule

module memoria_8x8_tb; 

reg clk;
reg rst;
reg r_w;
reg [2:0] enderecos;
reg [7:0] dados_entrada;
wire [7:0] dados_saida;
	
memoria_8x8 teste ( 
    .clk(clk),
    .rst(rst),
    .r_w(r_w),
    .dados_entrada(dados_entrada),
    .enderecos(enderecos),
    .dados_saida(dados_saida)
);

initial begin
    clk = 0;
    forever #5 clk = ~clk; 
end

initial begin
    rst = 1; r_w = 0; dados_entrada = 8'b0; enderecos = 3'b0;
    #10;

    rst = 0;
    r_w = 1;
    dados_entrada = 8'b10101010;
    enderecos = 3'b0;
    #10;

    r_w = 0;
    #10;

    r_w = 1;
    dados_entrada = 8'b11111111;
    enderecos = 3'b001;
    #10;

    r_w = 0;
    #10;

    r_w = 1;
    dados_entrada = 8'b10101010;
    enderecos = 3'b010;
    #10;

    r_w = 0;
    #10;

    r_w = 1;
    dados_entrada = 8'b00000001;
    enderecos = 3'b011;
    #10;

    r_w = 0;
    #10;

    r_w = 1;
    dados_entrada = 8'b10010001;
    enderecos = 3'b100;
    #10;

    r_w = 0;
    #10;

    r_w = 1;
    dados_entrada = 8'b00001111;
    enderecos = 3'b101;
    #10;

    r_w = 0;
    #10;

    r_w = 1;
    dados_entrada = 8'b00101001;
    enderecos = 3'b110;
    #10;

    r_w = 0;
    #10;

    r_w = 1;
    dados_entrada = 8'b10110001;
    enderecos = 3'b111;
    #10;

    r_w = 0;
    #10;

    $finish;
end

initial begin
    $monitor("No tempo %t, no endereço %b, dados_saida = %b", $time, enderecos, dados_saida);
end

endmodule
