package Tp4;

import java.util.Date;
import java.util.Random;

public	class	MonThread	extends	Thread	{
    private int num;
    private	ListeEntiers	liste;
    private Random generateurAleatoire=new	Random(new Date().getTime());

    public	MonThread(ListeEntiers	liste,int num){
        this.liste=liste;
        this.num=num;

    }

    public void run(){

        int[] tab=liste.getValeurs();
        int i1,i2,temp;
        for (int i=0;i<1000;i++){
            i1=generateurAleatoire.nextInt(tab.length);
            i2=generateurAleatoire.nextInt(tab.length);
            temp=tab[i1];
            tab[i1]=tab[i2];
            tab[i2]=temp;
        }
    }
}
