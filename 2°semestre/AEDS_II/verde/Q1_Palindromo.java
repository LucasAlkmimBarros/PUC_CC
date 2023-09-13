public class Q1_Palindromo {

    public static boolean ehPalindromo(String str) {
        boolean palindromo = true;
        for(int i = 0; i < str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                palindromo = false;
                i = str.length()/2; //SAI DO LOOP
            }
        }
        if(palindromo) System.out.println("SIM");
        else System.out.println("NAO");
        return palindromo;
    }



    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        String str;
        str = MyIO.readLine(); //LE A LINHA
        do{
            ehPalindromo(str);
            str = MyIO.readLine(); //LE A LINHA
        }while(!(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M')); // ENQUANTO NAO FOR FIM
    }
}
