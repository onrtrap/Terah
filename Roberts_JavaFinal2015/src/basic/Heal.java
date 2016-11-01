package basic;

import java.util.ArrayList;

/*************************************
 * Heal adds health to the user
 * based on their Magic.
 *************************************/
public class Heal implements Skill {

	Creature user;
	
	int cost;
	
	public Heal(Creature self, int mana)
	{
		user = self;
		cost = mana;
	}
	
	public void setTarget(Creature aim) 
	{
		
		
	}

	@Override
	public void setUser(Creature caster) 
	{
		user = caster;
	}

	@Override
	public void activate() 
	{
		System.out.println("Heal activated!");
		
		if(user.getMana() < cost)
		{
			System.out.println(user.getName() + " can't use Heal!");
		}
		else
		{
		user.addMana(-cost);
		System.out.println(user.getName() + " used Heal!"
				+ "\n" + user.getName() + ": Heal me, dang it!"
						+ "\n" + user.getName() + " regains " + (int)(user.getMagic()/2) + " health!");
		user.addHealth(2 * user.getMagic()/2);
		if(user.getHealth() > user.getActualHealth())
		{
			user.setHealth(user.getActualHealth());
		}
		}
	}

	@Override
	public String giveDescription() 
	{
	return "Heal: A basic healing spell. Heals some health, nothing fancy. " + cost;	
		
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
