package di.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ImOkkkk
 * @date 2022/7/27 9:00
 * @since 1.0
 */
public class BeanDefinition {
  private String id;
  private String className;
  private List<ConstructorArg> constructorArgs = new ArrayList<>();
  private Scope scope = Scope.SINGLETON;
  private boolean lazyInit = false;

  public BeanDefinition(
      String id,
      String className,
      List<ConstructorArg> constructorArgs,
      Scope scope,
      boolean lazyInit) {
    this.id = id;
    this.className = className;
    this.constructorArgs = constructorArgs;
    this.scope = scope;
    this.lazyInit = lazyInit;
  }

  public boolean isSingleton() {
    return scope.equals(Scope.SINGLETON);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public List<ConstructorArg> getConstructorArgs() {
    return constructorArgs;
  }

  public void setConstructorArgs(List<ConstructorArg> constructorArgs) {
    this.constructorArgs = constructorArgs;
  }

  public Scope getScope() {
    return scope;
  }

  public void setScope(Scope scope) {
    this.scope = scope;
  }

  public boolean isLazyInit() {
    return lazyInit;
  }

  public void setLazyInit(boolean lazyInit) {
    this.lazyInit = lazyInit;
  }

  public static enum Scope {
    SINGLETON,
    PROTOTYPE;
  }

  public static class ConstructorArg {
    private boolean isRef;

    private Class type;

    private Object arg;

    public ConstructorArg(boolean isRef, Class type, Object arg) {
      this.isRef = isRef;
      this.type = type;
      this.arg = arg;
    }

    public ConstructorArg(Builder builder) {
      this.isRef = builder.isRef;
      this.type = builder.type;
      this.arg = builder.arg;
    }

    public boolean isRef() {
      return isRef;
    }

    public void setRef(boolean ref) {
      isRef = ref;
    }

    public Class getType() {
      return type;
    }

    public void setType(Class type) {
      this.type = type;
    }

    public Object getArg() {
      return arg;
    }

    public void setArg(Object arg) {
      this.arg = arg;
    }

    public class Builder {
      private boolean isRef;
      private Class type;
      private Object arg;

      public ConstructorArg build() {
        if (this.isRef) {
          if (type != null) {
            throw new IllegalArgumentException("当 isRef 为 true 的时候，type 不需要设置");
          }
        }else {
          if (arg == null || type == null){
            throw new IllegalArgumentException("当 isRef 为 false 的时候，arg、type 都需要设置");
          }
        }
        ConstructorArg constructorArg = new ConstructorArg(this);
        return constructorArg;
      }
      public Builder setRef(boolean ref) {
        isRef = ref;
        return this;
      }

      public Builder setType(Class type) {
        this.type = type;
        return this;
      }

      public Builder setArg(Object arg) {
        this.arg = arg;
        return this;
      }
    }
  }
}
