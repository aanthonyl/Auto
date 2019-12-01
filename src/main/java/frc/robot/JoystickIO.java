package frc.robot;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;


import java.util.ArrayList;

public class JoystickIO {
	// Joysticks
	//public static Joystick leftJoystick = new Joystick(0);
	//public static Joystick rightJoystick = new Joystick(1);
	//public static Joystick coJoystick = new Joystick(2);
	public static Joystick xbox = new Joystick(0);
	// Buttons
	private static ArrayList<Button> buttons = new ArrayList<>();
	
	public static Button sOn = createButton(xbox, 6); 
	public static Button magic180 = createButton(xbox, 1);
	public static Button magic0 = createButton(xbox, 4);
	public static Button magic90 = createButton(xbox, 2);
	public static Button magic270 = createButton(xbox, 3);
	public static Button angleRes = createButton(xbox, 5);
	public static Button cam = createButton(xbox, 7); 
	
	public static void update() {
		for (Button b : buttons) {
			b.update();
		}
	}

	private static Button createButton(GenericHID stick, int button) {
		Button newButton = new Button(stick, button);
		buttons.add(newButton);
		return newButton;
	}
}