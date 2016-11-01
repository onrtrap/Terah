package basic;
import java.util.ArrayList;
/*************************************
 * PopRockets deals damage to picked
 * three times, using both 
 * user Attack and Magic.
 */
import java.util.concurrent.TimeUnit;

public class PopRockets implements Skill 
{
	public Creature picked;

	public Creature user;
	
	public int cost;
	
	public PopRockets(Creature target, Creature self, int mana)
	{
		picked = target;
		user = self;
		cost = mana;
	}
	
	public void setTarget(Creature aim) 
	{
	picked = aim;	
	}

	@Override
	public void setUser(Creature caster) 
	{
	user = caster;
	}

	public void activate() 
	{
		if(user.getMana() < cost)
		{
			System.out.println(user.getName() + " can't use Pop Rockets!\n"
					+ user.getName() +  ": What? My backup dancers aren't responding!?");
		}
		else{
			user.addMana(-cost);
	int random = 0;
	
	int total = 0;
	System.out.println("Now I'll sing you...Pop Rocket!\n" + user.getName() + " activated her Pop Rockets!");
	for(int i = 1; i <= 3; i++)
	{
		random = (int)(Math.random() * (user.getActualMagic()/2) + user.getActualAttack()/3 );
		
		total = random - (picked.getDefense()/3);
		
		if(total < 0)
		{
			total = 0;
		}
		
		if(i == 3)
		{
		System.out.println("La la la! *Boom! Pop Rocket!*");
		
		}
		else if(i == 2)
		{
		System.out.println("La la! *Can you feel the pain?*");
		}
		else
		{
		System.out.println("La! *Can you feel it?*");
		}
		System.out.println("Rocket dealt " + total + " damage to " + picked.getName() + "!");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(total > 0)
		{
			picked.addHealth(-random + picked.getDefense()/3);	
		}
	}
	}
		
	}


	public String giveDescription() 
	{
		return "Pop Rockets: Sparkla's hidden weapon. These rockets are controlled by Sparkla, and float around her"
				+ "\nuntil they are needed.  They explode in a burst of colors, always in tune with her music."
				+ "\nRockets hit three times with random damage.";
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
