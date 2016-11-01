package basic;

import java.util.ArrayList;

/**********************************************
 * Ydobon reverses the user's Magic and Attack.
 *********************************************/
public class Ydobon implements Skill {

	Creature picked;

	Creature user;

	boolean used = false;
	
	int targets = 1;

	public Ydobon(Creature self) 
	{	
		user = self;
	}

	public void setTarget(Creature aim) 
	{
		used = false;
		picked = aim;	
	}

	@Override
	public void setUser(Creature caster) 
	{
		used = false;
		user = caster;	
	}

	@Override
	public void activate()
	{
		if(!used)
		{
			int temp = user.getAttack();
			user.setAttack(user.getMagic());
			user.setMagic(temp);
			used = true;
			System.out.println(user.getName() + " used Ydobon!  Their magic and attack stats are flipped!");
		}
		else if(used)
		{
			int temp = user.getMagic();
			user.setMagic(user.getAttack());
			user.setAttack(temp);
			used = false;
			System.out.println(user.getName() + " used Ydobon!  Their stats are returned to normal!");
		}
	}


	public String giveDescription() {
		return "Ydobon: A skill that switches the user's attack and magic. Plus, no cost! Looc!";
	}

	
	public void setTargets(ArrayList<Creature> targets) 
	{
		
		
	}

	public int hitsWhat() 
	{
		return 1;
	}

}
