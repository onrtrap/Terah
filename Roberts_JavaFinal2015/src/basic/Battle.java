package basic;





import java.util.ArrayList;
/*****************************************************************************************************************************************
 * Notes:
 * chooseCommand and monsterAttack work perfectly.
 * public Battle needs to be fixed.  Problem seems to be calling the values.
 * figured out that /n is actually \n.  I would say I understand backslashes better, but I am going to forget this.
 * figured out what was wrong with initiateBattle.  It was taking from the creature class because of the super.
 * public Battle is working now. I changed Creature so its constructor takes no values, and it works perfectly now.
 * Now, the attack method has a chance of missing based off the hero's dodgeChance variable.
 * Because I added setters to my hero and monster classes, I no longer need some of the private variables.
 * I added the levelUp method and an expReward variable to add to experience because I was too lazy to type hero.getExperience().
 * I changed the monsterAttack method so they can not only use abilities, but alter their a.i based on their magic.
 *****************************************************************************************************************************************/
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Battle {
	
	//These variables are for the two Creatures in the initialized battle.
	
	private Creature hero;

	private Creature monster;
	
	private ArrayList<Creature> order = new ArrayList<Creature> (0);

	boolean defendH;

	boolean defendM;

	//Initializes the variables.
	
	public Battle(Creature player, Creature enemy)
	{

		hero = player;

		monster = enemy;

		defendH = false;

		defendM = false;
		
	}

	//prepareSkills sets each Skill in both Creature's ArrayLists to target themselves and their opponents.
	
	public void prepareSkills()
	{
		for(int i = 0; i < hero.getSkills().size(); i++)
		{
			hero.getSkills().get(i).setTarget(monster);
		}

		for(int i = 0; i < hero.getSkills().size(); i++)
		{
			hero.getSkills().get(i).setUser(hero);
		}

		for(int i = 0; i < monster.getSkills().size(); i++)
		{
			monster.getSkills().get(i).setTarget(hero);
		}

		for(int i = 0; i < monster.getSkills().size(); i++)
		{
			monster.getSkills().get(i).setUser(monster);
		}
	}

	/*****************************************************************************************************************
	 * Explaining this is going to be confusing.  Essentially, this is a lot of ifs inside of one while loop
	 * First, it displays who's fighting.
	 * Second, if either participant is defending at the beginning of the while loop, they no longer get that defense.
	 * Third, the Creature with the higher speed moves first, if they have equal speeds, order is random.
	 * Fourth, after each Creature's command, the other Creature has their health checked. 
	 * If it is below 0, a winner is declared.  If it is the hero, they get experience and the chance to level up.
	 *****************************************************************************************************************/
	public boolean initiateBattle()
	{
		System.out.println(hero.getName() + " vs " + monster.getName() + "! Who will win!?");
		try {
			TimeUnit.SECONDS.sleep(1/2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(hero.getTaunt());

		System.out.println(monster.getTaunt());
		
		order.add(hero);
		
		order.add(monster);

		while(hero.getHealth() > 0 && monster.getHealth() > 0)
		{

			int speed = 0;
			
			for(int i = 0; i < order.size(); i++)
			{
				if(order.get(i).getSpeed() > speed)
				{
					Creature temp = order.get(0);
					order.set(0, order.get(i));
					order.set(i, temp);
				}
			}
			
			for(int i = 0; i < order.size(); i++)
			{
				if(i == 0)
				{
					System.out.println("\n" + "Your health is: " + hero.getHealth());
					if(defendH == true)
					{
						hero.addDefense(-(2 * hero.getActualHealth()/2));
						defendH = false;
					}
					chooseCommand();
					if(monster.getHealth() <= 0)
					{
						System.out.println("\n" + monster.getName() + " has been defeated!" + "\n" + monster.getLoss());
						revertAll();
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						hero.addExp(monster.getExp());
						hero.levelUp();
						return true;
					}
				}
				else if(i == 1)
				{
					if(defendM == true)
					{
						monster.addDefense(-(2 * monster.getActualHealth()/2));
						defendM = false;
					}
					monsterAttack();
					if(hero.getHealth() <= 0)
					{
						System.out.println("\n" + hero.getName() + " has been defeated!" + "\n" + hero.getLoss());
						try {
							TimeUnit.SECONDS.sleep(2);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						revertAll();
						return false;
					}
				}
			}
			/**if(defendH == true)
			{
				hero.addDefense(-(2 * hero.getActualHealth()/2));
				defendH = false;
			}
			if(defendM == true)
			{
				monster.addDefense(-(2 * monster.getActualHealth()/2));
				defendM = false;
			}

			//hero.revertDefense();

			//monster.revertDefense();
			
			
			
			if(hero.getSpeed() > monster.getSpeed())
			{
				System.out.println("\n" + "Your health is: " + hero.getHealth());
				
				chooseCommand();

				monster.activateStatuses();
				
				if(monster.getHealth() <= 0)
				{
					System.out.println("\n" + monster.getName() + " has been defeated!" + "\n" + monster.getLoss());
					revertAll();
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					hero.addExp(monster.getExp());
					hero.levelUp();
					return true;
				}

				monsterAttack();
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				hero.activateStatuses();
				
				if(hero.getHealth() <= 0)
				{
					System.out.println("\n" + hero.getName() + " has been defeated!" + "\n" + hero.getLoss());
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					revertAll();
					return false;
				}
			}
			else if(hero.getSpeed() < monster.getSpeed())
			{

				monsterAttack();
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				hero.activateStatuses();
				
				if(hero.getHealth() <= 0)
				{
					System.out.println("\n" + hero.getName() + " has been defeated!" + "\n" + hero.getLoss());
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					revertAll();
					return false;
				} 
				System.out.println("\nYour health is: " + hero.getHealth());
			
				chooseCommand();
				try {
					TimeUnit.SECONDS.sleep(1/2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				monster.activateStatuses();
				
				if(monster.getHealth() <= 0)
				{
					System.out.println("\n" + monster.getName() + " has been defeated!" + "\n" + monster.getLoss());
					revertAll();
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					hero.addExp(monster.getExp());
					hero.levelUp();
					return true;
				}
			}

			else if(hero.getSpeed() == monster.getSpeed())
			{
				int first = (int)(Math.random() * 2);

				if(first ==  0)
				{
					System.out.println("\n" +"Your health is: " + hero.getHealth());
					chooseCommand();
					try {
						TimeUnit.SECONDS.sleep(1/2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					monster.activateStatuses();
					
					if(monster.getHealth() <= 0)
					{
						System.out.println("\n" + monster.getName() + " has been defeated!" + "\n" + monster.getLoss());
						revertAll();
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						hero.addExp(monster.getExp());
						hero.levelUp();
						return true;
					}
					monsterAttack();
					try {
						TimeUnit.SECONDS.sleep(1/2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					hero.activateStatuses();
					
					if(hero.getHealth() <= 0)
					{
						System.out.println("\n" + hero.getName() + " has been defeated!" + "\n" + hero.getLoss());
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						revertAll();
						return false;
					}
				}

				else if(first == 1)
				{

					monsterAttack();
					try {
						TimeUnit.SECONDS.sleep(1/2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					hero.activateStatuses();
			
					if(hero.getHealth() <= 0)
					{
						System.out.println("\n" + hero.getName() + " has been defeated!" + "\n" + hero.getLoss());
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						revertAll();
						return false;
					} 
					System.out.println("\n" + "Your health is: " + hero.getHealth());
					try {
						TimeUnit.SECONDS.sleep(1/2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					chooseCommand();
					try {
						TimeUnit.SECONDS.sleep(1/2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					monster.activateStatuses();
					
					if(monster.getHealth() <= 0)
					{
						System.out.println("\n" + monster.getName() + " has been defeated!" + "\n" + monster.getLoss());
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						revertAll();
						hero.addExp(monster.getExp());
						hero.levelUp();
						return true;
					}
				}
			}**/
		}

		return true;
	}
	
	//This method allows the player to choose commands. it uses a scanner.
	
	private void chooseCommand()
	{

		Scanner scan = new Scanner(System.in);

		System.out.println("What wil you do?\n" +  "('a' to attack, 's' to use a skill, 'd' to defend, 't' to taunt, 'c' to check stats)");

		String input = scan.nextLine();

		if(input.equals("a"))
		{
			attack(hero);
		}


		else if(input.equals("s"))
		{
			//This prints out all the different Skill descriptions in the Hero's ArrayList for the player so they know what they're picking.
			
			for(int i = 0; i < hero.getSkills().size(); i++)
			{
				System.out.println(i + ":" + hero.getSkills().get(i).giveDescription());
			}

			System.out.println("Type corresponding number to use skill.  Press e to return.");
			input = scan.nextLine();
			if(input.equals("e"))
			{
				chooseCommand();
			}

			for(int i = 0; i < hero.getSkills().size(); i++)
			{
				if(input.equals("" + i))
				{
					hero.getSkills().get(i).activate();	
				}

			}

		}

		else if(input.equals("d"))
		{
			defend(hero);
		}

		
		//If check or taunt are chosen, the player is asked to give another command, so they don't lose a turn over trivial things.
		
		else if(input.equals("t"))
		{
			taunt();
			chooseCommand();
		}

		else if(input.equals("c"))
		{
			check();
			chooseCommand();
		}


		else
		{
			chooseCommand();
		}

	}

	
	//This method is the monster's "brain".  It determines what it does, and how likely it will do it.
	//It uses the attack and defend methods in battle, and also the monster's Skill ArrayList.
	
	private void monsterAttack()
	{
		//Random value determines what if statement the monster will go into, in which there are more choices.
		
		int input = (int)(Math.random() * 10);

		if(input >= 0 && input <= 6)
		{
			
			//This prevents monsters with low attack from doing 0 damage with wild abandon.
			
			 if(monster.getMagic() > monster.getAttack() && monster.getSkills().size() > 0 && monster.getMana() > 0)
			{
				monster.getSkills().get((int)(Math.random() * monster.getSkills().size())).activate();
			}
			else
			{
			attack(monster);
			}
		}

		else if(input > 6 && input <= 8)
		{
			
			//There is still a slight chance of a high magic monster using attack.
			
			if(monster.getMagic() > monster.getAttack() && monster.getSkills().size() > 0)
			{
				attack(monster);
			}
			
			//If a monster has any skills, this allows them to use them, with the use of a lot of getters.
			
			else if(monster.getSkills().size() > 0)
			{
				monster.getSkills().get((int)(Math.random() * monster.getSkills().size())).activate();
			}
			else
				defend(monster);
		}

		else if(input == 9)
		{
			//If a monster has no other space to defend, they will always defend here.
		
			defend(monster);
		}

		else
			
			//if something slips out, this is here to block it.
			
			attack(monster);

	}
	
	//This method deals with attacking in the game's battle system.  The calculations are not super complicated, but 
	//it makes use of getters, and the addHealth method to calculate and subtract damage from health
	//it also displays the damage taken.
	
	private void attack(Creature creature)
	{

		int damage = 0;

		System.out.println(creature.getName() + " attacked!");

		if(creature.equals(monster))
		{
		
			damage = monster.getAttack() - hero.getDefense()/2;
			
			//This prevents addition of health due to damage becoming negative.
			
			if(damage < 0)
				damage = 0;
			
			//Dodge Chance is only a factor in the Hero object. If the random value is below the dodge chance, no damage
			//is taken. This fact is noted.
			
			if(Math.random() * 100 > hero.getDodgeChance())
			{
				hero.addHealth(-damage);
				System.out.println(hero.getName() + " took " + damage + " damage!" );
			}
			else
			{
				System.out.println(monster.getName() + " missed!");
			}
		}

		if(creature.equals(hero))
		{
			
			
			damage = hero.getAttack() - monster.getDefense()/2;
			
			//Once again, prevents negative damage.
			
			if(damage < 0)
				damage = 0;

			monster.addHealth(-damage);
			System.out.println(monster.getName() + " took " + damage + " damage!" );
		}
	}

	//Defend is a method that can add to either Creature object's defense in the battle object.
	//It also has a second feature: If health is below a half, some is restored.
	
	private void defend(Creature creature)
	{
		System.out.println(creature.getName() + " defends.");

		creature.addDefense(2 * creature.getActualHealth()/2);

		if(creature.getHealth() < creature.getActualHealth()/2)
		{
			System.out.println(creature.getName() + " recovered some health!");
			creature.addHealth(creature.getActualHealth()/3);
		}
		
		//The variables here need to be altered so defend only adds defense for one turn.
		
		if(creature.equals(hero))
		{
			defendH = true;
		}
		if(creature.equals(monster))
		{
			defendM = true;
		}
	}

	//Taunt is an interesting method.  Not only does it take a random taunt from the getBattleTaunt method in Hero, 
	//but it also alters the attack and defense of the opposing monster object. 
	//This was actually one of the first methods I added, even before skills.
	
	private void taunt()
	{
		System.out.println("You taunt " + monster.getName() + "!");
		System.out.println(hero.getTaunt());
		System.out.println(monster.getName() + " is angry! Its guard has went down! Attack +5 Defense -10!");
		monster.addAttack(5);
		monster.addDefense(-10);
		
		//Required to prevent stats from going negative.
		
		if(monster.getDefense() < 0)
		{
			monster.setDefense(0);
		}
	}

	//Check makes use of the Creature object's toString method, which is different for Hero and Monster.
	
	private void check()
	{
		System.out.println(hero.toString());
		System.out.println(monster.toString());
	}

	//revertAll uses the revertAll method from the Hero and Monster objects, so when a battle is over, stats do not carry over.
	
	private void revertAll()
	{
		hero.revertAll();
		monster.revertAll();
	}


}