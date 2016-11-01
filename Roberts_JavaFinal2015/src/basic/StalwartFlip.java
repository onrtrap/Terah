package basic;

import java.util.ArrayList;

/********************************************************
 * StalwartFlip switches the user's Attack and Defense.
 * It also subtracts some of their health.
 * Does not do anything if skill would bring health
 * down to 0.
 *******************************************************/
public class StalwartFlip implements Skill {


	Creature picked;

	Creature user;

	boolean used = false;

	public StalwartFlip(Creature self) 
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
		if(!used && user.getHealth() - user.getActualHealth()/15 > 0)
		{
			user.addHealth(-user.getActualHealth()/15);
			int temp = user.getAttack();
			user.setAttack(user.getDefense());
			user.setDefense(temp);
			used = true;
			System.out.println(user.getName() + " switched into a brave stance!  Their attack and defense stats are flipped!");
		}

		else if(used)
		{
			int temp = user.getDefense();
			user.setDefense(user.getAttack());
			user.setAttack(temp);
			used = false;
			System.out.println(user.getName() + " reverted into their normal stance!  Their stats are returned to normal!");
		}

		else
		{
			System.out.println("Not enough health!");
		}

	}


	public String giveDescription() 
	{

		return "Stalwart Flip: This daring manuver flips your defense and attack stats. All in, boys! "
				+ "\nBy the way, the cost of this ability is little bit of your health. Man up." ;
	}

	@Override
	public void setTargets(ArrayList<Creature> targets) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int hitsWhat() {
		// TODO Auto-generated method stub
		return 1;
	}

}
