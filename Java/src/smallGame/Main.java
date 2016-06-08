package smallGame;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Dorofeev on 4/5/2016.
 */
public class Main {
    private static Random rand = new Random();

    private static void randomEvent(IWarrior[] warriors)
    {
        int attacker = rand.nextInt(warriors.length);
        int attacked;
        while((attacked = rand.nextInt(warriors.length)) == attacker);
        boolean type = rand.nextBoolean();
        System.out.print("Warrior #");
        System.out.print(attacker+1);
        System.out.print(" attack warrior #");
        System.out.print(attacked+1);
        if(type)
        {
            System.out.println(" in milee");
            warriors[attacker].meleeAttack(warriors[attacked]);
        }
        else
        {
            System.out.println(" in distance");
            warriors[attacker].distAttack(warriors[attacked]);
        }

    }

    public static void printAll(IWarrior[] warriors)
    {
        for(int i=0; i<warriors.length; ++i)
        {
            if(i>0&&warriors[i].getHealth()>0) System.out.print(' ');
            System.out.print("Warrior #");
            System.out.print(i+1);
            System.out.print(" hp=");
            System.out.print(warriors[i].getHealth());
        }

        System.out.println();
    }

    public static void main(String[] args)
    {
        Warrior z = Warrior.getInstance();
        IWarrior[] warriors = new IWarrior[2];
        Scanner in = new Scanner(System.in);

        String d, m;
        for(int i = 0; i<2; ++i)
        {
            System.out.print("Warior № ");
            System.out.print(i+1);
            System.out.println(".");

            System.out.print("Can he attack distance? [y/n] ");
            d = in.nextLine();
            System.out.print("Can he attack melee? [y/n] ");
            m = in.nextLine();

            warriors[i] = z.getWarrior(d.charAt(0)=='y', m.charAt(0)=='y');
        }

        while(!".".equals(in.nextLine())){
            randomEvent(warriors);
            printAll(warriors);
        }
    }
}
