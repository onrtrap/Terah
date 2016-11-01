package basic;

import java.util.ArrayList;

/**************************************
 * Caviar adds 15 attack to the user.
 *************************************/
public class Caviar implements Skill
{
	public Creature picked;

	public Creature user;

	public int cost;

	public Caviar(Creature self, int mp) 
	{	
		user = self;
		cost = mp;
	}

	public void setTarget(Creature aim)
	{
		picked = aim;
	}

	public void setUser(Creature caster)
	{
		user = caster;
	}

	@Override
	public void activate() 
	{
		if(user.getMana() > 0)
		{
			user.addMana(-cost);
		System.out.println(user.getName() + " ate some caviar!"
				+ "\n" + user.getName() + " nom nom nom!"
				+ "\nThey gain attack!");
		user.addAttack(15);
		}
		else
		{
			System.out.println("Not enough mana!");
		}
	}

	@Override
	public String giveDescription() 
	{
		return " Caviar: This fancy food boosts attack. Yum! " + cost;
	}

	@Override
	public void setTargets(ArrayList<Creature> targets) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int hitsWhat() {
		// TODO Auto-generated method stub
		return 4;
	}

}
