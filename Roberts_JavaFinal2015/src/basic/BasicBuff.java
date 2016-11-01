package basic;

import java.util.ArrayList;

/**********************************************
 * BasicBuff increases the Attack, Defense,
 * Magic, and Speed of the user by 5.
 **********************************************/
public class BasicBuff implements Skill {
	public Creature picked;

	public Creature user;

	public int cost;

	public BasicBuff(Creature self, int mp) 
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
			System.out.println(user.getName() + " Boosted their inner chi!"
					+ "\n" + user.getName() + " grrrraaaaaaaa !"
					+ "\nThey gain stats across the board!");
			user.addAttack(5);
			user.addDefense(5);
			user.addMagic(5);
			user.addSpeed(5);
		}
		else
		{
			System.out.println("Not enough mana!");
		}
	}

	@Override
	public String giveDescription() 
	{
		return " Basic Buff: This skill boosts attack, defense, magic, and speed by 5. Basic, but boosting. " + cost;
	}

	@Override
	public void setTargets(ArrayList<Creature> targets) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int hitsWhat() 
	{
		
		return 1;
	}

}
