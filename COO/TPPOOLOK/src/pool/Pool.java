package pool;

import actions.*;

/** 
 * Main for the entire class
 * @author Nvk
 */
public class Pool {

	public static void main(String[] args) throws ActionFinishedException, EmptyListException {
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles = new CubiclePool(3);
		FairScheduler s = new FairScheduler();
		
		Swimmer swim1 = new Swimmer("Camille",baskets,cubicles, 6, 4, 8);
		Swimmer swim2 = new Swimmer("Lois",baskets,cubicles, 2, 10, 4);
		Swimmer swim3 = new Swimmer("Maé",baskets,cubicles, 10, 18, 10);
		Swimmer swim4 = new Swimmer("Ange",baskets,cubicles, 3, 7, 5);
		Swimmer swim5 = new Swimmer("Louison",baskets,cubicles, 18, 3, 3);
		Swimmer swim6 = new Swimmer("Charlie",baskets,cubicles, 3, 6, 10);
		Swimmer swim7 = new Swimmer("Alexis",baskets,cubicles, 6, 5, 7);
		
		s.addAction(swim1);
		s.addAction(swim2);
		s.addAction(swim3);
		s.addAction(swim4);
		s.addAction(swim5);
		s.addAction(swim6);
		s.addAction(swim7);
		
		int nbSteps = 0;
			while (!s.isFinished()){
				nbSteps++;
				s.doStep();
			}
		System.out.println("Finished in "+ nbSteps + " steps");
	}
}
