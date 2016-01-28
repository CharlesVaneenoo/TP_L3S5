package actions;

import java.util.Iterator;

public class FairScheduler extends SchedulerAction {
	
		Iterator<Action> iterateur;
		
		public FairScheduler(){
			super();
			this.iterateur = null;
		}
		
		/**
		 * This scheduler takes the first action of the action list
		 * and once it has done a step, it changes to the next action in
		 * the action list (parallel progression).
		 * @throws ActionFinishedException if the action is finished
		 * @throws EmptyListException if the list of actions is empty
		 */
		@Override
		protected void step() throws EmptyListException, ActionFinishedException  {
			Action currentAction;
			if(this.iterateur == null || !this.iterateur.hasNext()) 
				this.iterateur = this.actions.iterator();
			currentAction = this.iterateur.next();
			if (currentAction.isFinished()) throw new ActionFinishedException();
			currentAction.doStep();
			if(currentAction.isFinished())
				this.iterateur.remove();
		}
		
}
