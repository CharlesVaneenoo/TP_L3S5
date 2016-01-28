package actions;

public class SequentialScheduler extends SchedulerAction{

	//la prochaine action est celle en cours si elle n'est pas terminée ou si fini on passe a la suivante
	
	public SequentialScheduler(){
		super();
	}

	/**
	 * The sequentialScheduler will execute all the actions present in the list
	 * @throws ActionFinishedException 
	 * 						if the action is finished
	 * @throws EmptyListException
	 * 						if the list of action is empty
	 */
	@Override
	public void step() throws EmptyListException, ActionFinishedException {
				Action currentAction = this.actions.get(0);
					if (currentAction.isFinished()) throw new ActionFinishedException();
				currentAction.doStep();
				if(currentAction.isFinished()){
					this.actions.remove(0);
				}
		}

}

