package frc.robot;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private PS4Controller joystick;
  private static final int leftDeviceID = 1; 
  private static final int rightDeviceID = 2;
  private SparkMax m_leftMotor;
  private SparkMax m_rightMotor;

  @Override
  public void robotInit() {
  /**
   * SPARK MAX controllers are intialized over CAN by constructing a CANSparkMax object
   * 
   * The CAN ID, which can be configured using the SPARK MAX Client, is passed as the
   * first parameter
   * 
   * The motor type is passed as the second parameter. Motor type can either be:
   *  com.revrobotics.CANSparkLowLevel.MotorType.kBrushless
   *  com.revrobotics.CANSparkLowLevel.MotorType.kBrushed
   * 
   * The example below initializes four brushless motors with CAN IDs 1 and 2. Change
   * these parameters to match your setup
   */
    m_leftMotor = new SparkMax(leftDeviceID, MotorType.kBrushless);
    m_rightMotor = new SparkMax(rightDeviceID, MotorType.kBrushless);

    m_myRobot = new DifferentialDrive(m_leftMotor, m_rightMotor);

    joystick = new PS4Controller(0);
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(joystick.getLeftY(), joystick.getRightY());
  }
}