package smallGame;

/**
 * Created by Dorofeev on 4/6/2016.
 */
public class Warrior {
    private Warrior(){}
    private static Warrior instance = null;
    public  static Warrior getInstance(){
        if(instance == null){
            instance = new Warrior();
        }
        return instance;
    }

    public IWarrior getWarrior(
            boolean canDistanceAttack,
            boolean canMeleeAttack)
    {
        if(canDistanceAttack && canMeleeAttack)
        {
            return new IWarrior() {
                private int healthPoints = 100;
                public boolean canDistAttack() { return true; }
                public boolean canMeleeAttack() { return true; }
                public void distAttack(IWarrior another)
                {
                    another.loseHealth(5);
                }
                public void meleeAttack(IWarrior another)
                {
                    another.loseHealth(5);
                }
                public int getHealth() { return healthPoints; }
                public void loseHealth(int hp) { healthPoints -= hp; }

                @Override
                public boolean isDied() {
                    return false;
                }
            };
        }
        else if(canDistanceAttack)
        {
            return new IWarrior() {
                private int healthPoints = 100;
                public boolean canDistAttack() { return true; }
                public boolean canMeleeAttack() { return false; }
                public void distAttack(IWarrior another)
                {

                    another.loseHealth(15);
                }
                public void meleeAttack(IWarrior another) {}
                public int getHealth() { return healthPoints; }
                public void loseHealth(int hp) { healthPoints -= hp; }

                @Override
                public boolean isDied() {
                    return false;
                }
            };
        }
        else if(canMeleeAttack)
        {
            return new IWarrior() {
                private int healthPoints = 100;
                public boolean canDistAttack() { return false; }
                public boolean canMeleeAttack() { return true; }
                public void distAttack(IWarrior another) {}
                public void meleeAttack(IWarrior another)
                {
                    another.loseHealth(15);
                }
                public int getHealth() { return healthPoints; }
                public void loseHealth(int hp) { healthPoints -= hp; }

                @Override
                public boolean isDied() {
                    return false;
                }
            };
        }
        else
        {
            return new IWarrior() {
                private int healthPoints = 100;
                public boolean canDistAttack() { return false; }
                public boolean canMeleeAttack() { return false; }
                public void distAttack(IWarrior another) {}
                public void meleeAttack(IWarrior another) {}
                public int getHealth() { return healthPoints; }
                public void loseHealth(int hp) { healthPoints -= hp; }
                public boolean isDied() {return false;}

            };
        }

    }
}
