//LUCAS ALKMIM BARROS - 807205           (x' z') (x' y')

module Q5;

    reg x, y, z, s1, s2, s3;
  
  initial begin
    $display("x  |  y  |  z  |  output1  |  output2  |  (x'z')(x'y')  |");
    $display("------------------------------------");
    x = 0; y = 0; z = 0;
    s1 = (!x & !z);
    s2 = (!x & !y);
    s3 = (!x & !z) & (!x & !y);
    $display("%d  |  %d  |  %d  |     %d     |     %d     |       %d       |", x, y, z, s1, s2, s3);
    x = 0; y = 0; z = 1;
    s1 = (!x & !z);
    s2 = (!x & !y);
    s3 = (!x & !z) & (!x & !y);
    $display("%d  |  %d  |  %d  |     %d     |     %d     |       %d       |", x, y, z, s1, s2, s3);
    x = 0; y = 1; z = 0;
    s1 = (!x & !z);
    s2 = (!x & !y);
    s3 = (!x & !z) & (!x & !y);
    $display("%d  |  %d  |  %d  |     %d     |     %d     |       %d       |", x, y, z, s1, s2, s3);
    x = 0; y = 1; z = 1;
    s1 = (!x & !z);
    s2 = (!x & !y);
    s3 = (!x & !z) & (!x & !y);
    $display("%d  |  %d  |  %d  |     %d     |     %d     |       %d       |", x, y, z, s1, s2, s3);
    x = 1; y = 0; z = 0;
    s1 = (!x & !z);
    s2 = (!x & !y);
    s3 = (!x & !z) & (!x & !y);
    $display("%d  |  %d  |  %d  |     %d     |     %d     |       %d       |", x, y, z, s1, s2, s3);
    x = 1; y = 0; z = 1;
    s1 = (!x & !z);
    s2 = (!x & !y);
    s3 = (!x & !z) & (!x & !y);
    $display("%d  |  %d  |  %d  |     %d     |     %d     |       %d       |", x, y, z, s1, s2, s3);
    x = 1; y = 1; z = 0;
    s1 = (!x & !z);
    s2 = (!x & !y);
    s3 = (!x & !z) & (!x & !y);
    $display("%d  |  %d  |  %d  |     %d     |     %d     |       %d       |", x, y, z, s1, s2, s3);
    x = 1; y = 1; z = 1;
    s1 = (!x & !z);
    s2 = (!x & !y);
    s3 = (!x & !z) & (!x & !y);
    $display("%d  |  %d  |  %d  |     %d     |     %d     |       %d       |", x, y, z, s1, s2, s3);

    
    $finish;
  end

endmodule

