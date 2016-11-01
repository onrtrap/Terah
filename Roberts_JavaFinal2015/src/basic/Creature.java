package basic;
import java.util.ArrayList;
import java.util.Scanner;
/***************************************************************
 * The creature interface is the basic layout for the Hero
 * and Monster objects.  It features getters, setters,  
 * adders, and reverters, as well as a toString method.
 ****************************************************************/

public class Creature {

	private String name;
	private int health;
	private int attack;
	private int magic;
	private int mana;
	private int defense;
	private int speed;
	private String taunt;
	private String description;
	private String loss;
	private int experience;
	private int experienceCap;
	private int expAmount;
	private int dodgeChance;
	private int actualHealth;
	private int actualDefense;
	private int actualAttack;
	private int actualMagic;
	private int actualMana;
	private int actualSpeed;
	private int actualDodge;
	private int level;
	private boolean isPlayer;
	protected ArrayList<Effect> statuses;
	protected ArrayList<Skill> skills;

	public Creature(String nm, int hp, int atk, int mgc, int mp, int def, int spd, String desc, String insult, String defeat, int dodge, ArrayList<Skill> skl, int winExp, int lvl, boolean playable) 
	{
		name = nm;
		level = lvl;
		health = hp + (int)((level - 1)  * hp/3);
		attack = atk + (int)((level - 1) * atk/3);
		magic = mgc + (int)((level - 1)  * mgc/3);
		mana = mp + (int)((level - 1)  * mp/3);
		defense = def + (int)((level - 1)  * def/3);
		speed = spd + (int)((level - 1)  * spd/3);
		taunt = insult;
		experience = 0;
		experienceCap = 10;
		dodgeChance = dodge;
		actualHealth = health;
		actualDefense = defense;
		actualAttack = attack;
		actualMagic = magic;
		actualMana = mana;
		actualSpeed = speed;
		actualDodge = dodge;
		description = desc;
		loss = defeat;
		skills = skl;
		expAmount = winExp;
		isPlayer = playable;
		ArrayList <Effect> statuses = new ArrayList <Effect>(0);
	}
	//public void Command(ArrayList <ArrayList> players, ArrayList<ArrayList> enemies);

	public String getName() 
	{
		return name;
	}

	public int getHealth() 
	{
		return health;
	}

	public int getAttack() 
	{
		return attack;
	}

	public int getMagic() 
	{
		return magic;
	}

	public int getMana() 
	{
		return mana;
	}

	public int getDefense() 
	{
		return defense;
	}

	public int getSpeed() 
	{
		return speed;
	}

	protected int getDodgeChance()
	{
		return dodgeChance;
	}

	public int getActualHealth() 
	{
		return actualHealth;
	}

	public int getActualAttack() 
	{
		return actualAttack;
	}

	public int getActualMagic() 
	{
		return actualMagic;
	}

	public int getActualMana() 
	{
		return actualMana;
	}

	public int getActualDefense() 
	{
		return actualDefense;
	}

	public int getActualSpeed() 
	{
		return actualSpeed;
	}

	public void setHealth(int set) 
	{
		health = set;
	}

	public void setAttack(int set) 
	{
		attack = set;
	}

	public void setDefense(int set) 
	{
		defense = set;
	}

	public void setSpeed(int set) 
	{
		speed = set;
	}

	public void setMagic(int set) 
	{
		magic = set;
	}

	public void setMana (int set) 
	{
		mana = set;
	}

	public String getTaunt() 
	{
		return taunt;
	}
	
	public String getDescription()
	{
		return description;
	}

	public String getLoss() 
	{
		return loss;
	}

	public int getExp()
	{
		return expAmount;
	}


	public String toString()
	{
		return "Name: " + name +  "\n" + description + "\nLevel: " + level + "\nStats:"
				+ "\n" + "Health: " + health 
				+ "\n" + "Attack: " + attack + 
				"\n" + "Defense: " + defense + 
				"\n" + "Speed: " + speed + 
				"\n" + "Magic: " + magic
				+ "\n" + "Mana: " + mana + "\n" ;

	}
	
	public String displayTrue()
	{
		return "Name: " + name + "\nStats:\n" + "Health: " + actualHealth + "\n" + "Attack: " + actualAttack + "\n" + "Defense: " + actualDefense + "\n";
	}


	public void addHealth(int set)
	{
		health += set;
	}

	public void revertHealth()
	{
		health = actualHealth;
	}

	public void addDefense(int amount) 
	{
		defense += amount;
	}

