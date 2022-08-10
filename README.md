
# hmrc-example-frontend

This service allows a user to prelodge a transit movement.

Service manager port: 10125

### Testing

Run unit tests:
<pre>sbt test</pre>  
Run integration tests:  
<pre>sbt it:test</pre>  
or
<pre>sbt IntegrationTest/test</pre> 

### Running manually or for journey tests

    sm --start CTC_TRADERS_PRELODGE -r
    sm --stop MANAGE_TRANSIT_MOVEMENTS_PRELODGE_FRONTEND
    sbt run

### License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").

