# Simple-XML
This repository is used to teach future developers on how to use Simple framework.

## This repository will teach developers how to:
- Add Simple XML as a maven dependency.
- Use Simple XML to parse a basic XML file.
- Use Simple XML to parse a nesting XML file.
- Use Simple XML to parse an array expressed as an XML file.

## How to add Simple Framework to a Maven Project:
Maven is a software tool used for Java project management and build automation. The maven central repository is used to host various projects, which can be referenced and and downloaded using a project descriptor. For more information, see the [Maven](https://maven.apache.org/what-is-maven.html) project home. All of the releases of the Simple Framework are accessed from Maven.

```XML
<dependency>
    <groupId>org.simpleframework</groupId>
    <artifactId>simple-xml</artifactId>
    <version>2.7.1</version>
</dependency>
```
## Parsing a Basic XML File with Simple XML:
   In order to parse data from any file, you need a Persister.  See the Persister class [here](http://simple.sourceforge.net/download/stream/doc/javadoc/org/simpleframework/xml/core/Persister.html).  Through the Persister class functionality, you can both serialize and deserialize an object.  See the basic XML File use case on how to [deserialize](https://github.com/mstone9/Simple-XML/blob/main/src/main/java/edu/missouriwestern/csc346/SimpleUseCase.java) a serialized object.

   The basic XML file program creates a Credentials (super class) and Password class.  The Credentials class stores information pertaining to the credentials information located in the XML file.  The Credentials class stores the host, port, user and password information.  The Password class produces a hint attribute that hints at the password inside of the credentials object. The Main class creates a Serializer object, a File object and a Credentials object.
   
   The Main method reads in the information via an xml file stored in the repository, and not through a URL.  The Main method uses the Serializer class to read the information stored within the XML file, and stores the information in a new Credentials object.  
   
   ```Java
   Serializer serializer = new Persister();
   File source = new File("woz.xml");
   Credentials credentials = serializer.read(Credentials.class, source);
   ```
