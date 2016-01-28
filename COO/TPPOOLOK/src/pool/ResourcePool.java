package pool;

import java.util.*;

public abstract class ResourcePool<R extends Resource> {
	
	protected int numberResources;
	protected List<R> resources;
	protected List<R> usedResources;
	
	protected abstract R create();
	public abstract String toString();

		/**
		 * Constructor for the class ResourcePool 
		 * @param numberOfResources the number of resources
		 */
		public ResourcePool(int numberOfResources){
			this.numberResources=numberOfResources;
			this.resources = new ArrayList<R>(numberResources);
				for (int i = 0 ; i <numberResources;i++){
					resources.add(create());
				}
			this.usedResources = new ArrayList<R>();
		}
		
		/**
		 * This method return a resource which type is R and add it to the list usedResources
		 * @return a resource which type is R
		 * @throws NoSuchElementException
		 */
		public R provideResource() throws NoSuchElementException{
			if(this.resources.isEmpty()){
				throw new NoSuchElementException();
			}
			R resource=resources.get(0);
			usedResources.add(resource);
			resources.remove(0);
			return resource;
		}
	
		/**
		 * This method remove the resource of type R in the parameter if it is in the list.
		 * @param resource the resource to free
		 */
		public void freeResource(R resource){
			if(!usedResources.contains(resource)){
				throw new IllegalArgumentException("Not part of this pool");
			}
			usedResources.remove(resource);
			resources.add(resource);
		}	
}