package fetvisuals.event;
public final class Events {private Events(){} public record ClientTick(){} public record Attack(Object target){} public record Hit(Object target,float damage){} public record Key(int key,int action){} public record Render(float tickDelta){} public record HudRender(float tickDelta){} }
