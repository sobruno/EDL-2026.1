//Arquivo destinado a teste de métodos

import PilhaColorida.PIlhaColorida;

Package PilhaColorida;

public class Main{
    public static void main(String[] args){
        PIlhaColorida teste = new PIlhaColorida(10);

        for (int i =0; i<10; i++){
            System.out.println(teste.getArrayGeral(i));
        }

    }
}
