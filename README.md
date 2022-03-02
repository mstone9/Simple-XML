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
## Parsing a Basic XML File with Simple XML
    In order to parse data from any file, you need a Persister.  See the [Persister] (http://simple.sourceforge.net/download/stream/doc/javadoc/org/simpleframework/xml/core/Persister.html) class.
