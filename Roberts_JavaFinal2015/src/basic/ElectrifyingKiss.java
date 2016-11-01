package basic;

import java.util.ArrayList;

/******************************************************
 * Electrifying Kiss deals damage based on user magic
 * to picked, and also decreases the speed of picked.
 ******************************************************/
public class ElectrifyingKiss implements Skill {

	Creature user;
	
	Creature picked;
	
	int cost;
	
	public ElectrifyingKiss(Creature target, Creature self, int mp)
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
		System.out.println(user.getName() + " alright, set voice output to 110%!");
		if(user.getMana() < cost)
		{
			System.out.println(user.getName() + " can't use Electrifying Kiss!\n" 
					+ user.getName() + ": What?! My vocal systems are malfunctioning!");
		}
		else
		{
		user.addMana(-cost);
		System.out.println(user.getName() + ": Elec-tri-fy-ing Kiss!\n" + 
		picked.getName() + " was electrocuted! Disorientation makes them stagger! They take " + user.getMagic()/2 + " damage!");
		picked.addHealth(-user.getMagic()/2);
		picked.addSpeed(-20);
		if(picked.getSpeed() < 0)
		{
			picked.setSpeed(0);
		}
		}
	}

	
	public String giveDescription() 
	{
	
		return null;
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
