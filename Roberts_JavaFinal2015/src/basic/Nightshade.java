package basic;

import java.util.ArrayList;

/*******************************************
 * Poison adds the Poison Status
 * object to picked, which deals 5 damage
 *for 5 turns.
 *****************************************/
public class Nightshade implements Skill {

	public ArrayList<Creature> targeted;

	public Creature user;

	public int hits = 3;

	int cost;


	public Nightshade(ArrayList <Creature> targets, int mp, Creature self)
	{

		user = self;

				targeted = targets;

		cost = mp;
	}


	public void setTarget(Creature aim) 
	{


	}


	public void setUser(Creature self) 
	{

		user = self;
	}


	public void activate() 
	{
		if(user.getMana() < cost)
		{
			System.out.println(user.getName() + " can't use Nightshade!");
		}
		else
		{
			user.addMana(-cost);
			if(user.isPlayer())
			{	
				for(int i = 0; i < targeted.size(); i++)
				{
					if(!targeted.get(i).isPlayer())
					{

					}
				}
			}
			else if(!user.isPlayer())
			{	
				for(int i = 0; i < targeted.size(); i++)
				{
					if(targeted.get(i).isPlayer())
					{

					}
				}
			}
		}
	}


	public String giveDescription() {

		return "Nightshade: A bottle of distiled nightshade gas is thrown at the enemy, "
				+ "poisoning ALL foes.\n " + cost;
	}



	public void setTargets(ArrayList<Creature> targets)
	{
		targeted = targets;
	}


	@Override
	public int hitsWhat() 
	{
		return hits;
	}

}
