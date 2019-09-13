
package testing.com.ola.qa.util;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class Singleton {

private static Singleton single_instance = null;

private Map<String, Object> registry = new HashMap<>();

private WebDriver driver;

private Singleton() {

}

public static Singleton getInstance() {
 if (single_instance == null)
  single_instance = new Singleton();

 return single_instance;
}

public void setDriver(WebDriver driver) {
 this.driver = driver;
}

public WebDriver getDriver() {
 return driver;
}

public Object getValue(String name) {
 return registry.get(name);
}

public void putValue(String name, Object object) {
 registry.put(name, object);
}

 public Map<String, Object> getRegistry(){
 return registry;
}

}

