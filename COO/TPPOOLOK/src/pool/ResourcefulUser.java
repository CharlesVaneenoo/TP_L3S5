package pool;

public class ResourcefulUser<R extends Resource> {

	protected R resource;
	protected String nameOfUser;
	
	public ResourcefulUser(String name){
		this.nameOfUser = name;
	}
	
	public R getResource(){
		return resource;
	}
	
	public void setResource(R resource){
		this.resource=resource;
	}
	
	public void resetResource(){
		this.resource=null;
	}
	
	public String toString(){
		return this.nameOfUser;
	}
}
