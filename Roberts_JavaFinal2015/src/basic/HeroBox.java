package basic;

import java.util.ArrayList;
/********************************************************************************************************
 * This is a class that is basically for holding all the created heroes, as well as ones still in the works.
 *What it was supposed to do is allow for the return of each hero, so it is easier to use them, but
 *the concept is too tedious, as the heroes are way too involved in every class.
 ******************************************************************************************************/
public class HeroBox {

	SkillBox box = new SkillBox();

	ArrayList<Skill> billSkills = box.getBillSkills();

	ArrayList<Skill> emilliaSkills = box.getEmilliaSkills();
	
	ArrayList<Skill> noSkills = box.getNoSkills();
	
	ArrayList<Skill> lolipopSkills = box.getLolipopSkills();
	
	ArrayList<Skill> stoutleySkills = box.getStoutleySkills();

	//Hero bill = new Hero("Basic Bill", 50, 25, 25, 25, 25, 25, "Let's Go!", "*generic dying words*",  5, billSkills);

	//Hero emilia = new Hero("Princess Emilia", 40, 20, 30, 25, 3, 40, "Would you please entertain me? Do be careful though.", "Hold me, I feel faint...", 10, emilliaSkills);
	
	//Hero lolipop = new Hero("Lolipop", 35, 20, 40, 80, 20, 30, "I'll show you the power of Sugarmancy!", "Sugarpuff, this is all your fault!", 5, lolipopSkills);
	
	//Hero stoutley = new Hero("Stoutley", 150, 20, 0, 0, 150, 0,"I warn you, it's really hard to hurt me.", "Ow.", 5, stoutleySkills);
	
	public HeroBox()
	{
		
	}

}
