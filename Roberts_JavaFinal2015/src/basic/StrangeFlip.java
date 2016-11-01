package basic;

import java.util.ArrayList;

/*****************************************************
 * StrangeFlip switches the user's Mana and Speed.
 * It also subtracts some health from the user.
 * Does nothing if health would become 0.
 *****************************************************/
public class StrangeFlip implements Skill {


	Creature picked;

	Creature user;

	boolean used = false;

	public StrangeFlip(Creature self) 
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
			int temp = user.getMana();
			user.setMana(user.getSpeed());
			user.setSpeed(temp);
			used = true;
			System.out.println(user.getName() + " switched into a weird stance!  Their mana and speed stats are flipped!");
		}
		else if(used)
		{
			int temp = user.getSpeed();
			user.setSpeed(user.getMana());
			user.setMana(temp);
			used = false;
			System.out.println(user.getName() + " reverted to their normal stance!  Their stats are returned to normal!");
		}

		else
		{
			System.out.println("Not enough health!");
		}

	}
	public String giveDescription() 
	{

		return "Strange Flip: This weird skill switches mana and speed. As Stoutley would say, 'hm.'"
				+ "\nThis skill costs a tad bit of your health. Nothing for a man like Stoutley." ;
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
