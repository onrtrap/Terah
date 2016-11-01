package basic;
import java.util.ArrayList;
/*********************************************************************
 * This class creates a sort of second playable character
 * for the user.
 * It has it's own resource, called sugar, which is used for
 * some of its commands.
 * There also are the seal booleans. For each seal turned to true,
 * power increases, and some abilities are also altered.
 * Power is the basis for all the damage calculations in this class.
 **********************************************************************/
import java.util.Scanner;

public class Sugarpuff implements Skill {

	Creature picked;

	Creature user;

	int cost;

	//sugar is a variable that serves as a resource for the different commands.

	int sugar;

	//seal1, seal2, and seal3 are used to track how many of the seal commands have been used.

	boolean seal1 = false;

	boolean seal2 = false;

	boolean seal3 = false;

	int revealed = 0;

	//Defending prevents the defend command here from permanently adding defense.

	boolean defending = false;

	Creature pickedTemp;

	int powerTemp = 0;

	//Power is the value used for addition and subtraction of stats.

	int power;

	//Constructor initializes the basic values for the upcoming battle.

	public Sugarpuff(Creature target, Creature self)
	{
		picked = target;
		user = self;

		sugar = 0;
		power = 20;

		pickedTemp = target;
	}

	public int getSugar()
	{
		return sugar;
	}

	public void setTarget(Creature aim) 
	{
		picked = aim;
	}


	public void setUser(Creature caster) 
	{
		user = caster;
	}


