package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;

public class Button {
	private GenericHID joystick;
	private int buttonID;
	//Test variables for testing button states
	private boolean previousState = false;
	private boolean currentState = false;
	//Creates button object
	public Button(GenericHID joystick, int buttonID) {
		this.joystick = joystick;
		this.buttonID = buttonID;
		this.currentState = joystick.getRawButton(buttonID);
	}
	//Updates state of the button
	public void update() {
		previousState = currentState;
		currentState = joystick.getRawButton(buttonID);
	}
	//Returns True if the button is being pressed
	public boolean isDown() {
		return currentState;
	}	
	//Returns True when the button is pressed
	public boolean onButtonPressed() {
		return currentState && !previousState;
	}
	//Returns True when the button is released
	public boolean onButtonReleased() {
		return previousState && !currentState;
	}
}

/*THIS SHOULD BE THE FORMAT OF THE JoystickIO CLASS
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team86.util.Button;
public class JoystickIO {
	
	//Making Joystick Objects
	 
	public static Joystick ~variable~ = new Joystick(~port~);
	//ArrayList of Buttons
	 
	private static ArrayList<Button> buttons = new ArrayList<>();
	//Actual Buttons
	public static Button ~variable~  = createButton(~joystick object~,~button number~);
	//This makes updates the buttons. It should be called from Robot.java	
	public static void update() {
		for (Button b : buttons) {
			b.update();
		}
	}
	
	//This creates the buttons
	private static Button createButton(GenericHID stick, int button) {
		Button newButton = new Button(stick, button);
		buttons.add(newButton);
		return newButton;
	}
}
*/