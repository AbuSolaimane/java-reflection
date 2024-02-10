package dynamicproxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomHandlerInvocation implements InvocationHandler {

	private Map<Method, Object> cache = new ConcurrentHashMap<>();
			
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		Object result;
		if (method.isAnnotationPresent(Cacheable.class)) {
			if (!cache.containsKey(method))
				cache.put(method, method.invoke(proxy, args));
			
			result = cache.get(method);
		}
		else
			result = method.invoke(proxy, args);
		
		return result;
	}

}
