package basic;
import java.lang.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/******************************************************************************************************************
 * Roberts_JavaFinal2015
 * 6/9/15
 * Arena is a game in which you engage in one on one battles against an enemy using a chosen Hero.
 * Each Hero and Creature object is initialized outside as the game while loop, but the Battle object is initialized
 *within.
 *The player chooses from various Heroes, all with different stat values, and faces Creatures.
 *Various commands include attack, defend, and skill.
 *When exiting, the player has their number of wins relayed.
 ******************************************************************************************************************/


public class Arena {

	public static void main(String[] args) 
	{

		
		
		Scanner scan = new Scanner(System.in);
		
		JFrame frame = new JFrame("Arena");

		SkillBox box = new SkillBox();
		
	    String [] picNames = {"TerribleNobody.png", "TerribleSlime.png", "TerribleGruffin.png", "TerribleGublin.png", "TerribleSparkla.png"};

		int input;

		int wins = 0;

		int match = 1;

		int player = 0;

		int matchup = 0;

		boolean done = false;

		boolean winning = true;

		ArrayList<Skill> billSkills = box.getBillSkills();

		ArrayList<Skill> emilliaSkills = box.getEmilliaSkills();
		
		ArrayList<Skill> lolipopSkills = box.getLolipopSkills();
		
		ArrayList<Skill> stoutleySkills = box.getStoutleySkills();

		ArrayList <Skill> sparklaSkills = box.getSparklaSkills();

		ArrayList<Skill> noSkills = box.getNoSkills();
		
		ArrayList<Skill> nobodySkills = box.getNobodySkills();

		//String nm, int hp, int atk, int mgc, int mp, int def, int spd, String desc, String insult, String defeat, int dodge, ArrayList<Skill> skl, int winExp, int lvl, boolean playable
		
		Creature bill = new Creature("Basic Bill", 50, 25, 25, 50, 25, 25, "A balanced guy. Ready for anything.", "Let's go!","*generic dying words*",  5, billSkills, 1, 1, true);

		Creature emilia = new Creature("Princess Emilia", 40, 20, 25, 55, 20, 40, "The Princess of Emeremeret. She's kind of frail." ,"Would you please entertain me? Do be careful though.", "Hold me, I feel faint...", 10, emilliaSkills, 1, 1, true);
		
		Creature lolipop = new Creature("Lolipop", 35, 20, 40, 80, 20, 30, "An apprentice Sugaromancer.  His real name is James.","I'll show you the power of Sugaromancy!", "It's ok Sugarpuff...don't cry...", 5, lolipopSkills, 1, 1, true);
		
		Creature stoutley = new Creature("Stoutley", 100, 20, 0, 50, 40, 20, "No one knows who this mysterious man is or where he came from.  Just that he's really hard to hurt.", "I warn you, it's really hard to hurt me.", "Ow.", 5, stoutleySkills, 1, 1, true);

		Creature[] roster = {bill, emilia, lolipop, stoutley};

		Creature nobody = new Creature("Nobody", 20, 0, 15, 20, 20, 0, "Nobodies are essentially punching bags, if punching bags could burn you to death.", "...", ".......", 5, nobodySkills, 5, 1, false);

		Creature slime = new Creature("Slime", 30, 20, 0, 0, 25, 25, "Slimes come in many shapes and sizes.  Most come in 'I can't tell'.", "*gloops angrily*", "*splooshes in respect*", 5, noSkills, 6, 1, false);

		Creature greffin = new Creature("Greffin", 35, 25, 0, 0, 20, 45, "You may not understand them, but every squawk they make is an insult.  I think.", "KAWWWK!", "GRAWWAKK...", 5, noSkills, 8, 1, false);

		Creature gublin = new Creature("Gublin", 38, 30, 0, 0, 25, 35, "Gublins enjoy fighting, among other things, such as beach volleyball and karaoke night at the local bar.", "Wot m8? Eu wunt sum o dis?", "Dis is bloody insane!", 5, noSkills, 8, 1, false);

		Creature mommagician = new Creature("Mommagician", 100, 12, 12, 4, 80, 60, "Lolipop has a Mommagician.  She nags him about using too much mana ALL the time.", "Feeling cold sweetie?  I'll warm you up with a fireball!", "Now, you take care dear!", 5, noSkills, 20, 1, false);

		Creature announcer = new Creature("Announcer", 100, 65, 0, 0, 10, 10, "He doesn't realize he's getting his paycheck deducted for this." ,"Introducing...me!", "*Drops the microphone, walks out in shame*", 5, noSkills, 25, 1, false);
		
		Creature somebody = new Creature("Somebody", 100, 0, 80, 80, 50, 0, "They're really well known in someplace you've never heard of.","Wanna play scrub?", "...jerk.", 0, nobodySkills, 35, 1, false);
		
		Creature shadow;
		
		//String nm, int hp, int atk, int mgc, int mp, int def, int spd, String desc, String insult, String defeat, int dodge, ArrayList<Skill> skl, int winExp, int lvl, boolean playable

		Creature ares = new Creature("Ares, god of War", 1000, 200, 0, 0, 100, 100, "Ares is still angry about God of War. Don't take it personally.", "You believe you can fight a GOD?!", "First God of War, and now this...", 5, noSkills, 1, 1, false);

		Creature drak = new Creature("Drak, King of Dragons", 500, 150, 0, 0, 120, 34, "Not to be confused with Drake, Emperor of Dragons.", "You dare to face ME, human?", "...Well played...sir.", 5, noSkills, 1, 1, false);

		Creature tromdlov = new Creature("Tromdlov, the Dark Wizard", 350, 40, 100, 250, 50, 65, "He may be a master of dark magic, but he is weak to the power of friendship.", "Kek Kek Kek. You think you can defeat me?", "Noooooooooo!!!", 5, noSkills, 1, 1, false);

		Creature giuseppe = new Creature("Giuseppe, Fancyman of Firenze", 250, 75, 0, 0, 54, 100, "Che cosa?  Che io ho?  Io ho bello!", "Buon giorno. Tu sei preparato?", "Ah, io ho morto!", 5, noSkills, 1, 1, false);

		Creature sparkla = new Creature("Sparkla, The Robot Pop Star", 50, 30, 25, 100, 30, 15, "She's only here because her manager said so.", "I'll sing you my new hit single!  It's called 'Electrifying Kiss'!", "ERROR ARENA TRASHED.  ERR%@ NO RECOVERY PROGR%#. ER#@$@#$%@#$", 5, sparklaSkills, 1, 7, false);

		Battle nobodyFight;

		Battle slimeFight;

		Battle grefinFight;

		Battle gublinFight;

		Battle announcerFight;

		Battle mommagicianFight;
		
		Battle shadowFight;
		
		Battle somebodyFight;

		Battle aresFight;

		Battle drakFight;

		Battle tromdlovFight;

		Battle giuseppeFight;

		Battle sparklaFight;

		ArrayList <Creature> heroTest = new ArrayList<Creature>();
		
		ArrayList <Creature> Creature1 = new ArrayList<Creature>();
		
		Creature1.add(nobody);
		Creature1.add(slime);
		
		ArrayList <Creature> Creature2 = new ArrayList<Creature>();
		
		Creature2.add(slime);
		Creature2.add(slime);
		Creature2.add(nobody);
		
		ArrayList <Creature> Creature3 = new ArrayList<Creature>();
		
		Creature3.add(gublin);
		Creature3.add(greffin);
		
		ArrayList <Creature> Creature4 = new ArrayList<Creature>();
		
		Creature4.add(gublin);
		Creature4.add(nobody);
		Creature4.add(gublin);
		
		ArrayList <Creature> Creature5 = new ArrayList<Creature>();
		
		Creature5.add(sparkla);
		
		ArrayList <ArrayList> multiCreatures = new ArrayList <ArrayList>();
		
		multiCreatures.add(Creature1);
		
		multiCreatures.add(Creature2);
		
		multiCreatures.add(Creature3);
		
		multiCreatures.add(Creature4);
		
		multiCreatures.add(Creature5);
		
		MultiBattle test;
		
		
		while(!done)
		{
			System.out.println("\nWelcome to the Arena!"
					+ "\nMain Menu:\nPress corresponding number for choice."
					+ "\n1:Instructions"
					+ "\n2:Tourney Mode"
					+ "\n3:Party Mode"
					+ "\n4:Exit"
					+ "\n5:Credits");
			input = scan.nextInt();
			switch(input)
			{
			case 1: System.out.println("\nWhat would you like to learn?"
					+ "\n1:Rpg stats for nublords"
					+ "\n2:Which way is the game?"
					+ "\n3:Wait, how do I fight?");
			input = scan.nextInt();
			switch(input)
			{
			case 1: System.out.println
					( "\nLevel: A useless stat that makes you feel accomplished."
					+ "\nHealth: A value that somehow indicates the overall state of your entire body. If it goes down to 0, you lose."
					+ "\nDoes this mean that if you get a headache, you lost 10 health? I can't get it either."
					+ "\nAttack: How much you can make your opponent say 'ow'."
					+ "\nMagic: If you have this, you can do neat magic tricks like incinerating people or that pencil trick thing everybody talks about!"
					+ "\nMana: Apparently it's pronounced 'mah-na' or something.  Essentially, it let's you stall healing longer."
					+ "\nDefense: How resistant you are to being poked."
					+ "\nSpeed: How speedy you are. This determines whether or not you go first in a battle.  If your speed equals the enemy speed, the order is random."
					+ "\nHidden Stats:\nExperience: If you get enough, you level up.  Leveling up makes you stronger, and gives you a shiny new +1 to your level. Neat!"
					+ "\n It should be mentioned that you will only level up after a battle, even when you gain experience outside of one.\nDodge Chance: Very rarely, an enemy will miss due to this elusive stat. Get it?"
					);
			break;
			case 2: System.out.println("Tourney mode features one on one battles. Party mode features multiple players and enemies, so you can play with friends!"
					+ "\nOr alone, if you can't beat Sparkla because you're a scrub.(Sorry, I didn't mean that.)");
			break;
			case 3: System.out.println("Attack attacks."
					+ "\nDefend increases defenses for one turn, but if your health is less than half, you also regain some health."
					+ "\nSkill allows you to use one of your skills, if you want to be fancy."
					+ "\nTaunt slightly urks your opponent, but in return, they lower their guard a bit. They gain +5 attack for every -10 defense.  Be careful though, the effect may be permanent!"
					+ "\nCheck invades the privacy of you and your foe."
					+ "\nAttack, Defend, and Skill use up your turn, but taunt and check do not."
					+ "\nYou'll learn, trust me.");
			break;
			}
			break;
			case 2: System.out.println("Ok then, choose a fighter!"
					+ "\n1: Basic Bill, the most boring of battlers.  Basically balanced, bro.\n" + bill.toString() 
					+"\n2: Princess Emillia, member of the Royal Family of Emeremeret, and fragile fighter.  A dodgy dutchess though.\n" + emilia.toString()
					+"\n3: Lolipop, a Sugaromancer.  His abilities focus on magic and controlling his familiar, Sugarpuff.\n" + lolipop.toString()
					+"\n4: Stoutley. Stoutley is stout. Stoutley was awarded WOW tank of the year three times in a row. His skills focus on defense and switching stats.\n"
					+ "He's a hero for a real man/woman.\n" + stoutley.toString());
			input = scan.nextInt();
			switch(input)
			{
			case 1: player = 0;
			break;

			case 2: player = 1; 
			break;
			
			case 3: player = 2;
			break;
			
			case 4: player = 3;
			}
			shadow = new Creature("Shadow " + roster[player].getName(), roster[player].getActualHealth(), roster[player].getActualAttack(), roster[player].getActualDefense(), roster[player].getActualSpeed(), roster[player].getActualMagic(), roster[player].getActualMana(),"Evil duplicates are just annoying at this point.", "You've won "  + wins + " times, but can you defeat yourself, " + roster[player].getName() + "?", "No matter.  You will never get rid of me.", 25, roster[player].getSkills(), 1, 1, false);
			
			nobodyFight = new Battle(roster[player], nobody);

			slimeFight = new Battle(roster[player], slime);

			grefinFight = new Battle(roster[player], greffin);

			gublinFight = new Battle(roster[player], gublin);
			
			mommagicianFight = new Battle(roster[player], mommagician);
			
			announcerFight = new Battle(roster[player], announcer);
			
			somebodyFight = new Battle(roster[player], somebody);
			
			shadowFight = new Battle(roster[player], shadow);

			aresFight = new Battle(roster[player], ares);

			drakFight = new Battle(roster[player], drak);

			tromdlovFight = new Battle(roster[player], tromdlov);

			giuseppeFight = new Battle(roster[player], giuseppe);

			sparklaFight = new Battle(roster[player], sparkla);

			Battle[] easyBattles = {nobodyFight, slimeFight, grefinFight, gublinFight, sparklaFight};

			Battle[] hardBattles = {mommagicianFight, announcerFight, somebodyFight, shadowFight, giuseppeFight};

			Battle[] bossRush = {sparklaFight, giuseppeFight, tromdlovFight, drakFight, aresFight};

			Battle[] Battle[]  = {easyBattles, hardBattles, bossRush};

			System.out.println("Now, choose what tournament you want to play.\n1:Easy Tournament: A good start for a low level hero."
					+ "\n2:Hard Tournament: A bit more of a challenge."
					+ "\n3:Boss Rush: You will regret this.");
			input = scan.nextInt();
			switch(input)
			{
			case 1: matchup = 0; 
			break;

			case 2: matchup = 1; 
			break;

			case 3: matchup = 2; 
			break;

			
			}
			winning = true;
			match = 1;
			//int picture = 0;
			while(winning && match <= Battle[matchup].length)
			{
				if(match < Battle[matchup].length)
				{
					System.out.println("\nHere comes match number " + match + "!\n");
				}
				if(match == Battle[matchup].length)
				{
					System.out.println("\nThis is the final match!\n");
				}
				Battle[matchup][match-1].prepareSkills();
					
				/**ImageIcon icon = new ImageIcon(picNames[picture]);
					  JLabel label = new JLabel(icon);
					  frame.add(label);
					  frame.setDefaultCloseOperation
					         (JFrame.EXIT_ON_CLOSE);
					  frame.pack();
					  frame.setVisible(true);**/
				winning = Battle[matchup][match-1].initiateBattle();
				if(winning)
				{
					wins++;
					match++;
					//picture++;
				}
				frame.setVisible(false);
			}
			if(winning)
			{
				System.out.println("You won! As a bonus, you get 25 experience!");
				roster[player].addExp(25);
			}
			else if(!winning)
			{
				System.out.println("You lost...Well, there's always next time... You'll get a reward based on your wins.");
				roster[player].addExp(5 * match);
			}
			break;
			case 3: System.out.println("\nWelcome to Party Mode! First, choose how many heroes you want to play with."
					+ "\n1: One Hero"
					+ "\n2: Two Heroes"
					+ "\n3: Three Heroes"
					+ "\n4: Four Heroes");
			input = scan.nextInt();
			int more = input;
			while(more > 0)
			{
				System.out.println("Pick a character!"
						+ "\n1:Basic Bill: A balanced guy. Ready for anything."
						+ "\n2:Princess Emilia: She's a bit fragile, so be careful!"
						+ "\n3: Lolipop: This magic user needs time to really shine."
						+ "\n4: Stoutley: Built tough, but needs a helper to deal damage for him.");
				input = scan.nextInt();
				switch(input)
				{
				case 1: heroTest.add(roster[0]);
				System.out.println("Basic Bill");
				more--;
				break;

				case 2: heroTest.add(roster[1]);
				System.out.println("Princess Emilia");
				more--;
				break;
				
				case 3: heroTest.add(roster[2]);
				System.out.println("Lolipop");
				more--;
				break;
				
				case 4: heroTest.add(roster[3]);
				System.out.println("Stoutley");
				more--;
				break;
				}
			}
				System.out.println("Ok then! Let's get started!");
				boolean survived = true;
				int next = 0;
				while(survived && next < 5)
				{
					test = new MultiBattle(heroTest, multiCreatures.get(next));
					
					survived = test.initiateBattle();
					
					if(survived)
					{
						wins++;
						next++;
					}
				}
			break;
			case 4: System.out.println("\nWell goodbye then.  I won't even ask you if you're sure, obviously you don't have time to give this poor old game a spin.  But, I will tell you the wins you've gotten: " + wins +"." + " Goodbye!");
			done = true;
			break;
			case 5: System.out.println("\nProgrammed by Orion Roberts.");
			break;
			}
		}



	}

}