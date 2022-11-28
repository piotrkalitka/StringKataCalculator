# String Kata Calculator


## Requirements

- Java 17

# Building  and Testing project

All operations might be executed with your local gradle distribution, or using wrapped gradle which allows to work with project without installing additional software.

If you want to use wrapped gradle, create `./gradle.properties` file, basing on `./gradle.properties.template` template.
**You will have to provide full path to your java 17 home directory, otherwise wrapper will use JAVA_HOME environment variable**



## Building:

### using gradle wrapper:
on UNIX systems:
```
   gradlew build
```
on Windows systems:
```
    gradlew.bat build
```

### using local gradle:
```
   gradle build
```

## Testing

### using gradle wrapper:
on UNIX systems:
```
   gradlew test
```
on Windows systems:
```
    gradlew.bat test
```

### using local gradle:
```
   gradle test
```

In case of any failure, message will be printed out in command line. Also, you can find test report in `build\reports\tests\index.html` file.

