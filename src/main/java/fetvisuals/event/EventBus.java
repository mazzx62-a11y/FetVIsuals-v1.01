package fetvisuals.event;
import java.util.*; import java.util.function.Consumer;
public final class EventBus {private final Map<Class<?>,List<Consumer<?>>> map=new HashMap<>();public <T>void subscribe(Class<T> type,Consumer<T> c){map.computeIfAbsent(type,k->new ArrayList<>()).add(c);}public <T>void post(T e){for(Consumer<?> c:map.getOrDefault(e.getClass(),List.of()))((Consumer<T>)c).accept(e);}}
