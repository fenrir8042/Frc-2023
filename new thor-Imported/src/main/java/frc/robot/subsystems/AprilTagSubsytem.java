// package frc.robot.subsystems;


// import edu.wpi.first.cameraserver.CameraServer;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj.vision.VisionPipeline;
// import edu.wpi.first.wpilibj.vision.VisionRunner;
// import edu.wpi.first.wpilibj.vision.VisionThread;
// import edu.wpi.first.cameraserver.*;
// import org.opencv.core.*;
// import org.opencv.imgproc.*;
// import org.opencv.imgcodecs.*;

// import java.util.ArrayList;
// import java.util.List;

// public class ApriltagSubsystem extends Subsystem {

//   private final Object imgLock = new Object();
//   private final Object tagLock = new Object();
//   private final Mat rawImage = new Mat();
//   private final Mat processedImage = new Mat();
//   private final List<AprilTag> detectedTags = new ArrayList<>();
//   private final MatOfDouble cameraMatrix = new MatOfDouble(
//       298.4356761735851, 0.0, 160.5,
//       0.0, 298.4356761735851, 120.5,
//       0.0, 0.0, 1.0
//   );
//   private final MatOfDouble distortionCoeffs = new MatOfDouble(
//       0.0, 0.0, 0.0, 0.0, 0.0
//   );
//   private final AprilTagsPipeline pipeline = new AprilTagsPipeline();
//   private final edu.wpi.first.vision.VisionRunner AprilTagsPipeline = new edu.wpi.first.vision.VisionRunner<>(CameraServer.getInstance().startAutomaticCapture(), pipeline, pipeline -> {
//     synchronized (imgLock) {
//       Imgproc.cvtColor(pipeline.getRawImage(), rawImage, Imgproc.COLOR_BGR2GRAY);
//       Imgproc.undistort(rawImage, processedImage, cameraMatrix, distortionCoeffs);
//     }
//     synchronized (tagLock) {
//       detectedTags.clear();
//       for (AprilTagsPipeline.TagDetection detection : pipeline.getDetectedTags()) {
//         double[] xyz = detection.getXYZ();
//         if (xyz != null) {
//           detectedTags.add(new AprilTag(detection.getId(), detection.getHammingDistance(), xyz));
//         }
//       }
//     }
//     SmartDashboard.putNumber("Detected Tags", detectedTags.size());
//   });

//   private final edu.wpi.first.vision.VisionThread visionThread = new edu.wpi.first.vision.VisionThread( runner, pipeline -> {
//     synchronized (tagLock) {
//       SmartDashboard.putNumber("Detected Tags", detectedTags.size());
//     }
//   });

//   public ApriltagSubsystem() {
//     visionThread.start();
//   }

//   @Override
//   protected void initDefaultCommand() {}

//   public List<AprilTag> getDetectedTags() {
//     synchronized (tagLock) {
//       return new ArrayList<>(detectedTags);
//     }
//   }

//   public static class AprilTag {
//     private final int id;
//     private final int hammingDistance;
//     private final double[] xyz;

//     public AprilTag(int id, int hammingDistance, double[] xyz) {
//       this.id = id;
//       this.hammingDistance = hammingDistance;
//       this.xyz = xyz;
//     }

//     public int getId() {
//       return id;
//     }

//     public int getHammingDistance() {
//       return hammingDistance;
//     }

//     public double[] getXYZ() {
//       return xyz;
//     }
//   }

//   public static class AprilTagsPipeline implements VisionPipeline {
//     private List<TagDetection> detectedTags = new ArrayList<>();
//     private Mat rawImage;

//     public Mat getRawImage() {
//       return rawImage;
//     }

//     public List<TagDetection>
