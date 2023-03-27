// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// import com.pi4j.component.sensor.impl.I2cSensorComponent;
// import com.pi4j.component.sensor.impl.Mpu6050Driver;
// import com.pi4j.io.i2c.I2CFactory;
// import com.pi4j.io.i2c.I2CBus;

// import java.io.IOException;

// public class Main {
//     public static void main(String[] args) {
//         I2CBus i2c = null;
//         try {
//             i2c = I2CFactory.getInstance(I2CBus.BUS_1);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         I2cSensorComponent mpu6050 = new Mpu6050Driver(i2c.getDevice(0x68));
//         mpu6050.setEnabled(true);

//         // Read the current raw sensor values
//         double ax = mpu6050.getAccelerationX();
//         double ay = mpu6050.getAccelerationY();
//         double az = mpu6050.getAccelerationZ();
//         double gx = mpu6050.getAngularVelocityX();
//         double gy = mpu6050.getAngularVelocityY();
//         double gz = mpu6050.getAngularVelocityZ();

//         // Convert the raw sensor values to meaningful units
//         double ax_g = ax / 16384.0;
//         double ay_g = ay / 16384.0;
//         double az_g = az / 16384.0;
//         double gx_deg_per_sec = gx / 131.0;
//         double gy_deg_per_sec = gy / 131.0;
//         double gz_deg_per_sec = gz / 131.0;

//         // Print the converted sensor values to the console
//         System.out.println("Accelerometer (g): " + ax_g + ", " + ay_g + ", " + az_g);
//         System.out.println("Gyroscope (deg/s): " + gx_deg_per_sec + ", " + gy_deg_per_sec + ", " + gz_deg_per_sec);
//     }
// }
