package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
  private Auto auto;
  private Drive drive;
  private boolean once = true;

  @Override
  public void robotInit() {
    SmartDashboard.putNumber("kP", .02);
    SmartDashboard.putNumber("kI", 0);
    SmartDashboard.putNumber("kD", 0);
    SmartDashboard.putNumber("maxI", 0);
    SmartDashboard.putNumber("Izone", 0);
    SmartDashboard.putNumber("Sequence", 1);
    drive = new Drive(IO.left, IO.right, IO.navX);
    auto = new Auto();
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
    //auto.init();
  }

  @Override
  public void autonomousPeriodic() {
    if (once) {
      auto.selection((int)SmartDashboard.getNumber("Sequence", 1));
      auto.init();
      auto.execute();
      once = false;
    } else if (!auto.done()) {
      auto.execute();
    }
    SmartDashboard.putBoolean("Auto Done?", auto.done());
  }

  @Override
  public void teleopInit() {
    drive.init();
  }

  @Override
  public void teleopPeriodic() {
    JoystickIO.update();
    Time.update();
    drive.update();
    SmartDashboard.putNumber("EncR", IO.right.getSelectedSensorPosition());
    SmartDashboard.putNumber("EncL", IO.left.getSelectedSensorPosition());
    
  }

  @Override
  public void testPeriodic() {
  }
}
