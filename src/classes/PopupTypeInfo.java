package classes;

import java.util.List;

public class PopupTypeInfo {

	private final boolean isPrimitive;
	private final boolean isInterface;
	private final boolean isEnum;
	private final String name;
	private final boolean isJdk;
	private final List<String> inheritedClassNames;

	public PopupTypeInfo(Class<?> clazz) {
		super();
		this.isPrimitive = clazz.isPrimitive();
		this.isInterface = clazz.isInterface();
		this.isEnum = clazz.isEnum();
		this.name = clazz.getSimpleName();
		this.isJdk = UtilMethods.isJDKClass(clazz);
		this.inheritedClassNames = UtilMethods.getAllInheritedClassNames(clazz);
	}

	public boolean isPrimitive() {
		return isPrimitive;
	}

	public boolean isInterface() {
		return isInterface;
	}

	public boolean isEnum() {
		return isEnum;
	}

	public String getName() {
		return name;
	}

	public boolean isJdk() {
		return isJdk;
	}

	public List<String> getInheritedClassNames() {
		return inheritedClassNames;
	}

	@Override
	public String toString() {
		return "PopupTypeInfo [isPrimitive=" + isPrimitive + ", isInterface=" + isInterface + ", isEnum=" + isEnum
				+ ", name=" + name + ", isJdk=" + isJdk + ", inheritedClassNames=" + inheritedClassNames + "]";
	}

}