	public void revertDefense()
	{
		defense = actualDefense;
	}

	public void addAttack(int amount)
	{
		attack += amount;
	}

	public void revertAttack()
	{
		attack = actualAttack;
	}

	public void addMagic(int amount)
	{
		magic += amount;
	}

	public void revertMagic()
	{
		magic = actualMagic;
	}

	public void addMana(int amount)
	{
		mana += amount;
	}

	public void revertMana()
	{
		mana = actualMana;
	}

	public void addSpeed(int amount)
	{
		speed += amount;
	}

	public void revertSpeed()
	{
		speed = actualSpeed;
	}
	
	protected void addDodgeChance(int amount)
	{
		dodgeChance += amount;
	}

	protected void revertDodgeChance()
	{
		dodgeChance = actualDodge;
	}


	//This reverts everything.

	public void revertAll()
	{
		revertHealth();
		revertAttack();
		revertMagic();
		revertDefense();
		revertSpeed();
		revertMana();
	}

	//Another adder, but for experience.  It has a little printer too.

	protected void addExp(int amount)
	{
		System.out.println(this.getName() + " gained " + amount + " experience!");
		experience += amount;
	}

	//This boolean checks to see if experience is greater than or equal to experience cap,
	//and returns true if yes.  Then, it brings the experienceCap up by a certain amount.

	protected boolean atCap()
	{
		if(experience >= experienceCap)
		{
			experienceCap += 5 + level * (experienceCap/4);
			return true;
		}
		else
			return false;
	}

	//levelUp checks for atCap, and if true, it adds to all the actuals (except for actualDodge) 
	//Also, it adds to level.  If there is leftover experience, the Hero will levelUp until there is no leftovers.

	protected void levelUp()
	{
		if(atCap())
		{		
			System.out.println("You leveled up!" + "\n" + "You are now level " + (int)(level + 1)
					+"\nHealth went up by " + (int)(2*level + actualHealth/3) + "!" +
					"\nAttack went up by " +  (int)(level/2 + actualAttack/3) + "!" +
					"\nDefense went up by " + (int)(level/2 + actualDefense/3) + "!" +
					"\nMagic went up by " + (int)(level/2 + actualMagic/3) + "!" +
					"\nMana went up by " + (int)(2*level + actualMana/3) + "!" +
					"\nSpeed went up by " + (int)(level/3) + "!");
			actualHealth += 2*level/2 + actualHealth/3;
			actualAttack += 1*level/2 + actualAttack/3;
			actualDefense += 1*level/2 + actualDefense/3;
			actualMagic += 1*level/2 + actualMagic/3;
			actualMana += 2*level/2 + actualMana/3;
			actualSpeed += 1 * level/3;
			revertAll();
			level += 1;
			levelUp();
		}
	}


	//This allows for the addition of status effects.  I don't really like the how it turned out, but it's here.
	public void addStatus(Effect effect)
	{
		statuses.add(effect);
	}

	//This activates any status effects in the ArrayList in sequence.
	//If their time has worn out, they are removed.

	protected void activateStatuses()
	{
		/**if(statuses.size() < 1)
		{
		for(int i = 0; i < statuses.size(); i++)
		{
			statuses.get(i).statusOn();
			if(statuses.get(i).getTime() == 0)
			{
				System.out.println(statuses.get(i).getName() + " has worn off." );
				statuses.remove(i);
				System.out.println("Status effect " + statuses.get(i) + " went away!" );
				i--;	
			}
		}
		}**/
	}


	public ArrayList<Skill> getSkills() 
	{
		return skills;
	}

	public boolean isPlayer()
	{
		return isPlayer;
	}

