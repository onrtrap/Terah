package basic;

import java.util.ArrayList;

/*****************************************
 * Fireball deals damage to picked
 * based on the user's magic.
 *****************************************/
public class Fireball implements Skill {
	public Creature picked;

	public Creature user;
	
	int cost;
	
	public Fireball(Creature target, Creature self, int mp)
	{
		picked = target;
		user = self;
		cost = mp;
	}
	
	@Override
	public void setTarget(Creature aim) 
	{
		picked = aim;
	}

	@Override
	public void setUser(Creature caster) 
	{
		user = caster;
	}

	@Override
	public void activate() 
	{
		if(user.getMana() < cost)
		{
			System.out.println(user.getName() + " tried to conjure fire, but it fizzled out!");
		}
		else
		{
		user.addMana(-cost);
			System.out.println(user.getName() + " hit " + picked.getName() + " with a fireball! Toasty!"
					+ "\n" + picked.getName() + " takes " + (int)(user.getMagic()/2) + " damage!");
			picked.addHealth(-user.getMagic()/2);
		}
		
	}

	@Override
	public String giveDescription() {
		return "Fireball: You need some real fireballs to do damage with this. " + cost;
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
