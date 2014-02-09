Buffering using Jersey 2.x Apache Connector
============

Checkout this SOF question http://stackoverflow.com/questions/18157218/jersey-2-0-content-length-not-set

Output of EntitStreamingTest:

    Feb 08, 2014 2:43:17 PM org.glassfish.jersey.test.jetty.JettyTestContainerFactory$JettyTestContainer start
    INFO: Starting JettyTestContainer...
    2014-02-08 14:43:17.723:INFO:oejs.Server:main: jetty-9.0.6.v20130930
    2014-02-08 14:43:17.749:INFO:oejs.ServerConnector:main: Started ServerConnector@5884a914{HTTP/1.1}{0.0.0.0:9998}
    Feb 08, 2014 2:43:18 PM org.glassfish.jersey.filter.LoggingFilter log
    INFO: 1 * Server has received a request on thread qtp216856121-27
    1 > POST http://localhost:9998/test/chunked
    1 > Accept-Encoding: gzip,deflate
    1 > Connection: keep-alive
    1 > Content-Type: text/plain
    1 > Host: localhost:9998
    1 > Transfer-Encoding: chunked
    1 > User-Agent: Jersey/2.5.1 (Apache HttpClient 4.3.1)
    POST

    Feb 08, 2014 2:43:18 PM org.glassfish.jersey.filter.LoggingFilter log
    INFO: 2 * Server responded with a response on thread qtp216856121-27
    2 < 200
    2 < Content-Type: text/plain
    POST

    Feb 08, 2014 2:43:18 PM org.glassfish.jersey.test.jetty.JettyTestContainerFactory$JettyTestContainer stop
    INFO: Stopping JettyTestContainer...
    2014-02-08 14:43:18.063:INFO:oejs.ServerConnector:main: Stopped ServerConnector@5884a914{HTTP/1.1}{0.0.0.0:9998}
    Feb 08, 2014 2:43:18 PM org.glassfish.jersey.server.ApplicationHandler initialize
    INFO: Initiating Jersey application, version Jersey: 2.5.1 2014-01-02 13:43:00...
    Feb 08, 2014 2:43:18 PM org.glassfish.jersey.test.jetty.JettyTestContainerFactory$JettyTestContainer start
    INFO: Starting JettyTestContainer...
    2014-02-08 14:43:18.127:INFO:oejs.Server:main: jetty-9.0.6.v20130930
    2014-02-08 14:43:18.129:INFO:oejs.ServerConnector:main: Started ServerConnector@4c550889{HTTP/1.1}{0.0.0.0:9998}
    Feb 08, 2014 2:43:18 PM org.glassfish.jersey.filter.LoggingFilter log
    INFO: 1 * Server has received a request on thread qtp1155769010-45
    1 > POST http://localhost:9998/test
    1 > Accept-Encoding: gzip,deflate
    1 > Connection: keep-alive
    1 > Content-Length: 4
    1 > Content-Type: text/plain
    1 > Host: localhost:9998
    1 > User-Agent: Jersey/2.5.1 (Apache HttpClient 4.3.1)
    POST

    Feb 08, 2014 2:43:18 PM org.glassfish.jersey.filter.LoggingFilter log
    INFO: 2 * Server responded with a response on thread qtp1155769010-45
    2 < 200
    2 < Content-Type: text/plain
    POST

    Feb 08, 2014 2:43:18 PM org.glassfish.jersey.test.jetty.JettyTestContainerFactory$JettyTestContainer stop
    INFO: Stopping JettyTestContainer...
    2014-02-08 14:43:18.169:INFO:oejs.ServerConnector:main: Stopped ServerConnector@4c550889{HTTP/1.1}{0.0.0.0:9998}
    Feb 08, 2014 2:43:17 PM org.glassfish.jersey.server.ApplicationHandler initialize
    INFO: Initiating Jersey application, version Jersey: 2.5.1 2014-01-02 13:43:00...