	public void activate() {
		Scanner scan = new Scanner(System.in);
		boolean valid = false;

		//This makes sure that Sugarpuff is not in her final form indefinitely.

		if(!picked.equals(pickedTemp))
		{
			pickedTemp = picked;
			defending = false;
			seal1 = false;
			seal2 = false;
			seal3 = false;
			revealed = 0;
		}


		//If one seal command has been used successfully, sets power to a higher level.
		//Each progression is only displayed once due to the revealed integer.

		if((seal1 || seal2 || seal3) && !(seal1 && seal2 || seal2 && seal3 || seal1 && seal3) && !(seal1 == true && seal2 == true && seal3 == true) && revealed == 0)
		{
			power = 30;
			System.out.println("Sugarpuff is gaining power! Attack +10!");
			revealed++;
		}

		//If two have been used, it sets it higher.

		else if((seal1 && seal2 || seal2 && seal3 || seal1 && seal3) && !(seal1 == true && seal2 == true && seal3 == true) && revealed == 1)
		{
			power = 50;
			System.out.println("Sugarpuff is gaining power! Attack +20!");
			revealed++;
		}

		//If all have been used, both the command effects and power are altered.

		else if(seal1 == true && seal2 == true && seal3 == true && revealed == 2)
		{
			power = 80;
			System.out.println("Sugarpuff has released her true form! Attack +30!"
					+ "\nDaemon Princess Sugaraza: Gaze upon your doom, you heretic of pastries!!");
			revealed++;
		}
		else
		{
			power = 20;
		}
		while(!valid)
		{
			System.out.println("Sugarpuff: Puff! Sugar = " + sugar
					+ "\n1: Attack- Sugarpuff may not have a threatening name, but you really don't want to know her real one."
					+ "\n2: Generate Sugar- Magic sugar is a miracle ingredient. It can be used to form any dessert, pastry, or sweet imaginable."
					+ "\n3: Sugar Shield (1 sugar) Concentrated magic sugar can create a rather stout shield."
					+ "\n4: Release vanilla seal (1 sugar) Releasing this seal makes Sugarpuff remember the cold of a vanilla sundae."
					+ "\n5: Release chocolate seal (1 sugar) Releasing this seal makes Sugarpuff remember the warmth of a freshly cooked brownie."
					+ "\n6: Release strawberry seal (1 sugar) Releasing this seal makes Sugarpuff remember the tang of a lemon tart."
					+ "\n7: Caramel Fireball (2 sugar) Sugarpuff is from the Pastrinferno, where the haters of sweets and indulgence are tortured eternally.  With sweets."
					+ "\n8: Cakefield (2 sugar) Lolipop was told by his instructor that in order to make Sugaromancy a piece of cake, he had to have lots of material."
					+ "\n He may have taken this the wrong way, but it works."
					+ "\n9: Dolce Finale (All sugar) Go all out in a blaze of sweetness.");
			int input = scan.nextInt();
			switch(input)
			{


			case 1: 
				System.out.println("Sugarpuff attacks " + picked.getName() + "!");
				if(!(seal1 && seal2 && seal3))
				{
					System.out.println("Sugarpuff: PUFF!");
				}
				else if(!(seal1 && seal2 && seal3))
				{
					System.out.println("Daemon Princess Sugaraza: I have no mercy for the figure-conscious!");
				}
				System.out.println( "\n" + picked.getName() + " takes " + (power - picked.getDefense()/4) + " damage!");

				picked.addHealth(-power + picked.getDefense()/4);
				if(defending)
				{
					System.out.println("Sugarpuff is no longer protecting Lolipop!");
					user.addDefense(-powerTemp);
					defending = false;
				}
				valid = true;
				break;


			case 2: 
				if(!(seal1 && seal2 && seal3))
				{
					System.out.println("Sugarpuff is generating sugar..."
							+ "\nSugarpuff: Pufffff...");
					sugar += 2;
				}
				else if(seal1 && seal2 && seal3)
				{
					System.out.println("Sugarpuff is generating sugar..."
							+ "\nDaemon Princess Sugaraza: Sugar, rise from the blood of your captors!"
							+ "\n" + picked.getName() + " loses 8 health to blood sugar loss!");
					sugar += 8;
					picked.addHealth(-8);
				}
				if(defending)
				{
					System.out.println("Sugarpuff is no longer protecting Lolipop!");
					user.addDefense(-powerTemp);
					defending = false;
				}
				valid = true;
				break;


			case 3: 
				if(sugar > 0)
				{
					System.out.println("Sugarpuff shields Lolipop!");
					defending = true;
					powerTemp = power;
					user.addDefense(power);
					valid = true;
				}
				else
				{
					System.out.println("Not enough sugar!");
				}
				break;


			case 4: 
				if(sugar > 0)
				{
					valid = true;
					System.out.println("Sugarpuff has broken the vanilla seal!"
							+ "\nSugarpuff: Vanillaros!");
					seal1 = true;
					sugar--;
					if(defending)
					{
						System.out.println("Sugarpuff is no longer protecting Lolipop!");
						user.addDefense(-powerTemp);
						defending = false;
					}
				}
				else
				{
					System.out.println("Not enough sugar!");
				}
				break;


			case 5: 
				if(sugar > 0)
				{
					valid = true;
					System.out.println("Sugarpuff has broken the chocolate seal!"
							+ "\nSugarpuff: Chocolas!");
					seal2 = true;
					sugar--;
					if(defending)
					{
						System.out.println("Sugarpuff is no longer protecting Lolipop!");
						user.addDefense(-powerTemp);
						defending = false;
					}
				}
				else
				{
					System.out.println("Not enough sugar!");
				}
				break;


			case 6: 
				if(sugar > 0)
				{
					valid = true;
					System.out.println("Sugarpuff has broken the strawberry seal!"
							+ "\nSugarpuff: Strawberras!");
					seal3 = true;
					sugar--;
					if(defending)
					{
						System.out.println("Sugarpuff is no longer protecting Lolipop!");
						user.addDefense(-powerTemp);
						defending = false;
					}
				}
				else
				{
					System.out.println("Not enough sugar!");
				}

				break;


			case 7: 
				if(sugar >= 2)
				{
					valid = true;
					sugar -= 2;
					System.out.println("Sugarpuff spat out a ball of hot caramel!"
							+ "\n" + picked.getName() + " took " + (int)(power + 1) + " damage!");
					picked.addHealth(-power + 1);
					if(defending)
					{
						System.out.println("Sugarpuff is no longer protecting Lolipop!");
						user.addDefense(-powerTemp);
						defending = false;
					}
				}
				else
				{
					System.out.println("Not enough sugar!");
				}
				break;

			case 8: 
				if(sugar >= 2)
				{
					valid = true;
					sugar -= 2;
					System.out.println("The arena becomes cake! You gain more material for your magic! magic +" + power/3);
					user.addMagic(power/3);
					powerTemp = power;
					if(defending)
					{
						System.out.println("Sugarpuff is no longer protecting Lolipop!");
						user.addDefense(-powerTemp);
						defending = false;
					}
				}
				else
				{
					System.out.println("Not enough sugar!");
				}
				break;


			case 9: 
				if(sugar > 0)
				{
					valid = true;
					if(seal1 && seal2 && seal3)
					{
						System.out.println("Sugaraza uses all her power in a tempest of molten hot fudge!"
								+ "\nDaemon Princess Sugaraza: Witness the true power of the Sugarlords!"
								+ "\n" + picked.getName() + " took " + (int)(((sugar/2)*power) - picked.getDefense()/4) + " damage!");
						picked.addHealth(-((sugar/2)*power) + picked.getDefense()/4);
					}
					else if(!(seal1 && seal2 && seal3))
					{
						System.out.println("Sugarpuff uses all her power in a burst of burning hot cocoa!"
								+ "\nSugarpuff: PUFFFFF!"
								+ "\n" + picked.getName() + " took " + (int)(((sugar/3) *power) + picked.getDefense()/4) + " damage!");
						picked.addHealth(-((sugar/3) *power) + picked.getDefense()/4);
					}

					if(defending)
					{
						System.out.println("Sugarpuff is no longer protecting Lolipop!");
						user.addDefense(-powerTemp);
						defending = false;
					}
				}
				else
				{
					System.out.println("Not enough sugar!");
				}
				break;
			}
		}
		scan.close();
	}

	@Override
	public String giveDescription() {
		return "Sugarpuff: Lolipop's familiar, Sugarpuff, is called to do her own commands."
				+ "\nRelease all her seals and...";
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
