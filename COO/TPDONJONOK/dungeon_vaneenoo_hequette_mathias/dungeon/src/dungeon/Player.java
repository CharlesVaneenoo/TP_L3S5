package dungeon;

import java.util.*;

import dungeon.weapon.*;
/**
 * 
 * @author charlesvaneenoo
 * the class Player
 */
public class Player {
	
	private int life;
	private String name;
	private List<Loot> potions;
	protected List<Loot> keys;
	private Weapon weapon;
	
/**
 * the constructor Player	
 * @param life : the player's life
 * @param name : the player's name
 */
	public Player(String name, int life){
		this.life=life;
		this.setName(name);
		this.potions=new ArrayList<Loot>();
		this.keys =new ArrayList<Loot>();
		//this.weapon = new Gun();
		this.weapon = new Hand();
		//this.weapon = new Sword();
	}
	
	/**
	 * the function getName
	 * @return a String : the name of the player
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * the function setName change the name of a player
	 * @param name : the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * the function toString prints the player's name
	 */
	public String toString() {
		return "My name is"+ this.name;
	}
	
	/**
	 * the function getLife
	 * @return the life
	 */
	public int getLife() {
		return this.life;
	}
	
	/**
	 * the function setLife allow to change the life of players
	 * @param life2
	 */
	public void setLife(int life2) {
		this.life=life2;
	}

	/**
	 * the function addPotions adds a potion to the list of potions
	 * 
	 */
	public void addPotions() {
		potions.add(new Potion());
	}
	
	/**
	 * the function addKeys adds a key to the list of key
	 * 
	 */
	public void addKeys() {
		keys.add(new Keys());
	}
	
	/**
	 * the function removeKeys remove a key to the list of key
	 * 
	 */
	public void removeKeys(){
		if(keys.isEmpty()){
			System.out.println("I don't have keys");
		}
		else{
			keys.remove(0);
		}
	}
	
	/**
	 * the function removePotion remove a potion to the list of key
	 * 
	 */
	public void removePotion(){
		if(potions.isEmpty()){
			System.out.println("I don't have potions");
		}
		else{
			potions.remove(0);
		}
	}
	
	/**
	 * function is EmptyKeys check if the list of keys is empty or not
	 * @return a boolean 
	 */
	public boolean isEmptyKeys() {
		return keys.isEmpty();
		
	}

	/**
	 * function is EmptyPotions check if the list of potions is empty or not
	 * @return a boolean 
	 */
	public boolean isEmptyPotions(){
		return potions.isEmpty();
	}
	
	/**
	 * function usePotion permit to use a potion and regenerate players's life
	 */
	public void usePotion(){
		if (this.isEmptyPotions()){
			System.out.println("You don't have any potions");
		}
		else {
			this.removePotion();
			this.setLife(100);
			System.out.println("You used a potion");
		}
	}
	
	/**
	 * function useKey allows the player to use a key and open a door, only if he is in a locked room
	 */
	public void useKey(Dungeon dungeon){
		if (dungeon.getCurrentRoom().getPreview()=="a locked room"){
			if (this.isEmptyKeys()){
				System.out.println("You don't have any keys");
			}
			else {
				this.removeKeys();
				dungeon.getCurrentRoom().setCanBeLeft(true);
				System.out.println("You used a key, the door is now opened");
			}
		}else{
			System.out.println("You can't use a key in this room");
		}
	}
	/**
	 * the function hitPlayer allow a player to hit a monster
	 * @param monster who is hit by the player
	 */
	public void hitPlayer(Monster monster) {
		monster.setLife(monster.getLife()-weapon.getPower());
		
	}
	
	/**
	 * the function getWeapon
	 * @return the weapon hold by the player
	 */
	public Weapon getWeapon() {
		return weapon;
	}

	/**
	 * the function setWeapon change the old weapon with the new weapon in parameters
	 * @param weapon : the new weapon
	 */
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	/**
	 * the function isDeadPlayer checks if a player is alive or not 
	 * @return a boolean
	 */
	public boolean isDeadPlayer(){
		if (this.life >0){ 
		return false;
		}
		else return true;		
	}
	
	/**
	 * function getNbPotions permit to know the number of potions the players have with him
	 * @return a int 
	 */
	public int getNbPotions(){
		return potions.size();
	}

	/**
	 * function getNbKeys permit to know the number of keys the players have with him
	 * @return a int 
	 */
	public int getNbKeys(){
		return keys.size();
	}
	
	
}
