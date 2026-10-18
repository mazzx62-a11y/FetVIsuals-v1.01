package fetvisuals.modules.visuals;
import fetvisuals.module.*; import fetvisuals.module.settings.*;
public final class TrajectoryPrediction extends fetvisuals.module.Module {public final NumberSetting length=add(new NumberSetting("Prediction Length",2.5,0.5,8,.1));public final NumberSetting points=add(new NumberSetting("Trajectory Points",32,8,96,1));public final ColorSetting color=add(new ColorSetting("Line Color",0xFFB66DFF));public TrajectoryPrediction(){super("TrajectoryPrediction","Projectile trajectory settings",Category.VISUALS);}}
