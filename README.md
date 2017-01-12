<img align="right" src="http://i.imgur.com/HXSvCsC.jpg" height="320" width="320">

# RevloAPI

RevloAPI brings [Revlo](https://revlo.co) and Java Plataform together. This is made for developers that want to use Revlo on their Java Projects to get Information in reference to Revlo API.
Based in [RevloDocumentation](https://github.com/teamrevlo/revloapi)

## Installation
RevloAPI is distributed as a [maven](http://maven.apache.org/) project. To compile it and install it in your local Maven repository (.m2) use:

```
git clone https://github.com/Doc94/RevloAPI.git
cd RevloAPI
mvn clean install
```

## Basic Example
Here show a basic example for use the API (More examples in wiki)
```java
package net.mrdoc.examplerevloapi;

import net.mrdoc.revloapi.exception.RevloException;

/**
 * Created by Doc on 10-01-2017.
 *
 * @author Doc
 */
public class RevloExample {

    /**
     * AutoRun this
     * @param args not need here
     */
    public static void main(String[] args) {
        try {
            RevloAPI api = new RevloAPI("MyAPIKey"));
            
            //i need see debug code (?
            api.setDEBUGMODE(true);
        } catch (RevloException e) {
            e.printStackTrace();
        }
    }
}
```
