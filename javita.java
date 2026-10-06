public class javita {
    public static void main (String [] args) throws Exception {
        float [] notas= new float [5];
        notas[0]=4.2f;
        notas[1]=3.5f;
        notas[2]=2.9f;
        notas[3]=3.7f;
        notas[4]=3.0f;
        System.out.println(notas[4]);
        for (int i=0; i< notas.length;i++){
            System.out.println(notas[i]);
        }
        System.out.println("____TERMINADO____");

    }
}