
package frc.robot;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive {
	private TalonSRX left;
	private TalonSRX right;
	private NavX nav;
	private AutoMode seq = null;
	
	private boolean create = true;
	private boolean press = false;
	
public Drive (TalonSRX left, TalonSRX right, NavX nav){
	this.left = left;
	this.right = right;
	this.nav = nav;
}

public void rInit(){
	left.configClosedloopRamp(1.0, 0);
	right.configClosedloopRamp(1.0, 0);
	
	left.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
	right.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
	
	left.enableVoltageCompensation(true);
	right.enableVoltageCompensation(true);
	left.configVoltageCompSaturation(12.0, 0);
	right.configVoltageCompSaturation(12.0, 0);
	right.configVoltageMeasurementFilter(32, 0);
	left.configVoltageMeasurementFilter(32, 0);
	
}


public void init(){
	left.setSelectedSensorPosition(0, 0, 0);
	right.setSelectedSensorPosition(0, 0, 0);
	
	

}

public void update(){
	left.set(ControlMode.PercentOutput, -.6 * JoystickIO.xbox.getRawAxis(1));
	right.set(ControlMode.PercentOutput, -.6 * JoystickIO.xbox.getRawAxis(5));
	SmartDashboard.putNumber("leftPos", left.getSelectedSensorPosition(0));
	SmartDashboard.putNumber("angle", IO.navX.getNormalizedAngle());
	
	if(JoystickIO.angleRes.onButtonPressed()){
		IO.navX.reset();
	}
	if(JoystickIO.magic180.onButtonPressed() || press){
		press = true;
		if(create){
			 seq = new AutoMode(new PointTurn(180));
			 create = false;
		}
		}else if (JoystickIO.magic0.onButtonPressed() || press){
			press = true;
			if(create){
				 seq = new AutoMode(new PointTurn(0));
				 create = false;
			}
		}else if (JoystickIO.magic90.onButtonPressed() || press){
			press = true;
			if(create){
				 seq = new AutoMode(new PointTurn(90));
				 create = false;
			}
		}else if (JoystickIO.magic270.onButtonPressed() || press){
			press = true;
			if(create){
				 seq = new AutoMode(new PointTurn(270));
				 create = false;
			}
		
		}
	if(press){
		if(!seq.done()){
			seq.execute();
		}else{
			create = true;
			press = false;
		}
	}
	
		
	}
}



