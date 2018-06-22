## Overview
This repositoy is an example to utilize Pithos project.
There are two ways when you use Pithos. One is the general method based on Mybatis, and the other is to make dynamic sql directly such as Mybatis Dynamic SQL.
## Quick Start
#### General usage based on Mybatis
http://www.mybatis.org/mybatis-3/sqlmap-xml.html
#### Makeup of dynamic Sql statement by using build pattern
* Supported API throughout SqlStatement.Builder
	* insert, colValue, colValues, records
	* select
	* update, set
	* delete
	* where, whereNot, and, andNot, or, orNot

* Example
```
SqlStatement sqlStatement = null;
sqlStatement = new SqlStatement.Builder()
		.insert(tableName)
		.colValues(colNames, colValues)
		.build();
```
#### Payload for REST API
Payload can be used for POST, PUT, DELETE and the format of it is Json.
* Keywords
	* tableName
	* resultSet : List<Map<String,Object>>
	* colNames : for "INSERT" single value and multiple values
	* colValues : for "INSERT" single value
	* colVariables : for "UPDATE" multiple values
	* records : for "INSERT" multiple values
	* whereClause : for "SELECT"
	* statement : for general purpose

#### Example of REST API
* POST 
	* API: insert (one record)
	* Http message example
	```
	http://localhost:8080/record
	```
	* Payload
	```
	{
	"tableName" : "table1",
	"colVariables": [
			{"c1" : "xxx"},
		    {"c2" : "yyy"}
	    ],
	  "colNames" : [
		  	"c1", "c2", "c3"
	    ],
	  "colValues" : [
		    "0", "0", 0
	    ],
	  "records" : [
		    ["0", "0", 0],
		    ["1", "1", 1],
		    ["2", "2", 2]
	    ]
	}
	```
* POST
	* API: insert (multiple records)
	* Http message example
	```
	http://localhost:8080/records
	```
	* Payload
	```
	{
	"tableName" : "table1",
	"colVariables": [
			{"c1" : "xxx"},
		    {"c2" : "yyy"}
	    ],
	  "colNames" : [
		  	"c1", "c2", "c3"
	    ],
	  "colValues" : [
		    "0", "0", 0
	    ],
	  "records" : [
		    ["0", "0", 0],
		    ["1", "1", 1],
		    ["2", "2", 2]
	    ]
	}
	```
* GET
	* API: selectCustom
 	* Http message example
	```
	http://localhost:8080/selectCustom/?tableName=table1&c1=0&c2=0&c3=1
	```
* GET
	* API: selectAll
	* Http message example
	```
	http://localhost:8080/selectAll?tableName=table1
	```
* PUT
	* API: update
	* Http message example
	```
	http://localhost:8080/records
	```
	* Payload
	```
	{
	"tableName" : "table1",
	"colVariables": [
			{"c1" : "xxx"},
		    {"c2" : "yyy"}
	    ],
	  "colNames" : [
		  	"c1", "c2", "c3"
	    ],
	  "colValues" : [
		    "0", "0", 0
	    ],
	  "records" : [
		    ["0", "0", 0],
		    ["1", "1", 1],
		    ["2", "2", 2]
	    ]
		}
		```
* DELETE
	* API: delete
	* Http message example
	```
	http://localhost:8080/records
	```
	* Payload
	```
	{
	"tableName" : "table1",
	"whereClause" : "c3 >= 0"
	}
	```
