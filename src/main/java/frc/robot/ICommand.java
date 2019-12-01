package frc.robot;
public interface ICommand {
	
	public void init();
	
	public void execute();
	
	public boolean done();

}
