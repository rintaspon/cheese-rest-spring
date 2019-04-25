<h2>Spring REST cheesy example</h2>
<p><b>Related keys:</b></p>
<ul>
  <li>Representational state transfer (REST)</li>
  <li>Data Transfer Object (DTO)</li>
  <li>Model-View-Controller (MVC) architecture</li>
	<li>HTTP status codes</li>
	<li>Lombok: Object builder library (see: <u>https://projectlombok.org</u>)</li>
</ul>
<p><b>Scenario:</b></p>
<p>We have milk and want to produce cheese! so that we throw it to a cheese maker (Server).
After the milk is sent to the server as well-known JSON format, there are some activities here:</p>
<ol>
  <li>CheeseController (Controller) receives the incoming data by using <i>getCheese(@RequestBody MilkDTO milkDTO)</i>. 
	The milkDTO is only used for transfering Milk data from outside to the server.</li>
	<li>MilkDTO is converted to Entity named "Milk", which is the thing that we will work with. The conversion is done by <i>convertToEntity(MilkDTO milkDTO)</i>.</li>
  <li>After we get Milk entity, we will send it to CheeseService (Service). The service's implementation is wired to its interface by @Autowired annotation.</li>
  <li>Inside the service, there are two method named <i>makeCheese(Milk milk)</i> and <i>calculateCheeseWeight(double milkVolume)</i>. 
	The first method is in charge of producing cheese and the second one for weight calculation. In this example, we just use simple <i>Math.random()</i> in the calculation.
	For the cheese production, we simply create Cheese object and assign its 'id' randomly (assumed that it is already inserted into some database).</li>
	<li>If the cheese is produced with no error,
	it will be returned to milk sender with HTTP code 200 (successful), 
	otherwise the server will send an error message and HTTP code such as 400 (Bad Request) and 500 (Internal Server Error).</li>
</ol>
