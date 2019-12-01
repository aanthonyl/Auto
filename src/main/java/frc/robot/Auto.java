package frc.robot;

public class Auto implements ICommand{
	private AutoMode autoMode;
	public Auto(){
		autoMode = new AutoMode(new Magic(5,0));
	}
	
	@Override
	public void init() {
		autoMode.init();
		
	}
	
	@Override
	public void execute() {
		autoMode.execute();
		
		
	}

	@Override
	public boolean done() {
		
		return autoMode.done();
	}
	

}
