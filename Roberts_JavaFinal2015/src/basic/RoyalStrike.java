package basic;

import java.util.ArrayList;

/**********************************************
 * RoyalStrike subtracts health from picked
 * using the Attack of the user.
 **********************************************/
public class RoyalStrike implements Skill {

	public Creature picked;

	public Creature user;
	
	public int cost;

	public RoyalStrike(Creature target, Creature self, int mp) 
	{	
		picked = target;
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

	public void activate()
	{
		System.out.println("Royal Strike activated!");
		if(user.getMana() < cost)
		{
			System.out.println(user.getName() + " can't use Royal Strike!");
		}
		else
		{
		user.addMana(-cost);
		
		picked.addHealth(-user.getActualAttack());
		System.out.println( user.getName() + ": *chanting in ancient language*"
				+ " Rutso nouuf gwol je! Royal Strike!"
				+ "\n" + picked.getName() + " takes " + user.getActualAttack() + " damage!" );
		}
	}

	public String giveDescription()
	{
		return "Royal Strike: A secret technique known only by the royal family of Emeremeret. "
				+ "This skill deals the true attack of the user regardless of all else. ";	
	}

	@Override
	public void setTargets(ArrayList<Creature> targets) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int hitsWhat() {
		// TODO Auto-generated method stub
		return 5;
	}
}
