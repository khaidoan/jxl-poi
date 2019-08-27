# jxl-poi

This is a wrapper based on jexcelapi_2_6_12.  I was using jxl for creating Excel, but jxl only support Excel 2003, which has a limit of 256 columns.  I've taken jexcelapi_2_6_12 and modify it to internally use Apache POI.  This is a maven project.  To build this project, import this project into Eclipse, right click on the pom.xml and select "Run As -> Maven Install".  This will create the JAR file.  Find this JAR file and add it to your local maven repository.  

Information on the current version:

	<groupId>jxlpoi</groupId>
	<artifactId>jxlpoi</artifactId>
	<version>0.0.8</version>

This currently depends on Apache POI 3.15.

To use this wrapper, we should only have to change the import statement.

If you search the Internet for jxlpoi, you may find another implementation by the same name, but it involves changing the class name.  This was created by another developer.  I came to know about this after I have created this wrapper.
