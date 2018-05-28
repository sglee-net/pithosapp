### Overview
This repositoy is an example to utilize Pithos project.
There are two ways when you use Pithos. One is the general method based on Mybatis, and the other is to make dynamic sql directly such as Mybatis Dynamic SQL.
### Quick Start
#### General usage based on Mybatis
#### Makeup of dynamic Sql statement by using build pattern
#### Payload for REST API
Payload can be used for POST, PUT, DELETE and the format of it is Json.
* Keywords
	```
	tableName
	resultSet
	colNames
	colValues
	colVariables
	records
	whereClause
	statement
	```
#### Example of REST API
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
