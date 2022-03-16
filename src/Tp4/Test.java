package Tp4;

import java.util.Scanner;

public	class	Test	{
    public	static	void	main(String[]	args)	{
        System.out.println("Donnez	le	nombre	de	Threads	:");
        Scanner scanner=new	Scanner(System.in);
        int	nbThreads=scanner.nextInt();
        ListeEntiers	liste=new	ListeEntiers();
        Thread[] thread=new Thread[nbThreads];
        for(int i = 0;i<thread.length;i++){
            thread[i]=new MonThread(liste ,i);
        }
        for (int i =0 ;i<thread.length;i++){
            thread[i].start();
        }
        System.out.println(liste);
        System.out.println("C'est	terminé	!!!");
    }
}