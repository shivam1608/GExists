# GExists
Java library to check if Gmail/Google Username exists or not you know why to use it ;)
i made this for my own use but you guys can use it too its well documentated

### Version : 0.1

## Ouick Start
```java
import me.shivzee.GExists;
import me.shivzee.helper.Username;

public class Main {
    public static void main(String[] args) {
        GExists user = new GExists();
        Username username = new Username("shivzee");
        user.exists(username , (exist)->{
              System.out.println(exist?"Username Already exists":"Username not available");
          });
    }
}

```

## Add to your projects
Easy to add in your projects using gradle, maven or jar

### Gradle
- Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
- Add the dependency (replace version with the version on top)
```gradle
dependencies {
	        implementation 'com.github.shivam1608:GExists:0.1'
	}
```

### Maven
- Add the repository in pom.xml file
```maven
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

```
- Add the dependency (replace version with the version on top)
```maven 
	<dependency>
	    <groupId>com.github.shivam1608</groupId>
	    <artifactId>GExists</artifactId>
	    <version>0.1</version>
	</dependency>

```

### Jar 
Download the jar from this repo 
```
out/artifact/GExists.jar or Use the Release Section
```
# How to Use
- Create Instance
```java
GExists user = new GExists();
// OR
GExists user = new GExists(true); // if want to use executor for async task
// Note: Using executor service will result in your code not to exit so to exit the code and stop executor use
user.exit()
```

- Check Exists (Synchronous)
```java
	GExists user = new GExists();
 	Username username = new Username("shivzee");
        if(username.isValid()){
            boolean exists = user.exists(username);   
        }
        // OR you can do this way
        boolean existsAgain = user.exists("shivzee");

```
- Check Exists (Asynchronous)
```java
	GExists user = new GExists();
        Username username = new Username("shivzee");
        if(username.isValid()){
            user.exists(username , (exist)->{System.out.println(exist);});   
        }
        // OR you can do this way
        user.exists("shivzee" , (exist)->{System.out.println(exist);});;

```

## WTFPL (Do what the f*ck you want license)
Author : Shizee
IDE Used : IntelliJ
