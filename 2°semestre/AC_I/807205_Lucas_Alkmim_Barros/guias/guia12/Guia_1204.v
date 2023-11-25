module memoria_1x4(
    input clk,
    input rst,
    input r_w,
    input [3:0] dados_entrada,
    output reg [3:0] dados_saida
);

reg [3:0] registrador_jk;

always @(posedge clk or posedge rst) begin
    if (rst) begin
        registrador_jk <= 4'b0;
    end else if (r_w) begin
        registrador_jk <= dados_entrada;
    end
end

always @(negedge clk) begin
    if (!r_w) begin
        dados_saida <= registrador_jk;
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

module memoria_4x8(
    input clk,
    input rst,
    input r_w,
    input [1:0] enderecos,
    input [7:0] dados_entrada,
    output [7:0] dados_saida
);

    wire [7:0] dados_saida0, dados_saida1, dados_saida2, dados_saida3;
    wire habilitar0, habilitar1, habilitar2, habilitar3;

    assign habilitar0 = (enderecos == 2'b00) & r_w;
    assign habilitar1 = (enderecos == 2'b01) & r_w;
    assign habilitar2 = (enderecos == 2'b10) & r_w;
    assign habilitar3 = (enderecos == 2'b11) & r_w;

    memoria_1x8 memoria00(
        .clk(clk),
        .rst(rst),
        .r_w(habilitar0),
        .dados_entrada(dados_entrada),
        .dados_saida(dados_saida0)
    );

    memoria_1x8 memoria01(
        .clk(clk),
        .rst(rst),
        .r_w(habilitar1),
        .dados_entrada(dados_entrada),
        .dados_saida(dados_saida1)
    );

    memoria_1x8 memoria10(
        .clk(clk),
        .rst(rst),
        .r_w(habilitar2),
        .dados_entrada(dados_entrada),
        .dados_saida(dados_saida2)
    );

    memoria_1x8 memoria11(
        .clk(clk),
        .rst(rst),
        .r_w(habilitar3),
        .dados_entrada(dados_entrada),
        .dados_saida(dados_saida3)
    );

    assign dados_saida = (enderecos == 2'b00) ? dados_saida0 :
                      (enderecos == 2'b01) ? dados_saida1 :
                      (enderecos == 2'b10) ? dados_saida2 :
                      dados_saida3;

endmodule

module memoria_4x8_tb; 

reg clk;
reg rst;
reg r_w;
reg [1:0] enderecos;
reg [7:0] dados_entrada;
wire [7:0] dados_saida;
	
memoria_4x8 teste ( 
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
    rst = 1; r_w = 0; dados_entrada = 8'b0; enderecos = 2'b0;
    #10;

    rst = 0;
    r_w = 1;
    dados_entrada = 8'b10101010;
    enderecos = 2'b0;
    #10;

    r_w = 0;
    #10;

    r_w = 1;
    dados_entrada = 8'b11111111;
    enderecos = 2'b01;
    #10;

    r_w = 0;
    #10;

    r_w = 1;
    dados_entrada = 8'b10101010;
    enderecos = 2'b10;
    #10;

    r_w = 0;
    #10;

    r_w = 1;
    dados_entrada = 8'b00000001;
    enderecos = 2'b11;
    #10;

    r_w = 0;
    #10;

    $finish;
end

initial begin
    $monitor("No tempo %t, no endereço %b, dados_saida = %b", $time, enderecos, dados_saida);
end

endmodule
