package basic;

import java.util.ArrayList;

/*************************************************
 * EvenSlice divides the target's health by half.
 *************************************************/
public class EvenSlice implements Skill
{
	public Creature picked;

	public Creature user;

	public int cost;
	
	public EvenSlice(Creature target, Creature self, int mp) 
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
		System.out.println("Even Slice activated!");
		
		if(user.getMana() < cost)
		{
			System.out.println(user.getName() + " can't use Even Slice!");
		}
		else
		{
		user.addMana(-cost);
		picked.setHealth(picked.getHealth()/2);
		System.out.println(user.getName() + ": Was it perfect?"
				+ " Close enough.\n" + "Health is cut in half!");
		}
	}

	public String giveDescription()
	{
		return "Even Slice: This elegant ability slashes an enemies health in half.";	
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