	public void playerCommand(ArrayList<Creature> order, ArrayList<Creature> players, ArrayList<Creature> enemies)
	{
		Scanner scan = new Scanner(System.in);

		int choice;
		int target;

		System.out.println("It is " + this.getName() + "'s turn.\n" +  "(a)Attack (s)Skills, (d)Defend, (t)Taunt, (c)Check"
				+ " (p)Party");

	    String input = "";
		
		 input = scan.nextLine();

		if(input.equals("a"))
		{
			System.out.println("Who will you attack?");
			for(int i = 0; i < order.size(); i++)
			{
				System.out.println("" + i + ":" + " " + (order.get(i)).getName());
			}

			choice = scan.nextInt();
			if(choice < order.size() && choice > -1)
			{
				int damage = 0;
				
				System.out.println(this.getName() + " attacks " + order.get(choice).getName());
				
				damage = this.getAttack() - order.get(choice).getDefense()/2;
				if(damage < 0)
					damage = 0;
				if(Math.random() * 100 > order.get(choice).getDodgeChance())
				{
					order.get(choice).addHealth(-damage);
					System.out.println(order.get(choice).getName() + " took " + damage + " damage!" );
				}
				else
				{
					System.out.println(this.getName() + " missed!");
				}
			}
			else
			{
				playerCommand(order, players, enemies);
			}
		}


		else if(input.equals("s"))
		{
			//This prints out all the different Skill descriptions in the Hero's ArrayList for the player so they know what they're picking.


			System.out.println("Type corresponding number to use skill.");
			for(int h = 0; h < this.getSkills().size(); h++)
			{
				System.out.println(h + ":" + this.getSkills().get(h).giveDescription());
			}

			choice = scan.nextInt();
			
			if(this.getSkills().get(choice).hitsWhat() == 1)
			{
				this.getSkills().get(choice).setUser(this);
				this.getSkills().get(choice).activate();
			}
			
			if(this.getSkills().get(choice).hitsWhat() == 2)
			{
				this.getSkills().get(choice).setTargets(order);
				this.getSkills().get(choice).setUser(this);
				this.getSkills().get(choice).activate();
			}
			
			if(this.getSkills().get(choice).hitsWhat() == 3)
			{
				this.getSkills().get(choice).setTargets(order);
				this.getSkills().get(choice).setUser(this);
				this.getSkills().get(choice).activate();
			}
			
			if(this.getSkills().get(choice).hitsWhat() == 4)
			{
				System.out.println("Who will you use the skill on?");

				for(int d = 0; d < order.size(); d++)
				{
					if(order.get(d).isPlayer())
					{
					System.out.println("\n" + d + ":" + " " + order.get(d).getName());
					}
				}
				target = scan.nextInt();

				if(target >= 0 && target < order.size())
				{	this.getSkills().get(choice).setTarget(order.get(target));
				this.getSkills().get(choice).setUser(this);
				this.getSkills().get(choice).activate();
				}
				else
				{
					playerCommand(order, players, enemies);
				}
			}
			
			if(this.getSkills().get(choice).hitsWhat() == 5)
			{
				System.out.println("Who will you use the skill on?");

				for(int d = 0; d < order.size(); d++)
				{
					if(!order.get(d).isPlayer())
					{
					System.out.println("\n" + d + ":" + " " + order.get(d).getName());
					}
				}
				target = scan.nextInt();

				if(target >= 0 && target < order.size())
				{	this.getSkills().get(choice).setTarget(order.get(target));
				this.getSkills().get(choice).setUser(this);
				this.getSkills().get(choice).activate();
				}
				else
				{
					playerCommand(order, players, enemies);
				}
			}
			/**System.out.println("Who will you use the skill on?");

			for(int d = 0; d < order.size(); d++)
			{

				System.out.println("\n" + d + ":" + " " + order.get(d).getName());
			}
			target = scan.nextInt();

			if(target >= 0 && target < order.size())
			{	this.getSkills().get(choice).setTarget(order.get(target));
			this.getSkills().get(choice).setUser(this);
			this.getSkills().get(choice).activate();
			}
			**/
			else
			{
				playerCommand(order, players, enemies);
			}
		}



		else if(input.equals("d"))
		{
			System.out.println(this.getName() + " defends.");

			this.addDefense(2 * this.getActualHealth()/2);

			if(this.getHealth() < this.getActualHealth()/2)
			{
				System.out.println(this.getName() + " recovered some health!");
				this.addHealth(this.getActualHealth()/3);
			}
		}

		//If check or taunt are chosen, the player is asked to give another command, so they don't lose a turn over trivial things.

		else if(input.equals("t"))
		{
			System.out.println("Taunt who?");
			for(int i = 0; i < order.size(); i++)
			{
				System.out.println("" + i + ":" + " " + order.get(i).getName());
			}

			choice = scan.nextInt();
			if(choice < order.size() && choice > -1)
			{
				System.out.println(this.getName() + order.get(choice).getName() + "!");
				System.out.println(this.getTaunt());
				System.out.println(order.get(choice).getName() + " is angry! Their guard has went down! Attack +5 Defense -10!");
				order.get(choice).addAttack(5);
				order.get(choice).addDefense(-10);

				//Required to prevent stats from going negative.

				if(order.get(choice).getDefense() < 0)
				{
					order.get(choice).setDefense(0);
				}
			}
			else
			{
				playerCommand(order, players, enemies);
			}
		}

		else if(input.equals("c"))
		{
			System.out.println("Check who?");
			for(int i = 0; i < order.size(); i++)
			{
				System.out.println("" + i + ":" + " " + order.get(i).getName());
			}

			choice = scan.nextInt();
			if(choice < order.size() && choice > -1)
			{
				System.out.println(order.get(choice).toString());
				playerCommand(order, players, enemies);
			}
			else
			{
				playerCommand(order, players, enemies);
			}
		}

		else if(input.equals("p"))
		{
			for(int i = 0; i < players.size(); i++)
			{
				System.out.println(players.get(i).toString());
			}

			playerCommand(order, players, enemies);
		}

		else
		{
			playerCommand(order, players, enemies);
		}
		//Closing the scanner causes an error.  Guess it isn't always a good idea to close, huh?
		//scan.close();
	}
	
