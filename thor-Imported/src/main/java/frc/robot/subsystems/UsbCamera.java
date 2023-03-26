// package frc.robot.subsystems;

// import edu.wpi.first.cameraserver.CameraServer;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.cscore.CvSource;
// import edu.wpi.first.cscore.CvSink;
// import edu.wpi.first.cscore.VideoSink;
// import edu.wpi.first.cscore.UsbCamera;



// public class UsbCamera extends SubsystemBase {
//     private UsbCamera camera;
//     private VideoSink server;

//     public UsbCamera() {
//       camera = CameraServer.getInstance().startAutomaticCapture();
//       camera.setResolution(320, 240);

       
//       server = CameraServer.getInstance().getServer();
//       server.setSource(camera);
//   }

//   @Override
//     public void periodic() {
//         // Bu metod, her robot loop döngüsünde çağrılır.
//         // Burada, sistemle ilgili kontrol kodlarınızı yazabilirsiniz.
//         // Ancak, bu örnekte herhangi bir kontrol kodu olmadığından boş bırakıldı.
//     }
// }
