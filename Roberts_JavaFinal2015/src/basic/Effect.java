package basic;
/**********************************************************************************
 *The Effect Class creates Effect objects, which when used with a Creature, 
 *causes them to have constant stat loss or gain for a certain period of time. 
 *Basically unused, except for Poison.
 *********************************************************************************/
public interface Effect 
{

	public void setTarget(Creature aim);
	
	public int getTime();

	public void setTime(int set);

	public String getName();

	public void statusTick();
	
	
}