	public void enemyCommand(ArrayList<Creature> order, ArrayList<Creature> players)
	{
		//Random value determines what if statement the monster will go into, in which there are more choices.

		int input = (int)(Math.random() * 10);
		
		int target = (int) (Math.random() * players.size());

		int ability = (int) (Math.random() * this.getSkills().size());
		
		if(input >= 0 && input <= 6)
		{
			
			//This prevents monsters with low attack from doing 0 damage with wild abandon.

			if(this.getMagic() > this.getAttack() && 
					this.getSkills().size() > 0 && this.getMana() > 0)
			{

				this.getSkills().get(ability).setTarget((Creature)players.get(target));
				this.getSkills().get(ability).setUser(this);
				this.getSkills().get(ability).activate();
			}
			else
			{
					int damage = 0;
					
					System.out.println(this.getName() + " attacks " + players.get(target).getName());
					
					damage = this.getAttack() - players.get(target).getDefense()/2;
					if(damage < 0)
						damage = 0;
					if(Math.random() * 100 > players.get(target).getDodgeChance())
					{
						players.get(target).addHealth(-damage);
						System.out.println(players.get(target).getName() + " took " + damage + " damage!" );
					}
					else
					{
						System.out.println(this.getName() + " missed!");
					}
			}
		}

		else if(input > 6 && input <= 8)
		{

			//There is still a slight chance of a high magic monster using attack.

			if(this.getMagic() > this.getAttack() && this.getSkills().size() > 0)
			{
				int damage = 0;
				
				System.out.println(this.getName() + " attacks " + players.get(target).getName());
				
				damage = this.getAttack() - players.get(target).getDefense()/2;
				if(damage < 0)
					damage = 0;
				if(Math.random() * 100 > players.get(target).getDodgeChance())
				{
					players.get(target).addHealth(-damage);
					System.out.println(players.get(target).getName() + " took " + damage + " damage!" );
				}
				else
				{
					System.out.println(this.getName() + " missed!");
				}
			}

			//If a monster has any skills, this allows them to use them, with the use of a lot of getters.

			else if(this.getSkills().size() > 0)
			{
				this.getSkills().get(ability).setTarget((Creature)players.get(target));
				this.getSkills().get(ability).setUser(this);
				this.getSkills().get((int)(Math.random() * this.getSkills().size())).activate();
			}
			else
				System.out.println(this.getName() + " defends.");

			this.addDefense(2 * this.getActualHealth()/2);

			if(this.getHealth() < this.getActualHealth()/2)
			{
				System.out.println(this.getName() + " recovered some health!");
				this.addHealth(this.getActualHealth()/3);
			}
		}

		else if(input == 9)
		{
			//If a monster has no other space to defend, they will always defend here.

			System.out.println(this.getName() + " defends.");

			this.addDefense(2 * this.getActualHealth()/2);

			if(this.getHealth() < this.getActualHealth()/2)
			{
				System.out.println(this.getName() + " recovered some health!");
				this.addHealth(this.getActualHealth()/3);
			}
		}

		else
		{
			//if something slips out, this is here to block it.
		System.out.println(this.getName() + " attacks " + players.get(target).getName());
			int damage = 0;
			
			damage = this.getAttack() - players.get(target).getDefense()/2;
			if(damage < 0)
				damage = 0;
			if(Math.random() * 100 > players.get(target).getDodgeChance())
			{
				players.get(target).addHealth(-damage);
				System.out.println(players.get(target).getName() + " took " + damage + " damage!" );
			}
			else
			{
				System.out.println(this.getName() + " missed!");
			}
		}
	}

}
