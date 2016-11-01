package basic;

import java.util.ArrayList;
/*****************************************
 * SkillBox holds all the skills that will be used.  
 * It also holds all the ArrayLists of skills that creatures will have, and each of these gets a return.
 *The constructor adds skills to the appropriate ArrayList.
 **************************************/
public class SkillBox {
	//These are the variables that are constant in every skill, even if they are not in the constructor

	Creature target;

	Creature self;

	//This variable is only for ExpCannon

	Creature hero;

	//Each of these variables initialize the appropriate skill object.  This is needed because skills are NOT methods.
	public EvenSlice evenSlice = new EvenSlice(target, self, 10);

	public BasicBuff basicBuff = new BasicBuff(self, 12);

	public RoyalStrike royalStrike = new RoyalStrike(target, self, 10);

	public Caviar caviar = new Caviar (self , 15);

	public Sugarpuff sugarpuff = new Sugarpuff(target, self);

	public StalwartFlip stalwartFlip = new StalwartFlip(self);

	public StrangeFlip strangeFlip = new StrangeFlip(self);
	
	public ShieldSmasher shieldSmasher = new ShieldSmasher(target, self);

	public PopRockets popRockets = new PopRockets(target, self , 25);

	//public Nightshade poison = new Nightshade(target, 3);

	public Heal heal = new Heal(self, 20);

	public Fireball fireball = new Fireball(target, self, 10);

	public ElectrifyingKiss electrifyingKiss = new ElectrifyingKiss(target, self, 30);

	public Ydobon ydobon = new Ydobon(self);


	//These ArrayLists are initialized and used to hold certain sets of skills for different characters.

	public ArrayList<Skill> billSkills = new ArrayList<Skill>();

	public ArrayList<Skill> emilliaSkills = new ArrayList<Skill>();

	public ArrayList<Skill> lolipopSkills = new ArrayList<Skill>();

	public ArrayList<Skill> stoutleySkills = new ArrayList<Skill>();

	public ArrayList<Skill> sparklaSkills = new ArrayList<Skill>();

	public ArrayList<Skill> nobodySkills = new ArrayList<Skill>();

	//This ArrayList is special, because its only purpose is to be a placeholder for characters with no skills.

	public ArrayList<Skill> noSkills = new ArrayList<Skill>();

	//This is the constructor for SkillBox.  When it initializes, it adds skills to whatever ArrayList of skills I wish.

	public SkillBox()
	{
		billSkills.add(evenSlice);
		billSkills.add(heal);
		billSkills.add(basicBuff);

		emilliaSkills.add(royalStrike);
		emilliaSkills.add(heal);
		emilliaSkills.add(caviar);

		lolipopSkills.add(sugarpuff);
		lolipopSkills.add(fireball);
		lolipopSkills.add(heal);

		stoutleySkills.add(ydobon);
		stoutleySkills.add(stalwartFlip);
		stoutleySkills.add(strangeFlip);
		stoutleySkills.add(shieldSmasher);
		stoutleySkills.add(heal);

		sparklaSkills.add(popRockets);
		sparklaSkills.add(electrifyingKiss);

		nobodySkills.add(ydobon);
		nobodySkills.add(fireball);
	}

	//These are the get methods.  They return each of the ArrayLists in SkillBox so they can be used elsewhere.

	public ArrayList<Skill> getBillSkills()
	{
		return billSkills;
	}

	public ArrayList<Skill> getEmilliaSkills()
	{
		return emilliaSkills;
	}

	public ArrayList<Skill> getLolipopSkills()
	{
		return lolipopSkills;
	}

	public ArrayList<Skill> getStoutleySkills()
	{
		return stoutleySkills;
	}

	public ArrayList<Skill> getSparklaSkills()
	{
		return sparklaSkills;
	}

	public ArrayList<Skill> getNobodySkills()
	{
		return nobodySkills;
	}

	public ArrayList<Skill> getNoSkills()
	{
		return noSkills;
	}

}
