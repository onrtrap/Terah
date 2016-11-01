package basic;

import java.util.ArrayList;

/*************************************************************************
 *interface Skill creates the basic layout for the Skill child objects.
 *Their basics involve setting a target, setting a user, the actual
 *activation of the ability, and returning a description of the ability.
 *************************************************************************/
public interface Skill {

	public void setTarget(Creature creature);	

	public void setUser(Creature caster);
	
	public void setTargets(ArrayList<Creature> targets);

	public void activate();

	public String giveDescription();
	
	/**
	 * 1: Targets Self only
	 * 2: Targets Party only
	 * 3: Targets Enemy Party only
	 * 4: Targets One Party Member Only
	 * 5: Targets One Enemy Party Member Only
	 */
	public int hitsWhat();

}
