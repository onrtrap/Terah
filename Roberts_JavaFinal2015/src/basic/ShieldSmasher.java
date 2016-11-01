package basic;

import java.util.ArrayList;

/***********************************************
 * Deals damage to target based on user defense.
 * Also subtracts health from user.
 ***********************************************/
public class ShieldSmasher implements Skill {

	public Creature picked;

	public Creature user;

	public ShieldSmasher(Creature target, Creature self) 
	{	
		picked = target;
		user = self;
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
		if(user.getHealth() - user.getActualHealth()/4 > 0)
		{
			user.addHealth(-user.getActualHealth()/4);
			System.out.println(user.getName() + " crashed right into " + picked.getName() + "!"
					+ "\n" + picked.getName() + " took " + (int)(user.getDefense() - picked.getDefense()/4) + "!");
		}

		else
		{
			System.out.println("Not enough health!");
		}
	}


	public String giveDescription() 
	{
		return " Shield Smash: A superb smashing with a shield that deals damage based on defense."
				+ "\nWatch out though, you lose 1/4 of your health in return!";	
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
