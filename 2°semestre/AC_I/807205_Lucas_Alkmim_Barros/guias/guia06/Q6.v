// LUCAS ALKMIM BARROS - 807205      XY' + XW' + XZ'

module Q6;

  reg X, Y, Z, W;
  reg s1;
  
  initial begin
    $display("x  |  y  |  z  |  w  | XY' + XW' + XZ'  |  ");
    $display("------------------------------------");
    X = 0; Y = 0; Z = 0; W = 0;
    s1 = (X & !Y) | (X & !W) | (X & !Z);
    $display("%d  |  %d  |  %d  |  %d  |        %d        |", X, Y, Z, W, s1);
    X = 0; Y = 0; Z = 0; W = 1;
    s1 = (X & !Y) | (X & !W) | (X & !Z);
    $display("%d  |  %d  |  %d  |  %d  |        %d        |", X, Y, Z, W, s1);
    X = 0; Y = 0; Z = 1; W = 0;
    s1 = (X & !Y) | (X & !W) | (X & !Z);
    $display("%d  |  %d  |  %d  |  %d  |        %d        |", X, Y, Z, W, s1);
    X = 0; Y = 0; Z = 1; W = 1;
    s1 = (X & !Y) | (X & !W) | (X & !Z);
    $display("%d  |  %d  |  %d  |  %d  |        %d        |", X, Y, Z, W, s1);
    X = 0; Y = 1; Z = 0; W = 0;
    s1 = (X & !Y) | (X & !W) | (X & !Z);
    $display("%d  |  %d  |  %d  |  %d  |        %d        |", X, Y, Z, W, s1);
    X = 0; Y = 1; Z = 0; W = 1;
    s1 = (X & !Y) | (X & !W) | (X & !Z);
    $display("%d  |  %d  |  %d  |  %d  |        %d        |", X, Y, Z, W, s1);
    X = 0; Y = 1; Z = 1; W = 0;
    s1 = (X & !Y) | (X & !W) | (X & !Z);
    $display("%d  |  %d  |  %d  |  %d  |        %d        |", X, Y, Z, W, s1);
    X = 0; Y = 1; Z = 1; W = 1;
    s1 = (X & !Y) | (X & !W) | (X & !Z);
    $display("%d  |  %d  |  %d  |  %d  |        %d        |", X, Y, Z, W, s1);
    X = 1; Y = 0; Z = 0; W = 0;
    s1 = (X & !Y) | (X & !W) | (X & !Z);
    $display("%d  |  %d  |  %d  |  %d  |        %d        |", X, Y, Z, W, s1);
    X = 1; Y = 0; Z = 0; W = 1;
    s1 = (X & !Y) | (X & !W) | (X & !Z);
    $display("%d  |  %d  |  %d  |  %d  |        %d        |", X, Y, Z, W, s1);
    X = 1; Y = 0; Z = 1; W = 0;
    s1 = (X & !Y) | (X & !W) | (X & !Z);
    $display("%d  |  %d  |  %d  |  %d  |        %d        |", X, Y, Z, W, s1);
    X = 1; Y = 0; Z = 1; W = 1;
    s1 = (X & !Y) | (X & !W) | (X & !Z);
    $display("%d  |  %d  |  %d  |  %d  |        %d        |", X, Y, Z, W, s1);
    X = 1; Y = 1; Z = 0; W = 0;
    s1 = (X & !Y) | (X & !W) | (X & !Z);
    $display("%d  |  %d  |  %d  |  %d  |        %d        |", X, Y, Z, W, s1);
    X = 1; Y = 1; Z = 0; W = 1;
    s1 = (X & !Y) | (X & !W) | (X & !Z);
    $display("%d  |  %d  |  %d  |  %d  |        %d        |", X, Y, Z, W, s1);
    X = 1; Y = 1; Z = 1; W = 0;
    s1 = (X & !Y) | (X & !W) | (X & !Z);
    $display("%d  |  %d  |  %d  |  %d  |        %d        |", X, Y, Z, W, s1);
    X = 1; Y = 1; Z = 1; W = 1;
    s1 = (X & !Y) | (X & !W) | (X & !Z);
    $display("%d  |  %d  |  %d  |  %d  |        %d        |", X, Y, Z, W, s1);


    
    $finish;
  end

endmodule