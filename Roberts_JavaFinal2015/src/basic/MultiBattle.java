package basic;
/*********************************************
 * MultiBattle is for creating battles
 * with multiple heroes and monsters.
 * 
 ********************************************/
import java.util.ArrayList;
import java.util.Scanner;

public class MultiBattle 
{
	private ArrayList<Creature> players;

	private ArrayList<Creature> enemies;
	
	private ArrayList<Creature> order = new ArrayList<Creature> (0);
	
	private ArrayList<Creature> lost;

	private ArrayList<Creature> defeated;

	int playerTarget;

	int enemyTarget;

	public MultiBattle(ArrayList<Creature> party, ArrayList<Creature> enemyParty)
	{
		players = party;

		enemies = enemyParty;
		
		for(int i = 0; i < players.size(); i++)
		{
				order.add(players.get(i));
		}
		
		for(int i = 0; i < enemies.size(); i++)
		{
				order.add(enemies.get(i));
		}
		
		for(int i = 0; i < order.size(); i++)
		{
			System.out.println(order.get(i).getName());
		}
	}

	public boolean initiateBattle()
	{
		boolean won = false;
		
		boolean over = false;
		
		boolean noHeroes = false;
		
		boolean noEnemies = false;

		int fastest = 0;
		
		Creature temp;
		

		for(int i = 0; i < players.size(); i++)
		{
			System.out.println(players.get(i).getName() + " is in the battle!"
					+ "\n" + players.get(i).getTaunt());
		}
		
		for(int i = 0; i < enemies.size(); i++)
		{
			System.out.println(enemies.get(i).getName() + " is in the battle!"
					+ "\n" + enemies.get(i).getTaunt());
		}
		
		
		System.out.println("Let the battle...begin!");
		while(!over)
		{
			 noHeroes = false;
			
			 noEnemies = false;
			
			for(int i = 0; i < order.size(); i++)
			{
				System.out.println(order.get(i).getName());
				if(order.get(i).getSpeed() > fastest)
				{
					//temp = order.get(0);
					temp = order.get(i);
					//order.set(0, order.get(i));
					order.remove(i);
					order.add(0, temp);
					//order.set(i, temp);
				 fastest = order.get(0).getSpeed();
				}
			}
			
			for(int i = 0; i < order.size(); i++)
			{
				System.out.println(order.get(i).getName());
			}
			
			int go = 0;
			while(go < order.size())
			{
				if(order.get(go).isPlayer())
				{
				order.get(go).playerCommand(order, players, enemies);
				}
				
				if(!order.get(go).isPlayer())
				{
				order.get(go).enemyCommand(order, players);
				}
				
				for(int i = 0; i < order.size(); i++)
				{
					if(order.get(i).getHealth() <= 0)
					{
						System.out.println(order.get(i).getName() + " has been defeated!\n"
								+ order.get(i).getLoss());
						order.remove(order.get(i));
					}
				}
				go++;
				
			}
			
			noHeroes = true;
			 
			 noEnemies = true;
			 
			for(int i = 0; i < order.size(); i++)
			{
				 
				 for(int j = 0; j < players.size(); j++)
				 {
					 
				 if(order.get(i).getName().equals(players.get(j).getName()))
				 {
					 noHeroes = false;
				 }
				 
				 }
				 for(int j = 0; j < enemies.size(); j++)
				 {	 
				 if(order.get(i).getName().equals(enemies.get(j).getName()))
				 {
					 noEnemies = false;
				 }
				 
				 } 
			}
			
			if(noHeroes)
			{
				System.out.println("The party was wiped out...");
				over = true;
				won = false;
			}
			
			else if(noEnemies)
			{
				System.out.println("The enemies have been vanquished!");
				over = true;
				won = true;
				int total = 0;
				for(int i = 0; i < enemies.size(); i++)
				{
					total += enemies.get(i).getExp();
				}
				
				System.out.println("The party gained " + total + " experience!");
				
				for(int i = 0; i < players.size(); i++)
				{
					players.get(i).addExp(total);
					players.get(i).levelUp();
				}
			}
		}
		revertAll();
		return won;
	}

	
	private void revertAll()
	{
		for(int i = 0; i < players.size(); i++)
		{
			players.get(i).revertAll();
		}
		for(int i = 0; i < enemies.size(); i++)
		{
			enemies.get(i).revertAll();
		}
	}
}
