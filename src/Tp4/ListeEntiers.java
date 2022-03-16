package Tp4;

import java.util.Arrays;

public	class	ListeEntiers	{


    private	int	valeurs[];
    public	ListeEntiers(){
        valeurs=new int[20];

    }
    public	int[]	getValeurs(){
        return valeurs;
    }
    @Override
    public String toString() {
        return "ListeEntiers{" +
                "valeurs=" + Arrays.toString(valeurs) +
                '}';
    }
    public	static	void	main(String[]	args)	{
        ListeEntiers	liste=new	ListeEntiers();
        System.out.println(liste);
    }
    public void echanger(int i1, int i2){
        int temp=valeurs[i1];
        valeurs[i1]=valeurs[i2];
        valeurs[i2]=temp;
    }
}
