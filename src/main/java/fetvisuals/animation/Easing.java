package fetvisuals.animation;
public enum Easing { LINEAR,EASE_IN,EASE_OUT,EASE_IN_OUT,CUBIC,QUAD,EXPO,BACK;
 public float apply(float t){t=Math.max(0,Math.min(1,t));return switch(this){case LINEAR->t;case EASE_IN,QUAD->t*t;case EASE_OUT->1-(1-t)*(1-t);case EASE_IN_OUT->t<.5f?2*t*t:1-2*(1-t)*(1-t);case CUBIC->t*t*t;case EXPO->t==0?0:(float)Math.pow(2,10*(t-1));case BACK->{float s=1.70158f;yield t*t*((s+1)*t-s);}};}
}
