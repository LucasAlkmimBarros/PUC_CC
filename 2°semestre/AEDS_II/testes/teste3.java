public class teste3 {
    boolean isConsoante(String s, int n){
        boolean resp;
        if(n== s.length()) resp = true;
            else if(isConsoante(s.charAt(n)) == false) resp = false;
                else resp = isConsoante(s, n +1);
    }

}
