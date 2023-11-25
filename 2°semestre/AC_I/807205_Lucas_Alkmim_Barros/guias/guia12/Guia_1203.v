module memoria_1x4(
    input clk,         // Sinal de clock
    input rst,         // Sinal de reset
    input r_w,         // Sinal de controle de leitura/escrita, 0 para leitura e 1 para escrita
    input [3:0] dados_entrada,  // Entrada de dados de 4 bits
    output reg [3:0] dados_saida // Saída de dados de 4 bits
);

reg [3:0] registrador_jk; // Registrador de 4 bits para armazenar os dados usando flip-flops JK

// Código para escrever na memória se r_w == 1 e clk está na borda de subida
always @(posedge clk or posedge rst) begin
    if (rst) begin
        registrador_jk <= 4'b0;
    end else if (r_w) begin
        registrador_jk <= dados_entrada;
    end
end

// Código para ler da memória se r_w == 0 e clk está na borda de descida
always @(negedge clk) begin
    if (!r_w) begin
        dados_saida <= registrador_jk; // Extraindo dados da memória
    end
end

endmodule

module memoria_1x8(
    input clk,
    input rst,
    input r_w,
    input [7:0] dados_entrada,
    input endereco,
    output [7:0] dados_saida
);

wire [3:0] dados_saida_menor;
wire [3:0] dados_saida_maior;

// Instancia o primeiro módulo memoria_1x4 para os LSBs
memoria_1x4 memoria_menor(
    .clk(clk),
    .rst(rst),
    .r_w(r_w),
    .dados_entrada(dados_entrada[3:0]), // Envia os 4 bits menos significativos
    .dados_saida(dados_saida_menor)
);

// Instancia o segundo módulo memoria_1x4 para os MSBs
memoria_1x4 memoria_maior(
    .clk(clk),
    .rst(rst),
    .r_w(r_w),
    .dados_entrada(dados_entrada[7:4]), // Envia os 4 bits mais significativos
    .dados_saida(dados_saida_maior)
);

// Combina as saídas dos dois módulos memoria_1x4 para formar a saída de 8 bits
assign dados_saida = {dados_saida_maior, dados_saida_menor};

endmodule

module memoria_2x8(
    input clk,
    input rst,
    input r_w,
    input endereco, // Assume que este é um endereço de 1 bit
    input [7:0] dados_entrada,
    output [7:0] dados_saida
);

wire [7:0] dados_saida0, dados_saida1;

// Instancia os dois módulos de memoria_1x8
memoria_1x8 memoria0(
    .clk(clk),
    .rst(rst),
    .r_w(r_w & ~endereco), // Habilita escrita/leitura apenas quando o endereço é 0
    .dados_entrada(dados_entrada),
    .dados_saida(dados_saida0)
);

memoria_1x8 memoria1(
    .clk(clk),
    .rst(rst),
    .r_w(r_w & endereco), // Habilita escrita/leitura apenas quando o endereço é 1
    .dados_entrada(dados_entrada),
    .dados_saida(dados_saida1)
);

// Lógica para selecionar qual saída de dados usar baseada no endereço
assign dados_saida = endereco ? dados_saida1 : dados_saida0;

endmodule

module memoria_2x8_tb; 

// Declaração de sinais para conectar ao módulo de memória.
reg clk;
reg rst;
reg r_w;
reg endereco;
reg [7:0] dados_entrada;
wire [7:0] dados_saida;

memoria_2x8 memoria0 ( 
    .clk(clk),
    .rst(rst),
    .r_w(r_w),
    .dados_entrada(dados_entrada),
    .endereco(endereco),
    .dados_saida(dados_saida)
);

// Geração do sinal de clock.
initial begin
    clk = 0;
    forever #5 clk = ~clk; 
end

// Procedimento de teste.
initial begin
    // Inicializa os sinais.
    rst = 1; r_w = 0; dados_entrada = 8'b0; endereco = 0;
    #10; // Aguarda por 10ns.

    rst = 0; // Remove o reset.
    r_w = 1; // Define o modo para escrita.
    dados_entrada = 8'b10101010; // Valor a ser escrito na memória.
    endereco = 0;
    #10; // Aguarda um ciclo de clock.

    r_w = 0; // Muda para o modo de leitura.
    #10; // Aguarda um ciclo de clock.

    r_w = 1;
    dados_entrada = 8'b11111111;
    endereco = 1;
    #10;

    r_w = 0;
    #10;

    r_w = 1;
    dados_entrada = 8'b10101010;
    #10;

    r_w = 0;
    #10;

    // Finaliza a simulação.
    $finish;
end

// Adicionar aqui monitoramento de sinais, se necessário.
initial begin
    $monitor("No tempo %t, no endereço %b, dados_saida = %b", $time, endereco, dados_saida);
end

endmodule
