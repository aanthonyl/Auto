package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;

public class IO {
	public static TalonSRX right = new TalonSRX(57);
	public static TalonSRX left = new TalonSRX(56);
	
	public static Compressor compressor = new Compressor(0);
	public static Relay compressorRelay = new Relay(0);

	//public static ISolenoid sole = new InvertibleSolenoid(0,0);
	
	public static NavX navX = new NavX();
	
	public static UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
	
	static{
		right.setInverted(true);
	}

}
