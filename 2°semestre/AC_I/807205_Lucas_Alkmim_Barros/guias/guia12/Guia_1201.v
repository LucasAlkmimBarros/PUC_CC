module memoria_1x4(
    input clk,         // Sinal de clock
    input rst,         // Sinal de reset
    input r_w,         // Sinal de controle de leitura/escrita, 0 para leitura e 1 para escrita
    input [3:0] dados_entrada,  // Entrada de dados de 4 bits
    output reg [3:0] dados_saida // Saída de dados de 4 bits
);

reg [3:0] registro; // Registrador de 4 bits para armazenar os dados usando flip-flops JK


// Código para escrever na memória se r_w == 1 e clk está na borda de subida
	
always @(posedge clk or posedge rst) begin
    if (rst) begin
        registro <= 4'b0;
    end else if (r_w) begin
        registro <= dados_entrada;
    end
end


// Código para ler da memória se r_w == 0 e clk está na borda de descida

always @(negedge clk) begin
    if (!r_w) begin
        dados_saida <= registro; // Extrair dados da memória
    end
    else begin
        dados_saida <= 4'bx;
    end	
end

endmodule

module memoria_1x4_tb; 

    // Declaração de sinais para conectar ao módulo de memória.
    reg clk;
    reg rst;
    reg r_w;
    reg [3:0] dados_entrada;
    wire [3:0] dados_saida;
	
    memoria_1x4 uut ( 
        .clk(clk),
        .rst(rst),
        .r_w(r_w),
        .dados_entrada(dados_entrada),
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
        rst = 1; r_w = 0; dados_entrada = 4'b0;
        #10; // Aguarda por 10ns.

        rst = 0; // Tira o reset.
        r_w = 1; // Define o modo para escrita.
        dados_entrada = 4'b1010; // Valor a ser escrito na memória.
        #10; // Aguarda um ciclo de clock.

        r_w = 0; // Muda para o modo de leitura.
        #10; // Aguarda um ciclo de clock.

        r_w = 1;
        dados_entrada = 4'b1111;
        #10;

        r_w = 0;
        #10;
        
        // Finaliza a simulação.
        $finish;
    end

    // Adicionar aqui monitoramento de sinais, se necessário.
    initial begin
        $monitor("No tempo %t, dados_saida = %b", $time, dados_saida);
    end

endmodule
