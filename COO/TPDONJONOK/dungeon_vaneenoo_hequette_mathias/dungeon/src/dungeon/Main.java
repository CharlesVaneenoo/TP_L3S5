package dungeon;

import dungeon.room.*;
import dungeon.weapon.*;

public class Main {

	public static void main(String[] args) {
		
		//the player
		Player player1 = new Player( "Mario",100);
		
		
		// Dungeon 1
		// room11 = dungeon 1 room 1
		Room room11=new RoomIntersection();
		Room room12=new RoomIntersection();
		Room room13=new RoomIntersection();
		Room button11= new ButtonRoom();
		Room exit11=new Exit();
		
		room11.addAdjoiningRoom("north", room12);
		room12.addAdjoiningRoom("east", room13);
		room13.addAdjoiningRoom("south", button11);
		button11.addAdjoiningRoom("south", exit11);
	
		// End of Dungeon 1
		
		
		// Dungeon 2
		Room room21=new RoomIntersection();
		Room monster21 = new MonsterRoom(new Monster(50,50));
		Room keys21=new KeysRoom();
		Room keys22=new KeysRoom();
		Room treasure21=new TreasureRoom(new Potion());
		Room treasure22=new TreasureRoom(new Gun());
		Room treasure23=new TreasureRoom(new Sword());
		Room treasure24=new TreasureRoom(new Keys());
		Room treasure25=new TreasureRoom(new Keys());
		Room trap21=new Trap();
		Room trap22=new Trap();
		Room carpet21=new CarpetRoom();
		Room painting21=new PaintingRoom();
		Room button21= new ButtonRoom();
		Room exit21=new Exit();
		Room exit22=new Exit();

		
		room21.addAdjoiningRoom("north", monster21);
		room21.addAdjoiningRoom("south", treasure21 );
		room21.addAdjoiningRoom("east", treasure22);
		room21.addAdjoiningRoom("west", treasure23);
		monster21.addAdjoiningRoom("north", treasure24);
		monster21.addAdjoiningRoom("east", trap21);
		monster21.addAdjoiningRoom("west", treasure25);
		treasure24.addAdjoiningRoom("north", carpet21);
		carpet21.addAdjoiningRoom("carpet", keys21);
		keys21.addAdjoiningRoom("east", exit21);
		treasure24.addAdjoiningRoom("east", keys22);
		keys22.addAdjoiningRoom("west", trap22);
		keys22.addAdjoiningRoom("north", painting21);
		painting21.addAdjoiningRoom("painting", button21);
		button21.addAdjoiningRoom("east", exit22);
		
		// End of Dungeon 2
		
				
		
		// Dungeon 3
		Room room31=new RoomIntersection();
		Room room32=new RoomIntersection();
		Room room33=new RoomIntersection();
		Room trap31=new Trap();
		Room trap32=new Trap();
		Room trap33=new Trap();
		Room trap34=new Trap();
		Room trap35=new Trap();
		Room trap36=new Trap();
		Room trap37=new Trap();
		MonsterRoom monster31 = new MonsterRoom(new Monster(50,10));
		MonsterRoom monster32 = new MonsterRoom(new Monster(150,75));
		Room exit31=new Exit();
		Room carpet31=new CarpetRoom();
		Room painting31=new PaintingRoom();
		Room treasure31=new TreasureRoom(new Gun());
		Room treasure32=new TreasureRoom(new Keys());
		Room treasure33=new TreasureRoom(new Potion());
		Room treasure34=new TreasureRoom(new Keys());
		Room treasure35=new TreasureRoom(new Potion());
		Room button31= new ButtonRoom();
		Room keys31=new KeysRoom();
		
		room31.addAdjoiningRoom("north", trap31);
		room31.addAdjoiningRoom("east", carpet31);
		carpet31.addAdjoiningRoom("carpet",room32 );
		room32.addAdjoiningRoom("east",trap32 );
		room32.addAdjoiningRoom("north",painting31 );
		painting31.addAdjoiningRoom("painting",room33 );
		room33.addAdjoiningRoom("south", treasure31);
		room33.addAdjoiningRoom("west", treasure32);
		treasure32.addAdjoiningRoom("north",monster31 );
		treasure32.addAdjoiningRoom("east",treasure33 );
		treasure33.addAdjoiningRoom("east",trap33 );
		monster31.addAdjoiningRoom("north", monster32);
		monster31.addAdjoiningRoom("east",trap34 );
		monster31.addAdjoiningRoom("west",trap35 );
		monster32.addAdjoiningRoom("east", treasure34 );
		monster32.addAdjoiningRoom("west",keys31 );
		monster32.addAdjoiningRoom("north",treasure35 );
		keys31.addAdjoiningRoom("south",button31 );
		button31.addAdjoiningRoom("west",trap36 );
		button31.addAdjoiningRoom("west",trap37 );
		button31.addAdjoiningRoom("north",exit31 );
		
		// End of Dungeon 3
		
	
	
	Dungeon dungeon1=new Dungeon(room11,player1);
	Dungeon dungeon2=new Dungeon(room21,player1);
	Dungeon dungeon3=new Dungeon(room31,player1);
	
	dungeon1.start();
	room11.getAdjoiningRooms();
	dungeon1.goToNextDungeon(dungeon2);
	dungeon2.goToNextDungeon(dungeon3);

	
	}

}
