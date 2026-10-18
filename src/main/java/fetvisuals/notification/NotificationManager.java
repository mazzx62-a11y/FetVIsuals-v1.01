package fetvisuals.notification;
import java.util.*;
public final class NotificationManager {public static final class N{String text;int color;long born;N(String t,int c){text=t;color=c;born=System.currentTimeMillis();}}private final List<N> list=new ArrayList<>();public void push(String text,int color){list.add(new N(text,color));while(list.size()>6)list.remove(0);}public void tick(){long now=System.currentTimeMillis();list.removeIf(n->now-n.born>2600);}public List<N> all(){return Collections.unmodifiableList(list);}}
