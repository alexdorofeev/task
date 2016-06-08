package smallGame;

/**
 * Created by Dorofeev on 4/6/2016.
 */
public interface IWarrior {
    public boolean canDistAttack();
    public void distAttack(IWarrior another);

    public boolean canMeleeAttack();
    public void meleeAttack(IWarrior another);

    public int getHealth();
    public  void loseHealth(int hp);
    public boolean isDied();

}
