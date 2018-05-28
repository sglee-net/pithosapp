# pithosapp


#### Example of REST API

* GET
 - API: selectCustom
 - Http message example
  ```
  http://localhost:8080/selectCustom/?tableName=table1&c1=0&c2=0&c3=1
  ```
* GET
 ** API: selectAll
 ** Http message example
 ```
 http://localhost:8080/selectAll?tableName=table1
 ```
* POST 
 ** API: insert (one record)
 ** Http message example
 ```
 http://localhost:8080/record
 ```
 ** Payload
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
 ** API: insert (multiple records)
 ** Http message example
 ```
 http://localhost:8080/records
 ```
 ** Payload
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
 ** API: update
 ** Http message example
 ```
 http://localhost:8080/records
 ```
 ** Payload
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
 ** API: delete
 ** Http message example
 ```
 http://localhost:8080/records
 ```
 ** Payload
 ```
 {
	"tableName" : "table1",
	"whereClause" : "c3 >= 0"
 }
 ```
